package com.pedro.ceperizador.dto;

import com.pedro.ceperizador.entities.Cep;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CepResponseDTO {
    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
    private String ibge;
    private Integer gia;
    private Integer ddd;
    private Integer siafi;

    public CepResponseDTO(Cep cep){
        this.cep = cep.getCep();
        this.logradouro = cep.getLogradouro();
        this.complemento = cep.getComplemento();
        this.bairro = cep.getBairro();
        this.localidade = cep.getLocalidade();
        this.uf = cep.getUf();
        this.ibge = cep.getIbge();
        this.gia = cep.getGia();
        this.ddd = cep.getDdd();
        this.siafi = cep.getSiafi();
    }
}
