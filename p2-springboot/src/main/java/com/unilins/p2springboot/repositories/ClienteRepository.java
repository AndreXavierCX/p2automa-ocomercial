package com.unilins.p2springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unilins.p2springboot.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
