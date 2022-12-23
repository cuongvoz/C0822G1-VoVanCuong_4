package com.codegym.model;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class MusicDTO implements Validator {

    private int id;
    @NotBlank(message = "Không được để trống")
    @Size(max = 800,message = "Không được vượt quá 800 Kí Tự")
    @Pattern(regexp = "^[a-z A-Z]+$",message = "Không chứa các kí tự đặc biệt như @ ; , . = - + , ….")
    private String name;
    @NotBlank(message = "Không được để trống")
    @Size(max = 300,message = "Không được vượt quá 300 Kí Tự")
    @Pattern(regexp = "^[a-z A-Z]+$",message = "Không chứa các kí tự đặc biệt như @ ; , . = - + , ….")
    private String singed;
    @NotBlank(message = "Không được để trống")
    @Size(max = 1000,message = "Không được vượt quá 1000 Kí Tự")
    @Pattern(regexp = "^[a-z A-Z]+$",message = "Không chứa các kí tự đặc biệt như @ ; , . = - + , ….")
    private String category;

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

    public String getSinged() {
        return singed;
    }

    public void setSinged(String singed) {
        this.singed = singed;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }


    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }


    @Override
    public void validate(Object target, Errors errors) {

    }
}
