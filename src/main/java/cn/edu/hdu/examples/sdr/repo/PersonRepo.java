package cn.edu.hdu.examples.sdr.repo;

import java.util.Map;

import cn.edu.hdu.examples.sdr.bean.Person;

public interface PersonRepo {
	public void save(Person person);

	public Person find(String id);

	public Map<Object, Object> findAll();

	public void delete(String id);
}
