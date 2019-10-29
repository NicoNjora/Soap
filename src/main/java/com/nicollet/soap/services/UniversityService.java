package com.nicollet.soap.services;

import com.nicollet.soap.models.UniversityModel;

import java.util.List;

public interface UniversityService {

    List<UniversityModel> findAll();

    UniversityModel createUniversity(UniversityModel university);

    UniversityModel searchByName(String name);
}
