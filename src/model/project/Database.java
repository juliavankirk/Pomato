package model.project;

import model.users.User;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.UUID;

public class Database implements Serializable {
    public HashMap<String, User> mUserList;
    public HashMap<String, Project> mProjectList;
    public ArrayList <Task> mTaskList;

    public Database() {
        mUserList = new HashMap<String, User>();
        mProjectList = new HashMap<String, Project>();
        mTaskList = new ArrayList<Task>();
    }

    public Collection<User> getUserList() { return mUserList.values(); }
    public void addUser(User user) { mUserList.put(user.getId(), user); }
    public void removeUser(UUID id) { mUserList.remove(id); }
    public User getUserById (UUID id) { return mUserList.get(id); }


    public Collection<Project> getProjectList() { return mProjectList.values(); }
    public void addProject (Project project) { mProjectList.put(project.getId(), project); }
    public void removeProject(UUID id) { mProjectList.remove(id); }
    public Project getProjectById (UUID id) { return mProjectList.get(id); }

    public ArrayList<Task> getTaskList(){ return mTaskList;}
    public void addTask(Task task){ mTaskList.add(task);}
    public void removeTask(int index){ mTaskList.remove(index);}
//    public Task getTaskById (UUID id) { return mTaskList.get(id);}
}
