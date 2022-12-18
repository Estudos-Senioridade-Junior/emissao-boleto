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

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private EmissaoBoletoService emissaoBoleto;

    private byte[] emitirBoletos(List<Boleto> boletoImpressao) {
        try {
            var inputStream = this.getClass().getResourceAsStream("/boletoCobranca.jasper");

            var parameters = new HashMap<String, Object>();
            parameters.put("REPORT_LOCALE", new Locale("pt", "BR"));

            var dataSource = new JRBeanCollectionDataSource(boletoImpressao);

            var jasperPrint = JasperFillManager.fillReport(inputStream, parameters, dataSource);

            return JasperExportManager.exportReportToPdf(jasperPrint);

        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public byte[] buscaTodosOsBoletos() {
       List<Boleto> listaTodosOsBoletos = emissaoBoleto.buscaTodos();
       return emitirBoletos(listaTodosOsBoletos);
    }

    @Override
    public byte[] buscarUmBoleto(String numeroGuia) {
        Boleto boleto = emissaoBoleto.buscaUmBoleto(numeroGuia);
        return emitirBoletos(Collections.singletonList(boleto));
    }

    @Override
    public byte[] buscaIntervaloBoleto(String primeiroIndice, String segundoIndice) {
        List<Boleto> listaIntervaloBoletos = emissaoBoleto.buscaIntervaloBoletos(primeiroIndice, segundoIndice);
        return emitirBoletos(listaIntervaloBoletos);
    }


}
