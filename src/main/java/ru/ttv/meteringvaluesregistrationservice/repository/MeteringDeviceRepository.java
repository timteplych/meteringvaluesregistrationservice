package ru.ttv.meteringvaluesregistrationservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ttv.meteringvaluesregistrationservice.model.ConsumerAccount;
import ru.ttv.meteringvaluesregistrationservice.model.MeteringDevice;

import java.util.List;

/**
 * @author Teplykh Timofey  25.03.2019
 */
@Repository
public interface MeteringDeviceRepository extends JpaRepository<MeteringDevice, Long> {

    MeteringDevice getById(Long id);
    List<MeteringDevice> getByConsumerAccount(ConsumerAccount consumerAccount);
    MeteringDevice getByDeviceIdentifier(String deviceIdentifier);

}
