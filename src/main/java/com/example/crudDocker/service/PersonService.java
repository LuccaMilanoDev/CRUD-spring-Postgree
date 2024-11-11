package com.example.crudDocker.service;


import com.example.crudDocker.dto.request.PersonRequestDTO;
import com.example.crudDocker.dto.response.PersonResponseDTO;

import java.util.List;

public interface PersonService {

    PersonResponseDTO findById(Long id);

    List<PersonResponseDTO> findAll();

    PersonResponseDTO register(PersonRequestDTO personDTO);



    PersonResponseDTO update(PersonRequestDTO personDTO, Long id);

    String delete(Long id);
}

