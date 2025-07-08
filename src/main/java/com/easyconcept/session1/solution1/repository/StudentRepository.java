package com.easyconcept.session1.solution1.repository;

import com.easyconcept.session1.solution1.entity.Student;
import java.util.*;

public class StudentRepository {
    private final Map<UUID, Student> database = new HashMap<>();

    public void save(Student student) {
        database.put(student.getId(), student);
    }

    public List<Student> findAll() {
        return new ArrayList<>(database.values());
    }

    public Optional<Student> findByName(String name) {
        return database.values().stream()
                .filter(s -> s.getName().equalsIgnoreCase(name))
                .findFirst();
    }

    public Optional<Student> findById(UUID id) {
        return Optional.ofNullable(database.get(id));
    }

    public void delete(UUID id) {
        database.remove(id);
    }
}
