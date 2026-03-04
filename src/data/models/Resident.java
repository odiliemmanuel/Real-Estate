package data.models;

import java.time.LocalDateTime;

public class Resident {
    private String name;
    private String passCode;
    private String phoneNumber;
    private String houseId;
    private boolean isActive;
    private int id;


    public Resident(String name, String passCode, String phoneNumber) {
        this.name = name;
        this.passCode = passCode;
        this.phoneNumber = phoneNumber;


    }

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

    public String getPassCode() {
        return passCode;
    }

    public void setPassCode(String passCode) {
        this.passCode = passCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getHouseId() {
        return houseId;
    }

    public void setHouseId(String houseId) {
        this.houseId = houseId;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
