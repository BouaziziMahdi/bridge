package com.bridge.bridge.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "cours")
public class Cours {
    @Id
    @GeneratedValue()
    private Integer id ;
    private String name ;
    private String description ;
    private Float prix ;
    private String image ;
}
