/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.latihanwebmvc.Model;

/**
 *
 * @author helmy
 */
public class User {

    private int id;
    private String username;
    private String password;
    private String fullName;

    // default Constructor
    public User() {
    }

    // Constructor dengan parameter
    public User(String username, String password, String fullName) {
        this.username = username;
        this.password = password;
        this.fullName = fullName;
    }

    public User(int id, String username, String password, String fullName) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.fullName = fullName;
    }

    // Getter dan Setter untuk username
     public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    // Validasi login (contoh saja kita kasih hardcode untuk username "admin" dan password "admin123")
    public boolean isValidUser() {
        return "admin".equals(username) && "admin123".equals(password);
    }
}
