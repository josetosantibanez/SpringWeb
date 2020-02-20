package com.joseto.SpringWeb.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.joseto.SpringWeb.component.ContactConverter;
import com.joseto.SpringWeb.entity.ContactEntity;
import com.joseto.SpringWeb.model.ContactModel;
import com.joseto.SpringWeb.repository.ContactRepository;
import com.joseto.SpringWeb.service.ContactService;

@Service("contactServiceImpl")
public class ContactServiceImpl implements ContactService{

	@Autowired
	@Qualifier("contactRepository")
	private ContactRepository contactRepository;
	
	@Autowired
	@Qualifier("contactConverter")
	private ContactConverter contactConverter;
	
	public ContactModel addContact(ContactModel contactModel) {
		ContactEntity contactEntity = contactRepository.save(contactConverter.convertContactModelToContactEntity(contactModel));
		return contactConverter.convertContactEntityToContactModel(contactEntity);
	}

	public List<ContactModel> listAllContacts() {
		List<ContactEntity> contacts = contactRepository.findAll();
		List<ContactModel> contactsM = new ArrayList<ContactModel>();
		for(ContactEntity contact : contacts) {
			contactsM.add(contactConverter.convertContactEntityToContactModel(contact));
		}
		return contactsM;
	}

	public ContactEntity findContactById(int id) {
		return contactRepository.findById(id);
	}
	
	public ContactModel findContactModelById(int id) {
		return contactConverter.convertContactEntityToContactModel(findContactById(id));
	}

	public void removeContact(int id) {
		ContactEntity contact = findContactById(id);
		if (contact != null) {
			contactRepository.delete(contact);
		}	
	}

	
}
