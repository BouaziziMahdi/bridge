package com.bridge.bridge.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private String image ;
    private String prix ;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
