package com.SpringbootThymeleaf.Springboot.Thymeleaf.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.catalina.authenticator.jaspic.PersistentProviderRegistrations;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "merchants")
public class Merchant {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY )
    private int id;
    @Column(nullable = false)
    private String merchantName;
    @Column(nullable = false)
    private String emailId;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private int age;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "merchant_provider",
            joinColumns = @JoinColumn(
                    name = "merchant_id", referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "provider_id", referencedColumnName = "id"
            )
    )
    private Set<Provider> providers = new HashSet<>();
    @Column(nullable = false)
    private String accountNo;

    private LocalDateTime createdon;

}
