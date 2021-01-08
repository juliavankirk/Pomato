package model.project;

import java.io.Serializable;
import java.util.ArrayList;

public class Idea implements Serializable{

    /**
     * Attributes
     */

    private String ideaContent;
    private int like;
    private int disLike;
    private ArrayList<String> comment;

    /**
     * Constructor
     */

    public Idea (String ideaContent) {
        this.ideaContent = ideaContent;
        this.like = 0;
        this.disLike = 0;
        this.comment = new ArrayList<String>();
    }

    /**
     * Getters & Setters
     */

    public String getIdeaContent() {
        return ideaContent;
    }

    public void setIdeaContent(String ideaContent) {
        this.ideaContent = ideaContent;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public int getDisLike() {
        return disLike;
    }

    public void setDisLike(int disLike) {
        this.disLike = disLike;
    }

    public ArrayList<String> getComment() {
        return comment;
    }

    public void setComment(ArrayList<String> comment) {
        this.comment = comment;
    }

    /**
     * Methods
     */

    public void addLike() {
        this.like = this.like + 1;
    }

    public void addDisLike() {
        this.disLike = this.disLike + 1;
    }

    public void addComment(String newComment) {
        this.comment.add(newComment);
    }

    public String toString() {
        return this.ideaContent;
    }
// push to development
}
