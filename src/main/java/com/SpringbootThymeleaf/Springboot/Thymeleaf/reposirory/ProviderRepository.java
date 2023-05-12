package com.SpringbootThymeleaf.Springboot.Thymeleaf.reposirory;

import com.SpringbootThymeleaf.Springboot.Thymeleaf.entity.Provider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProviderRepository extends JpaRepository<Provider,Integer> {
}
