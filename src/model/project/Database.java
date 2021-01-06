package model.project;

import controllers.Controller;
import model.users.User;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

public class Database implements Serializable {
    public HashMap<UUID, User> mUserList;
    public HashMap<String, Project> mProjectList;
    public ArrayList <Task> mTaskList;
    public ArrayList<Progression> mProgression;
    public ArrayList <String> mActivityList;


    public Database() {
        mUserList = new HashMap<UUID, User>();
        mProjectList = new HashMap<String, Project>();
        mTaskList = new ArrayList<Task>();
        mProgression = new ArrayList<Progression>();
        mActivityList = new ArrayList<String>();
    }

    public Collection<User> getUserList() { return mUserList.values(); }
    public void addUser(User user) { mUserList.put(user.getId(), user); }
    public void removeUser(UUID id) { mUserList.remove(id); }
    public User getUserById (UUID id) { return mUserList.get(id); }


    public Collection<Project> getProjectList() { return mProjectList.values(); }
    public void addProject (Project project) { mProjectList.put(project.getId().toString(), project); }
    public void removeProject(UUID id) { mProjectList.remove(id); }
    public Project getProjectById (UUID id) { return mProjectList.get(id); }

    public ArrayList<Task> getTaskList(){ return mTaskList;}
    public void addTask(Task task){ mTaskList.add(task);}
    public void removeTask(int index){ mTaskList.remove(index);}
//    public Task getTaskById (UUID id) { return mTaskList.get(id);}

    public void startTask(User user, Task task, LocalDate startDate) {
        Progression progression = new Progression(user, task, startDate);

        mProgression.add(progression);
    }

    public long submitTask(Progression progression, LocalDate endDate) {
        progression.submitTask(endDate);

        return progression.totalHours();
    }

    public Collection<Progression> getProgressionList() { return mProgression; }

    public Collection<Progression> getProgressForUser(User user) {
        ArrayList<Progression> userProgress = new ArrayList<>();
        for (Progression progress : mProgression) {
            if (user.equals(progress.getUser())) {
                userProgress.add(progress);
            }
        }
        return userProgress;
    }

}
