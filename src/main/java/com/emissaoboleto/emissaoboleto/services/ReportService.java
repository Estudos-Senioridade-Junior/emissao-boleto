package com.emissaoboleto.emissaoboleto.services;

public interface ReportService {

    void buscaTodosOsBoletos();

    void buscarUmBoleto(String numeroGuia);

    void buscaIntervaloBoleto(String primeiroIndice, String segundoIndice);
}
