package service;

import model.Post;
import model.PostType;

public interface IPostService {

    public abstract Post publishPost(String title, String msg, PostType type) throws Exception;

}