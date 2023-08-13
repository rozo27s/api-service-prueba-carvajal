package com.api.assessment.module.publication.service.impl;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.api.assessment.framework.dto.PublicationDTO;
import com.api.assessment.framework.jpa.crudrepository.PublicationRepository;
import com.api.assessment.framework.jpa.entity.Publication;
import com.api.assessment.framework.pattern.Translator;
import com.api.assessment.module.publication.service.PublicationService;

import lombok.RequiredArgsConstructor;

/**
 * Logica para la conexion a tabla permite metodos crud
 *
 * @author Carvajal
 * @version 1.0
 */
@Component
@RequiredArgsConstructor
public class PublicationServiceImpl implements PublicationService {

  private final PublicationRepository publicationRepository;
  @Qualifier("publicationDTOToPublication")
  private final Translator<PublicationDTO, Publication> publicationDTOToPublication;
  @Qualifier("publicationToPublicationDTO")
  private final Translator<Publication, PublicationDTO> publicationToPublicationDTO;  

  @Override
  public List<PublicationDTO> findPublicationsByProfile(Long idprofile) {
    List<PublicationDTO> publicationDtos = new ArrayList<>();
    for (Publication publication : publicationRepository.findPublicationsByProfilrId(idprofile)) {
      publicationDtos.add(publicationToPublicationDTO.to(publication));
    }
    return publicationDtos;
  }

  @Override
  public PublicationDTO createPublication(PublicationDTO publicationDTO) {
    publicationDTO.setCreationDate(LocalDateTime.now());
    return publicationToPublicationDTO.to(publicationRepository.save(publicationDTOToPublication.to(publicationDTO)));
  }

  @Override
  public PublicationDTO updatePublication(PublicationDTO publicationDTO) {
    return null;
  }

  @Override
  public PublicationDTO deletePublication(PublicationDTO publicationDTO) {
    return null;
  }


}
