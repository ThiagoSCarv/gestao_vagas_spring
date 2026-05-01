package br.com.thiago.gestao_vagas.exceptions;

public class UserAlreadyExistsException extends RuntimeException {

  public UserAlreadyExistsException() {
    super("Usuário ou e-mail já cadastrado");
  }
}
