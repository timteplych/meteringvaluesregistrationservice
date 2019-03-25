package ru.ttv.meteringvaluesregistrationservice.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Teplykh Timofey  24.03.2019
 */
@Entity
@Table(name = "metering_device_values")
@Getter
@Setter
public class MeteringDeviceValues {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @Column(name = "metering_device")
    private MeteringDevice meteringDevice;

    @Column(name = "registration_date")
    @Temporal(TemporalType.DATE)
    private Date registrationDate;

    @Column(name = "value")
    private double value;

    public MeteringDeviceValues() {
    }
}
