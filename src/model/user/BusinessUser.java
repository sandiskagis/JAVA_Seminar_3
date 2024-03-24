package model.user;

import java.util.ArrayList;

import model.Page;
import model.Post;
import model.PostType;

public class BusinessUser extends RegisteredUser{

    //1.variables
    private String VATNo; //LV90000362426
    private ArrayList<Page> allUserPages = new ArrayList<Page>();

    //2.get and set

    public String getVATNo() {
        return VATNo;
    }


    public void setVATNo(String vATNo) {
        if(vATNo != null && vATNo.matches("[A-Z]{2}[0-9]{11}"))//LV90000362426
            VATNo = vATNo;
        else
            VATNo =  "------------";
    }


    public ArrayList<Page> getAllUserPages() {
        return allUserPages;
    }

    @Override
    public void setNameAndSurnameOrTitle(String nameAndSurnameOrTitle) {
        if(nameAndSurnameOrTitle !=null &&
                nameAndSurnameOrTitle.matches("[A-ZĒŪĪĻĶĢŠĀŽČŅa-zēūīļķģšāžčņ0-9.,:'@&%+= ]{2,40}"))
            super.nameAndSurnameOrTitle = nameAndSurnameOrTitle;

        else
            super.nameAndSurnameOrTitle = "--------";

    }


    //3. constructors
    public BusinessUser() {
        super();//tiek izsaukts RegisteredUser() konstruktors
        setNameAndSurnameOrTitle("SIA Autoserviss");
        setUsername();
        setVATNo("LV90000362426");
    }

    public BusinessUser(String title, String password, String VATNo) {
        super(password);//tiks izsauukts RegisteredUser(String password) konstruktors
        setNameAndSurnameOrTitle(title);
        setUsername();
        setVATNo(VATNo);
    }


    //4. toString

    public String toString() {
        return super.toString() + "[" + VATNo + "]";
    }



    //5. other functions
    public void addPage(String title, String description) throws Exception {
        //TODO ja nepieciešams, pārbauda ievades parametrus uz not null

        for(Page tempP: allUserPages) {
            if(tempP.getTitle().toLowerCase().equals(title.toLowerCase())) {
                throw new Exception("Page already exists");
            }
        }

        Page newPage = new Page(title, description);
        allUserPages.add(newPage);

    }

    public void publishPostInPage(String postTitle, String msg,
                                  String pageTitle, PostType type) throws Exception{
        //TODO ja nepieciešams, pārbauda ievades parametrus uz not null


        for(Page tempP: allUserPages) {
            if(tempP.getTitle().toLowerCase().equals(pageTitle.toLowerCase())) {
                Post newPost = publishPost(postTitle, msg, type);
                if(type.equals(PostType.privatePost))
                    tempP.getPrivatePosts().add(newPost);
                else if(type.equals(PostType.publicPost))
                    tempP.getPublicPosts().add(newPost);

                return;
            }
        }

        throw new Exception("Page not found");




    }



    @Override
    public Post publishPost(String title, String msg, PostType type) throws Exception {
        //TODO ja nepieciešams, pārbauda ievades parametrus uz not null
        Post newPost = new Post(title, msg);
        return newPost;

    }


}