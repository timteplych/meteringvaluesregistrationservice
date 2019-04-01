package ru.ttv.meteringvaluesregistrationservice.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ttv.meteringvaluesregistrationservice.model.MeteringDevice;
import ru.ttv.meteringvaluesregistrationservice.repository.MeteringDeviceRepository;

import java.util.List;

/**
 * @author Teplykh Timofey  25.03.2019
 */
@RestController
@RequestMapping(value = "/api/v1/metering_device/")
public class MeteringDeviceController implements ru.ttv.meteringvaluesregistrationservice.rest.api.IMeteringDeviceController {

    @Autowired
    MeteringDeviceRepository meteringDeviceRepository;

    @Override
    @GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<MeteringDevice> getMeteringDevice(@PathVariable("id") Long id){
        return new ResponseEntity<>(meteringDeviceRepository.getById(id), HttpStatus.OK);
    }

    @Override
    @GetMapping(value = "dev_id/{id}")
    public ResponseEntity<MeteringDevice> getMeteringDeviceByDevId(@PathVariable("id") String id){
        return new ResponseEntity<>(meteringDeviceRepository.getByDeviceIdentifier(id), HttpStatus.OK);
    }

    @Override
    @GetMapping(value = "getall", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<MeteringDevice>> getAll(){
        return new ResponseEntity<>(meteringDeviceRepository.findAll(), HttpStatus.OK);
    }
}
