package data.models;

import java.time.LocalDateTime;

public class GatePass {

    private String name;
    private int id;
    private int residentId;
    private LocalDateTime startingDate =  LocalDateTime.now();
    private LocalDateTime expirationDate;
    private boolean isActive = true;

    public GatePass(String name, String phoneNumber) {
        this.id = id;
        this.residentId = residentId;


    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getResidentId() {
        return residentId;
    }

    public void setResidentId(int residentId) {
        this.residentId = residentId;
    }

    public LocalDateTime getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDateTime expirationDate) {
        this.expirationDate = expirationDate;
    }

    public LocalDateTime getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(LocalDateTime startingDate) {
        this.startingDate = startingDate;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
