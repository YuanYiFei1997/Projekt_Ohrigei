package edu.dlufl.ohrigei.model

class Delegate {
    private int ID
    private String name
    private int schoolID
    private String committeeName
    private int committeeID
    private String schoolName
    private int applicationStatusID
    private String applicationType
    private String applicationStatus
    private String phone
    private String email
    private Integer groupID
    private boolean enable_Login
    private String avatarPath

    String getAvatarPath() {
        return avatarPath
    }

    void setAvatarPath(String avatarPath) {
        this.avatarPath = avatarPath
    }

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

    int getSchoolID() {
        return schoolID
    }

    void setSchoolID(int schoolID) {
        this.schoolID = schoolID
    }

    String getCommitteeName() {
        return committeeName
    }

    void setCommitteeName(String committeeName) {
        this.committeeName = committeeName
    }

    int getCommitteeID() {
        return committeeID
    }

    void setCommitteeID(int committeeID) {
        this.committeeID = committeeID
    }


    Integer getGroupID() {
        return groupID
    }

    void setGroupID(Integer groupID) {
        this.groupID = groupID
    }

    int getApplicationStatusID() {
        return applicationStatusID
    }

    void setApplicationStatusID(int applicationStatusID) {
        this.applicationStatusID = applicationStatusID
    }

    @Override
    public String toString() {
        return "Delegate{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", schoolID=" + schoolID +
                ", committeeName='" + committeeName + '\'' +
                ", committeeID=" + committeeID +
                ", schoolName='" + schoolName + '\'' +
                ", applicationStatusID=" + applicationStatusID +
                ", applicationType='" + applicationType + '\'' +
                ", applicationStatus='" + applicationStatus + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", groupID=" + groupID +
                ", enable_Login=" + enable_Login +
                ", avatarPath='" + avatarPath + '\'' +
                '}';
    }
}
