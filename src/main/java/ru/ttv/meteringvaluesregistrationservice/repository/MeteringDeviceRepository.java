package ru.ttv.meteringvaluesregistrationservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ttv.meteringvaluesregistrationservice.model.MeteringDevice;

/**
 * @author Teplykh Timofey  25.03.2019
 */
public interface MeteringDeviceRepository extends JpaRepository<MeteringDevice, Long> {

    MeteringDevice getById(Long id);

}
