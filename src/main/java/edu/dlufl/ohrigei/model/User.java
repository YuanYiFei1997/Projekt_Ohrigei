package edu.dlufl.ohrigei.model;

import com.alibaba.fastjson.JSONObject;

public class User {
    private short id;
    private String name;
    private String email;
    private String password;
    private String phone;
    private byte type;
    private byte enable_Login;

    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public byte getType() {
        return type;
    }

    public void setType(byte type) {
        this.type = type;
    }

    public byte getEnable_Login() {
        return enable_Login;
    }

    public void setEnableToLogin(byte enable_Login) {
        this.enable_Login = enable_Login;
    }

    @Override
    public String toString() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id",id);
        jsonObject.put("name",name);
        jsonObject.put("email",email);
        jsonObject.put("password",password);
        jsonObject.put("phone",phone);
        jsonObject.put("type",type);
        jsonObject.put("enableToLogin",enable_Login);
        return jsonObject.toJSONString();
    }
}
