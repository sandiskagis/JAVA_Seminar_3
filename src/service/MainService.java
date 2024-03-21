package service;

import java.util.ArrayList;
import java.util.Arrays;


import model.user.BusinessUser;
import model.user.GuestUser;
import model.user.PrivateUser;
import model.*;


public class MainService {


    private static ArrayList<GuestUser> allusers = new ArrayList<GuestUser>();

    public static void main(String[] args){

        //tips     nosaukums = new     konstruktora_izsaukums;
        GuestUser    gU1     = new     GuestUser()           ;
        GuestUser    gU2     = new     GuestUser()           ;
        GuestUser    gU3     = new     GuestUser()           ;

        PrivateUser  pU1     = new     PrivateUser("Sandis", "Ozoliņš", "1234");
        BusinessUser bU1 = new BusinessUser();
        BusinessUser bU2 = new BusinessUser("SIA Hesburger", "qwerty", "LV40003666476");


        allusers.addAll(Arrays.asList(gU1, gU2, gU3, pU1, bU1, bU2));

        for(GuestUser tempU : allusers)
        {
            System.out.println(tempU);
        }





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
