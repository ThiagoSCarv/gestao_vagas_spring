package br.com.thiago.gestao_vagas.modules.company.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.thiago.gestao_vagas.exceptions.UserAlreadyExistsException;
import br.com.thiago.gestao_vagas.modules.company.entities.CompanyEntity;
import br.com.thiago.gestao_vagas.modules.company.repositories.CompanyRepository;

// Caso de uso responsável por criar uma nova empresa no sistema
@Service
public class CreateCompanyUseCase {

  @Autowired
  private CompanyRepository companyRepository;

  @Autowired
  private BCryptPasswordEncoder passwordEncoder;

  public CompanyEntity execute(CompanyEntity companyEntity) {
    // Verifica se já existe uma empresa com o mesmo username ou email
    this.companyRepository
        .findByUsernameOrEmail(companyEntity.getUsername(), companyEntity.getEmail())
        .ifPresent(company -> {
          throw new UserAlreadyExistsException();
        });

    // Substitui a senha em texto puro pelo hash BCrypt antes de salvar no banco
    companyEntity.setPassword(passwordEncoder.encode(companyEntity.getPassword()));

    return this.companyRepository.save(companyEntity);
  }
}
