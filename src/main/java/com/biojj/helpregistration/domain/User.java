package com.biojj.helpregistration.domain;

import com.biojj.helpregistration.domain.enums.Profile;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.br.CPF;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name = "users")
@Data
public abstract class User implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;

    protected String name;

    @CPF()
    @EqualsAndHashCode.Include
    @Column(unique = true)
    protected String cpf;

    @Email
    @Column(unique = true)
    protected String email;

    protected String password;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "Profile")
    protected Set<Integer> profiles = new HashSet<>();

    @JsonFormat(pattern = "dd/MM/yyyy")
    protected LocalDate dataCreation = LocalDate.now();


    public User() {
        super();
    }

    public User(Integer id, String name, String cpf, String email, String password) {
        super();
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.password = password;
    }

    public Set<Profile> getProfiles() {
        return profiles.stream().map(Profile::toEnum).collect(Collectors.toSet());
    }

    public void addProfiles(Profile profile) {
        this.profiles.add(profile.getCode());
    }
}
