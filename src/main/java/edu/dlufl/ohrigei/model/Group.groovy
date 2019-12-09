package edu.dlufl.ohrigei.model

class Group {
    private int id
    private String schoolName
    private String headDelegateName
    private int groupSize

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

    @Override
    String toString() {
        return "Group{" +
                "id=" + id +
                ", schoolName='" + schoolName + '\'' +
                ", headDelegateName=" + headDelegateName +
                ", groupSize=" + groupSize +
                '}';
    }
}
