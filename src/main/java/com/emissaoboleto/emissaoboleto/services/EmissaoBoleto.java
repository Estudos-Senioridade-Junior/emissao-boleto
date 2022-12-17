package com.emissaoboleto.emissaoboleto.services;

import com.emissaoboleto.emissaoboleto.domain.DadosBoleto;

import java.util.List;

public interface EmissaoBoleto {

    List<DadosBoleto> buscaDados();

}
