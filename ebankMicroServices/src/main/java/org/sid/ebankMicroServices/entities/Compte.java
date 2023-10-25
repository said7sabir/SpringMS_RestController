package org.sid.ebankMicroServices.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sid.ebankMicroServices.enums.TypeCompte;

import java.util.Date;


@Entity
@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class Compte {
    @Id
    private String id;
    private Date dateCreation;
    private double montantCmpt;
    private String devise;
    @Enumerated(EnumType.STRING)
    private TypeCompte type;

}
