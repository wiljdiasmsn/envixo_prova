package br.com.envixo.springboot2.crud.repository;

import br.com.envixo.springboot2.crud.model.Categories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriesRepository extends JpaRepository<Categories, Long>{

}
