package com.cqupt.weigs.shirodemo.entity;

public class Permission {
    private Long id;

    private String permission;

    private String description;

    private Boolean available;

    public Permission(Long id, String permission, String description, Boolean available) {
        this.id = id;
        this.permission = permission;
        this.description = description;
        this.available = available;
    }

    public Permission() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission == null ? null : permission.trim();
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