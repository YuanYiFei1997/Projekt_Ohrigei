package edu.dlufl.ohrigei.model

class ApplicationStatus {
    private int id
    private String applicationStatusText
    private String applicationStatusTextEN

    int getId() {
        return id
    }

    void setId(int id) {
        this.id = id
    }

    String getApplicationStatusText() {
        return applicationStatusText
    }

    void setApplicationStatusText(String applicationStatusText) {
        this.applicationStatusText = applicationStatusText
    }

    String getApplicationStatusTextEN() {
        return applicationStatusTextEN
    }

    void setApplicationStatusTextEN(String applicationStatusTextEN) {
        this.applicationStatusTextEN = applicationStatusTextEN
    }

    @Override
    public String toString() {
        return "ApplicationStatus{" +
                "id=" + id +
                ", applicationStatusText='" + applicationStatusText + '\'' +
                ", applicationStatusTextEN='" + applicationStatusTextEN + '\'' +
                '}';
    }
}
