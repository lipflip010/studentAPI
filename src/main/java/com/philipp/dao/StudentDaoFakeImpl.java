package com.philipp.dao;

import com.philipp.entity.Student;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
@Repository
@Qualifier("fakeImpl")
public class StudentDaoFakeImpl implements StudentDao {
    private static Map<Integer, Student> students;

    static {
        students = new HashMap<Integer, Student>() {
            {
                put(1, new Student(1, "Philipp", "CompSci"));
                put(2, new Student(2, "Carla", "Angular"));
                put(3, new Student(3, "Willi", "Master CompSci"));
            }
        };
    }
    @Override
    public Collection<Student> getAllStudents(){
        return students.values();
    }

    @Override
    public Student getStudentById(int id) {
        return students.get(id);
    }

    @Override
    public void removeStudentById(int id){
        students.remove(id);
    }

    @Override
    public void updateStudent(Student student){
        Student s = students.get(student.getId());
        s.setCourse(student.getCourse());
        s.setName(student.getName());
        students.put(student.getId(),s);
    }

    @Override
    public void insertStudent(Student student) {
        students.put(student.getId(),student);
    }
}
