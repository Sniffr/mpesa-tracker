package com.cryptochain.movies.entities.Money;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Description {
    @OneToMany(mappedBy = "description")
    @JsonManagedReference
    List<Recepient> recepients;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Override
    public String toString() {
        return "Description{" +
                "recepients=" + recepients +
                ", id=" + id +
                '}';
    }
}
