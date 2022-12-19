package com.emissaoboleto.emissaoboleto.services.Impl;

import com.emissaoboleto.emissaoboleto.infrastructure.domain.Boleto2023;
import com.emissaoboleto.emissaoboleto.infrastructure.exception.BoletoNaoEncontradoException;
import com.emissaoboleto.emissaoboleto.infrastructure.repository.BoletoRepository;
import com.emissaoboleto.emissaoboleto.services.EmissaoBoletoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class EmissaoBoletoServiceImpl implements EmissaoBoletoService {

    @Autowired
    private BoletoRepository boletoRepository;


    @Override
    public List<Boleto2023> buscaTodos() {
       return boletoRepository.findAll();
    }

    @Override
    public Boleto2023 buscaUmBoleto(String numeroGuia) {
        Boleto2023 boleto = boletoRepository.findByNumeroGuia(numeroGuia);
        if (Objects.isNull(boleto)){
            throw new BoletoNaoEncontradoException(numeroGuia);
        }
        return boleto;
    }

    @Override
    public List<Boleto2023> buscaIntervaloBoletos(String primeiroIndice, String segundoIndice){
        return boletoRepository.findBoletoByIndiceBetween(primeiroIndice,segundoIndice);
    }

}
