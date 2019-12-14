package com.javainuse.springbootsoapclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.javainuse.InputSOATest;
import com.javainuse.OutputSOATest;

@SpringBootApplication
public class SpringBootSoapClientApplication //implements CommandLineRunner
{
	  @Autowired
	  private ConfigurableApplicationContext context;


	public static void main(String[] args) {
		SpringApplication.run(SpringBootSoapClientApplication.class, args);
	}
	
	@Bean
	CommandLineRunner lookup(SOAPConnector soapConnector) {
		return args -> {
			String name = "Shahbaz";//Default Name
			if(args.length>0){
				name = args[0];
			}
			InputSOATest request = new InputSOATest();
			request.setTest(name);
			//OutputSOATest response =(OutputSOATest) soapConnector.callWebService("http://localhost:8080/javainuse/ws/helloWorldExample", request);
			OutputSOATest response =(OutputSOATest) soapConnector.callWebService("http://localhost:8080/javainuse/ws/helloworld", request);
			System.out.println("Got Response As below ========= : ");
			System.out.println("Name : "+response.getResult());
			
			  System.exit(SpringApplication.exit(context));
			
			//SpringApplication.exit(context);
			//System.exit(0);

		};
	}

//	@Override
//	public void run(String... arg0) throws Exception {
//		System.out.println("run method call");
//		
//		
//		
//	}
}
