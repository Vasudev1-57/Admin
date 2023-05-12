package com.SpringbootThymeleaf.Springboot.Thymeleaf.controller;

import com.SpringbootThymeleaf.Springboot.Thymeleaf.entity.Provider;
import com.SpringbootThymeleaf.Springboot.Thymeleaf.reposirory.ProviderRepository;
import com.SpringbootThymeleaf.Springboot.Thymeleaf.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.objenesis.SpringObjenesis;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/provider")
public class ProviderController {

    @Autowired
   private ProviderService providerService;

    @Autowired
    private ProviderRepository providerRepository ;


    @GetMapping("/addProvider")
    public String addProvider(Model model)    {
        Provider provider=new Provider();
        model.addAttribute("providers",provider);
        model.addAttribute("content","add-providers.html");
        return "base";
    }

    @GetMapping("/ShowProviders")
    public String provider(Model model)
    {
        List<Provider> providers=providerService.ShowProviders();
       model.addAttribute("providers",providers);
        model.addAttribute("content","all-providers.html");
        return "base";
    }
    @PostMapping("/saveProvider")
    public String  SaveProvider(Model model,@ModelAttribute Provider provider)
    {
 providerService.SaveProvider(provider) ;
        List<Provider> providers=providerService.ShowProviders();
        model.addAttribute("providers",providers);
        model.addAttribute("content","all-providers.html");
        return "redirect:/provider/ShowProviders";


    }

    @GetMapping("/ShowUpdateProvider")
    public String ShowUpdateProvider(Model model, @RequestParam int providerId)
    {

        Provider provider=providerService.findById(providerId);
           model.addAttribute("providers",provider);
        model.addAttribute("content","add-providers.html");
        return "base";
    }

    @GetMapping("/DeleteProvider")
    public String DeleteProvider(Model model,@RequestParam int providerId)
    {
        providerRepository.deleteById(providerId);
        List<Provider> providers=providerService.ShowProviders();
        model.addAttribute("providers",providers);
        model.addAttribute("content","all-providers.html");
        return "redirect:/provider/ShowProviders";
    }

}
