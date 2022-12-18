package com.emissaoboleto.emissaoboleto.resources;


import com.emissaoboleto.emissaoboleto.services.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/emite-boleto")
public class EmissaoBoletoResource {

    @Autowired
    private ReportService reportService;

    @GetMapping(path ="/todos", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<byte[]> emitirTodosBoletos(){


        byte[] bytesPdf = reportService.buscaTodosOsBoletos();

        var headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=boletos.pdf");

        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_PDF)
                .headers(headers)
                .body(bytesPdf);
    }

    @GetMapping(path ="/um-boleto", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<byte[]> emitirUmBoleto(@RequestParam String numeroGuia){

        var headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=boletos.pdf");

        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_PDF)
                .headers(headers)
                .body(reportService.buscarUmBoleto(numeroGuia));
    }

    @GetMapping(path ="/intervalo-boletos", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<byte[]> emitirIntervaloBoletos(@RequestParam String primeiroIndice,
                                                         @RequestParam String segundoIndice){
        byte[] bytesPdf = reportService.buscaIntervaloBoleto(primeiroIndice, segundoIndice);

        var headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=boletos.pdf");

        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_PDF)
                .headers(headers)
                .body(bytesPdf);
    }


}
