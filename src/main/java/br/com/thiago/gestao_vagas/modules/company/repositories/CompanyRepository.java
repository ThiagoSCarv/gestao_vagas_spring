package br.com.thiago.gestao_vagas.modules.company.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.thiago.gestao_vagas.modules.company.entities.CompanyEntity;

// Repositório JPA para operações de banco de dados sobre CompanyEntity
public interface CompanyRepository extends JpaRepository<CompanyEntity, UUID> {

  // Busca empresa por username OU email — usado para verificar duplicidade no cadastro
  Optional<CompanyEntity> findByUsernameOrEmail(String username, String email);

  // Busca empresa apenas por username — usado no fluxo de autenticação
  Optional<CompanyEntity> findByUsername(String username);
}
