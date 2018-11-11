package com.cqupt.weigs.shirodemo.entity;

public class Role {
    private Long id;

    private String role;

    private String description;

    private Boolean available;

    public Role(Long id, String role, String description, Boolean available) {
        this.id = id;
        this.role = role;
        this.description = description;
        this.available = available;
    }

    public Role() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role == null ? null : role.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }
}