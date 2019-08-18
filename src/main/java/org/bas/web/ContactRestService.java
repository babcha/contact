package org.bas.web;

import java.util.List;
import java.util.Optional;

import org.bas.dao.ContactRepository;
import org.bas.entities.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactRestService {
	@Autowired
	private ContactRepository contactRepository;

	@RequestMapping(value="/contacts",method=RequestMethod.GET)
	public List<Contact> getContacts(){
		return contactRepository.findAll();
	}
	
	@RequestMapping(value="/contacts/{id}",method=RequestMethod.GET)
	public Optional<Contact> getContact(@PathVariable Long id){
		return contactRepository.findById(id);
	}
	@RequestMapping(value="/contacts",method=RequestMethod.POST)
	public Contact saveContact(@RequestBody Contact contact){
		return contactRepository.saveAndFlush(contact);
	}
	
	@RequestMapping(value="/contacts/{id}",method=RequestMethod.DELETE)
	public boolean deleteContact(@PathVariable Long id){
		contactRepository.deleteById(id);
		return true;
	}
	
	@RequestMapping(value="/contacts/{id}",method=RequestMethod.PUT)
	public Contact updateContact(@PathVariable Long id,@RequestBody Contact contact){
		contact.setId(id);
		return contactRepository.save(contact);
	}
	
	@RequestMapping(value="/chercherContacts",method=RequestMethod.GET)
	public Page<Contact> chercher(
			@RequestParam(name="mc",defaultValue="") String mc,
			@RequestParam(name="page",defaultValue="0")int page,
			@RequestParam(name="size",defaultValue="5")int size){
		return contactRepository.cherher("%"+mc+"%", new PageRequest(page, size));
	}
}
