package com.crystaldata.dscatalog.services;

import com.crystaldata.dscatalog.dto.CategoryDTO;
import com.crystaldata.dscatalog.entities.Category;
import com.crystaldata.dscatalog.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseDataSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    @Transactional(readOnly = true)
    public List<CategoryDTO> findAll(){
        List<Category> list = repository.findAll();
         return list.stream().map(x -> new CategoryDTO(x)).collect(Collectors.toList());
    }
}
