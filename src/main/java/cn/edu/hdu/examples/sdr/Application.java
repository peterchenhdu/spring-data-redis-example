package cn.edu.hdu.examples.sdr;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import cn.edu.hdu.examples.sdr.bean.Person;
import cn.edu.hdu.examples.sdr.bean.Person.Gender;
import cn.edu.hdu.examples.sdr.repo.PersonRepo;

@SpringBootApplication
public class Application implements CommandLineRunner {
	@Autowired
	private PersonRepo personRepo;

	@Override
	public void run(String... args) throws Exception {

		Map<Object, Object> personMatrixMap = personRepo.findAll();
		System.out.println("@@当前Redis存储的所有用户：" + personMatrixMap);
		
		Person person = new Person();
		person.setId("1");
		person.setAge(55);
		person.setGender(Gender.Female);
		person.setName("Oracle");

		personRepo.save(person);

		Person person2 = new Person();
		person2.setId("2");
		person2.setAge(60);
		person2.setGender(Gender.Male);
		person2.setName("TheArchitect");

		personRepo.save(person2);

		Person person3 = new Person();
		person3.setId("3");
		person3.setAge(25);
		person3.setGender(Gender.Male);
		person3.setName("TheOne");

		personRepo.save(person3);

		System.out.println("查找ID为3的用户 : " + personRepo.find("3"));

		personMatrixMap = personRepo.findAll();

		System.out.println("当前Redis存储的所有用户：" + personMatrixMap);

		personRepo.delete("2");

		personMatrixMap = personRepo.findAll();

		System.out.println("删除ID为2的用户后，剩余的所有用户: " + personMatrixMap);
	}

	public static void main(String[] args) {
		// Close the context so it doesn't stay awake listening for redis
		SpringApplication.run(Application.class, args).close();

	}
}
