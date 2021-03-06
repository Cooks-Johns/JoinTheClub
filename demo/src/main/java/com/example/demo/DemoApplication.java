
package com.example.demo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
  
  @SpringBootApplication
  @RestController
  public class DemoApplication {
    
      
      public static void main(String[] args) {
      SpringApplication.run(DemoApplication.class, args);
      }
      
      @GetMapping("/hello")
      public String hello(@RequestParam(value = "name", defaultValue = "Join the Club") String name) {
    	  return String.format("Hello %s!", name);
      }
      
     // @GetMapping("/login")
    //  public String sayHello
      
      @Controller
      public class HomeController {

          @GetMapping("/home")
          public String welcome() {
              return "home";
          }

  }
}