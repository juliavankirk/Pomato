package model.project;

import model.users.User;

import java.io.Serializable;
import java.time.LocalDate;


public class Holiday implements Serializable {

    private String mUser;
    private LocalDate mStartDate;
    private LocalDate mEndDate;
    private String mHolidayDescription;


    public Holiday(String userName, String holidayDescription, LocalDate startDate, LocalDate endDate) {

        mUser = userName;
        mHolidayDescription = holidayDescription;
        mStartDate = startDate;
        mEndDate = endDate;

    }

    public String getUserName() {return mUser;}

    public void setUserName(String mUser) {this.mUser = mUser;}

    public LocalDate getHolidayStartDate() {return mStartDate;}

    public void setHolidayStartDate(LocalDate mStartDate) {this.mStartDate = mStartDate;}

    public LocalDate getHolidayEndDate() {return mEndDate;}

    public void setHolidayEndDate(LocalDate mEndDate) {this.mEndDate = mEndDate;}

    public String getHolidayDescription() {return mHolidayDescription;}

    public void setHolidayDescription(String mHolidayDescription) {this.mHolidayDescription = mHolidayDescription;}


    public String toString() {
        String retVal = "";
        retVal += ("Username: " + getUserName());
        retVal += ("\nHoliday Description: " + getHolidayDescription());
        retVal += ("\nStart Date: " + getHolidayStartDate());
        retVal += ("\nEnd Date: " + getHolidayEndDate());

        return retVal;

    }


}
