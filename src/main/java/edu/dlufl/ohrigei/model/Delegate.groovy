package edu.dlufl.ohrigei.model

class Delegate {
    private int ID
    private String name
    private String group
    private String applicationType
    private String applicationStatus

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

    String getGroup() {
        return group
    }

    void setGroup(String group) {
        this.group = group
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

    @Override
    String toString() {
        return "Delegate{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", group='" + group + '\'' +
                ", applicationType='" + applicationType + '\'' +
                ", applicationStatus='" + applicationStatus + '\'' +
                '}';
    }
}
