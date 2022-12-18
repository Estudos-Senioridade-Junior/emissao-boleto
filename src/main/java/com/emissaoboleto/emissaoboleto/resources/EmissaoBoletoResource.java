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

    @GetMapping(path ="/todos")
    public ResponseEntity<String> emitirTodosBoletos(@RequestParam boolean arquivoUnico){
       reportService.buscaTodosOsBoletos(arquivoUnico);
        return ResponseEntity.ok()
                .body("Boletos salvos com sucesso!");
    }

    @GetMapping(path ="/um-boleto")
    public ResponseEntity<String> emitirUmBoleto(@RequestParam String numeroGuia){
        reportService.buscarUmBoleto(numeroGuia);
        return ResponseEntity.ok()
                .body("Boleto salvo com sucesso!");
    }

    @GetMapping(path ="/intervalo-boletos")
    public ResponseEntity<String> emitirIntervaloBoletos(@RequestParam String primeiroIndice,
                                                         @RequestParam String segundoIndice,
                                                         @RequestParam boolean arquivoUnico){
        reportService.buscaIntervaloBoleto(primeiroIndice, segundoIndice, arquivoUnico);
        return ResponseEntity.ok()
                .body("Boletos salvos com sucesso!");
    }


}
