package ru.ttv.meteringvaluesregistrationservice.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;
import ru.ttv.meteringvaluesregistrationservice.soap.endpoint.MeteringValuesRegisterEndpoint;

/**
 * @author Teplykh Timofey  15.03.2019
 */
@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {

    private final static String WS_MAPPING = "/ws/*";

    @Bean
    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext){
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean(servlet,WS_MAPPING);
    }

    @Bean(name = "metering")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema xsdSchema){
        DefaultWsdl11Definition defaultWsdl11Definition = new DefaultWsdl11Definition();
        defaultWsdl11Definition.setPortTypeName(MeteringValuesRegisterEndpoint.PORT_TYPE_NAME);
        defaultWsdl11Definition.setLocationUri(MeteringValuesRegisterEndpoint.LOCATION_URI);
        defaultWsdl11Definition.setTargetNamespace(MeteringValuesRegisterEndpoint.NAMESPACE_URI);
        defaultWsdl11Definition.setSchema(xsdSchema);
        return defaultWsdl11Definition;
    }

    @Bean
    public XsdSchema xsdSchema(){
        return new SimpleXsdSchema(new ClassPathResource("xsd/register-metering-vals.xsd"));
    }
}
