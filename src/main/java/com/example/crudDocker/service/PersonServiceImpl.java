package com.example.crudDocker.service;

import com.example.crudDocker.dto.request.PersonRequestDTO;
import com.example.crudDocker.dto.response.PersonResponseDTO;
import com.example.crudDocker.entity.Person;
import com.example.crudDocker.repository.PersonRepository;
import com.example.crudDocker.util.PersonMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService{
    private final PersonRepository personRepository;

    private final PersonMapper personMapper;

    @Override
    public PersonResponseDTO findById(Long id) {
          Person person = returnUser(id);

          return new PersonResponseDTO(person);
    }

    @Override
    public List<PersonResponseDTO> findAll() {
        return personMapper.toPeopleDTO(personRepository.findAll());
    }

    @Override
    public PersonResponseDTO register(PersonRequestDTO personDTO) {
        Person person = personMapper.toPerson(personDTO);
        return personMapper.toPersonDTO(personRepository.save(person));
    }


    @Override
    public PersonResponseDTO upadte(PersonRequestDTO personDTO, Long id) {
        Person person = returnUser(id);

        personMapper.updatePersonData(person, personDTO);

        return personMapper.toPersonDTO(personRepository.save(person));
    }

    @Override
    public String delete(Long id) {
        personRepository.deleteById(id);
        return "Person id:"+id+" deleted";
    }

    private Person returnUser(Long id){
        return personRepository.findById(id).orElseThrow(() -> new RuntimeException("Person wasn´t found on database"));

    }
}
