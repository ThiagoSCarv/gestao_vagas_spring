package br.com.thiago.gestao_vagas.modules.company.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.thiago.gestao_vagas.modules.company.entities.JobEntity;
import br.com.thiago.gestao_vagas.modules.company.repositories.JobRepository;

// Caso de uso responsável por criar uma nova vaga no sistema
@Service
public class CreateJobUseCase {

  @Autowired
  private JobRepository jobRepository;

  // Persiste a vaga diretamente — a validação de campos obrigatórios é feita pelo @Valid no controller
  public JobEntity execute(JobEntity jobEntity) {
    return this.jobRepository.save(jobEntity);
  }
}
