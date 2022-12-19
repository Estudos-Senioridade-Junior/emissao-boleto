package com.emissaoboleto.emissaoboleto.services.Impl;

import com.emissaoboleto.emissaoboleto.infrastructure.domain.Boleto2023;
import com.emissaoboleto.emissaoboleto.services.EmissaoBoletoService;
import com.emissaoboleto.emissaoboleto.services.ReportService;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private EmissaoBoletoService emissaoBoleto;

    @Value("${local.salvamento.boletos}")
    private String localSalvamento;

    private void emitirBoletos(List<Boleto2023> boleto2023Impressao, boolean arquivoUnico) {
        try {
            var inputStream = this.getClass().getResourceAsStream("/boletoCobranca.jasper");
            var numeroGuia = "";

            if (Boolean.FALSE.equals(arquivoUnico)) {
                numeroGuia = boleto2023Impressao.get(0).getNumeroGuia() + ".pdf";
            }

            var parameters = new HashMap<String, Object>();
            parameters.put("REPORT_LOCALE", new Locale("pt", "BR"));

            var dataSource = new JRBeanCollectionDataSource(boleto2023Impressao);

            var jasperPrint = JasperFillManager.fillReport(inputStream, parameters, dataSource);

            if (Boolean.FALSE.equals(arquivoUnico)) {
                JasperExportManager.exportReportToPdfFile(jasperPrint, localSalvamento + numeroGuia);
            } else {
                JasperExportManager.exportReportToPdfFile(jasperPrint, localSalvamento + "boletos.pdf");
            }

        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void buscaTodosOsBoletos(boolean arquivoUnico) {
        List<Boleto2023> listaTodosOsBoleto2023s = emissaoBoleto.buscaTodos();
        if (Boolean.FALSE.equals(arquivoUnico)) {
            listaTodosOsBoleto2023s.stream()
                    .peek(boleto2023 -> emitirBoletos(Collections.singletonList(boleto2023), arquivoUnico))
                    .collect(Collectors.toList());
        } else {
            emitirBoletos(listaTodosOsBoleto2023s, arquivoUnico);
        }

    }

    @Override
    public void buscarUmBoleto(String numeroGuia) {
        Boleto2023 boleto2023 = emissaoBoleto.buscaUmBoleto(numeroGuia);
        emitirBoletos(Collections.singletonList(boleto2023), false);
    }

    @Override
    public void buscaIntervaloBoleto(String primeiroIndice, String segundoIndice, boolean arquivoUnico) {
        List<Boleto2023> listaIntervaloBoleto2023s = emissaoBoleto.buscaIntervaloBoletos(primeiroIndice, segundoIndice);
        if (Boolean.FALSE.equals(arquivoUnico)) {
            listaIntervaloBoleto2023s.stream()
                    .peek(boleto2023 -> emitirBoletos(Collections.singletonList(boleto2023), arquivoUnico))
                    .collect(Collectors.toList());
        } else {
            emitirBoletos(listaIntervaloBoleto2023s, arquivoUnico);
        }
    }

}
