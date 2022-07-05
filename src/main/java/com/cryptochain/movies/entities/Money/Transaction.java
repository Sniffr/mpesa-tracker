package com.cryptochain.movies.entities.Money;
//add anotations belongng to a jpa entity

import lombok.*;

import javax.persistence.*;

//create a Jpa entity called Transaction with the following attributes id,amount,recipient,transactionId
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Transaction {
    String amount;
    String recipient;
    String transactionId;
    @ManyToOne
    @JoinColumn(name = "recepient_id")
    Recepient recepient;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
}
