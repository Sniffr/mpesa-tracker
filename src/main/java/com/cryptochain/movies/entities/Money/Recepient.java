package com.cryptochain.movies.entities.Money;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Recepient {
    String name;
    String description;
    @OneToMany(mappedBy = "recepient")
    private List<Transaction> transactions;

    Long totalSpent;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
}
