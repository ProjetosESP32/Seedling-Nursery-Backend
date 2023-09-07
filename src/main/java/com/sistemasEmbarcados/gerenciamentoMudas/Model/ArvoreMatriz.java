package com.sistemasEmbarcados.gerenciamentoMudas.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "arvore_matriz")
public class ArvoreMatriz implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_arvore_matriz")
    private Long id;

    @Column(name = "nome_comum")
    private String nomeComum;

    @Column(name = "nome_cientifico")
    private String nomeCientifico;

    @Column(name = "altura_arvore")
    private double alturaArvore;

    @Column(name = "altura_fuste")
    private double alturaFuste;

    @Column(name = "cap")
    private double cap;

    @Column(name = "formacao_copa")
    private String formacaoCopa;

    @Column(name = "formacao_tronco")
    private String formacaoTronco;

    @Column(name = "densidade_ocorrencia")
    private int densidadeOcorrencia;

    @Column(name = "nome_uf")
    private String uf;

    @Column(name = "nome_cidade")
    private String cidade;

    @Column(name = "tipo_solo")
    private String tipoSolo;

    @Column(name = "tipo_vegetacao")
    private String tipovegetacao;

    @Column(name = "endereco_coleta")
    private String enderecoColeta;

    @Column(name = "nome_determinador")
    private String nomeDeterminador;

    @Column(name = "lagitude")
    private String lagitude;

    @Column(name = "longitude")
    private String longitude;

    @Column(name = "altitude")
    private String altitude;

    @Column(name = "especies_associadas")
    private String especiesAssociadas;

    @Column(name = "qtd_sementes")
    private int quantidadeSementes;

    @Basic(fetch=FetchType.LAZY)
    @Column(name = "imagem_matriz", columnDefinition = "bytea")
    @JsonIgnore
    private byte[] imagem;

    @Column(name = "observacoes", length = 10000)
    private String observacoes;

    @JsonManagedReference(value = "arvoreMatriz-semente")
    @OneToMany(mappedBy = "ArvoreMatriz", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Semente> sementeList;

}
