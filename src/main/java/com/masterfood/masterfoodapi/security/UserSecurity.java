package com.masterfood.masterfoodapi.security;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.masterfood.masterfoodapi.domain.enums.PerfilType;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

public class UserSecurity implements UserDetails {
    private static final long serialVersionUID = 1L;

    @Getter
    private String id;
    @Getter
    private String email;
    @JsonIgnore
    private String password;
    private Collection<GrantedAuthority> authorities;
    @Getter
    private String restaurantId;

    public UserSecurity() {
    }

    public UserSecurity(String id, String email, String password, Set<PerfilType> perfis, String restaurantId) {
        super();
        this.id = id;
        this.email = email;
        this.password = password;
        this.restaurantId = restaurantId;
        if (perfis != null) {
            this.authorities = perfis.stream()
                    .map(x -> new SimpleGrantedAuthority(x.getDescricao()))
                    .collect(Collectors.toList());
        } else {
            this.authorities = new ArrayList<>();
            this.authorities.add(new SimpleGrantedAuthority(PerfilType.CUSTOMERS.getDescricao()));
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public boolean allowedToFindRestaurant() {
        for (GrantedAuthority e : authorities) {
            if (e.getAuthority()
                    .equals(PerfilType.ROOT.getDescricao()) ||
                    e.getAuthority()
                            .equals(PerfilType.CUSTOMERS.getDescricao())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isEnabled() {
        return true;
    }

    public boolean hasRole(PerfilType perfil) {
        return getAuthorities().contains(new SimpleGrantedAuthority(perfil.getDescricao()));
    }
}