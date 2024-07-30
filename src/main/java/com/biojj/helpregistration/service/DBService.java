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

        Collaborator tec1 = new Collaborator(null, "adm", "98024434253", "adm@gmail.com", encoder.encode("adm123"));
        tec1.addProfiles(Profile.ADMIN);

        Collaborator cli1 = new Collaborator(
                null,
                "Jefferson Coelho",
                "02026636206",
                "bio.jeffcoelho@gmail.com",
                encoder.encode("pandora"),
                "Desenvolvedor",
                LocalDate.now(),
                "Desenvolvimento",
                new BigDecimal(8000));

        Collaborator cli2 = new Collaborator(
                null,
                "Snow Coelho",
                "44384488084",
                "snow@gmail.com",
                encoder.encode("snow123"),
                "CEO",
                LocalDate.now(),
                "Diretoria",
                new BigDecimal(18000));

        Collaborator cli3 = new Collaborator(
                null,
                "Brutus Coelho",
                "26221901073",
                "brutus@gmail.com",
                encoder.encode("brutus123"),
                "Setoritsta",
                LocalDate.now(),
                "P&D",
                new BigDecimal(8000));

        Collaborator cli4 = new Collaborator(
                null,
                "Pandora Coelho",
                "32181102031",
                "pandora@gmail.com",
                encoder.encode("pandora123"),
                "Analista Contabel",
                LocalDate.now(),
                "Financeiro",
                new BigDecimal(8000));

        Activity c1 = new Activity(null, Priority.BAIXA, Status.ABERTO, "Chamado 01", "1º Chamado", cli1);
        Activity c2 = new Activity(null, Priority.BAIXA, Status.ABERTO, "Chamado 02", "2º Chamado", cli1);
        Activity c3 = new Activity(null, Priority.BAIXA, Status.ABERTO, "Chamado 03", "3º Chamado", cli1);
        Activity c4 = new Activity(null, Priority.MEDIA, Status.ANDAMENTO, "Chamado 04", "4º Chamado", cli1);
        Activity c5 = new Activity(null, Priority.MEDIA, Status.ANDAMENTO, "Chamado 05", "5º Chamado", cli1);
        Activity c6 = new Activity(null, Priority.MEDIA, Status.ANDAMENTO, "Chamado 06", "6º Chamado", cli1);
        Activity c7 = new Activity(null, Priority.ALTA, Status.ANDAMENTO, "Chamado 07", "7º Chamado", cli1);
        Activity c8 = new Activity(null, Priority.ALTA, Status.ANDAMENTO, "Chamado 08", "8º Chamado", cli1);
        Activity c9 = new Activity(null, Priority.ALTA, Status.ANDAMENTO, "Chamado 09", "9º Chamado", cli1);
        Activity c10 = new Activity(null, Priority.ALTA, Status.ANDAMENTO, "Chamado 10", "10º Chamado", cli1);

        collaboratorRepository.saveAll(List.of(cli1, tec1, cli2, cli3, cli4));
        activityRepository.saveAll(List.of(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10));
    }
}
