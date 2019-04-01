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

    @Column(name = "deviceIdentifier")
    private String deviceIdentifier;

    @Column(name = "installation_date")
    @Temporal(TemporalType.DATE)
    private Date installationDate;

    @ManyToOne
    private ConsumerAccount consumerAccount;

    public MeteringDevice() {
    }

}
