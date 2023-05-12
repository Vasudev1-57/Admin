package com.SpringbootThymeleaf.Springboot.Thymeleaf.controller;

import com.SpringbootThymeleaf.Springboot.Thymeleaf.entity.Merchant;
import com.SpringbootThymeleaf.Springboot.Thymeleaf.entity.Provider;
import com.SpringbootThymeleaf.Springboot.Thymeleaf.reposirory.MerchantRepository;
import com.SpringbootThymeleaf.Springboot.Thymeleaf.service.MerchantService;
import com.SpringbootThymeleaf.Springboot.Thymeleaf.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Controller
@RequestMapping("/merchant")
public class MerchantController {

    @Autowired
    private MerchantService merchantService;

    @Autowired
    private MerchantRepository merchantRepository;
    @Autowired
    private ProviderService providerService;

    @GetMapping("/addMerchant")
    public String addMerchant(Model model) {
        Merchant merchant = new Merchant();
        List<Provider> providers = providerService.ShowProviders();
        model.addAttribute("providers", providers);
        model.addAttribute("merchants", merchant);
        model.addAttribute("content", "add-merchants.html");
        return "base";
    }

    @GetMapping("/ShowMerchants")
    public String Merchant(Model model) {
        List<Merchant> merchants = merchantService.ShowMerchants();
        model.addAttribute("merchants", merchants);
        model.addAttribute("content", "all-merchants.html");
        return "base";
    }

    @PostMapping("/saveMerchant")
    public String saveMerchant(Model model, @ModelAttribute Merchant merchant) {
        merchantService.SaveMerchant(merchant);
        return "redirect:/merchant/ShowMerchants";


    }

    @GetMapping("/MerchantDetails")
    public String MerchantDetails(Model model, @RequestParam int merchantId) {

        Merchant merchant = merchantService.findById(merchantId);

        Set<Provider> providers = merchant.getProviders();

       // List<Provider> providers = providerService.ShowProviders();
        model.addAttribute("providers", providers);
        model.addAttribute("merchants", merchant);
        model.addAttribute("content", "merchants-details.html");
        return "merchant-details";
    }

    @GetMapping("/ShowUpdateMerchant")
    public String ShowUpdateMerchant(Model model, @RequestParam int merchantId) {

        Merchant merchant = merchantService.findById(merchantId);
        List<Provider> providers = providerService.ShowProviders();
        model.addAttribute("providers", providers);
        model.addAttribute("merchants", merchant);
        model.addAttribute("content", "add-merchants.html");
        return "base";
    }

    @GetMapping("/DeleteMerchant")
    public String DeleteProvider(Model model, @RequestParam int merchantId) {
        // merchantRepository.deleteById(merchantId);

        Optional<Merchant> merchant1 = merchantRepository.findById(merchantId);
        Merchant merchant = merchant1.get();
        Set<Provider> subs = merchant.getProviders();
        subs.clear();
        merchant.setProviders(subs);
        merchantRepository.save(merchant);
        merchantRepository.deleteById(merchantId);
        return "redirect:/merchant/ShowMerchants";
    }
}

