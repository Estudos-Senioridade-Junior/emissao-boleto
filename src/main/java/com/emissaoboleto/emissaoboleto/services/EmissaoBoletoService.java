package com.emissaoboleto.emissaoboleto.services;

import com.emissaoboleto.emissaoboleto.infrastructure.domain.Boleto;

import java.util.List;

public interface EmissaoBoletoService {

    List<Boleto> buscaTodos();

    Boleto buscaUmBoleto (String numeroGuia);

    List<Boleto> buscaIntervaloBoletos(String primeiroIndice, String segundoIndice);

}
