package com.codegym.model.customer;

import com.codegym.service.customer.CustomerService;
import com.codegym.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Component
public class CustomerDTO implements Validator {

    private int id;
    private String name;
    @NotBlank(message = "Vui lòng nhập ngày sinh")
    private String dateOfBirth;
    private boolean gender;
    @NotBlank(message = "Vui lòng nhập CMND")
    private String iDCard;
    @NotBlank(message = "Vui lòng nhập Số Điện Thoại")
    private String phoneNumber;
    @NotBlank(message = "Vui lòng nhập Email")
    private String email;
    @NotBlank(message = "Vui lòng nhập Địa Chỉ")
    private String address;
    @Column(columnDefinition = "boolean default false")
    private boolean isDelete;
    private CustomerType customerType;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getiDCard() {
        return iDCard;
    }

    public void setiDCard(String iDCard) {
        this.iDCard = iDCard;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }


    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    public void check(List<Customer> list, CustomerDTO customerDTO, Errors errors) {
        String regexName = "^[a-z A-Z]+$";
        if (customerDTO.getName().equals("") || customerDTO.getName() == null) {
            errors.rejectValue("name", "name", "Tên không được bỏ trống");
        } else if (!customerDTO.getName().matches(regexName)) {
            errors.rejectValue("name", "name", "Tên không đúng định dạng");
        }
        for (Customer customer : list) {
            if (customer.getId() == customerDTO.getId()) {
                continue;
            }
            if (customer.getEmail().equals(customerDTO.getEmail())) {
                errors.rejectValue("email", "email", "Email " + customerDTO.getEmail() + " đã có người sử dụng !");
            }
            if (customer.getPhoneNumber().equals(customerDTO.getPhoneNumber())) {
                errors.rejectValue("phoneNumber", "phoneNumber", "Số điện thoại " + customerDTO.getPhoneNumber() + " đã có người sử dụng rồi !");
            }
            if (customer.getiDCard().equals(customerDTO.getiDCard())) {
                errors.rejectValue("iDCard", "iDCard", "CMND " + customerDTO.getiDCard() + " đã có người dùng !");
            }

        }
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
