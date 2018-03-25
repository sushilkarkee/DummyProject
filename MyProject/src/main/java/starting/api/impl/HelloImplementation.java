package starting.api.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import starting.api.HelloApi;
import starting.model.Student;
import starting.model.dao.StudentDao;

@Component
public class HelloImplementation implements HelloApi {

	@Override
	public String helloWorld() {
		return "hello world";
	}

	@Override
	public List<Student> fetch() {
		return Arrays.asList(new Student("sushil", 1), new Student("jpt", 2));
	}

	@Autowired
	private StudentDao studentDao;

	@Override
	public String insertData(List<Student> studentList) {
		if (studentList != null) {
			studentDao.save(studentList);
			return "successfully inserted";
		} else {
			return "list is  empty";
		}
	}

	@Override
	public List<Student> getInfo() {

		List<Student> studentList = new ArrayList<Student>();

		studentList = (List<Student>) studentDao.findAll();

		return studentList;
	}

}
