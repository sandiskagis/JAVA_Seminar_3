package model.user;

import service.IPostService;


public abstract class RegisteredUser extends GuestUser implements IPostService{
    //1.variables
    private String username;
    protected String nameAndSurnameOrTitle;

    //TODO izmantot enkodēšanu parolei
    private String password;

    //2.get and set

    public String getUsername() {
        return username;
    }

    //TODO
    public void setUsername() {
        this.username = super.getUserID() + "_" + nameAndSurnameOrTitle.substring(0, 5).trim();
    }

    public String getNameAndSurnameOrTitle() {
        return nameAndSurnameOrTitle;
    }

    public abstract void setNameAndSurnameOrTitle(String nameAndSurnameOrTitle);



    //TODO apdomāt, varbūt nomainīt pieejamību
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //3.constructor

    public RegisteredUser(){
        super();//tiks izsaukts GuestUser konstruktors
        setPassword("1234567");
    }
    public RegisteredUser(String password){
        super();//tiks izsaukts GuestUser konstruktors
        setPassword(password);
    }

    //4.toString

    public String toString()
    {
        return "Registered User -> " + super.toString() + ":" + nameAndSurnameOrTitle + "(" + username + ")";
    }

    //5.other functions
    //TODO login and followPage





}
