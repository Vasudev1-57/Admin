package com.SpringbootThymeleaf.Springboot.Thymeleaf.service;

import com.SpringbootThymeleaf.Springboot.Thymeleaf.entity.Merchant;
import com.SpringbootThymeleaf.Springboot.Thymeleaf.entity.Provider;
import com.SpringbootThymeleaf.Springboot.Thymeleaf.reposirory.MerchantRepository;
import com.SpringbootThymeleaf.Springboot.Thymeleaf.reposirory.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class MerchantService {
    @Autowired
    private MerchantRepository merchantRepository;
    @Autowired
    private ProviderRepository providerRepository;
    public List<Merchant> ShowMerchants() {
        return merchantRepository.findAll();
    }

    public void SaveMerchant(Merchant merchant) {

            merchant.setCreatedon(LocalDateTime.now());
//       List<Provider> provider = merchant.getProvider() ;
//        merchant.setProvider(provider);
        merchantRepository.save(merchant);
    }

    public Merchant findById(int merchantId) {

        Optional<Merchant> merchant1 = merchantRepository.findById(merchantId);
        Merchant merchant = merchant1.get();
        return merchant;
    }
}
