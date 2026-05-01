package br.com.thiago.gestao_vagas.modules.candidate.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.thiago.gestao_vagas.modules.candidate.CandidateEntity;
import br.com.thiago.gestao_vagas.modules.candidate.CandidateRepository;

@RestController
@RequestMapping("/candidate")
public class CandidateController {

  @Autowired
  private CandidateRepository candidateRepository;

  @PostMapping
  public ResponseEntity<Object> create(@Valid @RequestBody CandidateEntity candidateEntity) {
    var result = this.candidateRepository.save(candidateEntity);
    return ResponseEntity.ok().body(result);
  }
}
