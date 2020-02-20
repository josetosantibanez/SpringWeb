package com.joseto.SpringWeb.service;

import java.util.List;

import com.joseto.SpringWeb.entity.ContactEntity;
import com.joseto.SpringWeb.model.ContactModel;

public interface ContactService {

	public abstract ContactModel addContact(ContactModel contactModel);
	public abstract List<ContactModel> listAllContacts();
	public abstract ContactEntity findContactById(int id);
	public abstract void removeContact(int id);
	public abstract ContactModel findContactModelById(int id);
}
