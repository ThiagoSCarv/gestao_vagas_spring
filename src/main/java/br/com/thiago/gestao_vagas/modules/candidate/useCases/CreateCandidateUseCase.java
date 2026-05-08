package br.com.thiago.gestao_vagas.modules.candidate.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.thiago.gestao_vagas.exceptions.UserAlreadyExistsException;
import br.com.thiago.gestao_vagas.modules.candidate.CandidateEntity;
import br.com.thiago.gestao_vagas.modules.candidate.CandidateRepository;

// Caso de uso responsável por criar um novo candidato no sistema
@Service
public class CreateCandidateUseCase {

  @Autowired
  private CandidateRepository candidateRepository;

  public CandidateEntity execute(CandidateEntity candidateEntity) {
    // Verifica se já existe um candidato com o mesmo username ou email
    this.candidateRepository
        .findByUsernameOrEmail(candidateEntity.getUsername(), candidateEntity.getEmail())
        .ifPresent(candidate -> {
          throw new UserAlreadyExistsException();
        });

    // Nenhum conflito encontrado — persiste o candidato no banco
    return this.candidateRepository.save(candidateEntity);
  }
}
