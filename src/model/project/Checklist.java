package model.project;

import java.util.ArrayList;
import java.util.UUID;

public class Checklist {

    private UUID mId;
    private String mName;
    private ArrayList<Item> mItems; // really unsure about the naming,
    // but couldn't come up with something better

    public Checklist(String name){
        mId = UUID.randomUUID();
        mName = name;
        mItems = new ArrayList<>();
    }

    public ArrayList<Item> getItems(){ return mItems;}
    public String getName(){return mName;}
    public UUID getId(){return mId;}
    public void setName(String name){mName = name;}

    public String toString() {
        String retVal = "";
        retVal += ("Name: " +getName());
        retVal += ("\nID: " + getId() + "\n");
        return retVal;
    }
}

