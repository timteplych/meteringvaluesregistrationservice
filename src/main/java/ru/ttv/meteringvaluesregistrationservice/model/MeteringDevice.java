package ru.ttv.meteringvaluesregistrationservice.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Teplykh Timofey  24.03.2019
 */
@Entity
@Table(name = "metering_devices")
@Getter
@Setter
public class MeteringDevice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "device_identifier")
    private String device_identifier;

    @Column(name = "installation_date")
    @Temporal(TemporalType.DATE)
    private Date installationDate;

    @ManyToOne
    @Column(name = "consumer_account")
    private ConsumerAccount consumerAccount;

    public MeteringDevice() {
    }

}
