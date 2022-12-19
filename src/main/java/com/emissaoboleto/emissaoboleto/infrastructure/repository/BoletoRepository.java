package com.emissaoboleto.emissaoboleto.infrastructure.repository;

import com.emissaoboleto.emissaoboleto.infrastructure.domain.Boleto2023;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoletoRepository extends JpaRepository<Boleto2023, String> {

    List<Boleto2023>findBoletoByIndiceBetween(String primeiroIndice, String segundoIndice);

    Boleto2023 findByNumeroGuia(String numeroGuia);

}
