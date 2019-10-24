package com.nicollet.soap;

import com.nicollet.soap.repositories.UniversityRepository;
import localhost._7000.universities.GetUniversityRequest;
import localhost._7000.universities.GetUniversityResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class UniversityEndpoint {
    private static final String NAMESPACE_URI = "http://localhost:7000/universities";

    private UniversityRepository universityRepository;

    @Autowired
    public UniversityEndpoint(UniversityRepository universityRepository) {
        this.universityRepository = universityRepository;
    }


    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getUniversityRequest")
    @ResponsePayload
    public GetUniversityResponse getUniversity(@RequestPayload GetUniversityRequest request) {
        GetUniversityResponse response = new GetUniversityResponse();
        response.setUniversity(universityRepository.getUniversityByName(request.getName()));

        return response;
    }
    
}
