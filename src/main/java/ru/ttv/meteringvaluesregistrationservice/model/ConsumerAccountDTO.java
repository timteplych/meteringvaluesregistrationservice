package ru.ttv.meteringvaluesregistrationservice.model;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Teplykh Timofey  26.03.2019
 */
@Getter
@Setter
public class ConsumerAccountDTO {

    private String accountNumber;

    private String street;

    private String house;

    private String apartment;

    public ConsumerAccountDTO() {
    }
}
