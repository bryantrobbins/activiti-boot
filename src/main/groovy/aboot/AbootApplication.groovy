package aboot

import org.activiti.engine.RepositoryService
import org.activiti.engine.RuntimeService
import org.activiti.engine.TaskService
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.stereotype.Component

@Configuration
@ComponentScan
@EnableAutoConfiguration
class AbootApplication {

    static void main(String[] args) {
        SpringApplication.run AbootApplication, args
    }

    @Bean
    CommandLineRunner init(final RepositoryService repositoryService,
                           final RuntimeService runtimeService,
                           final TaskService taskService) {

        return new CommandLineRunner() {
            public void run(String... strings) throws Exception {
                Map<String, Object> variables = new HashMap<String, Object>();
                variables.put("applicantName", "John Doe");
                variables.put("email", "john.doe@activiti.com");
                variables.put("phoneNumber", "123456789");
                runtimeService.startProcessInstanceByKey("hireProcess", variables);
            }
        };
    }
}

@Component
public class ResumeService {

    public void storeResume() {
        System.out.println("Storing resume ...");
    }

}
