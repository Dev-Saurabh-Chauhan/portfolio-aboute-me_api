package com.portfolio.about_me.Dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class AboutMeSaveDto {
    @NotBlank(message = "Name cannot be blank")
    @Size(max = 30, message = "Name cannot exceed 100 characters")
    private String name;

    @NotBlank(message = "Tech Stack cannot be blank")
    @Size(max = 255, message = "Tech Stack cannot exceed 255 characters")
    private String techStack;

    @NotBlank(message = "Description cannot be blank")
    private String description;

    @NotBlank(message = "Date of Birth cannot be blank")
    @Size(max = 12, message = "Date of Birth cannot exceed 12 characters")
    private String dateOfBirth;

    @NotBlank(message = "Current Address cannot be blank")
    @Size(max = 255, message = "Current Address cannot exceed 255 characters")
    private String currentAddress;

    @NotBlank(message = "Permanent Address cannot be blank")
    @Size(max = 255, message = "Permanent Address cannot exceed 255 characters")
    private String permanentAddress;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTechStack() {
        return techStack;
    }

    public void setTechStack(String techStack) {
        this.techStack = techStack;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getCurrentAddress() {
        return currentAddress;
    }

    public void setCurrentAddress(String currentAddress) {
        this.currentAddress = currentAddress;
    }

    public String getPermanentAddress() {
        return permanentAddress;
    }

    public void setPermanentAddress(String permanentAddress) {
        this.permanentAddress = permanentAddress;
    }
}
