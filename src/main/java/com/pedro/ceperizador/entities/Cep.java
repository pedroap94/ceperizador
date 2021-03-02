package com.pedro.ceperizador.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;


@Data
@NoArgsConstructor
@Accessors(chain = true)
@Entity
public class Cep implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
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
}
