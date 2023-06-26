package com.SpringbootThymeleaf.Springboot.Thymeleaf.reposirory;

import com.SpringbootThymeleaf.Springboot.Thymeleaf.entity.Merchant;
import com.SpringbootThymeleaf.Springboot.Thymeleaf.entity.MerchantResponse;
import com.SpringbootThymeleaf.Springboot.Thymeleaf.entity.ProviderResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MerchantRepository extends JpaRepository<Merchant,Integer> {
    @Query("""
            select new com.SpringbootThymeleaf.Springboot.Thymeleaf.entity.MerchantResponse (a. merchantName) from Merchant a """)
    List<MerchantResponse> findAllmerchantName();
}
