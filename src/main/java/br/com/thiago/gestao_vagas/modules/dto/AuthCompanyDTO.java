package br.com.thiago.gestao_vagas.modules.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

// DTO que carrega as credenciais enviadas pela empresa no momento do login
@Data
@AllArgsConstructor
public class AuthCompanyDTO {

    private String username;
    private String password;
}
