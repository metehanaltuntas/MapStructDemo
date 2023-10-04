package com.app.mapstructdemo.mapper;

import com.app.mapstructdemo.dto.ContactDTO;
import com.app.mapstructdemo.entity.Contact;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ContactMapper {

    Contact toEntity(ContactDTO contactDTO);

    ContactDTO toDTO(Contact contact);

    List<ContactDTO> toDTOList(List<Contact> contactList);

}
