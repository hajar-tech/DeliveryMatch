package com.deliveryMatch.backend.services.implementationServices;

import com.deliveryMatch.backend.dtos.AnnonceTrajetDto;
import com.deliveryMatch.backend.mappers.AnnonceMapper;
import com.deliveryMatch.backend.modules.AnnonceTrajet;
import com.deliveryMatch.backend.modules.Conducteur;
import com.deliveryMatch.backend.repository.AnnonceTrajetRepository;
import com.deliveryMatch.backend.repository.ConducteurRepository;
import com.deliveryMatch.backend.services.InterfaceServices.AnnonceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AnnonceImpl implements AnnonceService {

  private   final AnnonceTrajetRepository annonceRepository;
  private   final AnnonceMapper annonceMapper;
   private final ConducteurRepository  conducteurRepository;

   @Autowired
    public AnnonceImpl( AnnonceMapper annonceMapper , ConducteurRepository conducteurRepository , AnnonceTrajetRepository annonceRepository) {
        this.annonceRepository = annonceRepository;
        this.annonceMapper = annonceMapper;
        this.conducteurRepository = conducteurRepository;
    }

    @Override
    public AnnonceTrajetDto creerAnnonce(AnnonceTrajetDto annonceTrajetDto) {

       //récupération du conducteur
        Conducteur conducteur = conducteurRepository.findById(annonceTrajetDto.conducteurId())
                .orElseThrow(()-> new RuntimeException("Conducteur introuvable"));

        //pour mapper dto vers entité
        AnnonceTrajet annonce = annonceMapper.dtoToEntity(annonceTrajetDto);

        //pour ajouter conducteur et date de création
        annonce.setConducteur(conducteur);
        annonce.setDateAnance(new Date());
        return annonceMapper.entityToDto(annonceRepository.save(annonce));
    }

    @Override
    public AnnonceTrajet modifierAnnonceTrajet(AnnonceTrajetDto annonceTrajetDto, Long id) {

//        //récupération du conducteur
//        Conducteur conducteur = conducteurRepository.findById(annonceTrajetDto.getConducteurId())
//                .orElseThrow(()-> new RuntimeException("Conducteur introuvable"));
//
//
      return null;
    }

//    // 🔹 READ - find all
//    public List<AnnonceTrajetDto> getAllAnnonces() {
//        return annonceMapper.entityListToDtoList(annonceRepo.findAll());
//    }

//    // 🔹 READ - find by id
//    public AnnonceTrajetDto getAnnonceById(Long id) {
//        AnnonceTrajet annonce = annonceRepo.findById(id)
//                .orElseThrow(() -> new RuntimeException("Annonce non trouvée"));
//        return annonceMapper.entityToDto(annonce);
//    }
//
//    // 🔸 UPDATE
//    public AnnonceTrajetDto updateAnnonce(Long id, AnnonceTrajetDto dto) {
//        AnnonceTrajet annonce = annonceRepo.findById(id)
//                .orElseThrow(() -> new RuntimeException("Annonce non trouvée"));
//
//        annonce.setLieuDepart(dto.getLieuDepart());
//        annonce.setDestinationFinale(dto.getDestinationFinale());
//        annonce.setEtapeIntermediaire(dto.getEtapeIntermediaire());
//        annonce.setDateDepart(dto.getDateDepart());
//
//        return annonceMapper.entityToDto(annonceRepo.save(annonce));
//    }
//
//    // 🔴 DELETE
//    public void deleteAnnonce(Long id) {
//        annonceRepo.deleteById(id);
//    }
}
