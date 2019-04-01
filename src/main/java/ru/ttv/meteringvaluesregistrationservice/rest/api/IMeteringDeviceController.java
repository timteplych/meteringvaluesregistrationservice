package ru.ttv.meteringvaluesregistrationservice.rest.api;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.ttv.meteringvaluesregistrationservice.model.MeteringDevice;

import java.util.List;

/**
 * @author Teplykh Timofey  29.03.2019
 */
public interface IMeteringDeviceController {
    @GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseEntity<MeteringDevice> getMeteringDevice(@PathVariable("id") Long id);

    @GetMapping(value = "dev_id/{id}")
    ResponseEntity<MeteringDevice> getMeteringDeviceByDevId(@PathVariable("id") String id);

    @GetMapping(value = "getall", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseEntity<List<MeteringDevice>> getAll();
}
