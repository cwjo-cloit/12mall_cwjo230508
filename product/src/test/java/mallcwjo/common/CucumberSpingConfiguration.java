package mallcwjo.common;

import io.cucumber.spring.CucumberContextConfiguration;
import mallcwjo.ProductApplication;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = { ProductApplication.class })
public class CucumberSpingConfiguration {}
