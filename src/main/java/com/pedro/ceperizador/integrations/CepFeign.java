package com.pedro.ceperizador.integrations;

import com.pedro.ceperizador.entities.Cep;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Esta interface utiliza openfeign e retorna o json com os dados do Cep buscado.
 */

@FeignClient(name = "cep", url = "viacep.com.br/ws/")
public interface CepFeign {

    @RequestMapping(value = "/{cep}/json")
    Cep getCepById(@PathVariable String cep);
}
