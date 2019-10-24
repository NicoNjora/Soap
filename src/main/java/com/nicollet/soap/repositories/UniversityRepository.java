package com.nicollet.soap.repositories;

import localhost._7000.universities.University;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
public class UniversityRepository {

    private Map<String, University> universities = new HashMap<>();

    @PostConstruct
    private void loadData(){
        University strath = new University();
        strath.setLocation("Ole Sangale");
        strath.setName("Strathmore");
        strath.setYearFounded(1960);
        universities.put(strath.getName(), strath);

        University jkuat = new University();
        jkuat.setLocation("Juja");
        jkuat.setName("JKUAT");
        jkuat.setYearFounded(1980);
        universities.put(jkuat.getName(), jkuat);

        University ku = new University();
        ku.setLocation("Ruiru");
        ku.setName("Kenyatta");
        ku.setYearFounded(1950);
        universities.put(ku.getName(), ku);
    }

    public University getUniversityByName(String name){
        return universities.get(name);
    }
}
