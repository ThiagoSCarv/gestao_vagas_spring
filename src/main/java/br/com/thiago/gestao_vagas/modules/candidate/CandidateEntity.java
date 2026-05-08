package br.com.thiago.gestao_vagas.modules.candidate;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

// Entidade JPA mapeada para a tabela "candidate" no banco de dados
@Data
@Entity
@Table(name = "candidate")
public class CandidateEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID) // UUID gerado automaticamente pelo banco
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

  private String description; // descrição/bio do candidato
  private String curriculum;  // link ou caminho para o currículo

  @CreationTimestamp
  private LocalDateTime createdAt; // preenchido automaticamente na inserção

  @UpdateTimestamp
  private LocalDateTime updatedAt; // atualizado automaticamente a cada alteração
}
