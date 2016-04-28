package sf.example;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import sf.example.data.DataConfiguration;

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = "sf.example", 
excludeFilters = 
{@ComponentScan.Filter(value = DataConfiguration.class, type = FilterType.ASSIGNABLE_TYPE),
		@ComponentScan.Filter(value = Boot.class, type = FilterType.ASSIGNABLE_TYPE)})
public class TestConfiguration {
}
