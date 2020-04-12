package edu.dlufl.ohrigei.model

class Group {
    private int id
    private int schoolID
    private String schoolName
    private int headDelegateID
    private String headDelegateName
    private int groupSize
    private int usedCapacity

    int getSchoolID() {
        return schoolID
    }

    int getHeadDelegateID() {
        return headDelegateID
    }

    void setSchoolID(int schoolID) {
        this.schoolID = schoolID
    }

    void setHeadDelegateID(int headDelegateID) {
        this.headDelegateID = headDelegateID
    }

    void setHeadDelegateName(String headDelegateName) {
        this.headDelegateName = headDelegateName
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

    String getHeadDelegateName() {
        return headDelegateName
    }

    void setHeadDelegateName(int headDelegateName) {
        this.headDelegateName = headDelegateName
    }

    int getGroupSize() {
        return groupSize
    }

    void setGroupSize(int groupSize) {
        this.groupSize = groupSize
    }

    int getUsedCapacity() {
        return usedCapacity
    }

    void setUsedCapacity(int usedCapacity) {
        this.usedCapacity = usedCapacity
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", schoolID=" + schoolID +
                ", schoolName='" + schoolName + '\'' +
                ", headDelegateID=" + headDelegateID +
                ", headDelegateName='" + headDelegateName + '\'' +
                ", groupSize=" + groupSize +
                ", usedCapacity=" + usedCapacity +
                '}';
    }
}
