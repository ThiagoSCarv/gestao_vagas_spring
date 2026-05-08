package br.com.thiago.gestao_vagas.modules.candidate.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.thiago.gestao_vagas.modules.candidate.CandidateEntity;
import br.com.thiago.gestao_vagas.modules.candidate.useCases.CreateCandidateUseCase;

// Controller responsável pelos endpoints de candidatos
@RestController
@RequestMapping("/candidate")
public class CandidateController {

  @Autowired
  private CreateCandidateUseCase createCandidateUseCase;

  // POST /candidate — cadastra um novo candidato
  // @Valid aciona as validações declaradas em CandidateEntity antes de executar o use case
  @PostMapping
  public ResponseEntity<Object> create(@Valid @RequestBody CandidateEntity candidateEntity) {
    var result = this.createCandidateUseCase.execute(candidateEntity);
    return ResponseEntity.ok().body(result);
  }
}
