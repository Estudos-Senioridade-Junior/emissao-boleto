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
public class Boleto2023 {

    @Column(name = "Nguia")
    private String numeroGuia;
    @Id
    @Column(name = "index")
    private String indice;
    private String nome;
    @Column(name = "registro")
    private String numRegistro;
    private Integer categoria;
    @Column(name = "vencimento")
    private String dataVencto;
    @Column(name = "dtimpressao")
    private String dataImpressao;
    @Column(name = "Codigobarras")
    private String codigoBarras;
    @Column(name = "Totalguia")
    private String totalGuia;
    @Column(name = "CPF")
    private String cpfCnpj;
    private String mensagem;
    @Column(name = "Endereco_Completo")
    private String enderecoCompleto;
    @Column(name = "Linhadigitavel")
    private String linhaDigitavel;

}
