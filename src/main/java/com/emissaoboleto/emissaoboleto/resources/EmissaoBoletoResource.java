package com.emissaoboleto.emissaoboleto.resources;


import com.emissaoboleto.emissaoboleto.infrastructure.domain.Boleto2023;
import com.emissaoboleto.emissaoboleto.services.EmissaoBoletoService;
import com.emissaoboleto.emissaoboleto.services.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/emite-boleto")
public class EmissaoBoletoResource {

    @Autowired
    private ReportService reportService;

    @Autowired
    private EmissaoBoletoService emissaoBoletoService;

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

    @GetMapping(path = "/teste-base")
    public List<Boleto2023> testeBase(){
        return emissaoBoletoService.buscaTodos();
    }



}
