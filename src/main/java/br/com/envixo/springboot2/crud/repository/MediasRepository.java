package br.com.envixo.springboot2.crud.repository;

import br.com.envixo.springboot2.crud.model.Medias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MediasRepository extends JpaRepository<Medias, Long>{

}
