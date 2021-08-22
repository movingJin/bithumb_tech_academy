package net.movingjin.customer.customer;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class CustomerApplication implements CommandLineRunner {
	private final CustomerRepository customerRepository;

	public static void main(String[] args) {
		SpringApplication.run(CustomerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		customerRepository.deleteAll();
		customerRepository.save(new Customer("DongJin", "Lee"));
		customerRepository.save(new Customer("EunSook", "Kim"));
		customerRepository.save(new Customer("J", "Kim"));
		System.out.println("Customers found with findAll()");
		for(Customer customer: customerRepository.findAll()){
			System.out.println(customer);
		}
		System.out.println();

		System.out.println("Dong-Jin 이라는 이름으로 찾기");
		System.out.println(customerRepository.findByFirstName("DongJin"));
		System.out.println("Eun-Sook 이라는 이름으로 찾기");
		for(Customer customer: customerRepository.findByLastName("Kim")){
			System.out.println(customer);
		}

	}
}
