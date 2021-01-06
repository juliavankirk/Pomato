package model.project;

import model.users.User;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;

public class Progression implements Serializable {
    private User mUser;
    private Project mProject;
    private Task mTask;
    private LocalDate mStartDate;
    private LocalDate mEndDate;

    public Progression(User user, Task task, LocalDate startDate) {
        mUser = user;
        mTask = task;
        mTask.beginTask();
        mStartDate = startDate;
        mEndDate = null;
    }

    //sets completion to true and passes value to endDate
    public void submitTask(LocalDate endDate) {
        mTask.completeTask();
        mEndDate = endDate;
    }

    public long totalHours() {
        //end date is assigned current date if null, otherwise passed value is entered
        LocalDate submission = mEndDate == null ? LocalDate.now() : mEndDate;
        //delta calculation between start and end dates
        long daysBetween = Period.between(mStartDate, submission).getDays() + 1;
        return daysBetween;
    }

    public Double totalWages() {
        Double salary = totalHours() * mUser.getHourlyWage();
        return salary;
    }

    public User getUser() { return mUser; }

    public Project getProject() { return mProject; }

    public Task getTask() { return mTask; }

}
