package com.pedro.ceperizador.services;

import com.pedro.ceperizador.dto.Cep;
import com.pedro.ceperizador.integrations.CepFeign;
import com.pedro.ceperizador.repositories.CepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CepService {

    @Autowired
    private CepFeign cepFeign;

    @Autowired
    private CepRepository cepRepository;


    public static String digitsOnly(String palavra){
        String digits = "";
        char[] letras = palavra.toCharArray();
        for(char letra : letras){
            if(Character.isDigit(letra)){
                digits += letra;
            }
        }
        return digits;
    }

    public Cep getCepById(String cep) {
        String cepVerify = digitsOnly(cep);
        if (cepVerify.length() == 8) {
            return cepFeign.getCepById(cep);
        } else {
            return null;
        }

    }

}
