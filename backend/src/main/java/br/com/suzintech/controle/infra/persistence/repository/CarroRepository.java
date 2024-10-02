package br.com.suzintech.controle.infra.persistence.repository;

import br.com.suzintech.controle.infra.persistence.entity.CarroEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarroRepository extends JpaRepository<CarroEntity, Long> {
}
