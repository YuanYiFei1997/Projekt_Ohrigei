package edu.dlufl.ohrigei.model

class Committee {
    private int id
    private String name
    private int seatWidth
    private String chairManName

    int getId() {
        return id
    }

    void setId(int id) {
        this.id = id
    }

    String getName() {
        return name
    }

    void setName(String name) {
        this.name = name
    }

    int getSeatWidth() {
        return seatWidth
    }

    void setSeatWidth(int seatWidth) {
        this.seatWidth = seatWidth
    }

    String getChairManName() {
        return chairManName
    }

    void setChairManName(String chairManName) {
        this.chairManName = chairManName
    }

    @Override
    String toString() {
        return "Committee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", seatWidth=" + seatWidth +
                ", chairManName='" + chairManName + '\'' +
                '}';
    }
}
