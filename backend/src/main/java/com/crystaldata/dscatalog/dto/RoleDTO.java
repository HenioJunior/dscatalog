package com.crystaldata.dscatalog.dto;

import com.crystaldata.dscatalog.entities.Role;

import java.io.Serializable;

public class RoleDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String authority;

    public RoleDTO() {}

    public RoleDTO(Long id, String authority) {
        this.id = id;
        this.authority = authority;
    }

    public RoleDTO(Role role) {
        id = role.getId();
        authority = role.getAuthority();
    }

    public Long getId() {
        return id;
    }

    public String getAuthority() {
        return authority;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
