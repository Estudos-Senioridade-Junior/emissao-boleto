package com.emissaoboleto.emissaoboleto.services;

import com.emissaoboleto.emissaoboleto.infrastructure.domain.Boleto2023;

import java.util.List;

public interface EmissaoBoletoService {

    List<Boleto2023> buscaTodos();

    Boleto2023 buscaUmBoleto (String numeroGuia);

    List<Boleto2023> buscaIntervaloBoletos(String primeiroIndice, String segundoIndice);


}
