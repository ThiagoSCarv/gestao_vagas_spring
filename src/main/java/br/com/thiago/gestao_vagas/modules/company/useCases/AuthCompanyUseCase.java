package br.com.thiago.gestao_vagas.modules.company.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.thiago.gestao_vagas.modules.company.entities.CompanyEntity;
import br.com.thiago.gestao_vagas.modules.company.repositories.CompanyRepository;
import br.com.thiago.gestao_vagas.modules.dto.AuthCompanyDTO;

// Caso de uso responsável por autenticar uma empresa com username e senha
@Service
public class AuthCompanyUseCase {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public CompanyEntity execute(AuthCompanyDTO authCompanyDTO) {
        // Busca a empresa pelo username — lança exceção se não encontrada
        CompanyEntity company = this.companyRepository
                .findByUsername(authCompanyDTO.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("Username/password incorrect"));

        // Compara a senha enviada com o hash armazenado no banco usando BCrypt
        boolean passwordMatches = passwordEncoder.matches(authCompanyDTO.getPassword(), company.getPassword());

        // Mensagem genérica intencional: não revela se o erro é no username ou na senha
        if (!passwordMatches) {
            throw new BadCredentialsException("Username/password incorrect");
        }

        return company;
    }
}
