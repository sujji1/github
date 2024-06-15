package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
public class GuestCont {
@Autowired
private GuestsRepo gr;
@PostMapping("/guest")

public ResponseEntity<Guests>save(@RequestBody Guests g){
	return new ResponseEntity<>(gr.save(g),HttpStatus.CREATED);
}
@GetMapping("/guest")
public ResponseEntity<List<Guests>>getall(){
	return new ResponseEntity<>(gr.findAll(),HttpStatus.CREATED);
}
@GetMapping("/guest/{id}")
public ResponseEntity<Guests>getdata(@PathVariable int gid,@RequestBody Guests g){
	Optional<Guests>op=gr.findById(gid);
	if(op.isPresent()) {
		return new ResponseEntity<>(op.get(),HttpStatus.OK);
	}
	else {
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
@PutMapping("/guest/{id}")
public ResponseEntity<Guests>updatedata(@PathVariable int gid,@RequestBody Guests g){
	Optional<Guests>op=gr.findById(gid);
	if(op.isPresent()) {
		return new ResponseEntity<>(gr.save(op.get()),HttpStatus.OK);
	}
	else {
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
@DeleteMapping("/guest/{id}")
public ResponseEntity<Guests>deletedata(@PathVariable int gid,@RequestBody Guests g){
	Optional<Guests>op=gr.findById(gid);
	if(op.isPresent()) {
		gr.deleteById(gid);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	else {
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}










}
