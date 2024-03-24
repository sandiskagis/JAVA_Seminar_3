package service;

import java.util.ArrayList;
import java.util.Arrays;

import model.Page;
import model.PostType;
import model.user.BusinessUser;
import model.user.GuestUser;
import model.user.PrivateUser;
import model.user.RegisteredUser;

public class MainService {

    public static ArrayList<GuestUser> allUsers = new ArrayList<GuestUser>();

    public static void main(String[] args) {

        //tips      nosaukums = new kontruktora_izsaukums ;
        GuestUser   gU1       = new GuestUser()           ;
        GuestUser   gU2       = new GuestUser()           ;
        GuestUser   gU3       = new GuestUser()           ;
        PrivateUser pU1       = new PrivateUser("Karina", "Šķirmante", "1234");
        PrivateUser pU2       = new PrivateUser("Hesburger", "Ēdājs", "1234");
        BusinessUser bu1 = new BusinessUser();
        BusinessUser bu2 = new BusinessUser("SIA Hesburger", "qwerty", "LV40003666476");


        allUsers.addAll(Arrays.asList(gU1, gU2, gU3, pU1, bu1, bu2, pU2));


        for(GuestUser tempU : allUsers)
        {
            System.out.println(tempU);
        }

        System.out.println("----------------------");


        try {
            pU1.publishPost("Mana pirmā ziņa", "Man ļoti patīk programmēt", PostType.publicPost);
            pU1.publishPost("Mana otrā ziņa", "Man viss ir apnicis", PostType.privatePost);
            pU1.publishPost("Mana trešā ziņa", "Gribu, lai ir piektdiena", PostType.privatePost);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        System.out.println(gU1);
        System.out.println(gU2);
        System.out.println(gU3);

        System.out.println(pU1);

        System.out.println("Private posts->");
        System.out.println(pU1.getPrivatePosts());
        System.out.println("Public posts->");
        System.out.println(pU1.getPublicPosts());

        System.out.println("-----------------------------");
        try {
            bu2.addPage("Hesburgers Ventspili", "Aktualitates par Ventspils filiāli");
            bu2.addPage("Hesburgers Daugavpili", "Aktualitates par Daugavpils filiāli");
            bu2.addPage("Hesburgers Ainazi", "Aktualitates par Ainažu filiāli");

            bu2.publishPostInPage(
                    "Jaunumi martā",
                    "20% atlaide siera burgeriem Ventspils svētkos",
                    "Hesburgers Ventspili",
                    PostType.publicPost);

            bu2.publishPostInPage(
                    "Jaunumi aprīlī",
                    "Lieldienu atlaide - 30% saldējumam",
                    "Hesburgers Ventspili",
                    PostType.publicPost);

            bu2.publishPostInPage(
                    "Jaunumi martā",
                    "50% atlaide fri Daugavpils svētkos",
                    "Hesburgers Daugavpili",
                    PostType.publicPost);


        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        for(Page tempP: bu2.getAllUserPages()) {
            System.out.println("page->" + tempP);
            System.out.println("private posts ->" + tempP.getPrivatePosts());
            System.out.println("public posts ->" + tempP.getPublicPosts());
        }

        System.out.println("-----------------------------");



        System.out.println("Search users->");
        System.out.println(gU2.service.findUsers("hes"));

        System.out.println("Search pages->");
        System.out.println(gU2.service.findPages("vent"));
    }

}