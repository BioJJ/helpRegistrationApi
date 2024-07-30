package com.biojj.helpregistration.domain.dtos;

import com.biojj.helpregistration.domain.Collaborator;
import com.biojj.helpregistration.domain.enums.Profile;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
public class CollaboratorDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    protected Integer id;
    protected String name;
    protected String cpf;
    protected String email;
    protected String password;

    protected String cargo;

    @JsonFormat(pattern = "dd/MM/yyyy")
    protected LocalDate dataDeAdmissao = LocalDate.now();

    private String setor;

    private BigDecimal salario;

    protected Set<Integer> profile = new HashSet<>();
    @JsonFormat(pattern = "dd/MM/yyyy")
    protected LocalDate datacriacao = LocalDate.now();

    public Set<Profile> getPerfis() {
        return profile.stream().map(Profile::toEnum).collect(Collectors.toSet());
    }

    public void addPerfil(Profile perfil) {
        this.profile.add(perfil.getCode());
    }

    public CollaboratorDTO() {
        super();
        addPerfil(Profile.USER);
    }

    public CollaboratorDTO(Collaborator obj) {
        super();
        this.id = obj.getId();
        this.name = obj.getName();
        this.cpf = obj.getCpf();
        this.email = obj.getEmail();
        this.password = obj.getPassword();
        this.profile = obj.getProfiles().stream().map(Profile::getCode).collect(Collectors.toSet());
        this.datacriacao = obj.getDataCreation();
        this.setor = obj.getSetor();
        this.salario = obj.getSalario();
        this.dataDeAdmissao = obj.getDataDeAdmissao();
        this.cargo = obj.getCargo();
        addPerfil(Profile.USER);
    }
}
