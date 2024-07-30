package com.biojj.helpregistration.domain;

import com.biojj.helpregistration.domain.dtos.CollaboratorDTO;
import com.biojj.helpregistration.domain.enums.Profile;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
public class Collaborator extends User {

    @Serial
    private static final long serialVersionUID = 1L;

    private String cargo;

    @JsonFormat(pattern = "dd/MM/yyyy")
    protected LocalDate dataDeAdmissao;

    private String setor;

    @Positive
    @Column(precision = 10, scale = 2)
    private BigDecimal salario;

    @JsonIgnore
    @OneToMany(mappedBy = "collaborator")
    private List<Activity> activities = new ArrayList<>();

    public Collaborator(Integer id, String name, String cpf, String email, String password, String cargo, LocalDate dataDeAdmissao, String setor, BigDecimal salario) {
        super(id, name, cpf, email, password);
        this.cargo = cargo;
        this.dataDeAdmissao = dataDeAdmissao;
        this.setor = setor;
        this.salario = salario;

        addProfiles(Profile.USER);
    }

    public Collaborator() {
        super();
        addProfiles(Profile.USER);
    }

    public Collaborator(CollaboratorDTO objDTO) {
        super();
        this.id = objDTO.getId();
        this.name = objDTO.getName();
        this.cpf = objDTO.getCpf();
        this.email = objDTO.getEmail();
        this.password = objDTO.getPassword();
        this.profiles = objDTO.getPerfis().stream().map(Profile::getCode).collect(Collectors.toSet());
        this.dataCreation = objDTO.getDatacriacao();
        this.cargo = objDTO.getCargo();
        this.dataDeAdmissao = objDTO.getDataDeAdmissao();
        this.setor = objDTO.getSetor();
        this.salario = objDTO.getSalario();

    }


    public Collaborator(Integer id, String name, String cpf, String email, String password) {
        super(id, name, cpf, email, password);
        addProfiles(Profile.ADMIN);
    }
}
