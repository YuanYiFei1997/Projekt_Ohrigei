package edu.dlufl.ohrigei.model

class Group {
    private int id
    private String name
    private int delegateID

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

    int getDelegateID() {
        return delegateID
    }

    void setDelegateID(int delegateID) {
        this.delegateID = delegateID
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", delegateID=" + delegateID +
                '}';
    }
}
