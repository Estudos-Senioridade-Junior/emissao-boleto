package com.emissaoboleto.emissaoboleto.resources;

import com.emissaoboleto.emissaoboleto.domain.DadosBoleto;
import com.emissaoboleto.emissaoboleto.services.EmissaoBoleto;
import com.emissaoboleto.emissaoboleto.services.ReportService;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private EmissaoBoleto emissaoBoleto;

    @Override
    public void emitirTodosBoletos() {
        try {
            var inputStream = this.getClass().getResourceAsStream("/boletoCobranca.jasper");

            var parameters = new HashMap<String, Object>();
            parameters.put("REPORT_LOCALE", new Locale("pt", "BR"));
            parameters.put("teste", "teste");

            List<DadosBoleto> listaDados = emissaoBoleto.buscaDados();

            var dataSource = new JRBeanCollectionDataSource(listaDados);

           var jasperPrint = JasperFillManager.fillReport(inputStream, parameters, dataSource);

            JasperExportManager.exportReportToPdfFile(jasperPrint, "/novoBoleto.pdf");

        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }
}
