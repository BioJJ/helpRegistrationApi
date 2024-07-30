package com.biojj.helpregistration.domain;

import com.biojj.helpregistration.domain.enums.Priority;
import com.biojj.helpregistration.domain.enums.Status;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate openDate = LocalDate.now();

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate closingDate;

    @ManyToOne
    @JoinColumn(name = "collaborator_id")
    private Collaborator collaborator;

    private Priority priority;
    private Status status;
    private String title;
    private String description;

    public Activity(Integer id, Priority priority, Status status, String title, String description, Collaborator collaborator) {
        super();
        this.id = id;
        this.priority = priority;
        this.status = status;
        this.title = title;
        this.description = description;
        this.collaborator = collaborator;
    }

    public Activity() {
    }

}
