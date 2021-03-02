package com.pedro.ceperizador.services;

import com.pedro.ceperizador.dto.CepResponseDTO;
import com.pedro.ceperizador.entities.Cep;
import com.pedro.ceperizador.exceptions.InvalidCepException;
import com.pedro.ceperizador.integrations.CepFeign;
import com.pedro.ceperizador.repositories.CepRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Classe onde estão as regras de negócio.
 */

@Service
@AllArgsConstructor
public class CepService {

    static final Pattern pattern = Pattern.compile("\\D", Pattern.MULTILINE);

    private final CepFeign cepFeign;

    private final CepRepository cepRepository;


    /**
     * Este método busca o Cep pelo Id, primeiramente no banco de dados, e caso não exista, busca na API-CEP.
     *
     * @param cep
     * @return Cep do banco de dados, ou Cep da API-CEP,
     * ou lança uma exceção em caso de cep informado com mais ou menos números que necessário
     */
    public CepResponseDTO getCepById(String cep) throws InvalidCepException {
        //retorna apenas os números do CEP digitado

        final Matcher result = pattern.matcher(cep);
        final String cepVerify = result.replaceAll("");

        if (cepVerify.length() != 8) {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "O CEP deve conter 8 dígitos.", new Throwable());
            throw new InvalidCepException();
        }

        StringBuilder stringBuilder = new StringBuilder(cepVerify); //utilizado StringBuilder para gerar o cep igual ao que é salvo no banco com hífen
        stringBuilder.insert(5, '-');

        //se não existir cep no banco, busca na api e cria o registro no banco.
        Cep cep2 = cepRepository.getByCep(stringBuilder.toString());
        return new CepResponseDTO(Objects.isNull(cep2) ? cepRepository.save(cepFeign.getCepById(cepVerify)) : cep2);

//            if (Objects.isNull(cep2)){
//                return new CepResponseDTO(cepRepository.save(cepFeign.getCepById(cepVerify)));
//
//            //caso exista, retorna o registro do banco.
//            } else{
//                return new CepResponseDTO(cep2);
//            }

        //se o cep inserido contiver mais ou menos do que 8 números, retorna exceção.
    }
}
