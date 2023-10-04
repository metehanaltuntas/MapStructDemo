package com.app.mapstructdemo.service;

import com.app.mapstructdemo.dto.ContactDTO;
import com.app.mapstructdemo.entity.Contact;
import com.app.mapstructdemo.mapper.ContactMapper;
import com.app.mapstructdemo.repository.ContactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContactService {

    private final ContactRepository contactRepository;

    private final ContactMapper contactMapper;

    public Contact saveContact(ContactDTO contactDTO) {
        /*Contact contact = new Contact();
        contact.setFirstName(contactDTO.getFirstName());
        contact.setLastName(contactDTO.getLastName());
        contact.setEmail(contactDTO.getEmail());
        contact.setPhoneNo(contactDTO.getPhoneNo());*/
        return contactRepository.save(contactMapper.toEntity(contactDTO));
    }

    public ContactDTO getContactById(Long id) {
        /*Optional<Contact> contact = contactRepository.findById(id);
        ContactDTO contactDTO = new ContactDTO();
        if (contact.isPresent()) {
            contactDTO.setId(id);
            contactDTO.setFirstName(contact.get().getFirstName());
            contactDTO.setLastName(contact.get().getLastName());
            contactDTO.setEmail(contact.get().getEmail());
            contactDTO.setPhoneNo(contact.get().getPhoneNo());
        }*/
        return contactRepository.findById(id).map(contactMapper::toDTO).orElse(null);
    }

    public List<ContactDTO> getContactList() {
        /*return contactRepository.findAll().stream().map(contact -> {
            ContactDTO contactDTO = new ContactDTO();
            contactDTO.setId(contact.getId());
            contactDTO.setFirstName(contact.getFirstName());
            contactDTO.setLastName(contact.getLastName());
            contactDTO.setEmail(contact.getEmail());
            contactDTO.setPhoneNo(contact.getPhoneNo());
            return contactDTO;
        }).collect(Collectors.toList());*/

        return contactMapper.toDTOList(contactRepository.findAll());
    }

}
