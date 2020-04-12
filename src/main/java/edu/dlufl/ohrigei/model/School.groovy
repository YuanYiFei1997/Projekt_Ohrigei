package edu.dlufl.ohrigei.model

class School {
    int id
    String schoolName
    String schoolNameEN
    String schoolType
    String schoolAddress
    int size
    int clubID

    String getSchoolType() {
        return schoolType
    }

    void setSchoolType(String schoolType) {
        this.schoolType = schoolType
    }

    int getId() {
        return id
    }

    void setId(int id) {
        this.id = id
    }

    String getSchoolName() {
        return schoolName
    }

    void setSchoolName(String schoolName) {
        this.schoolName = schoolName
    }

    String getSchoolNameEN() {
        return schoolNameEN
    }

    void setSchoolNameEN(String schoolNameEN) {
        this.schoolNameEN = schoolNameEN
    }


    String getSchoolAddress() {
        return schoolAddress
    }

    void setSchoolAddress(String schoolAddress) {
        this.schoolAddress = schoolAddress
    }

    int getSize() {
        return size
    }

    void setSize(int size) {
        this.size = size
    }

    int getClubID() {
        return clubID
    }

    void setClubID(int clubID) {
        this.clubID = clubID
    }

    @Override
    public String toString() {
        return "School{" +
                "id=" + id +
                ", schoolName='" + schoolName + '\'' +
                ", schoolNameEN='" + schoolNameEN + '\'' +
                ", schoolTypeID=" + schoolType +
                ", schoolAddress='" + schoolAddress + '\'' +
                ", size=" + size +
                ", clubID=" + clubID +
                '}';
    }
}
