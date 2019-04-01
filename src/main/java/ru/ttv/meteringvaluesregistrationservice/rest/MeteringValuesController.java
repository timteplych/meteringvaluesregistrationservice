package ru.ttv.meteringvaluesregistrationservice.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ttv.meteringvaluesregistrationservice.model.MeteringDeviceValue;
import ru.ttv.meteringvaluesregistrationservice.repository.MeteringDeviceRepository;
import ru.ttv.meteringvaluesregistrationservice.repository.MeteringDeviceValueRepository;
import ru.ttv.meteringvaluesregistrationservice.rest.api.IMeteringValuesController;

import java.util.List;

/**
 * @author Teplykh Timofey  29.03.2019
 */
@RestController
@RequestMapping(value = "/api/v1/metering_values")
public class MeteringValuesController implements IMeteringValuesController {

    @Autowired
    MeteringDeviceRepository meteringDeviceRepository;

    @Autowired
    MeteringDeviceValueRepository meteringDeviceValueRepository;

    @Override
    @GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<MeteringDeviceValue>> getMeteringValuesByDeviceId(@PathVariable("id") String deviceId){
        return new ResponseEntity<>(meteringDeviceValueRepository.getByMeteringDevice(deviceId), HttpStatus.OK);
    }

    @Override
    @PostMapping(value = "", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<MeteringDeviceValue> saveMeteringValue(@RequestBody MeteringDeviceValue value){
        if(value == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        meteringDeviceValueRepository.save(value);
        return new ResponseEntity<>(value,HttpStatus.OK);
    }

    @Override
    @DeleteMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<MeteringDeviceValue> deleteDeviceValue(@PathVariable("id") Long id){
        MeteringDeviceValue value = meteringDeviceValueRepository.getOne(id);
        if(value == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        meteringDeviceValueRepository.delete(value);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
