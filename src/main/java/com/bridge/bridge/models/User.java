package com.bridge.bridge.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue
    private Integer id ;
    private String firstName ;
    private String lastName ;
    @Column(unique = true)
    private String email ;
    private String password ;
    @OneToMany(mappedBy = "user")
    private List<Cours> cours ;
}
