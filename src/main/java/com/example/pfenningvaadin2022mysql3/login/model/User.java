package com.example.pfenningvaadin2022mysql3.login.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.RandomStringUtils;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;
    private String username;
    private String password;
    //private String passwordSalt;
    //private String passwordHash;
    private Role role;
    private String activationCode;
    private boolean active;



    public User(String username, String password, Role role) {
        this.username = username;
        this.role = role;
        this.password=password;
        //this.passwordSalt = RandomStringUtils.random(32);
        //this.passwordHash = DigestUtils.sha1Hex(password + passwordSalt);
        //this.activationCode = RandomStringUtils.randomAlphanumeric(32);
    }

    public boolean checkPassword(String password1) {
        if(password1.equals(password)){
            return true;}
            else{
                return  false;
        }
        }
        //return DigestUtils.sha1(password).equals(password);
        //return DigestUtils.sha1Hex(password + passwordSalt).equals(passwordHash);
    }

  /*  public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordSalt() {
        return passwordSalt;
    }

    public void setPasswordSalt(String passwordSalt) {
        this.passwordSalt = passwordSalt;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getActivationCode() {
        return activationCode;
    }

    public void setActivationCode(String activationCode) {
        this.activationCode = activationCode;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }*/

