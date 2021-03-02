package com.pedro.ceperizador.exceptions;

public class InvalidCepException extends Exception {
    public InvalidCepException (String errorMessage) {
        super(errorMessage);
    }

    public InvalidCepException(){
        super("O CEP deve conter 8 dígitos.");
    }
}
