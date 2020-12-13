package com.crystaldata.dscatalog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crystaldata.dscatalog.entities.Product;

//Camada de acesso a dados
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
