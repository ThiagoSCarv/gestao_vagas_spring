package br.com.thiago.gestao_vagas.exceptions;

import java.util.List;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// Intercepta exceções lançadas pelos controllers e retorna respostas HTTP padronizadas
@RestControllerAdvice
public class ExceptionHandlerController {

  // MessageSource permite buscar mensagens de validação internacionalizadas (i18n)
  private final MessageSource messageSource;

  public ExceptionHandlerController(MessageSource messageSource) {
    this.messageSource = messageSource;
  }

  // Captura falhas de validação do @Valid e retorna 422 com a lista de campos inválidos
  @ExceptionHandler(MethodArgumentNotValidException.class)
  @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
  public List<ErrorMessageDTO> handleValidationErrors(MethodArgumentNotValidException ex) {
    return ex.getBindingResult().getFieldErrors().stream()
        .map(error -> new ErrorMessageDTO(
            error.getField(),
            messageSource.getMessage(error, LocaleContextHolder.getLocale())))
        .toList();
  }

  // Captura tentativas de cadastro duplicado e retorna 409 Conflict
  @ExceptionHandler(UserAlreadyExistsException.class)
  @ResponseStatus(HttpStatus.CONFLICT)
  public ResponseEntity<String> handleUserAlreadyExists(UserAlreadyExistsException ex) {
    return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
  }
}
