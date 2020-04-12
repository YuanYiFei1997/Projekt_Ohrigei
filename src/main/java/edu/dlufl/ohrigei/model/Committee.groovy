package edu.dlufl.ohrigei.model

class Committee {
    private int id
    private String committeeName
    private int seatWidth
    private int chairmanID
    private String chairmanName

    String getCommitteeName() {
        return committeeName
    }

    void setCommitteeName(String committeeName) {
        this.committeeName = committeeName
    }

    int getChairmanID() {
        return chairmanID
    }

    void setChairmanID(int chairmanID) {
        this.chairmanID = chairmanID
    }

    String getChairmanName() {
        return chairmanName
    }

    void setChairmanName(String chairmanName) {
        this.chairmanName = chairmanName
    }

    int getId() {
        return id
    }

    void setId(int id) {
        this.id = id
    }


    int getSeatWidth() {
        return seatWidth
    }

    void setSeatWidth(int seatWidth) {
        this.seatWidth = seatWidth
    }

    @Override
    public String toString() {
        return "Committee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", seatWidth=" + seatWidth +
                ", chairmanID=" + chairmanID +
                ", chairmanName='" + chairmanName + '\'' +
                '}';
    }
}
