package com.crystaldata.dscatalog.repositories;

import com.crystaldata.dscatalog.entities.Category;
import com.crystaldata.dscatalog.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Camada de acesso a dados
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
