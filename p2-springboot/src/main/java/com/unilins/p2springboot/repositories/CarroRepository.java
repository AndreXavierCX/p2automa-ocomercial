package com.unilins.p2springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unilins.p2springboot.entities.*;
import com.unilins.p2springboot.entities.pk.*;

public interface CarroRepository extends JpaRepository<Carro, Long> {

}
