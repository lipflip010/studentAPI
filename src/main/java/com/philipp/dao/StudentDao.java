package com.philipp.dao;

import com.philipp.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
@Repository
public class StudentDao {
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
    public Collection<Student> getAllStudents(){
        return students.values();
    }
}
