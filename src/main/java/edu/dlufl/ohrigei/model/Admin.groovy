package edu.dlufl.ohrigei.model;
class Admin {
    private int id
    private String title
    private String name
    private String committeeName
    private int role_AG
    private int role_AD
    private int role_D
    private int role_L
    private int role_F
    private int role_SG

    int getId() {
        return id
    }

    void setId(int id) {
        this.id = id
    }

    String getTitle() {
        return title
    }

    void setTitle(String title) {
        this.title = title
    }

    String getName() {
        return name
    }

    void setName(String name) {
        this.name = name
    }

    String getCommitteeName() {
        return committeeName
    }

    void setCommitteeName(String committeeName) {
        this.committeeName = committeeName
    }

    int getRole_AG() {
        return role_AG
    }

    void setRole_AG(int role_AG) {
        this.role_AG = role_AG
    }

    int getRole_AD() {
        return role_AD
    }

    void setRole_AD(int role_AD) {
        this.role_AD = role_AD
    }

    int getRole_D() {
        return role_D
    }

    void setRole_D(int role_D) {
        this.role_D = role_D
    }

    int getRole_L() {
        return role_L
    }

    void setRole_L(int role_L) {
        this.role_L = role_L
    }

    int getRole_F() {
        return role_F
    }

    void setRole_F(int role_F) {
        this.role_F = role_F
    }

    int getRole_SG() {
        return role_SG
    }

    void setRole_SG(int role_SG) {
        this.role_SG = role_SG
    }

    @Override
    String toString() {
        return "Admin{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", name='" + name + '\'' +
                ", committeeName='" + committeeName + '\'' +
                ", role_AG=" + role_AG +
                ", role_AD=" + role_AD +
                ", role_D=" + role_D +
                ", role_L=" + role_L +
                ", role_F=" + role_F +
                ", role_SG=" + role_SG +
                '}';
    }
}
