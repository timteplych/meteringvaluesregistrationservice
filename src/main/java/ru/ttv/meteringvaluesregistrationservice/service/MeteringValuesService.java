package ru.ttv.meteringvaluesregistrationservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ttv.meteringvaluesregistrationservice.model.MeteringDeviceValue;
import ru.ttv.meteringvaluesregistrationservice.model.MeteringDeviceValueDTO;
import ru.ttv.meteringvaluesregistrationservice.repository.MeteringDeviceRepository;
import ru.ttv.meteringvaluesregistrationservice.repository.MeteringDeviceValueRepository;

import java.util.Date;

/**
 * @author Teplykh Timofey  28.03.2019
 */
@Service
public class MeteringValuesService {

    private MeteringDeviceValueRepository meteringDeviceValueRepository;

    private MeteringDeviceRepository meteringDeviceRepository;

    @Autowired
    public MeteringValuesService(MeteringDeviceValueRepository meteringDeviceValueRepository, MeteringDeviceRepository meteringDeviceRepository) {
        this.meteringDeviceValueRepository = meteringDeviceValueRepository;
        this.meteringDeviceRepository = meteringDeviceRepository;
    }

    @Transactional
    public void saveMeteringValues(MeteringDeviceValueDTO meteringDeviceValueDTO){
        MeteringDeviceValue meteringDeviceValue = new MeteringDeviceValue();
        meteringDeviceValue.setMeteringDevice(meteringDeviceRepository.getByDeviceIdentifier(meteringDeviceValueDTO.getDeviceId()));
        meteringDeviceValue.setRegistrationDate(new Date());
        meteringDeviceValue.setValue(meteringDeviceValueDTO.getValue());
        meteringDeviceValueRepository.save(meteringDeviceValue);
    }
}
