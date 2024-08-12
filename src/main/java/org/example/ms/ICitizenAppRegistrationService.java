package org.example.ms;

import org.example.bindings.CitizenAppRegistrationInputs;
import org.example.entity.CitizenAppRegistrationEntity;


public interface ICitizenAppRegistrationService {
    public Integer registerCitizenApplication(CitizenAppRegistrationInputs inputs);
}
