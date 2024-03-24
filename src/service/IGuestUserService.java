package service;

import java.util.ArrayList;

import model.Page;
import model.Post;
import model.user.RegisteredUser;

public interface IGuestUserService {

    public abstract ArrayList<RegisteredUser> findUsers(String keyText);
    public abstract ArrayList<Page> findPages(String keyText);
    public abstract ArrayList<Post> findPublicPosts(String keyText);



}