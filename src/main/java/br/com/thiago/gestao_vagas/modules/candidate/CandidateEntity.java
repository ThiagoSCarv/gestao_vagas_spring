package br.com.thiago.gestao_vagas.modules.candidate;

import java.util.UUID;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CandidateEntity {

  private UUID id;

  @NotBlank
  @Pattern(regexp = "\\S+", message = "O campo username não deve conter espaços")
  private String username;

  @NotBlank
  private String name;

  @Email(message = "O campo email deve conter um email válido")
  @NotBlank
  private String email;

  @NotBlank
  @Size(min = 8, max = 100, message = "A senha deve ter entre 8 e 100 caracteres")
  private String password;

  private String description;
  private String curriculum;
}
