package br.com.thiago.gestao_vagas.modules.candidate;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

// Repositório JPA para operações de banco de dados sobre CandidateEntity
public interface CandidateRepository extends JpaRepository<CandidateEntity, UUID> {

  // Busca candidato por username OU email — usado para verificar duplicidade no cadastro
  Optional<CandidateEntity> findByUsernameOrEmail(String username, String email);
}
