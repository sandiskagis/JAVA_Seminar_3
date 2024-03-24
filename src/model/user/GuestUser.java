package model.user;

import service.impl.AllUserServiceImpl;

public class GuestUser {
    //1. variables
    private long userID;

    private static long counter = 0;

    public AllUserServiceImpl service = new AllUserServiceImpl();

    //2.get and set

    public long getUserID() {
        return userID;
    }

    public void setUserID() {
        this.userID = counter++;
    }

    //3. constructors
    public GuestUser()
    {
        setUserID();
    }


    //4. toString
    public String toString() {
        return "" + userID;
    }




    //5. other function
    //TODO nodrošināt servisa daļu GuestUser lietotajam

}