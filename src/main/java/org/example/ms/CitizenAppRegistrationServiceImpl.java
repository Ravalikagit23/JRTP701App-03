package org.example.ms;

import org.example.bindings.CitizenAppRegistrationInputs;
import org.example.entity.CitizenAppRegistrationEntity;
import org.example.repositary.IAppRegistrationRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
public class CitizenAppRegistrationServiceImpl implements ICitizenAppRegistrationService {

    @Autowired
   private IAppRegistrationRepo citizenRepo;
    @Autowired
   private RestTemplate template;
    @Value("${ar.ssa-web.url}")
    private String endpointUrl;
    @Value("${ar.state}")
    private String targetState;

    @Override
    public Integer registerCitizenApplication(CitizenAppRegistrationInputs inputs) {
       //performing the web call whether given ssn is valid or not
        ResponseEntity<String>response=template.exchange(endpointUrl,HttpMethod.GET,
                null,String.class,inputs.getSsn());
        //get the stateName
        String stateName=response.getBody();
        //citizen registarion if he belomngs toca state
        if(stateName.equalsIgnoreCase(targetState)){
            //preparing the entity object
            CitizenAppRegistrationEntity entity=new CitizenAppRegistrationEntity();
            BeanUtils.copyProperties(inputs,entity);
            entity.setStateName(stateName);
            //save the object here c
            Integer appId = citizenRepo.save(entity).getAppId();
return appId;
        }
return 0;
    }

}
