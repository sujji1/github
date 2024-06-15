package com.example.demo;

import java.util.*;

import jakarta.persistence.*;

@Entity(name="users")
public class Clerk {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	@OneToMany(cascade=CascadeType.ALL)
	List<Guests>G=new ArrayList<>();
	public Clerk() {
		
	}
	public Clerk(int id, String name, List<Guests> g) {
		super();
		this.id = id;
		this.name = name;
		G = g;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Guests> getG() {
		return G;
	}
	public void setG(List<Guests> g) {
		G = g;
	}
	@Override
	public String toString() {
		return "Clerk [id=" + id + ", name=" + name + ", G=" + G + "]";
	}
	
	
	
	
}
