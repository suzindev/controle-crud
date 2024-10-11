package br.com.suzintech.controle.infra.persistence.repository;

import br.com.suzintech.controle.infra.persistence.entity.AcessorioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AcessorioRepository extends JpaRepository<AcessorioEntity, Long> {
}
