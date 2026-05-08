package br.com.thiago.gestao_vagas.modules.company.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

// Entidade JPA mapeada para a tabela "job" — representa uma vaga cadastrada por uma empresa
@Data
@Entity
@Table(name = "job")
public class JobEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  private String description; // descrição detalhada da vaga
  private String level;       // nível exigido (ex.: júnior, pleno, sênior)
  private String benefits;    // benefícios oferecidos

  // Relacionamento leitura-only com CompanyEntity — usado apenas para joins e consultas
  // insertable/updatable = false porque a FK é gerenciada pela coluna id_company abaixo
  @ManyToOne
  @JoinColumn(name = "id_company", insertable = false, updatable = false)
  private CompanyEntity company;

  // Coluna FK que efetivamente persiste o vínculo com a empresa no banco
  @NotNull
  @Column(name = "id_company")
  private UUID idCompany;

  @CreationTimestamp
  private LocalDateTime createdAt;

  @UpdateTimestamp
  private LocalDateTime updatedAt;
}
