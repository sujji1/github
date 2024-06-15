package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClerkCon {

	@Autowired
	private ClerkRepo cr;
	@GetMapping("/pageone")
	public List<Clerk>getpageone() {
	
	Pageable paging = PageRequest.of(0, 5,Sort.by("users").ascending());
	Page<Clerk> p=cr.findAll(paging);
	return p.getContent();
	}
	@PostMapping("/clerk")

	public ResponseEntity<Clerk>save(@RequestBody Clerk c){
		return new ResponseEntity<>(cr.save(c),HttpStatus.CREATED);
	}
	@GetMapping("/clerk")
	public ResponseEntity<List<Clerk>>getall(){
		return new ResponseEntity<>(cr.findAll(),HttpStatus.CREATED);
	}
	@GetMapping("/clerk/{id}")
	public ResponseEntity<Clerk>getdata(@PathVariable int id,@RequestBody Clerk c){
		Optional<Clerk>op=cr.findById(id);
		if(op.isPresent()) {
			return new ResponseEntity<>(op.get(),HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
	@PutMapping("/clerk/{id}")
	public ResponseEntity<Clerk>updatedata(@PathVariable int id,@RequestBody Clerk c){
		Optional<Clerk>op=cr.findById(id);
		if(op.isPresent()) {
			return new ResponseEntity<>(cr.save(op.get()),HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
	@DeleteMapping("/clerk/{id}")
	public ResponseEntity<Clerk>deletedata(@PathVariable int id,@RequestBody Clerk c){
		Optional<Clerk>op=cr.findById(id);
		if(op.isPresent()) {
			cr.deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.OK);
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
