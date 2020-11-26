package model;

import model.project.Project;
import model.users.User;

import java.util.Collection;
import java.util.HashMap;
import java.util.UUID;

public class Database {
    public HashMap<UUID, User> mUserList;
    public HashMap<UUID, Project> mProjectList;

    public Database() {
        mUserList = new HashMap<UUID, User>();
        mProjectList = new HashMap<UUID, Project>();
    }

    public Collection<User> getUserList() { return mUserList.values(); }
    public void addUser(User user) { mUserList.put(user.getId(), user); }
    public void removerUser(UUID id) { mUserList.remove(id); }
    public User getUserById (UUID id) { return mUserList.get(id); }

    public Collection<Project> getProjectList() { return mProjectList.values(); }
    public void addProject (Project project) { mProjectList.put(project.getId(), project); }
    public void removeProject(UUID id) { mProjectList.remove(id); }
    public Project getProjectById (UUID id) { return mProjectList.get(id); }
}
