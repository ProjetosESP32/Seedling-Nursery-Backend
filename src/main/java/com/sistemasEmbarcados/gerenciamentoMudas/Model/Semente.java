package com.sistemasEmbarcados.gerenciamentoMudas.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "sementes")
public class Semente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_semente")
    private Long id;

    @Column(name = "observacao_crescimento")
    private String observacoesCrecimento;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "arvore_matriz_id")
    @JsonBackReference(value = "arvoreMatriz-semente")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private ArvoreMatriz ArvoreMatriz;

    @Column(name = "data_plantio")
    private LocalDate dataPlantio;

    @Column(name = "data_doacao")
    private LocalDate dataDoacao;

    @Basic(fetch=FetchType.LAZY)
    @Column(name = "imagem_matriz", columnDefinition = "bytea")
    private byte[] imagem;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_localizacao")
    @JsonBackReference(value = "Localizacao-Semente")
    private Localizacao localizacaoSemente;

    @Column(name = "estado_semente")
    private String estadoSemente;
}
