package com.pablobuendia.universitymanager;

import com.pablobuendia.universitymanager.address.Address;
import com.pablobuendia.universitymanager.address.AddressRepository;
import com.pablobuendia.universitymanager.address.city.City;
import com.pablobuendia.universitymanager.address.city.CityRepository;
import com.pablobuendia.universitymanager.address.country.Country;
import com.pablobuendia.universitymanager.address.country.CountryRepository;
import com.pablobuendia.universitymanager.student.Student;
import com.pablobuendia.universitymanager.student.StudentRepository;
import com.pablobuendia.universitymanager.university.University;
import com.pablobuendia.universitymanager.university.UniversityRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
@Slf4j
public class UniversityManagerApplication implements CommandLineRunner {

	private final StudentRepository studentRepository;
	private final UniversityRepository universityRepository;
	private final AddressRepository addressRepository;
	private final CityRepository cityRepository;
	private final CountryRepository countryRepository;

	public static void main(String[] args) {
		SpringApplication.run(UniversityManagerApplication.class, args);
	}

	@Override
	public void run(String... args) {
		log.info("Entering sample data through CommandLineRunner");

		val uni = University.builder().name("University of Buenos Aires").build();
		universityRepository.save(uni);

		val argentina = Country.builder().name("Argentina").build();
		countryRepository.save(argentina);
		val buenosAires = City.builder().name("Buenos Aires").country(argentina).build();
		cityRepository.save(buenosAires);
		val addressUni = Address.builder().lineStreet1("Rivadavia 111").city(buenosAires).owner(uni).build();
		addressRepository.save(addressUni);

		val pablo = studentRepository.save(Student.builder().firstName("Pablo").lastName("Buendia").university(uni).build());
		val maria = studentRepository.save(Student.builder().firstName("Maria").lastName("Rodriguez").university(uni).build());
		val juana = studentRepository.save(Student.builder().firstName("Juana").lastName("Perez").university(uni).build());

		val addressPablo = Address.builder().lineStreet1("Belgrano 111").city(buenosAires).owner(pablo).build();
		val addressMaria =Address.builder().lineStreet1("Guemes 111").city(buenosAires).owner(maria).build();
		val addressJuana =Address.builder().lineStreet1("Paz 111").city(buenosAires).owner(juana).build();
		addressRepository.saveAll(List.of(addressPablo, addressMaria, addressJuana));
	}

}
