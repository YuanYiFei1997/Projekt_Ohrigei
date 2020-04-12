package edu.dlufl.ohrigei.model

class Interview {
    int id
    int adminID
    String delegateName
    String adminName
    String date
    float interviewScore
    int academicScore
    int passionScore
    Boolean interviewStatus
    String comment

    int getId() {
        return id
    }

    void setId(int id) {
        this.id = id
    }

    int getAdminID() {
        return adminID
    }

    void setAdminID(int adminID) {
        this.adminID = adminID
    }

    String getDelegateName() {
        return delegateName
    }

    void setDelegateName(String delegateName) {
        this.delegateName = delegateName
    }

    String getAdminName() {
        return adminName
    }

    void setAdminName(String adminName) {
        this.adminName = adminName
    }

    String getDate() {
        return date
    }

    void setDate(String date) {
        this.date = date
    }

    float getInterviewScore() {
        return interviewScore
    }

    void setInterviewScore(float interviewScore) {
        this.interviewScore = interviewScore
    }

    int getAcademicScore() {
        return academicScore
    }

    void setAcademicScore(int academicScore) {
        this.academicScore = academicScore
    }

    int getPassionScore() {
        return passionScore
    }

    void setPassionScore(int passionScore) {
        this.passionScore = passionScore
    }

    Boolean getInterviewStatus() {
        return interviewStatus
    }

    void setInterviewStatus(Boolean interviewStatus) {
        this.interviewStatus = interviewStatus
    }

    String getComment() {
        return comment
    }

    void setComment(String comment) {
        this.comment = comment
    }

    @Override
    public String toString() {
        return "Interview{" +
                "id=" + id +
                ", adminID=" + adminID +
                ", delegateName='" + delegateName + '\'' +
                ", adminName='" + adminName + '\'' +
                ", date='" + date + '\'' +
                ", interviewScore=" + interviewScore +
                ", academicScore=" + academicScore +
                ", passionScore=" + passionScore +
                ", interviewStatus=" + interviewStatus +
                ", comment='" + comment + '\'' +
                '}';
    }
}
