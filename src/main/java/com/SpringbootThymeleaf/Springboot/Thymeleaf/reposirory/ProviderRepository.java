package com.SpringbootThymeleaf.Springboot.Thymeleaf.reposirory;

import com.SpringbootThymeleaf.Springboot.Thymeleaf.entity.Provider;
import com.SpringbootThymeleaf.Springboot.Thymeleaf.entity.ProviderResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ProviderRepository extends JpaRepository<Provider,Integer> {
    @Query("""
            select new com.SpringbootThymeleaf.Springboot.Thymeleaf.entity.ProviderResponse (a. providerName) from Provider a """)
    List<ProviderResponse> findAllproviderName();



}
