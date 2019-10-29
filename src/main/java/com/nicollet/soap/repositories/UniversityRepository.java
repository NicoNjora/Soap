package com.nicollet.soap.repositories;

import com.nicollet.soap.models.UniversityModel;
import localhost._7000.universities.University;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UniversityRepository extends JpaRepository<UniversityModel, Long> {
    UniversityModel findByName(String name);
}
