package com.emissaoboleto.emissaoboleto.resources.exceptionhandler;

import lombok.Getter;

@Getter
public enum ProblemType {
	
	//Tipo de Enum (Complemento da uri, título)
	ERRO_DE_SISTEMA("/erro-de-sistema","Erro de sistema"),
	RECURSO_NAO_ENCONTRADO ("/recurso-nao-encontrado", "Recurso não encontrado"),
	ENTIDADE_EM_USO("/entidade-em-uso", "Entidade em uso"),
	ERRO_NEGOCIO("/erro-de-negocio", "Erro de negócio"),
	ERRO_VALIDACAO("/erro-de-validacao", "Erro de validação");

	private String title;
	private String uri;
	
	ProblemType (String path, String title){
		this.title=title;
		this.uri="https://localhost/emite-boleto"+path;
	}

}
