package com.bridge.bridge.dto;

import com.bridge.bridge.models.Cours;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CoursDto {
    private Integer id ;
    private String name ;
    private String description ;
    private String image ;
    private String prix ;
    private UserDto userDto ;
    public static CoursDto fromEntityToDto(Cours cours){
        if(cours == null){
            return null;
        }
        return CoursDto.builder()
                .id(cours.getId())
                .name(cours.getName())
                .description(cours.getDescription())
                .image(cours.getImage())
                .prix(cours.getPrix())
                .userDto(UserDto.fromEntityToDto(cours.getUser()))
                .build();
    }
    public static Cours fromDtoToEntity(CoursDto coursDto){
        if(coursDto == null){
            return null;
        }
        Cours cours = new Cours();
        cours.setId(coursDto.getId());
        cours.setName(coursDto.getName());
        cours.setDescription(coursDto.getDescription());
        cours.setImage(coursDto.getImage());
        cours.setPrix(coursDto.getPrix());
        cours.setUser(UserDto.fromDtoToEntity(coursDto.getUserDto()));
        return cours;
    }
}
