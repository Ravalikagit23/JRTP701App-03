package org.example.repositary;

import org.example.entity.CitizenAppRegistrationEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IAppRegistrationRepo extends JpaRepository<CitizenAppRegistrationEntity, Integer> {
}
