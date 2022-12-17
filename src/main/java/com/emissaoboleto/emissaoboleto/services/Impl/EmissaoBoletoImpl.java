package com.emissaoboleto.emissaoboleto.services.Impl;

import com.emissaoboleto.emissaoboleto.domain.DadosBoleto;
import com.emissaoboleto.emissaoboleto.services.EmissaoBoleto;
import com.emissaoboleto.emissaoboleto.utilitarios.ConectaBanco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmissaoBoletoImpl implements EmissaoBoleto {

    @Autowired
    ConectaBanco conecta;


    @Override
    public List<DadosBoleto> buscaDados() {
        conecta.conexao();

        List<DadosBoleto> listaDadosBoleto = new ArrayList<>();

        try {
            conecta.executaPesquisaSQL("Select * from dadosBoleto");
            conecta.rs.first();
            do {
                DadosBoleto dadosBoleto = new DadosBoleto();
                dadosBoleto.setCep(conecta.rs.getString("CEP"));
                dadosBoleto.setEndereco(conecta.rs.getString("ENDERECO"));
                //dadosBoleto.setUf(conecta.rs.getString("UF"));
                dadosBoleto.setNome(conecta.rs.getString("NOME"));
                dadosBoleto.setValor(conecta.rs.getString("VALOR"));
                dadosBoleto.setCpfCnpj(conecta.rs.getString("CPFCNPJ"));
                dadosBoleto.setRegistro(conecta.rs.getString("REGISTRO"));
                dadosBoleto.setCodigoBarras(conecta.rs.getString("CODIGOBARRAAS"));
                dadosBoleto.setDataProcessamento(conecta.rs.getString("DATAPROCESSAMENTO"));
                dadosBoleto.setNumeroGuia(conecta.rs.getString("NGUIA"));
                dadosBoleto.setVencimento(conecta.rs.getString("VENCIMENTO"));
                listaDadosBoleto.add(dadosBoleto);
            } while (conecta.rs.next());

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaDadosBoleto;

    }
}
