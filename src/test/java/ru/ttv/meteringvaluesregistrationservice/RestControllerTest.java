package ru.ttv.meteringvaluesregistrationservice;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import ru.ttv.meteringvaluesregistrationservice.model.MeteringDevice;

/**
 * @author Teplykh Timofey  25.03.2019
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class RestControllerTest {

    @Autowired
    TestRestTemplate  testRestTemplate;

    @Test
    public void MeteringDeviceControllerTest(){
        ResponseEntity<MeteringDevice> entity = testRestTemplate.getForEntity("/api/v1/metering_device/{id}",
                MeteringDevice.class,1);
        Assert.assertTrue(entity.getStatusCode() == HttpStatus.OK);
    }
}