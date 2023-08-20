package com.example.BookMyShowCloneAPI.util;

import java.util.Arrays;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class BookMyShowConfig {

	public OpenAPI swaggerDocOpenApi() {
		
		Server developmentServer=new Server();
		developmentServer.setUrl("http://localhost:8080");
		developmentServer.setDescription("This server is for development");
		
		Server productionServer=new Server();
		productionServer.setUrl("http://localhost:8080");
		productionServer.setDescription("This server is for development");
		
		Contact contact=new Contact();
		contact.setName("Book My Show");
		contact.setEmail("help.bookmyshow.in");
		contact.setUrl("https://cdnjs.com/libraries/font-aweso");
		
		License licence=new License();
		licence.setName(null);
		licence.setUrl(null);
		
		Info info=new Info();
		info.title("BookMyShow");
		info.version("1.0");
		info.contact(contact);
		info.description("designed for Ticket Booking ");
		
		OpenAPI openApi=new OpenAPI();
		openApi.info(info);
		openApi.servers(Arrays.asList(developmentServer,productionServer));
		return openApi;
		
	}
}
