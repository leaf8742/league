package com.rainbow_weaver.league.domain;

import java.io.Serializable;

public class Player implements Serializable {
	private static final long serialVersionUID = -571362616205424809L;
	private int pid;
    private String name;
    private String address;
    private String city;
    private String email;
    
    public Player() {}
    
    public Player(int pid, String name, String address,
                   String city, String email) {
        this.pid = pid;
        this.name = name;
        this.address = address;
        this.city = city;
        this.email = email;        
    }
    
    public int getPid() {
        return pid;
    }
     
    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }
    
    public String getCity() {
        return city;
    }
    
    public String getEmail() {
        return email;
    }
    
    public String toString() {
        return name + " " + address + " " + city;
    }
}
