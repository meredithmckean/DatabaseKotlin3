package com.example.databasekotlin3;

public class User {
    private String Username;
    private String Password;
    private int FTP;
    int pz_1;
    int pz_2;
    int pz_3;
    int pz_4;
    int pz_5;
    int pz_6;
    int pz_7;

    public User(String username, String password, int FTP, int pz_1, int pz_2, int pz_3, int pz_4, int pz_5, int pz_6, int pz_7) {
        Username = username;
        Password = password;
        this.FTP = FTP;
        this.pz_1 = pz_1;
        this.pz_2 = pz_2;
        this.pz_3 = pz_3;
        this.pz_4 = pz_4;
        this.pz_5 = pz_5;
        this.pz_6 = pz_6;
        this.pz_7 = pz_7;
    }

    public User() {
    }

    //toString is necessary for printing the contents of a class object

    @Override
    public String toString() {
        return "User{" +
                "Username='" + Username + '\'' +
                ", Password='" + Password + '\'' +
                ", FTP=" + FTP +
                ", pz_1=" + pz_1 +
                ", pz_2=" + pz_2 +
                ", pz_3=" + pz_3 +
                ", pz_4=" + pz_4 +
                ", pz_5=" + pz_5 +
                ", pz_6=" + pz_6 +
                ", pz_7=" + pz_7 +
                '}';
    }


    //Getters and Setters

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public int getFTP() {
        return FTP;
    }

    public void setFTP(int FTP) {
        this.FTP = FTP;
    }

    public int getPz_1() {
        return pz_1;
    }

    public void setPz_1(int pz_1) {
        this.pz_1 = pz_1;
    }

    public int getPz_2() {
        return pz_2;
    }

    public void setPz_2(int pz_2) {
        this.pz_2 = pz_2;
    }

    public int getPz_3() {
        return pz_3;
    }

    public void setPz_3(int pz_3) {
        this.pz_3 = pz_3;
    }

    public int getPz_4() {
        return pz_4;
    }

    public void setPz_4(int pz_4) {
        this.pz_4 = pz_4;
    }

    public int getPz_5() {
        return pz_5;
    }

    public void setPz_5(int pz_5) {
        this.pz_5 = pz_5;
    }

    public int getPz_6() {
        return pz_6;
    }

    public void setPz_6(int pz_6) {
        this.pz_6 = pz_6;
    }

    public int getPz_7() {
        return pz_7;
    }

    public void setPz_7(int pz_7) {
        this.pz_7 = pz_7;
    }
}
