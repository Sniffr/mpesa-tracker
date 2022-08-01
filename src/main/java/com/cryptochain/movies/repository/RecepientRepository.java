package com.cryptochain.movies.repository;

import com.cryptochain.movies.entities.Money.Recepient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecepientRepository extends JpaRepository<Recepient, Long> {
    Recepient findByName(String name);


    List<Recepient> findAllByDescriptionIsNull();
}
