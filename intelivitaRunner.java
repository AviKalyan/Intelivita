package TestRunner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		//Path of feature files.
		features="src/test/java/FeatureFiles/Intelivita.feature",
				
		//Path(Package name with) of step definition file.
		glue="StepDefinitions",
		
		//For net(Arranging console output) output.
		monochrome=true,
						
		//For strict output.
		strict=true
)

public class intelivitaRunner {

}
