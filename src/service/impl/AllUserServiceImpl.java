package service.impl;

import java.util.ArrayList;

import model.Page;
import model.Post;
import model.user.BusinessUser;
import model.user.GuestUser;
import model.user.PrivateUser;
import model.user.RegisteredUser;
import service.IGuestUserService;
import service.MainService;

public class AllUserServiceImpl implements IGuestUserService{

    @Override
    public ArrayList<RegisteredUser> findUsers(String keyText) {
        //TODO pārbaudīt keyText uz null

        ArrayList<RegisteredUser> foundUsers = new ArrayList<RegisteredUser>();

        for(GuestUser tempU: MainService.allUsers) {
            if(tempU instanceof PrivateUser || tempU instanceof BusinessUser)
            {
                RegisteredUser user = (RegisteredUser) tempU;
                if(user.getNameAndSurnameOrTitle().toLowerCase().contains(keyText.toLowerCase()))
                {
                    foundUsers.add(user);
                }

            }
        }


        return foundUsers;
    }

    @Override
    public ArrayList<Page> findPages(String keyText) {
        ArrayList<Page> foundPages = new ArrayList<Page>();

        for(GuestUser tempU: MainService.allUsers) {
            if(tempU instanceof BusinessUser)
            {
                BusinessUser user = (BusinessUser) tempU;
                for(Page tempP: user.getAllUserPages() )
                {
                    if(tempP.getTitle().toLowerCase().contains(keyText.toLowerCase()))
                    {
                        foundPages.add(tempP);
                    }
                }

            }
        }


        return foundPages;
    }

    @Override
    public ArrayList<Post> findPublicPosts(String keyText) {
        // TODO Auto-generated method stub
        return null;
    }

}