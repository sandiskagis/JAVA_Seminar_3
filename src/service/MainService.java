package service;

import java.util.ArrayList;


import model.user.GuestUser;
import model.user.PrivateUser;
import model.*;


public class MainService {

    public static void main(String[] args){

        //tips     nosaukums = new     konstruktora_izsaukums;
        GuestUser    gU1     = new     GuestUser()           ;
        GuestUser    gU2     = new     GuestUser()           ;
        GuestUser    gU3     = new     GuestUser()           ;

        PrivateUser  pU1     = new     PrivateUser("Sandis", "Ozoliņš", "1234");

        try {
            pU1.publishPost("Mana 1. ziņa", "Man patīk programmēt", PostType.publicPost);
            pU1.publishPost("Mana 2. ziņa", "Man ļoti patīk programmēt", PostType.privatePost);
            pU1.publishPost("Mana 3. ziņa", "Man pārāk patīk programmēt", PostType.privatePost);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        System.out.println(gU1);
        System.out.println(gU2);
        System.out.println(gU3);
        System.out.println(pU1);

        System.out.println("Public posts ->");
        System.out.println(pU1.getPublicPosts());
        System.out.println("Private posts ->");
        System.out.println(pU1.getPrivatePosts());



    }

}
