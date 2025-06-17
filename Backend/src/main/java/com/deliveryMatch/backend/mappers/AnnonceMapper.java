package com.deliveryMatch.backend.mappers;

import com.deliveryMatch.backend.dtos.AnnonceTrajetDto;
import com.deliveryMatch.backend.modules.AnnonceTrajet;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public class AnnonceMapper {

    @Mapping(target = "conducteur", ignore = true)
    @Mapping(target = "demandes", ignore = true)
    public AnnonceTrajet dtoToEntity(AnnonceTrajetDto dto){
        return null;
    };

    @Mapping(source = "conducteur.id", target = "conducteurId")
    public AnnonceTrajetDto entityToDto(AnnonceTrajet entity){
        return null;
    };

   public List<AnnonceTrajetDto> entityListToDtoList(List<AnnonceTrajet> list) {
        return null;
    }
}
