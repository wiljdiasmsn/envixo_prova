package br.com.envixo.springboot2.crud.repository;

import br.com.envixo.springboot2.crud.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductsRepository extends JpaRepository<Products, Long>{
    List<Products> findByTitleContaining(String title);

    List<Products> findByEnabled(Boolean Enabled);
}
