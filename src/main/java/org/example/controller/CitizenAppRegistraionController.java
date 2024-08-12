package org.example.controller;

import org.example.bindings.CitizenAppRegistrationInputs;
import org.example.ms.ICitizenAppRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/CitizenAr-api")
public class CitizenAppRegistraionController {
    @Autowired
    private ICitizenAppRegistrationService registrationService;
    @PostMapping("/save")
    public ResponseEntity<String>saveCitizenApp(@RequestBody CitizenAppRegistrationInputs inputs){
        try{
            //useService
            int appId=registrationService.registerCitizenApplication(inputs);
            if(appId>0)
                return new ResponseEntity<String>("Citizen Application is registeredwith the id::"+appId, HttpStatus.CREATED);
            else
                return new ResponseEntity<String>("OInavalid SSN or Citizen must belong to California state::", HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

}
