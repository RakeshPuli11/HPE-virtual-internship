package com.HPE.HPEFinal.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Employee {
    private String employee_id;
    private String first_name;
    private String last_name;
    private String mail;
    private String title;
//
//    public Employee(String employee_id, String first_name, String last_name, String mail, String title) {
//        this.employee_id = employee_id;
//        this.mail = mail;
//        this.first_name = first_name;
//        this.last_name = last_name;
//        this.title = title;
//    }
//
//    public String getLast_name() {
//        return last_name;
//    }
//
//    public void setLast_name(String last_name) {
//        this.last_name = last_name;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getEmployee_id() {
//        return employee_id;
//    }
//
//    public void setEmployee_id(String employee_id) {
//        this.employee_id = employee_id;
//    }
//
//    public String getFirst_name() {
//        return first_name;
//    }
//
//    public void setFirst_name(String first_name) {
//        this.first_name = first_name;
//    }
//
//    public String getEmail() {
//        return mail;
//    }
//
//    public void setEmail(String email) {
//        this.mail = mail;
//    }


    @Override
    public String toString() {
        return "Employee{" +
                ", employee_id='" + employee_id + '\'' +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", mail='" + mail + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}

