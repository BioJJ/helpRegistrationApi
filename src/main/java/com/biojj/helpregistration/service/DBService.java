package com.biojj.helpregistration.service;

import com.biojj.helpregistration.domain.Activity;
import com.biojj.helpregistration.domain.Collaborator;
import com.biojj.helpregistration.domain.enums.Priority;
import com.biojj.helpregistration.domain.enums.Profile;
import com.biojj.helpregistration.domain.enums.Status;
import com.biojj.helpregistration.repositories.ActivityRepository;
import com.biojj.helpregistration.repositories.CollaboratorRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class DBService {

    private final CollaboratorRepository collaboratorRepository;

    private final ActivityRepository activityRepository;

    private BCryptPasswordEncoder encoder;

    public DBService(CollaboratorRepository collaboratorRepository, ActivityRepository activityRepository, BCryptPasswordEncoder encoder) {
        this.collaboratorRepository = collaboratorRepository;
        this.activityRepository = activityRepository;
        this.encoder = encoder;
    }

    public void InstanciaDB() {

        Collaborator tec1 = new Collaborator(null, "Pandora", "98024434253", "pandora@gmail.com", encoder.encode("Pandora123"));
        tec1.addProfiles(Profile.ADMIN);

        Collaborator cli1 = new Collaborator(
                null,
                "Jefferson Coelho",
                "02026636206",
                "bio.jeffcoelho@gmail.com",
                encoder.encode("pandora"),
                "Desenvolvedor",
                LocalDate.now(),
                "P&D",
                new BigDecimal(8000));

        Activity c1 = new Activity(null, Priority.MEDIA, Status.ANDAMENTO, "Chamado 01", "Primeiro Chamado", cli1);

        collaboratorRepository.saveAll(List.of(cli1, tec1));
        activityRepository.saveAll(List.of(c1));
    }
}
