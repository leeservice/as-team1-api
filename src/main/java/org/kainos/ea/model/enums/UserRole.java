package org.kainos.ea.model.enums;

public enum UserRole {
    ADMIN("admin"),
    EMPLOYEE("employee");

    private String roleString;

    UserRole(String roleString) {
        this.roleString = roleString;
    }

    @Override
    public String toString() {
        return this.roleString;
    }

    public int getRoleId() {
        if (this == UserRole.ADMIN) {
            return 1;
        } else if (this == UserRole.EMPLOYEE) {
            return 2;
        } else {
            return -1;
        }
    }
}
