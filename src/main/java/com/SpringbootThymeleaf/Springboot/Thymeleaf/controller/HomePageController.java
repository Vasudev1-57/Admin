package com.SpringbootThymeleaf.Springboot.Thymeleaf.controller;

import com.SpringbootThymeleaf.Springboot.Thymeleaf.entity.Merchant;
import com.SpringbootThymeleaf.Springboot.Thymeleaf.entity.Provider;
import com.SpringbootThymeleaf.Springboot.Thymeleaf.reposirory.MerchantRepository;
import com.SpringbootThymeleaf.Springboot.Thymeleaf.service.MerchantService;
import com.SpringbootThymeleaf.Springboot.Thymeleaf.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/thymeleaf")
public class HomePageController {

    @Autowired
    private MerchantService merchantService;

    @Autowired
    private MerchantRepository merchantRepository;
    @Autowired
    private ProviderService providerService;

    @GetMapping("/home")
    public String provider(Model model)
    {
        model.addAttribute("content","body-check.html");
        List<Merchant> merchants = merchantService.ShowMerchants();
        int merchantscount=merchants.size();
        List<Provider> providers = providerService.ShowProviders();
        int providerscount=providers.size();
        model.addAttribute("merchantscount", merchantscount);
        model.addAttribute("providerscount", providerscount);
        return "base";
    }
    @GetMapping("/about")
    public String about(Model model)
    {
        model.addAttribute("content","about.html");
        return "base";
    }
}
