package edu.dlufl.ohrigei.model

class Group {
    private int id
    private int schoolID
    private int headDelegateID
    private int groupSize

    int getId() {
        return id
    }

    void setId(int id) {
        this.id = id
    }

    int getSchoolID() {
        return schoolID
    }

    void setSchoolID(int schoolID) {
        this.schoolID = schoolID
    }

    int getHeadDelegateID() {
        return headDelegateID
    }

    void setHeadDelegateID(int headDelegateID) {
        this.headDelegateID = headDelegateID
    }

    int getGroupSize() {
        return groupSize
    }

    void setGroupSize(int groupSize) {
        this.groupSize = groupSize
    }

    @Override
    String toString() {
        return "Group{" +
                "id=" + id +
                ", schoolID=" + schoolID +
                ", headDelegateID=" + headDelegateID +
                ", groupSize=" + groupSize +
                '}';
    }
}
