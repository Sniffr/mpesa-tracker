package com.cryptochain.movies.repository;

import com.cryptochain.movies.entities.Money.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction,Long> {
}
