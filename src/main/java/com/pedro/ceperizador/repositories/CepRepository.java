package com.pedro.ceperizador.repositories;

import com.pedro.ceperizador.entities.Cep;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface responsável por adicionar/consultar no banco de dados utilizando JPA
 */

public interface CepRepository extends JpaRepository<Cep, String> {
    public Cep getByCep(String cep);
}
