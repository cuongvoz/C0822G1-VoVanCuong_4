package com.codegym.model.customer;

import javax.persistence.*;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;
   private String name;
   private String dateOfBirth;
   private boolean gender;
   private String iDCard;
   private String phoneNumber;
   private String email;
   private String address;
   @ManyToOne
   @JoinColumn(name = "customerType",referencedColumnName = "id")
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

   public CustomerType getCustomerType() {
      return customerType;
   }

   public void setCustomerType(CustomerType customerType) {
      this.customerType = customerType;
   }
}
