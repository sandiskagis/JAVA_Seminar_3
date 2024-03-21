package model;

import java.util.ArrayList;

public class Page {
    //1. variables
    private String title;
    private String description;

    public ArrayList<Post> getPublicPosts() {
        return publicPosts;
    }

    private ArrayList<Post> publicPosts = new ArrayList<Post>();
    private ArrayList<Post> privatePosts = new ArrayList<Post>();

    //2. get and set

    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        if(title != null && title.matches("[A-Za-z0-9 ]{5,20}"))
            this.title = title;
        else
            this.title =  "------";
    }

    public ArrayList<Post> getPrivatePosts() {
        return privatePosts;
    }

    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        if(title != null && description.length() > 10 && description.length() < 200)
            this.description = description;
        else
            this.description = "------";
    }

    //3. constructors

    public Page()
    {
        setTitle("Test page");
        setDescription("Test page description");
    }
    public Page(String title, String description)
    {
        setTitle(title);
        setDescription(description);
    }

    //4. toString

    public String toString(){
        return title + "( " + description + "): [" + (privatePosts.size() + publicPosts.size()) + "]";
    }

}
