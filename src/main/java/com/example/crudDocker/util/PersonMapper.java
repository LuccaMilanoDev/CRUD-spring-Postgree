package com.example.crudDocker.util;

import com.example.crudDocker.dto.request.PersonRequestDTO;
import com.example.crudDocker.dto.response.PersonResponseDTO;
import com.example.crudDocker.entity.Person;

import java.util.List;
import java.util.stream.Collectors;

public class PersonMapper {

    public Person toPerson(PersonRequestDTO personDTO){
        return Person.builder().age(personDTO.getAge()).cpf(personDTO.getCpf()).name(personDTO.getName()).build();
    }

    public PersonResponseDTO toPersonDTO(Person person){
        return new PersonResponseDTO(person);
    }

    public List<PersonResponseDTO> toPeopleDTO(List<Person> peopleList){
        return peopleList.stream().map(PersonResponseDTO::new).collect(Collectors.toList());
    }

    public void updatePersonData(Person person, PersonRequestDTO personDTO) {

        person.setName(personDTO.getName());
        person.setCpf(personDTO.getCpf());
        person.setAge(personDTO.getAge());

    }
}
