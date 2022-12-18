package com.emissaoboleto.emissaoboleto.infrastructure.exception;

public class EntidadeNaoEncontradaException extends NegocioException{

    //Classe mais específica da nossa exception. Todas as exceptions que representem NotFound de um recurso herdarão esta classe
    private static final long serialVersionUID = 1L;

    public EntidadeNaoEncontradaException (String mensagem){
        super(mensagem);
    }
}
