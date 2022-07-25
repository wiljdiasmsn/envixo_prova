package br.com.envixo.springboot2.crud.repository;

import br.com.envixo.springboot2.crud.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepository extends JpaRepository<Products, Long>{

}
