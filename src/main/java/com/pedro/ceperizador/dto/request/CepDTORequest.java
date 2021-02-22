package com.pedro.ceperizador.dto.request;

import com.pedro.ceperizador.model.Cep;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CepDTORequest {

    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
    private String ibge;
    private Integer ddd;

    public Cep build(){
        Cep cep = new Cep()
                .setCep(this.cep)
                .setLogradouro(this.logradouro)
                .setComplemento(this.complemento)
                .setBairro(this.bairro)
                .setLocalidade(this.localidade)
                .setUf(this.uf)
                .setIbge(this.ibge)
                .setDdd(this.ddd);

        return cep;
    }
}

