package model.user;

public class GuestUser {
    //1.variables
    private long userID;
    private static long counter = 0;

    //2.get and set

    public long getUserID() {
        return userID;
    }

    public void setUserID() {
        this.userID = counter++;
    }

    //3.constructors

    public GuestUser()
    {
        setUserID();
    }

    //4.toString

    public String toString()
    {
        return "" + userID;
    }

    //5.other functions
    //TODO nodrošināt servisa daļu GuestUser lietotājam
}
