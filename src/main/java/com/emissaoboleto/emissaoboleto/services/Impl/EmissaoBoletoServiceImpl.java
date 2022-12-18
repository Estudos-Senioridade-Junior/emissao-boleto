package com.emissaoboleto.emissaoboleto.services.Impl;

import com.emissaoboleto.emissaoboleto.infrastructure.domain.Boleto;
import com.emissaoboleto.emissaoboleto.infrastructure.exception.BoletoNaoEncontradoException;
import com.emissaoboleto.emissaoboleto.infrastructure.repository.BoletoRepository;
import com.emissaoboleto.emissaoboleto.services.EmissaoBoletoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmissaoBoletoServiceImpl implements EmissaoBoletoService {

    @Autowired
    private BoletoRepository boletoRepository;


    @Override
    public List<Boleto> buscaTodos() {
       return boletoRepository.findAll();
    }

    @Override
    public Boleto buscaUmBoleto(String numeroGuia) {
        return boletoRepository.findById(numeroGuia)
                .orElseThrow(() -> new BoletoNaoEncontradoException(numeroGuia));
    }

    @Override
    public List<Boleto> buscaIntervaloBoletos(String primeiroIndice, String segundoIndice){
        return boletoRepository.findBoletoByIndiceBetween(primeiroIndice,segundoIndice);
    }

}
