package com.ifmt.gerenciamentoMudas.Model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "specie")
public class Specie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "scien-name")
    private String scienName;

    @Column(name = "description", length = 10000)
    private String description;

    @Basic(fetch = FetchType.LAZY)
    @Column(name = "image", columnDefinition = "bytea")
    private byte[] image;
}
