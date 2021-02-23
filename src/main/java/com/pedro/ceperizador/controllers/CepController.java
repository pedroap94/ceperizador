package com.pedro.ceperizador.controllers;

import com.pedro.ceperizador.dto.Cep;
import com.pedro.ceperizador.integrations.CepFeign;
import com.pedro.ceperizador.services.CepService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Classe controller onde estão os EndPoints da aplicação para receber o GET com o Cep
 */
@AllArgsConstructor
@RestController
@RequestMapping("cep")
public class CepController {


    private CepService cepService;

    @GetMapping("/{cep}")
    public Cep getCep(@PathVariable String cep) {
        return cepService.getCepById(cep);
    }
}

