package ru.ttv.meteringvaluesregistrationservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ttv.meteringvaluesregistrationservice.model.ConsumerAccount;
import ru.ttv.meteringvaluesregistrationservice.model.ConsumerAccountDTO;
import ru.ttv.meteringvaluesregistrationservice.model.MeteringDevice;
import ru.ttv.meteringvaluesregistrationservice.model.MeteringDeviceValueDTO;
import ru.ttv.meteringvaluesregistrationservice.repository.ConsumerAccountRepository;
import ru.ttv.meteringvaluesregistrationservice.repository.MeteringDeviceRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Teplykh Timofey  28.03.2019
 */
@Service
public class AccountService {

    private ConsumerAccountRepository consumerAccountRepository;

    private MeteringDeviceRepository meteringDeviceRepository;

    @Autowired
    public AccountService(ConsumerAccountRepository consumerAccountRepository, MeteringDeviceRepository meteringDeviceRepository) {
        this.consumerAccountRepository = consumerAccountRepository;
        this.meteringDeviceRepository = meteringDeviceRepository;
    }

    public List<MeteringDeviceValueDTO> getConsumerMeteringDevices(ConsumerAccountDTO consumerAccountDTO){
        if(consumerAccountDTO.getAccountNumber() == null){
            return new ArrayList<>();
        }
        ConsumerAccount consumerAccount = consumerAccountRepository.getByAccountNumber(consumerAccountDTO.getAccountNumber());
        if(consumerAccount != null){
            return transformToDTO(meteringDeviceRepository.getByConsumerAccount(consumerAccount));
        }
        if(consumerAccountDTO.getStreet() == null
                || consumerAccountDTO.getHouse() == null
                || consumerAccountDTO.getApartment() == null){
            return new ArrayList<>();
        }
        return new ArrayList<>();
    }

    private List<MeteringDeviceValueDTO> transformToDTO(List<MeteringDevice> meteringDevices) {
        List<MeteringDeviceValueDTO> meteringDeviceValueDTOS = new ArrayList<>();
        for (MeteringDevice meteringDevice : meteringDevices){
            meteringDeviceValueDTOS.add(new MeteringDeviceValueDTO(meteringDevice.getDeviceIdentifier(),10));
        }

        return meteringDeviceValueDTOS;
    }
}
