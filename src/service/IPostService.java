package service;

import model.PostType;
public interface IPostService {

    public abstract void publishPost(String title, String msg, PostType type) throws Exception;


}
