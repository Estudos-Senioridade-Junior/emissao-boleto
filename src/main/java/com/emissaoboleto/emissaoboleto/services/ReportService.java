package com.emissaoboleto.emissaoboleto.services;

public interface ReportService {

    byte[] buscaTodosOsBoletos();

    byte[] buscarUmBoleto(String numeroGuia);

    byte[] buscaIntervaloBoleto(String primeiroIndice, String segundoIndice);
}
