package com.emissaoboleto.emissaoboleto.services.Impl;

import com.emissaoboleto.emissaoboleto.infrastructure.domain.Boleto;
import com.emissaoboleto.emissaoboleto.services.EmissaoBoletoService;
import com.emissaoboleto.emissaoboleto.services.ReportService;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private EmissaoBoletoService emissaoBoleto;

    private void emitirBoletos(List<Boleto> boletoImpressao) {
        try {
            var inputStream = this.getClass().getResourceAsStream("/boletoCobranca.jasper");

            var numeroGuia = boletoImpressao.get(0).getNumeroGuia() + ".pdf";

            var parameters = new HashMap<String, Object>();
            parameters.put("REPORT_LOCALE", new Locale("pt", "BR"));

            var dataSource = new JRBeanCollectionDataSource(boletoImpressao);

            var jasperPrint = JasperFillManager.fillReport(inputStream, parameters, dataSource);

            JasperExportManager.exportReportToPdfFile(jasperPrint, "C:\\Users\\Patrick\\Documents\\boletos\\" + numeroGuia);


        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void buscaTodosOsBoletos() {
        List<Boleto> listaTodosOsBoletos = emissaoBoleto.buscaTodos();
        listaTodosOsBoletos.stream()
                .peek(boleto -> emitirBoletos(Collections.singletonList(boleto)))
                .collect(Collectors.toList());

    }

    @Override
    public void buscarUmBoleto(String numeroGuia) {
        Boleto boleto = emissaoBoleto.buscaUmBoleto(numeroGuia);
        emitirBoletos(Collections.singletonList(boleto));
    }

    @Override
    public void buscaIntervaloBoleto(String primeiroIndice, String segundoIndice) {
        List<Boleto> listaIntervaloBoletos = emissaoBoleto.buscaIntervaloBoletos(primeiroIndice, segundoIndice);
        emitirBoletos(listaIntervaloBoletos);
    }


}
