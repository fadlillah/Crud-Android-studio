package com.fadli.myfragment;

public class Users {
    public String User, Email, Npm;
    public Users(){

    }
    public Users(String npm, String user, String email){
        this.Npm = npm;
        this.User = user;
        this.Email = email;
    }
    public String getNpm(){
        return Npm;
    }
    public String getUser(){
        return User;
    }
    public String getEmail(){
        return Email;
    }
}
