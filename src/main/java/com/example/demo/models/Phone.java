package com.example.demo.models;

import javax.persistence.*;


@Entity(name = "Phone")
@Table(name = "phone")
public class Phone {

    @Id
    @Column(name = "`number`")
    private String number;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(
                    name = "company_id",
                    referencedColumnName = "company_id"),
            @JoinColumn(
                    name = "employee_number",
                    referencedColumnName = "employee_number")
    })
    private Employee employee;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}