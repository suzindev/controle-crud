package br.com.suzintech.controle.infra.persistence.repository;

import br.com.suzintech.controle.infra.persistence.entity.MarcaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarcaRepository extends JpaRepository<MarcaEntity, Long> {
}
