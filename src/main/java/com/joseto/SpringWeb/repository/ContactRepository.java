package com.joseto.SpringWeb.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.joseto.SpringWeb.entity.ContactEntity;

@Repository("contactRepository")
public interface ContactRepository extends JpaRepository<ContactEntity, Serializable>{

	public abstract ContactEntity findById(int id);
	
}
