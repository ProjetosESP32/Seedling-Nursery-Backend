package com.sistemasEmbarcados.gerenciamentoMudas.Model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Type;

import java.io.Serial;
import java.io.Serializable;


@Data
@Entity
@Table(name = "especie")
public class Especie implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome_comum")
    private String nomeComum;

    @Column(name = "nome_cientifico")
    private String nomeCientifico;

    @Column(name = "descricao", length = 10000)
    private String descricao;

    @Basic(fetch=FetchType.LAZY)
    @Column(name = "imagem", columnDefinition = "bytea")
    private byte[] imagem;
}
