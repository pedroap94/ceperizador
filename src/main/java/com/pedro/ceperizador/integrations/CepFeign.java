package com.pedro.ceperizador.integrations;

import com.pedro.ceperizador.model.Cep;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "cep", url = "viacep.com.br/ws/01001000/json/")
public interface CepFeign {

    @RequestMapping(method = RequestMethod.GET, value = "")
    Cep getCep();
}
