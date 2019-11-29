package edu.dlufl.ohrigei.model;

import com.alibaba.fastjson.JSONObject;

import javax.validation.constraints.NotBlank;

public class User {
    private int id;
    @NotBlank(message = "姓名不能为空")
    private String name;
    private String last_name;
    @NotBlank(message = "姓名拼音不能为空")
    private String first_name;
    @NotBlank(message = "电子邮箱不能为空")
    private String email;
    @NotBlank(message = "密码不能为空")
    private String password;
    @NotBlank(message = "手机号码不能为空")
    private String phone;
    private int type;
    private int enable_Login;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getType() {
        return type;
    }

    public void setType(byte type) {
        this.type = type;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setEnable_Login(byte enable_Login) {
        this.enable_Login = enable_Login;
    }

    @Override
    public String toString() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", id);
        jsonObject.put("name", name);
        jsonObject.put("email", email);
        jsonObject.put("password", password);
        jsonObject.put("phone", phone);
        jsonObject.put("type", type);
        jsonObject.put("last_name", last_name);
        jsonObject.put("first_name", first_name);
        jsonObject.put("enable_Login", enable_Login);
        return jsonObject.toJSONString();
    }
}
