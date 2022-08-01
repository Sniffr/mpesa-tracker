package com.cryptochain.movies.repository;

import com.cryptochain.movies.entities.Money.Recepient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RecepientRepositoryTest {
    @Autowired
    private RecepientRepository recepientRepository;

    @Test
    void findAllByDescriptionIsNull() {
        //save to a list and assert it is not null
        List<Recepient> recepients = recepientRepository.findAllByDescriptionIsNull();
        System.out.println(recepients);
        assertNotNull(recepients);


    }
}