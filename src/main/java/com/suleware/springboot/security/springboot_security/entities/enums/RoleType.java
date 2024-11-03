package com.suleware.springboot.security.springboot_security.entities.enums;

public enum RoleType {
    ROLE_USER {
        @Override
        public String toString() {
            return "ROLE_USER";
        }
    },
    ROLE_ADMIN {
        @Override
        public String toString() {
            return "ROLE_ADMIN";
        }
    }
}
