package com.cryptochain.movies.entities.Money;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Recepient {
    String name;

    String description;
    @OneToMany(mappedBy = "recepient")
    @JsonManagedReference
    private List<Transaction> transactions;

    Long totalSpent;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    @Override
    public String toString() {
        return "Recepient{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", transactions=" + transactions +
                ", totalSpent=" + totalSpent +
                ", id=" + id +
                '}';
    }
}
