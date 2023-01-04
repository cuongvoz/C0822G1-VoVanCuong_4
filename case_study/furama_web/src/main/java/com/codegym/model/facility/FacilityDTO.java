package com.codegym.model.facility;


import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import java.util.List;

public class FacilityDTO implements Validator {
    private int id;
    private String name;
    private Integer area;
    private Double cost;
    private Double maxPeople;
    private String standardRoom;
    private String descriptionOtherConvenience;
    private Double poolArea;
    private Integer numberOfFloor;
    private String facilityFree;
    private RentType rentType;
    private FacilityType facilityType;

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

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Double getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(Double maxPeople) {
        this.maxPeople = maxPeople;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescriptionOtherConvenience() {
        return descriptionOtherConvenience;
    }

    public void setDescriptionOtherConvenience(String descriptionOtherConvenience) {
        this.descriptionOtherConvenience = descriptionOtherConvenience;
    }

    public Double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(Double poolArea) {
        this.poolArea = poolArea;
    }

    public Integer getNumberOfFloor() {
        return numberOfFloor;
    }

    public void setNumberOfFloor(Integer numberOfFloor) {
        this.numberOfFloor = numberOfFloor;
    }

    public String getFacilityFree() {
        return facilityFree;
    }

    public void setFacilityFree(String facilityFree) {
        this.facilityFree = facilityFree;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public FacilityType getFacilityType() {
        return facilityType;
    }

    public void setFacilityType(FacilityType facilityType) {
        this.facilityType = facilityType;
    }

    public void check(List<Facility> list, FacilityDTO facilityDTO, Errors errors) {
        if (facilityDTO.getName().equals("")) {
            errors.rejectValue("name", "name", "Vui lòng nhập tên dịch vụ");
        }
        if (facilityDTO.getArea() == null) {
            errors.rejectValue("area", "area", "Vui lòng nhập diện tích sử dụng");
        }
        if (facilityDTO.getCost() == null) {
            errors.rejectValue("cost", "cost", "Vui lòng nhập chi phí thuê");
        }
        if (facilityDTO.getMaxPeople() == null) {
            errors.rejectValue("maxPeople", "maxPeople", "Vui lòng nhập số lượng người tối đa");
        }
        for (Facility facility : list) {
            if (facilityDTO.getId() == facility.getId()) {
                continue;
            }
            if (facility.getName().equals(facilityDTO.getName()) && !facilityDTO.getName().equals("")) {
                errors.rejectValue("name", "name", "Dịch Vụ " + facilityDTO.getName() + " đã có rồi vui lòng nhập tên khác");
            }
        }
        switch (facilityDTO.facilityType.getId()) {
            case 1:
                if (facilityDTO.getStandardRoom().equals("")) {
                    errors.rejectValue("standardRoom", "standardRoom", "Vui lòng nhập tiêu chuẩn phòng cho villa");
                }
                if (facilityDTO.getDescriptionOtherConvenience().equals("")) {
                    errors.rejectValue("descriptionOtherConvenience", "descriptionOtherConvenience", "Vui lòng nhập mô tả cho villa");
                }
                if (facilityDTO.getPoolArea() == null) {
                    errors.rejectValue("poolArea", "poolArea", "Vui lòng nhập lại diện tích hồ bơi cho villa");
                }
                if (facilityDTO.getNumberOfFloor() == null) {
                    errors.rejectValue("numberOfFloor", "numberOfFloor", "Vui lòng lại số tầng cho villa");
                }
                break;
            case 2:
                if (facilityDTO.getStandardRoom().equals("")) {
                    errors.rejectValue("standardRoom", "standardRoom", "Vui lòng nhập tiêu chuẩn phòng cho House");
                }
                if (facilityDTO.getDescriptionOtherConvenience().equals("")) {
                    errors.rejectValue("descriptionOtherConvenience", "descriptionOtherConvenience", "Vui lòng nhập mô tả cho House");
                }
                if (facilityDTO.getNumberOfFloor() == null ) {
                    errors.rejectValue("numberOfFloor", "numberOfFloor", "Vui lòng lại số tầng cho House");
                }
                break;
            case 3:
                if (facilityDTO.getFacilityFree().equals("")) {
                    errors.rejectValue("facilityFree", "facilityFree", "Vui lòng dịch vụ miễn phí phòng cho Room");
                }
                break;
        }
    }


    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
