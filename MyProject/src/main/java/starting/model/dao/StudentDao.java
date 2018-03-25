package starting.model.dao;

import org.springframework.data.repository.CrudRepository;

import starting.model.Student;

public interface StudentDao extends CrudRepository<Student,Integer> {

}
