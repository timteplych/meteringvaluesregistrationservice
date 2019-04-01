package ru.ttv.meteringvaluesregistrationservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.ttv.meteringvaluesregistrationservice.model.MeteringDevice;
import ru.ttv.meteringvaluesregistrationservice.model.MeteringDeviceValue;

import java.util.List;

/**
 * @author Teplykh Timofey  28.03.2019
 */
@Repository
public interface MeteringDeviceValueRepository extends JpaRepository<MeteringDeviceValue, Long> {

    @Query("select a from MeteringDeviceValue a where a.meteringDevice.deviceIdentifier=:id")
    List<MeteringDeviceValue> getByMeteringDevice(@Param("id") String meteringDeviceId);

}
