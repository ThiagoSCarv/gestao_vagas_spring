package br.com.thiago.gestao_vagas.modules.candidate.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.thiago.gestao_vagas.exceptions.UserAlreadyExistsException;
import br.com.thiago.gestao_vagas.modules.candidate.CandidateEntity;
import br.com.thiago.gestao_vagas.modules.candidate.CandidateRepository;

@Service
public class CreateCandidateUseCase {

  @Autowired
  private CandidateRepository candidateRepository;

  public CandidateEntity execute(CandidateEntity candidateEntity) {
    this.candidateRepository
        .findByUsernameOrEmail(candidateEntity.getUsername(), candidateEntity.getEmail())
        .ifPresent(candidate -> {
          throw new UserAlreadyExistsException();
        });

    return this.candidateRepository.save(candidateEntity);
  }
}
