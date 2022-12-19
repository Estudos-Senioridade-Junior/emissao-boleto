package com.emissaoboleto.emissaoboleto.infrastructure.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Boleto {

    @Id
    @Column(name = "Numero Guia",columnDefinition="TEXT", nullable = false)
    private String numeroGuia;
    @Column(name = "index",length = 1000)
    private long indice;
    @Column(name = "Nome",length = 1000)
    private String nome;
    @Column(name = "Num. Registro", length = 12)
    private String numRegistro;
    private long categoria;
    @Column(name = "Data Vencto", length = 100)
    private String dataVencto;
    @Column(name = "Data Impressao", length = 100)
    private String dataImpressao;
    @Column(name = "Codigo Barras", length = 1000)
    private String codigoBarras;
    @Column(name = "Total Guia", length = 100)
    private String totalGuia;
    @Column(name = "CPF", length = 100)
    private String cpfCnpj;
    @Column(name = "Mensagem",length = 10000)
    private String mensagem;
    @Column(name = "Endereco_Completo", length = 1000)
    private String enderecoCompleto;
    @Column(name = "Linha Digitavel", length = 1000)
    private String linhaDigitavel;
}
