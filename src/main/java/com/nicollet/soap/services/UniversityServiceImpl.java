package com.nicollet.soap.services;

import com.nicollet.soap.models.UniversityModel;
import com.nicollet.soap.repositories.UniversityRepository;
import localhost._7000.universities.University;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UniversityServiceImpl implements UniversityService {
    private final UniversityRepository universityRepository;

    public UniversityServiceImpl(UniversityRepository universityRepository) {
        this.universityRepository = universityRepository;
    }

    @Override
    public List<UniversityModel> findAll() {
        return universityRepository.findAll();
    }

    @Override
    public UniversityModel createUniversity(UniversityModel university) {
        return universityRepository.save(university);
    }

    @Override
    public UniversityModel searchByName(String name) {
        return universityRepository.findByName(name);
    }
}
