package mallcwjo.common;

import io.cucumber.spring.CucumberContextConfiguration;
import mallcwjo.DeliveryApplication;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = { DeliveryApplication.class })
public class CucumberSpingConfiguration {}
