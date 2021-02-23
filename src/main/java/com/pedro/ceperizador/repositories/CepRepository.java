package com.pedro.ceperizador.repositories;

import com.pedro.ceperizador.dto.Cep;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Interface responsável por adicionar/consultar no banco de dados utilizando JPA
 */

public interface CepRepository extends JpaRepository<Cep, String> {
    public Cep getByCep(String cep);
}
