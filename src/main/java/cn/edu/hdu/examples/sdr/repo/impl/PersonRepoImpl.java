package cn.edu.hdu.examples.sdr.repo.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import cn.edu.hdu.examples.sdr.bean.Person;
import cn.edu.hdu.examples.sdr.repo.PersonRepo;

@Repository
public class PersonRepoImpl implements PersonRepo {

	@Autowired
	private RedisTemplate<String, Object> redisTemplate;

	private static String PERSON_KEY = "Person";

	@Override
	public void save(Person person) {
		this.redisTemplate.opsForHash().put(PERSON_KEY, person.getId(), person);
	}

	@Override
	public Person find(String id) {
		return (Person) this.redisTemplate.opsForHash().get(PERSON_KEY, id);
	}

	@Override
	public Map<Object, Object> findAll() {
		return this.redisTemplate.opsForHash().entries(PERSON_KEY);
	}

	@Override
	public void delete(String id) {
		this.redisTemplate.opsForHash().delete(PERSON_KEY, id);

	}

}
