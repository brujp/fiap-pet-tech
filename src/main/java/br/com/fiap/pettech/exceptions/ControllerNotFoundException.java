package br.com.fiap.pettech.exceptions;

public class ControllerNotFoundException extends RuntimeException{

    public ControllerNotFoundException(String mensagem) {
        super(mensagem);
    }
}
