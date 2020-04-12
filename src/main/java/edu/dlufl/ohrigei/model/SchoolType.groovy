package edu.dlufl.ohrigei.model

class SchoolType {
    int id
    String schoolType

    int getId() {
        return id
    }

    void setId(int id) {
        this.id = id
    }

    String getSchoolType() {
        return schoolType
    }

    void setSchoolType(String schoolType) {
        this.schoolType = schoolType
    }

    @Override
    String toString() {
        return "SchoolType{" +
                "id=" + id +
                ", schoolType='" + schoolType + '\'' +
                '}';
    }
}
