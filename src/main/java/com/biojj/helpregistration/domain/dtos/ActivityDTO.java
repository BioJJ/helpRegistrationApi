package com.biojj.helpregistration.domain.dtos;

import com.biojj.helpregistration.domain.Activity;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;


@Getter
@Setter
public class ActivityDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Integer id;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate openDate = LocalDate.now();

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate closingDate;

    @NotNull(message = "O campo Prioridade é requerido")
    private Integer priority;

    @NotNull(message = "O campo Status é requerido")
    private Integer status;

    @NotNull(message = "O campo Titulo é requerido")
    private String title;

    @NotNull(message = "O campo Observações é requerido")
    private String description;

    @NotNull(message = "O campo Cliente é requerido")
    private Integer collaborator;

    public ActivityDTO(Activity obj) {
        super();
        this.id = obj.getId();
        this.openDate = obj.getOpenDate();
        this.closingDate = obj.getClosingDate();
        this.priority = obj.getPriority().getCode();
        this.status = obj.getStatus().getCode();
        this.title = obj.getTitle();
        this.description = obj.getDescription();
        this.collaborator = obj.getCollaborator().getId();
    }

    public ActivityDTO() {
        super();

    }

}
