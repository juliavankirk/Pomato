/*package Model.Users;

public class Employee extends User {

    //Attributes
    private String mCompanyName;
    private String mJobTitle;
    private Double mHourlyWage;

    //Constructor
    public Employee( String companyName, String jobTitle, Double hourlyWage, String firstName, String lastName,
                     String userName, String password) {
        super(firstName, lastName, userName, password);

        mCompanyName = companyName;
        mJobTitle = jobTitle;
        mHourlyWage = hourlyWage;
    }

    //Methods
    public String getCompanyName() { return mCompanyName; }

    public String getJobTitle() { return mJobTitle; }

    public Double getHourlyWage() { return mHourlyWage; }

    @Override
    public String toRow() {
        String retVal = ("User ID: " + getId());
        retVal += ("Employee: " + getName());
        retVal += ("Company: " + getCompanyName());
        retVal += ("Position: " + getJobTitle());
        retVal += ("Hourly Wage: " + getHourlyWage());

        return retVal;
    };
}

*/