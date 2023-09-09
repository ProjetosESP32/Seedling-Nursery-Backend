package com.ifmt.gerenciamentoMudas.dto;

import lombok.Data;

@Data
public class ArvoreMatrizDTO {
    private Long id;
    private String nomeComum;
    private String nomeCientifico;
    private double alturaArvore;
    private double alturaFuste;
    private double cap;
    private String formacaoCopa;
    private String formacaoTronco;
    private int densidadeOcorrencia;
    private String uf;
    private String cidade;
    private String tipoSolo;
    private String tipovegetacao;
    private String enderecoColeta;
    private String nomeDeterminador;
    private String lagitude;
    private String longitude;
    private String altitude;
    private String especiesAssociadas;
    private int quantidadeSementes;
    private String imagemMatriz;
    private String observacoes;
}
