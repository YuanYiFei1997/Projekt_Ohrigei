package edu.dlufl.ohrigei.model


import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.AuthorityUtils
import org.springframework.security.core.userdetails.UserDetails

class User implements UserDetails{
    private int id
    private String name
    private String last_name
    private String first_name
    private String email
    private String password
    private String phone
    private String role
    private boolean enable_Login
    private String avatarPath

    private List<GrantedAuthority>authorities
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

    String getLast_name() {
        return last_name
    }

    void setLast_name(String last_name) {
        this.last_name = last_name
    }

    String getFirst_name() {
        return first_name
    }

    void setFirst_name(String first_name) {
        this.first_name = first_name
    }

    String getEmail() {
        return email
    }

    void setEmail(String email) {
        this.email = email
    }

    void setEnable_Login(boolean enable_Login) {
        this.enable_Login = enable_Login
    }

    String getAvatarPath() {
        return avatarPath
    }

    void setAvatarPath(String avatarPath) {
        this.avatarPath = avatarPath
    }

    @Override
    Collection<? extends GrantedAuthority> getAuthorities() {
        return AuthorityUtils.commaSeparatedStringToAuthorityList(role)
    }
    void setAuthorities(List<GrantedAuthority> authorities){
        this.authorities=authorities
    }
    String getPassword() {
        return password
    }

    @Override
    String getUsername() {
        return email
    }

    @Override
    boolean isAccountNonExpired() {
        return true
    }

    @Override
    boolean isAccountNonLocked() {
        return true
    }

    @Override
    boolean isCredentialsNonExpired() {
        return true
    }

    @Override
    boolean isEnabled() {
        return enable_Login
    }

    void setPassword(String password) {
        this.password = password
    }

    String getPhone() {
        return phone
    }

    void setPhone(String phone) {
        this.phone = phone
    }

    String getRole() {
        return role
    }

    void setRole(String role) {
        this.role = role
    }

    boolean getEnable_Login() {
        return enable_Login
    }

    void setEnable_Login(int enable_Login) {
        this.enable_Login = enable_Login
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", first_name='" + first_name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", role='" + role + '\'' +
                ", enable_Login=" + enable_Login +
                ", avatarPath='" + avatarPath + '\'' +
                ", authorities=" + authorities +
                '}';
    }
}
