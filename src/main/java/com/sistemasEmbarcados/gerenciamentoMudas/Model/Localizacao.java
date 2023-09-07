package com.sistemasEmbarcados.gerenciamentoMudas.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "localizacao")
public class Localizacao {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_localizacao")
    private Long id;

    @Column(name = "nome_localizacao")
    private String nomeLocalizacao;

    @Column(name = "quantidade_microControlador")
    private int quantidadeMicroControlador;

    @JsonManagedReference(value = "Localizacao-MicroControlador")
    @OneToMany(mappedBy = "localizacaoMicroControlador", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<MicroControlador> microControladorList;

    @JsonManagedReference(value = "Localizacao-Semente")
    @OneToMany(mappedBy = "localizacaoSemente", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Semente> sementeList;
}
