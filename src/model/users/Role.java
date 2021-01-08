package model.users;

import java.io.Serializable;

public class Role implements Serializable{

    /**
     * Attribute
     */

    String projectId;
    String memberRole;

    /**
     * Constructor
     */

    public Role(String projectId) {
        this.projectId = projectId;
        this.memberRole = "Developer";
    }

    /**
     * Methods
     */

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getMemberRole() {
        return memberRole;
    }

    public void changeRole() {
        if(this.memberRole.equals("Developer")) {
            this.memberRole = "Manager";
        } else {
            this.memberRole = "Developer";
        }
    }
}
