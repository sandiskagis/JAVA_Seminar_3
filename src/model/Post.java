package model;

import java.time.LocalDateTime;

public class Post {
    //1.variables
    private String title;
    private String msg;
    private LocalDateTime dateTime = LocalDateTime.now();
    //TODO pārtaisīt uz user sarakstu
    private int countOfLikes = 0;


    //2.get and set
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if(title != null && title.length() > 5 && title.length() < 50)
            this.title = title;
        else this.title = "------";
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        if(msg != null && msg.length() > 5 && msg.length() < 1000)
            this.msg = msg;
        else
            this.msg = "------";
    }

    public int getCountOfLikes() {
        return countOfLikes;
    }

    //TODO iespējams mainīsies, ja izmantosim sarakstu ar lietotājiem, kuri spiež like
    public void incrementCountOfLikes() {
        this.countOfLikes++;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }


    //3.constructors

    public Post()
    {
        setTitle("Test post");
        setMsg("Test message");
    }
    public Post(String title, String msg)
    {
        setTitle(title);
        setMsg(msg);
    }


    //4.toString

    public String toString()
    {
        return title + "(" + dateTime + ") \n" + msg + "\n[ " + countOfLikes + "]\n";
    }

    //5.other functions
}
