package com.crystaldata.dscatalog.repositories;

import com.crystaldata.dscatalog.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Camada de acesso a dados
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
