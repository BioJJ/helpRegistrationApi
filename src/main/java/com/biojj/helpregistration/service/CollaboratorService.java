package com.biojj.helpregistration.service;

import com.biojj.helpregistration.domain.Collaborator;
import com.biojj.helpregistration.domain.User;
import com.biojj.helpregistration.domain.dtos.CollaboratorDTO;
import com.biojj.helpregistration.repositories.CollaboratorRepository;
import com.biojj.helpregistration.repositories.UserRepository;
import com.biojj.helpregistration.service.exception.DataIntegrityViolationException;
import com.biojj.helpregistration.service.exception.ObjectNotFoundException;
import jakarta.validation.Valid;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CollaboratorService {

    private final CollaboratorRepository repository;

    private final UserRepository userRepository;

    private final BCryptPasswordEncoder encoder;

    public CollaboratorService(CollaboratorRepository repository, UserRepository userRepository, BCryptPasswordEncoder encoder) {
        this.repository = repository;
        this.userRepository = userRepository;
        this.encoder = encoder;
    }

    public Collaborator findById(Integer id){
        Optional<Collaborator> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! id: "+ id));
    }

    public List<Collaborator> findAll(){
        return repository.findAll();
    }

    public Collaborator create(CollaboratorDTO objDTO){

        objDTO.setId(null);
        validaCpfEmail(objDTO);

        objDTO.setPassword(encoder.encode(objDTO.getPassword()));

        Collaborator obj = new Collaborator(objDTO);
        return repository.save(obj);
    }

    private void validaCpfEmail(CollaboratorDTO objDTO) {
        Optional<User> obj = userRepository.findByCpf(objDTO.getCpf());

        if(obj.isPresent() && !Objects.equals(obj.get().getId(), objDTO.getId())) {
            throw new DataIntegrityViolationException("CPF já cadastrado");
        }

        obj = userRepository.findByEmail(objDTO.getEmail());
        if(obj.isPresent() && !Objects.equals(obj.get().getId(), objDTO.getId())) {
            throw new DataIntegrityViolationException("Email já cadastrado");
        }
    }

    public Collaborator update(Integer id, @Valid CollaboratorDTO objDTO) {
        objDTO.setId(id);
        Collaborator oldObj = findById(id);
        validaCpfEmail(objDTO);


        objDTO.setPassword(encoder.encode(objDTO.getPassword()));

        oldObj = new Collaborator(objDTO);
        return repository.save(oldObj);
    }

    public void delete(Integer id) {
        Collaborator obj = findById(id);
        if(!obj.getActivities().isEmpty()) {
            throw new DataIntegrityViolationException("Colaborador possui Atividades e não pode ser deletado");
        }
        repository.deleteById(id);

    }
}
