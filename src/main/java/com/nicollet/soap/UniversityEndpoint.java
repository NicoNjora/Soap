package com.nicollet.soap;

import com.nicollet.soap.models.UniversityModel;
import com.nicollet.soap.services.UniversityService;
import localhost._7000.universities.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.ArrayList;
import java.util.List;

@Endpoint
public class UniversityEndpoint {
    private static final String NAMESPACE_URI = "http://localhost:7000/universities";

    private UniversityService universityService;

    @Autowired
    public UniversityEndpoint(UniversityService universityService) {
        this.universityService = universityService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getUniversityRequest")
    @ResponsePayload
    public GetUniversityResponse getUniversity(@RequestPayload GetUniversityRequest request) {
        GetUniversityResponse response = new GetUniversityResponse();
        University university = new University();
        BeanUtils.copyProperties(universityService.searchByName(request.getName()), university);
        response.setUniversity(university);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllUniversitiesRequest")
    @ResponsePayload
    public GetAllUniversitiesResponse getAllUniversities() {
        GetAllUniversitiesResponse response = new GetAllUniversitiesResponse();

        List<University> universities = new ArrayList<University>();
        List<UniversityModel> universityModels = universityService.findAll();


        for (UniversityModel universityModel : universityModels) {
            University ob = new University();
            BeanUtils.copyProperties(universityModel, ob);
            universities.add(ob);
        }
        response.getUniversity().addAll(universities);
        return response;
    }
    
}
