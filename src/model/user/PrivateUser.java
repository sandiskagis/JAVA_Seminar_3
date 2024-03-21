package model.user;

import model.Post;
import model.PostType;

import java.util.ArrayList;

public class PrivateUser extends RegisteredUser{


    //1.variables
    private ArrayList<Post> privatePosts = new ArrayList<Post>();
    private ArrayList<Post> publicPosts = new ArrayList<Post>();
    private ArrayList<RegisteredUser> followers = new ArrayList<RegisteredUser>();

    //2.get and set

    public ArrayList<Post> getPrivatePosts() {
        return privatePosts;
    }

    public ArrayList<Post> getPublicPosts() {
        return publicPosts;
    }

    public ArrayList<RegisteredUser> getFollowers() {
        return followers;
    }
    @Override
    public void setNameAndSurnameOrTitle(String nameAndSurnameOrTitle) {
        if(nameAndSurnameOrTitle != null && nameAndSurnameOrTitle.matches("[A-ZĒŪĪĀŠĢĶĻŽČŅ]{1}[a-zēūīāšģķļžčņ]{2,20} [A-ZĒŪĪĀŠĢĶĻŽČŅ]{1}[a-zēūīāšģķļžčņ]{2,30}")) {
            super.nameAndSurnameOrTitle = nameAndSurnameOrTitle;
        }
        else {
            super.nameAndSurnameOrTitle = "-------";
        }
    }

    //3.constructors

    public PrivateUser(){
        super();//te izsaucās RegisteredUser() konstruktors
        setNameAndSurnameOrTitle("Jānis Bērziņš");
        setUsername();
    }

    public PrivateUser(String name, String surname, String password) {
        super();//tiks izsaukts Registered(String password) konstruktors
        setNameAndSurnameOrTitle(name + " " + surname);
        setUsername();
    }

    //4.toString

    public String toString(){
        return super.toString() + "[" + (privatePosts.size() + publicPosts.size()) + "posts]";
    }

    //5.other functions



    @Override
    public Post publishPost(String title, String msg, PostType type) throws Exception {
        if(title == null || msg == null || type == null)
            throw new Exception("Problems with input params");

        Post newPost = new Post(title,msg);

        if(type.equals(PostType.privatePost))
            privatePosts.add(newPost);
        else
            publicPosts.add(newPost);

        return newPost;
    }

    //TODO AddFollower
}
