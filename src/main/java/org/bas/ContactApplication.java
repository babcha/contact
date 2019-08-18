package org.bas;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.bas.dao.ContactRepository;
import org.bas.entities.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ContactApplication implements CommandLineRunner {

	@Autowired
	ContactRepository contactRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ContactApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
	}

}
