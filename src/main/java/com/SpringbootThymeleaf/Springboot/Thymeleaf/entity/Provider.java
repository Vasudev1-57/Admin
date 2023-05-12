package com.SpringbootThymeleaf.Springboot.Thymeleaf.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "providers")
public class Provider {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY )
    private int id;
    @Column(nullable = false)
    private String providerName;

   private LocalDateTime createdon;

    private LocalDateTime modifiedon;



}
