package mallcwjo.common;

import io.cucumber.spring.CucumberContextConfiguration;
import mallcwjo.CustomercenterApplication;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = { CustomercenterApplication.class })
public class CucumberSpingConfiguration {}
