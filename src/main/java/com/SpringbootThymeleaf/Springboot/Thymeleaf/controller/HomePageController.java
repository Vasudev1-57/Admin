package com.SpringbootThymeleaf.Springboot.Thymeleaf.controller;

import com.SpringbootThymeleaf.Springboot.Thymeleaf.entity.Merchant;
import com.SpringbootThymeleaf.Springboot.Thymeleaf.entity.MerchantResponse;
import com.SpringbootThymeleaf.Springboot.Thymeleaf.entity.Provider;
import com.SpringbootThymeleaf.Springboot.Thymeleaf.entity.ProviderResponse;
import com.SpringbootThymeleaf.Springboot.Thymeleaf.reposirory.MerchantRepository;
import com.SpringbootThymeleaf.Springboot.Thymeleaf.reposirory.ProviderRepository;
import com.SpringbootThymeleaf.Springboot.Thymeleaf.service.MerchantService;
import com.SpringbootThymeleaf.Springboot.Thymeleaf.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/thymeleaf")
public class HomePageController {

    @Autowired
    private MerchantService merchantService;

    @Autowired
    private MerchantRepository merchantRepository;
    @Autowired
    private ProviderService providerService;

    @Autowired
    private ProviderRepository providerRepository;

    @GetMapping("/home")
    public String provider(Model model)
    {
        model.addAttribute("content","body-check.html");
        List<Merchant> merchants = merchantService.ShowMerchants();
        int merchantscount=merchants.size();

        List<MerchantResponse> merchantList =merchantRepository.findAllmerchantName();
        List<Provider> providers = providerService.ShowProviders();
        int providerscount=providers.size();
        model.addAttribute("merchantscount", merchantscount);
        model.addAttribute("providerscount", providerscount);
        model.addAttribute("merchantList", merchantList);
        //List<ProviderResponse> providerList =providerRepository.findAllproviderName();
        //model.addAttribute("providerList", providerList);
        List<String> providerList =providerService.ShowProviders().stream().map(x->x.getProviderName() ).collect(Collectors.toList());
        model.addAttribute("providerList", providerList);
        return "base";
    }
    @GetMapping("/about")
    public String about(Model model)
    {
        model.addAttribute("content","about.html");
        return "base";
    }
    //https://95d2-122-165-218-216.in.ngrok.io/3ds-webhook


}
