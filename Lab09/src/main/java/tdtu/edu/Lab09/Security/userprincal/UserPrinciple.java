package com.tdtu.Cinema.Security.userprincal;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tdtu.Cinema.Entity.UserEnity;
import com.tdtu.Cinema.dto.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
public class UserPrinciple implements UserDetails {

    private Long id;
    private String user;
    private String email;
    private String avatar;
    @JsonIgnore
    private  String pass;

    private Collection<? extends GrantedAuthority> roles;

 public static UserPrinciple build(UserEnity user){
     List<GrantedAuthority> authorities = user.getLikeRoles().stream().map(role ->
             new SimpleGrantedAuthority(role.getRoleName())).collect(Collectors.toList());

     return new UserPrinciple(
             user.getId(),
             user.getUser(),
             user.getEmail(),
             user.getAvatar(),
             user.getPass(),
             authorities
     );
 }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public String getPassword() {
        return pass;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
