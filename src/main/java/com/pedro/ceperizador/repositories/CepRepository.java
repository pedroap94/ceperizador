package com.pedro.ceperizador.repositories;

import com.pedro.ceperizador.dto.Cep;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CepRepository extends JpaRepository<Cep, String> {
}
