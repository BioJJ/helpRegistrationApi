package com.biojj.helpregistration.service;

import com.biojj.helpregistration.domain.Activity;
import com.biojj.helpregistration.domain.Collaborator;
import com.biojj.helpregistration.domain.dtos.ActivityDTO;
import com.biojj.helpregistration.domain.enums.Priority;
import com.biojj.helpregistration.domain.enums.Status;
import com.biojj.helpregistration.repositories.ActivityRepository;
import com.biojj.helpregistration.service.exception.ObjectNotFoundException;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ActivityService {

    private final ActivityRepository activityRepository;

    private final CollaboratorService collaboratorService;

    public ActivityService(ActivityRepository activityRepository, CollaboratorService collaboratorService) {
        this.activityRepository = activityRepository;
        this.collaboratorService = collaboratorService;
    }

    public Activity findById(Integer id) {
        Optional<Activity> obj = activityRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! ID: " + id));
    }

    public List<Activity> findAll() {
        return activityRepository.findAll();
    }

    public Activity create(@Valid ActivityDTO objDTO) {
        return activityRepository.save(newChamado(objDTO));
    }

    public Activity update(Integer id, @Valid ActivityDTO objDTO) {
        objDTO.setId(id);
        Activity oldObj = findById(id);
        oldObj = newChamado(objDTO);
        return activityRepository.save(oldObj);
    }

    private Activity newChamado(ActivityDTO obj) {
        Collaborator cliente = collaboratorService.findById(obj.getCollaborator());

        Activity chamado = new Activity();
        if (obj.getId() != null) {
            chamado.setId(obj.getId());
        }

        if (obj.getStatus().equals(2)) {
            chamado.setClosingDate(LocalDate.now());
        }

        chamado.setCollaborator(cliente);
        chamado.setPriority(Priority.toEnum(obj.getPriority()));
        chamado.setStatus(Status.toEnum(obj.getStatus()));
        chamado.setTitle(obj.getTitle());
        chamado.setDescription(obj.getDescription());
        return chamado;

    }
}
