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
        StringBuilder retVal = new StringBuilder();
        retVal.append("\n").append(getName());
        retVal.append("\nID: ").append(getId()).append("\n");
        for (int i = 0; i < mItems.size(); i++) {
            Item currentItem = mItems.get(i);

            if (currentItem.getStatus().equals("Not Done")) {
                retVal.append( "[ ] " + currentItem.getTopic() + "\n");
            } else {
                retVal.append( "[V] " + currentItem.getTopic() + "\n");
            }
        }
        return retVal.toString();
    }

    public void setItems(ArrayList<Item> items) {
        mItems = items;
    }
}

