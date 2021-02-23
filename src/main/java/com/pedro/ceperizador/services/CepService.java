package com.pedro.ceperizador.services;

import com.pedro.ceperizador.dto.Cep;
import com.pedro.ceperizador.integrations.CepFeign;
import com.pedro.ceperizador.repositories.CepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Classe onde estão as regras de negócio.
 */

@Service
public class CepService {

    @Autowired
    private CepFeign cepFeign;

    @Autowired
    private CepRepository cepRepository;


    /**
     * Método auxiliar para retirar o que não for dígito do CEP
     * @param palavra
     * @return digits
     */
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

    /**
     * Este método busca o Cep pelo Id, primeiramente no banco de dados, e caso não exista, busca na API-CEP.
     * @param cep
     * @return Cep do banco de dados, ou Cep da API-CEP,
     * ou null em caso de cep informado com mais ou menos números que necessário
     */
    public Cep getCepById(String cep) {
        String cepVerify = digitsOnly(cep); //retorna apenas os números do CEP digitado
        if (cepVerify.length() == 8) {
            StringBuilder stringBuilder = new StringBuilder(cepVerify); //utilizado StringBuilder para gerar o cep igual ao que é salvo no banco com hífen
            stringBuilder.insert(5,'-');
            System.out.println(stringBuilder.toString());

            //se não existir cep no banco, busca na api e cria o registro no banco.
            if (cepRepository.getByCep(stringBuilder.toString()) == null){
                Cep cepAux = cepFeign.getCepById(cepVerify);
                cepRepository.save(cepAux);
                return cepAux;

            //caso exista, retorna o registro do banco.
            } else{
                return cepRepository.getByCep(stringBuilder.toString());
            }

        //se o cep inserido contiver mais ou menos do que 8 números, retorna null.
        } else {
            return null;
        }

    }

}
