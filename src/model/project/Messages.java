package model.project;

import java.io.Serializable;
import java.util.UUID;

public class Messages implements Serializable {
    private UUID mSenderId;
    private String mSubject;
    private String mContent;
    private boolean mStatus;

    public Messages(UUID senderId, String subject, String content) {
        mSenderId = senderId;
        mSubject = subject;
        mContent = content;
    }

    public UUID getSenderId() {
        return mSenderId;
    }

    public boolean getStatus() {
        return mStatus;
    }

    public void setStatus(boolean status) {
        mStatus = status;
    }

    public String getContent() {
        return mContent;
    }

    public String getSubject() {
        return mSubject;
    }

    @Override
    public String toString() {
        return "ID:" + getSenderId() + "\nTitle: " + getSubject() + "\n\n" + getContent();
    }

}
