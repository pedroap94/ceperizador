package com.pedro.ceperizador.controllers;

import com.pedro.ceperizador.dto.CepResponseDTO;
import com.pedro.ceperizador.exceptions.InvalidCepException;
import com.pedro.ceperizador.services.CepService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.net.http.HttpResponse;

/**
 * Classe controller onde estão os EndPoints da aplicação para receber o GET com o Cep
 */
@AllArgsConstructor
@RestController
@RequestMapping("cep")
public class CepController {


    private CepService cepService;

    @GetMapping("/{cep}")
    public CepResponseDTO getCep(@PathVariable String cep) {
        try {
            return cepService.getCepById(cep);
        } catch (InvalidCepException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
}

