package com.nicollet.soap;

import com.nicollet.soap.models.UniversityModel;
import com.nicollet.soap.repositories.UniversityRepository;
import localhost._7000.universities.University;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DummyData implements CommandLineRunner {

    private final UniversityRepository universityRepository;

    public DummyData(UniversityRepository universityRepository) {
        this.universityRepository = universityRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        UniversityModel strath = new UniversityModel();
        strath.setLocation("Ole Sangale");
        strath.setName("Strathmore");
        strath.setYearFounded(1965);
        universityRepository.save(strath);

        UniversityModel jkuat = new UniversityModel();
        jkuat.setLocation("Juja");
        jkuat.setName("JKUAT");
        jkuat.setYearFounded(1980);
        universityRepository.save(jkuat);

        UniversityModel ku = new UniversityModel();
        ku.setLocation("Ruiru");
        ku.setName("Kenyatta");
        ku.setYearFounded(1998);
        universityRepository.save(ku);
    }
}
