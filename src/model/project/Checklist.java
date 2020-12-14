package model.project;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.UUID;

public class Checklist implements Serializable {

    private UUID mId;
    private String mName;
    private ArrayList<ChecklistItem> mChecklistItems; // really unsure about the naming,
    // but couldn't come up with something better
    // I'm really unsure about ChecklistItems as a name too hehe. Ohh well.

    public Checklist(String name){
        mId = UUID.randomUUID();
        mName = name;
        mChecklistItems = new ArrayList<>();
    }

    public ArrayList<ChecklistItem> getChecklistItems(){ return mChecklistItems;}
    public void addChecklistItem(ChecklistItem checklistItem){ mChecklistItems.add(checklistItem);}
    public String getName(){return mName;}
    public UUID getId(){return mId;}
    public void setName(String name){mName = name;}

    public String toString() {
        StringBuilder retVal = new StringBuilder();
        retVal.append("\n").append(getName());
        retVal.append(", ID: ").append(getId()).append("\n");
        for (int i = 0; i < mChecklistItems.size(); i++) {
            ChecklistItem currentChecklistItem = mChecklistItems.get(i);

            if (currentChecklistItem.getStatus().equals("Not Done")) {
                retVal.append( currentChecklistItem.getId() + ". [ ] " + currentChecklistItem.getTopic() + "\n");
            } else {
                retVal.append( currentChecklistItem.getId() + ". [V] " + currentChecklistItem.getTopic() + "\n");
            }
        }
        return retVal.toString();
    }

    public void setItems(ArrayList<ChecklistItem> checklistItems) {
        mChecklistItems = checklistItems;
    }
}

