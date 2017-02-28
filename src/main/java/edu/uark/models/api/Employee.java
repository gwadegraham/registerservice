package edu.uark.models.api;

import java.util.UUID;

public class Employee {

    private UUID id;
    public UUID getId() { return this.id; }
    public Employee setId(UUID id) {

        this.id = id;
        return this;
    }

    private String firstName;
    public String getFirstName() { return this.firstName; }
    public Employee setFirstName(String fn) {

        this.firstName = fn;
        return this;
    }

    private String lastName;
    public String getLastName() { return this.lastName; }
    public Employee setLastName(String ln) {

        this.lastName = ln;
        return this;
    }

    private String employeeId;
    public String getEmployeeId() { return this.employeeId; }
    public Employee setEmployeeId(String id) {

        this.employeeId = id;
        return this;
    }

    private Boolean active;
    public Boolean getActive() { return this.active; }
    public Employee setActive(Boolean active) {

        this.active = active;
        return this;
    }

    private String role;
    public String getRole() { return this.role; }
    public Employee setRole(String role) {

        this.role = role;
        return this;
    }

    private UUID managerId;
    public UUID getManagerId() { return this.managerId; }
    public Employee setManagerId(UUID managerId) {

        this.managerId = managerId;
        return this;
    }

    private String password;
    public String getPassword() { return this.password; }
    public Employee setPassword(String password) {

        this.password = password;
        return this;
    }

    public Employee() {

        this.id = new UUID(0, 0);
        this.managerId = new UUID(0, 0);
        this.firstName = "";
        this.lastName = "";
        this.employeeId = "";
        this.role = "";
        this.password = "";
        this.active = false;
    }

}
