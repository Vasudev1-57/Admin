package com.SpringbootThymeleaf.Springboot.Thymeleaf.service;

import com.SpringbootThymeleaf.Springboot.Thymeleaf.entity.Provider;
import com.SpringbootThymeleaf.Springboot.Thymeleaf.reposirory.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ProviderService {
    @Autowired
     private ProviderRepository providerRepository;
    public  void  SaveProvider(Provider provider) {
        if (provider.getId() != 0)
        {
            provider.setCreatedon(provider.getCreatedon());
            provider.setModifiedon(LocalDateTime.now());
        }
        else    {
            provider.setCreatedon(LocalDateTime.now());
        }

        providerRepository.save(provider);

    }

    public List<Provider> ShowProviders() {
       return  providerRepository.findAll();
    }

        public Provider findById(int providerId) {
            Optional<Provider> provider1 = providerRepository.findById(providerId);
        Provider provider = provider1.get();
        return provider;
    }
}
