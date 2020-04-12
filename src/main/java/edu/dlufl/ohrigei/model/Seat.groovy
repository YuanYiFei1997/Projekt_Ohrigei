package edu.dlufl.ohrigei.model

class Seat {
    int id
    String seatName
    int committeeID
    String committeeName
    int seatDifficulty
    int delegateID
    String delegateName
    String delegatePhone
    String delegateEmail
    boolean seatSelectStatus
    String seatSelectDate
    boolean seatConfirmStatus

    int getId() {
        return id
    }

    void setId(int id) {
        this.id = id
    }

    String getSeatName() {
        return seatName
    }

    void setSeatName(String seatName) {
        this.seatName = seatName
    }

    int getCommitteeID() {
        return committeeID
    }

    void setCommitteeID(int committeeID) {
        this.committeeID = committeeID
    }

    String getCommitteeName() {
        return committeeName
    }

    void setCommitteeName(String committeeName) {
        this.committeeName = committeeName
    }

    int getSeatDifficulty() {
        return seatDifficulty
    }

    void setSeatDifficulty(int seatDifficulty) {
        this.seatDifficulty = seatDifficulty
    }

    int getDelegateID() {
        return delegateID
    }

    void setDelegateID(int delegateID) {
        this.delegateID = delegateID
    }

    String getDelegateName() {
        return delegateName
    }

    void setDelegateName(String delegateName) {
        this.delegateName = delegateName
    }

    boolean getSeatSelectStatus() {
        return seatSelectStatus
    }

    void setSeatSelectStatus(boolean seatSelectStatus) {
        this.seatSelectStatus = seatSelectStatus
    }

    String getSelectSeatDate() {
        return selectSeatDate
    }

    void setSelectSeatDate(String selectSeatDate) {
        this.selectSeatDate = selectSeatDate
    }

    boolean getSeatConfirmStatus() {
        return seatConfirmStatus
    }

    void setSeatConfirmStatus(boolean seatConfirmStatus) {
        this.seatConfirmStatus = seatConfirmStatus
    }

    String getDelegatePhone() {
        return delegatePhone
    }

    void setDelegatePhone(String delegatePhone) {
        this.delegatePhone = delegatePhone
    }

    String getDelegateEmail() {
        return delegateEmail
    }

    void setDelegateEmail(String delegateEmail) {
        this.delegateEmail = delegateEmail
    }

    String getSeatSelectDate() {
        return seatSelectDate
    }

    void setSeatSelectDate(String seatSelectDate) {
        this.seatSelectDate = seatSelectDate
    }


    @Override
    public String toString() {
        return "Seat{" +
                "id=" + id +
                ", seatName='" + seatName + '\'' +
                ", committeeID=" + committeeID +
                ", committeeName='" + committeeName + '\'' +
                ", seatDifficulty=" + seatDifficulty +
                ", delegateID=" + delegateID +
                ", delegateName='" + delegateName + '\'' +
                ", delegatePhone='" + delegatePhone + '\'' +
                ", delegateEmail='" + delegateEmail + '\'' +
                ", seatSelectStatus=" + seatSelectStatus +
                ", seatSelectDate='" + seatSelectDate + '\'' +
                ", seatConfirmStatus=" + seatConfirmStatus +
                '}';
    }
}
