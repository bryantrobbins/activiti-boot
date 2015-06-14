package aboot

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

@Configuration
@ComponentScan
@EnableAutoConfiguration 
class AbootApplication {

    static void main(String[] args) {
        SpringApplication.run AbootApplication, args
    }
}
