package com.example.cinemacontrolersystem.model;

public class User extends Entity<Long>{
    private String name;
    private String password;
    private String mail;
    private String phone;
    private byte[] photo;
    private String role;
    private String salt;

    private String photoFileName = "";

    public User (long id, String name,  String password,String mail, String phone){
        super(id);
        this.name = name;
        this.password = password;
        this.mail = mail;
        this.phone = phone;
    }
    public User(String name, String password, String mail, String phone){
        this.name = name;
        this.password = password;
        this.mail = mail;
        this.phone = phone;
    }
    public User(){};

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getSalt(){
        return salt;
    }

    public String getMail() {
        return mail;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
