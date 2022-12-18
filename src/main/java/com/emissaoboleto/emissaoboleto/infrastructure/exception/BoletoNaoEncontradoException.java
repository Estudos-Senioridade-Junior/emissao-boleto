package com.emissaoboleto.emissaoboleto.infrastructure.exception;

public class BoletoNaoEncontradoException extends EntidadeNaoEncontradaException{

    private static final long serialVersionUID = 1L;

    public BoletoNaoEncontradoException(String numeroGuia){
        super(String.format("Não existe guia com o id %s", numeroGuia));
    }
}
