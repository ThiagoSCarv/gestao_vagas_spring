package br.com.thiago.gestao_vagas.modules.company.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.thiago.gestao_vagas.modules.company.entities.JobEntity;

// Repositório JPA para operações de banco de dados sobre JobEntity
// Os métodos básicos (save, findById, findAll, delete) são herdados de JpaRepository
public interface JobRepository extends JpaRepository<JobEntity, UUID> {

}
