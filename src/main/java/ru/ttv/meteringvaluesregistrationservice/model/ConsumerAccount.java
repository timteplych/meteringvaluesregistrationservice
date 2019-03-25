package ru.ttv.meteringvaluesregistrationservice.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author Teplykh Timofey  24.03.2019
 */
@Entity
@Table(name = "consumer_accounts")
@Getter
@Setter
public class ConsumerAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "account_number")
    private String accountNumber;

    @Column(name = "street")
    private String street;

    @Column(name = "house")
    private String house;

    @Column(name = "apartment")
    private String apartment;

    public ConsumerAccount() {
    }
}
