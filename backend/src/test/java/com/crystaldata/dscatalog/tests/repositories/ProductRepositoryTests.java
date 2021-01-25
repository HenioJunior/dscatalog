package com.crystaldata.dscatalog.tests.repositories;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.crystaldata.dscatalog.entities.Product;
import com.crystaldata.dscatalog.repositories.ProductRepository;
import com.crystaldata.dscatalog.tests.factory.ProductFactory;


@DataJpaTest
public class ProductRepositoryTests {

    @Autowired
    private ProductRepository repository;
    
    private Long existingId;
    private Long nonExistingId;
    private Long countTotalProducts;
    private Long countPCGamerProducts;
    
    @BeforeEach
    void setUp() throws Exception {
    	existingId = 1L;
    	nonExistingId = 1000L;
    	countTotalProducts = 25L;
    	countPCGamerProducts = 21L;
    }
    
    @Test
    public void findShouldReturnProductsWhenNameExists() {
    	
    	String name = "PC Gamer";
    	PageRequest pageRequest = PageRequest.of(0, 10);
    	
    	Page<Product> result = repository.find(null, name, pageRequest);
    	
    	Assertions.assertFalse(result.isEmpty());
    	Assertions.assertEquals(countPCGamerProducts, result.getTotalElements());
    	
    }
    
    
    
    @Test
    public void saveShouldPersistWithAutoincrementWhenIdIsNull() {
    	Product product = ProductFactory.createProduct();
    	product.setId(null);
    	
    	product = repository.save(product);
    	Optional<Product> result = repository.findById(product.getId());
    	
    	Assertions.assertNotNull(product.getId());
    	Assertions.assertEquals(countTotalProducts + 1L, product.getId());
    	Assertions.assertTrue(result.isPresent());
    	Assertions.assertSame(result.get(), product);
    	
    }

    @Test
    public void deleteShouldDeleteObjectWhenIdExists() {

        repository.deleteById(existingId);

        Optional<Product> result = repository.findById(existingId);

        Assertions.assertFalse(result.isPresent());
    }
    
    @Test
    public void deleteShouldEmptyResultDataAccessExceptionWhenIdDoesNotExists() {

        Assertions.assertThrows(EmptyResultDataAccessException.class, () -> {
        	repository.deleteById(nonExistingId);	
        });
    }
}
