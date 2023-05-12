package com.SpringbootThymeleaf.Springboot.Thymeleaf.reposirory;

import com.SpringbootThymeleaf.Springboot.Thymeleaf.entity.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MerchantRepository extends JpaRepository<Merchant,Integer> {
}
