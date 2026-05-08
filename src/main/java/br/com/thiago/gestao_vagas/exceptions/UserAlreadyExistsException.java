package br.com.thiago.gestao_vagas.exceptions;

// Exceção lançada quando se tenta cadastrar um usuário com username ou e-mail já existente no banco
public class UserAlreadyExistsException extends RuntimeException {

  public UserAlreadyExistsException() {
    super("Usuário ou e-mail já cadastrado");
  }
}
