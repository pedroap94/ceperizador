package com.pedro.ceperizador.integrations;

import com.pedro.ceperizador.dto.Cep;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "cep", url = "viacep.com.br/ws/")
public interface CepFeign {

    @RequestMapping(value = "/{cep}/json")
    Cep getCepById(@PathVariable String cep);
}
