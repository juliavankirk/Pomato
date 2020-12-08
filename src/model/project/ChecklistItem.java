package model.project;

import java.io.Serializable;
import java.util.UUID;

public class ChecklistItem implements Serializable {
    private UUID mId;
    private String mTopic;
    private String mStatus;

    public ChecklistItem(String topic){
        mId = UUID.randomUUID();
        mTopic = topic;
        mStatus = "Not Done";
    }
    public UUID getId() { return mId; }
    public String getStatus(){ return mStatus; }
    public String getTopic(){ return mTopic; }
    public void setStatus (String status){ mStatus = status;}
    public void setTopic (String topic){ mTopic = topic; }
}
