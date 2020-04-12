package edu.dlufl.ohrigei.model;
class Admin {
    private int id
    private String title
    private String name
    private String committeeName
    private String password
    private String email
    private String phone
    private boolean role_AG
    private boolean role_AD
    private boolean role_D
    private boolean role_L
    private boolean role_F
    private boolean role_SG
    private String avatarPath

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

    String getPassword() {
        return password
    }

    void setPassword(String password) {
        this.password = password
    }

    String getEmail() {
        return email
    }

    void setEmail(String email) {
        this.email = email
    }

    String getPhone() {
        return phone
    }

    void setPhone(String phone) {
        this.phone = phone
    }

    boolean getRole_AG() {
        return role_AG
    }

    void setRole_AG(boolean role_AG) {
        this.role_AG = role_AG
    }

    boolean getRole_AD() {
        return role_AD
    }

    void setRole_AD(boolean role_AD) {
        this.role_AD = role_AD
    }

    boolean getRole_D() {
        return role_D
    }

    void setRole_D(boolean role_D) {
        this.role_D = role_D
    }

    boolean getRole_L() {
        return role_L
    }

    void setRole_L(boolean role_L) {
        this.role_L = role_L
    }

    boolean getRole_F() {
        return role_F
    }

    void setRole_F(boolean role_F) {
        this.role_F = role_F
    }

    boolean getRole_SG() {
        return role_SG
    }

    void setRole_SG(boolean role_SG) {
        this.role_SG = role_SG
    }

    String getAvatarPath() {
        return avatarPath
    }

    void setAvatarPath(String avatarPath) {
        this.avatarPath = avatarPath
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", name='" + name + '\'' +
                ", committeeName='" + committeeName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", role_AG=" + role_AG +
                ", role_AD=" + role_AD +
                ", role_D=" + role_D +
                ", role_L=" + role_L +
                ", role_F=" + role_F +
                ", role_SG=" + role_SG +
                ", avatarPath='" + avatarPath + '\'' +
                '}';
    }
}
