package com.example.demo;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.*;

@Entity
public class Guests {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int gid;
	private int registrationnum;
	public Guests() {
		
	}
	public Guests(int gid, int registrationnum) {
		super();
		this.gid = gid;
		this.registrationnum = registrationnum;
	}
	public int getGid() {
		return gid;
	}
	public void setGid(int gid) {
		this.gid = gid;
	}
	public int getRegistrationnum() {
		return registrationnum;
	}
	public void setRegistrationnum(int registrationnum) {
		this.registrationnum = registrationnum;
	}
	@Override
	public String toString() {
		return "Guests [gid=" + gid + ", registrationnum=" + registrationnum + "]";
	}
	
}
