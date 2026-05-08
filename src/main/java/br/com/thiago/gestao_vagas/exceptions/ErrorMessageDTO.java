package br.com.thiago.gestao_vagas.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

// DTO usado para padronizar a resposta de erros de validação
// Cada instância representa um campo inválido e sua mensagem de erro
@Data
@AllArgsConstructor
public class ErrorMessageDTO {

  private String field;    // nome do campo que falhou na validação
  private String message;  // mensagem descritiva do erro
}
