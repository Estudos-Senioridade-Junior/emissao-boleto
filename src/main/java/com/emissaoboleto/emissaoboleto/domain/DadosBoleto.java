package com.emissaoboleto.emissaoboleto.domain;

import lombok.Data;

@Data
public class DadosBoleto {

    private String nome;
    private String endereco;
    private String cep;
    private String cidade;
    private String uf;
    private String registro;
    private String cpfCnpj;
    private String codigoBarras;
    private String vencimento;
    private String dataProcessamento;
    private String numeroGuia;
    private String valor;
}
