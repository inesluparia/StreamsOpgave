public class Student {

    private String userName;
    private String firstName;
    private String lastName;
    private String classOrigin;

    public Student(String userName, String firstName, String lastName, String classOrigin) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.classOrigin = classOrigin;
    }

    @Override
    public String toString() {
        return "\n" + lastName
                ;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getClassOrigin() {
        return classOrigin;
    }

    public void setClassOrigin(String classOrigin) {
        this.classOrigin = classOrigin;
    }
}
