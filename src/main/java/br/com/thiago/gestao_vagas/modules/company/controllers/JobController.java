package br.com.thiago.gestao_vagas.modules.company.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.thiago.gestao_vagas.modules.company.entities.JobEntity;
import br.com.thiago.gestao_vagas.modules.company.useCases.CreateJobUseCase;

import jakarta.validation.Valid;

// Controller responsável pelos endpoints de vagas
@RestController
@RequestMapping("/job")
public class JobController {

  @Autowired
  private CreateJobUseCase createJobUseCase;

  // POST /job — cadastra uma nova vaga vinculada a uma empresa
  // Rota protegida: exige autenticação conforme regra definida no SecurityConfig
  @PostMapping
  public ResponseEntity<Object> create(@Valid @RequestBody JobEntity jobEntity) {
    try {
      var result = this.createJobUseCase.execute(jobEntity);
      return ResponseEntity.ok().body(result);
    } catch (Exception e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }
}
