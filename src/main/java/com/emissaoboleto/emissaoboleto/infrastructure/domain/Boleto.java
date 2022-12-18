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
    @Column(name = "numeroguia", length = 100)
    private String numeroGuia;
    @Column(length = 1000)
    private String indice;
    @Column(length = 1000)
    private String nome;
    @Column(name = "numregistro", length = 12)
    private String numRegistro;
    private Integer categoria;
    @Column(name = "datavencto", length = 100)
    private String dataVencto;
    @Column(name = "dataimpressao", length = 100)
    private String dataImpressao;
    @Column(name = "codigobarras", length = 1000)
    private String codigoBarras;
    @Column(name = "totalguia", length = 100)
    private String totalGuia;
    @Column(name = "cpfcnpj", length = 100)
    private String cpfCnpj;
    @Column(length = 10000)
    private String mensagem;
    @Column(name = "enderecocompleto", length = 1000)
    private String enderecoCompleto;
}
