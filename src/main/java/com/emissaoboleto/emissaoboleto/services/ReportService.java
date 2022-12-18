package com.emissaoboleto.emissaoboleto.services;

public interface ReportService {

    void buscaTodosOsBoletos(boolean arquivoUnico);

    void buscarUmBoleto(String numeroGuia);

    void buscaIntervaloBoleto(String primeiroIndice, String segundoIndice, boolean arquivoUnico);

}
