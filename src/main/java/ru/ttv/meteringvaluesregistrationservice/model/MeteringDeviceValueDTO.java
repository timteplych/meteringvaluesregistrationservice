package ru.ttv.meteringvaluesregistrationservice.model;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Teplykh Timofey  26.03.2019
 */
@Getter
@Setter
public class MeteringDeviceValueDTO {

    private String deviceId;

    private double value;

    public MeteringDeviceValueDTO() {
    }

    public MeteringDeviceValueDTO(String deviceId, double value) {
        this.deviceId = deviceId;
        this.value = value;
    }
}
