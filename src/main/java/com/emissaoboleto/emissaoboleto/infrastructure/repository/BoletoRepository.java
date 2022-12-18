package com.emissaoboleto.emissaoboleto.infrastructure.repository;

import com.emissaoboleto.emissaoboleto.infrastructure.domain.Boleto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoletoRepository extends JpaRepository<Boleto, String> {

    List<Boleto>findBoletoByIndiceBetween(String primeiroIndice, String segundoIndice);

    Boleto findByNumeroGuia(String numeroGuia);

}
