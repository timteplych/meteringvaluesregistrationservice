package ru.ttv.meteringvaluesregistrationservice.rest.api;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ttv.meteringvaluesregistrationservice.model.MeteringDeviceValue;

import java.util.List;

/**
 * @author Teplykh Timofey  29.03.2019
 */
public interface IMeteringValuesController {
    @GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseEntity<List<MeteringDeviceValue>> getMeteringValuesByDeviceId(@PathVariable("id") String deviceId);

    @PostMapping(value = "", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseEntity<MeteringDeviceValue> saveMeteringValue(@RequestBody MeteringDeviceValue value);

    @DeleteMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseEntity<MeteringDeviceValue> deleteDeviceValue(@PathVariable("id") Long id);
}
