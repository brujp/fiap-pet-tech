package br.com.fiap.pettech.controllers.exceptions;

public class ControllerNotFoundException extends RuntimeException{

    public ControllerNotFoundException(String mensagem) {
        super(mensagem);
    }
}
