package com.ifmt.gerenciamentoMudas.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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

}
