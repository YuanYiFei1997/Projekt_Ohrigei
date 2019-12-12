package edu.dlufl.ohrigei.service.userService.Impl

import edu.dlufl.ohrigei.dao.UserDao
import edu.dlufl.ohrigei.model.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.AuthorityUtils
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException

class MyUserDetailsServiceImpl implements UserDetailsService{
    @Autowired
    private UserDao userDao
    @Override
    UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userDao.login(email)
        if (user==null){
            throw  new UsernameNotFoundException("用户不存在")
        }
        user.setAuthorities(AuthorityUtils.commaSeparatedStringToAuthorityList(user.getRole()))
        return user
    }
    private static List<GrantedAuthority> grantedAuthorities(String role){
        List<GrantedAuthority> authorities=new ArrayList<>()
        String[] roleArray = role.split(",")
        if (role!=null&& "" != role){
            for (String roles:roleArray){
                authorities.add(new SimpleGrantedAuthority(roles))
            }
        }
        return authorities

    }
}
