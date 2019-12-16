package edu.dlufl.ohrigei.model

class Delegate {
    private int ID
    private String name
    private String schoolName
    private String applicationType
    private String applicationStatus
    private String phone
    private String email
    private boolean enable_Login

    String getPhone() {
        return phone
    }

    void setPhone(String phone) {
        this.phone = phone
    }

    String getEmail() {
        return email
    }

    void setEmail(String email) {
        this.email = email
    }

    int getID() {
        return ID
    }

    void setID(int ID) {
        this.ID = ID
    }

    String getName() {
        return name
    }

    void setName(String name) {
        this.name = name
    }

    String getSchoolName() {
        return schoolName
    }

    void setSchoolName(String schoolName) {
        this.schoolName = schoolName
    }

    String getApplicationType() {
        return applicationType
    }

    void setApplicationType(String applicationType) {
        this.applicationType = applicationType
    }

    String getApplicationStatus() {
        return applicationStatus
    }

    void setApplicationStatus(String applicationStatus) {
        this.applicationStatus = applicationStatus
    }

    boolean getEnable_Login() {
        return enable_Login
    }

    void setEnable_Login(boolean enable_Login) {
        this.enable_Login = enable_Login
    }

    @Override
    public String toString() {
        return "Delegate{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", schoolName='" + schoolName + '\'' +
                ", applicationType='" + applicationType + '\'' +
                ", applicationStatus='" + applicationStatus + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", enable_Login=" + enable_Login +
                '}';
    }
}
