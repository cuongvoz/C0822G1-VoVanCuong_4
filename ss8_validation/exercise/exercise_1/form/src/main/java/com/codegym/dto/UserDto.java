package com.codegym.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserDto implements Validator {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Vui lòng điền Họ")
    @Size(min = 5, max = 45 ,message = "Tên phải lớn hơn 5 kí tự và nhỏ hơn 45 Kí tự")
    @Pattern(regexp = "^[a-z A-Z]+$", message = "Tên không đúng định dạng")

    @Size(min = 5, max = 45)
    private String firstName;
    @NotBlank(message = "Vui lòng điền Tên")
    @Pattern(regexp = "^[a-z A-Z]+$", message = "Tên không đúng định dạng")
    @Size(min = 5, max = 45 ,message = "Tên phải lớn hơn 5 kí tự và nhỏ hơn 45 Kí tự")
    private String lastName;

    @NotBlank(message = "Vui lòng điền số điện thoại vào đây")
    @Pattern(regexp = "^0[\\d]{9}$", message = "vui lòng nhập 10 số và số bắt đầu từ 0")
    private String phoneNumber;


    @Min(value = 18,message = "Tuổi Phải Lớn hon 18")
    private int age;

    @Pattern(regexp = "^[\\w]+@gmail.com$", message = "Vui lòng nhập email đúng định dạng")
    private String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
