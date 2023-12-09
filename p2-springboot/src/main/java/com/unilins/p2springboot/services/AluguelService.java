package com.unilins.p2springboot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unilins.p2springboot.entities.Aluguel;
import com.unilins.p2springboot.entities.pk.PK_Aluguel;
import com.unilins.p2springboot.repositories.AluguelRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AluguelService {

    @Autowired
    private AluguelRepository aluguelRepository;

    public Aluguel saveAluguel(Aluguel aluguel) {
        return aluguelRepository.save(aluguel);
    }

    public Aluguel getAluguel(PK_Aluguel id) {
        Optional<Aluguel> aluguel = aluguelRepository.findById(id);
        return aluguel.orElse(null);
    }

    public List<Aluguel> getAllAlugueis() {
        return aluguelRepository.findAll();
    }

    public Aluguel updateAluguel(PK_Aluguel id, Aluguel updatedAluguel) {
        if (aluguelRepository.existsById(id)) {
            updatedAluguel.setId(id);
            return aluguelRepository.save(updatedAluguel);
        }
        return null;
    }

    public void deleteAluguel(PK_Aluguel id) {
        aluguelRepository.deleteById(id);
    }
}
