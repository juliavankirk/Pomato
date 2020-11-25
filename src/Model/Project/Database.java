package Model.Project;

import Model.Users.User;

import java.util.Collection;
import java.util.HashMap;
import java.util.UUID;

public class Database {
    public HashMap<UUID, User> mUsers;
    public HashMap<UUID, Project> mProject;

    public Database() {
        mUsers = new HashMap<UUID, User>();
        mProject = new HashMap<UUID, Project>();
    }

    public Collection<User> getUserList() { return mUsers.values(); }
    public void addUser(User user) { mUsers.put(user.getId(), user); }
    public void removerUser(UUID id) { mUsers.remove(id); }
    public User getUserById (UUID id) { return mUsers.get(id); }

    public Collection<Project> getProjectList() { return mProject.values(); }
    public void addProject (Project project) { mProject.put(project.getId(), project); }
    public void removeProject(UUID id) { mProject.remove(id); }
    public Project getProjectById (UUID id) { return mProject.get(id); }
}
