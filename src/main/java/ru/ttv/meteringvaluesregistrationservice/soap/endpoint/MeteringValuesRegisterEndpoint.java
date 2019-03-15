package ru.ttv.meteringvaluesregistrationservice.soap.endpoint;

import com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import ru.ttv.meteringvaluesregistrationservice.soap.metering.ImportMeteringValuesRequest;
import ru.ttv.meteringvaluesregistrationservice.soap.metering.ImportMeteringValuesResponse;
import ru.ttv.meteringvaluesregistrationservice.soap.metering.MeteringRegistrationResponseData;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * @author Teplykh Timofey  15.03.2019
 */

@Endpoint
public class MeteringValuesRegisterEndpoint {

    public final static String NAMESPACE_URI = "http://meteringvaluesregistrationservice.ttv.ru/soap/metering/";
    public final static String PORT_TYPE_NAME = "MeteringPort";
    public final static String LOCATION_URI = "/ws";

    @Autowired
    public MeteringValuesRegisterEndpoint() {

    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "importMeteringValuesRequest")
    @ResponsePayload
    public ImportMeteringValuesResponse getResponse(ImportMeteringValuesRequest request) throws DatatypeConfigurationException {
        ImportMeteringValuesResponse response = new ImportMeteringValuesResponse();
        MeteringRegistrationResponseData meteringRegistrationResponseData = new MeteringRegistrationResponseData();
        meteringRegistrationResponseData.setRegistrationResult("Metering values registered at device "+request.getDeviceID());
        XMLGregorianCalendar date = new XMLGregorianCalendarImpl();
        meteringRegistrationResponseData.setDate(date);
        response.setResponse(meteringRegistrationResponseData);
        return response;
    }
}
