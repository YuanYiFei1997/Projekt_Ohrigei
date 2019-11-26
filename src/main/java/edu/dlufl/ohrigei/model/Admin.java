package edu.dlufl.ohrigei.model;
public class Admin {
    private int id;
    private int titleID;
    private String name;
    private int role_reviewer;
    private int role_dais;
    private int role_interviewer;
    private int role_cashier;
    private int role_administrator;
    private int role_bureaucrat;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTitleID() {
        return titleID;
    }

    public void setTitleID(int titleID) {
        this.titleID = titleID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRole_reviewer() {
        return role_reviewer;
    }

    public void setRole_reviewer(int role_reviewer) {
        this.role_reviewer = role_reviewer;
    }

    public int getRole_dais() {
        return role_dais;
    }

    public void setRole_dais(int role_dais) {
        this.role_dais = role_dais;
    }

    public int getRole_interviewer() {
        return role_interviewer;
    }

    public void setRole_interviewer(int role_interviewer) {
        this.role_interviewer = role_interviewer;
    }

    public int getRole_cashier() {
        return role_cashier;
    }

    public void setRole_cashier(int role_cashier) {
        this.role_cashier = role_cashier;
    }

    public int getRole_administrator() {
        return role_administrator;
    }

    public void setRole_administrator(int role_administrator) {
        this.role_administrator = role_administrator;
    }

    public int getRole_bureaucrat() {
        return role_bureaucrat;
    }

    public void setRole_bureaucrat(int role_bureaucrat) {
        this.role_bureaucrat = role_bureaucrat;
    }
}
