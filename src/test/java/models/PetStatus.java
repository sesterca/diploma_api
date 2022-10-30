package models;

public enum PetStatus {
    AVAILABLE("available"),
    PENDING("pending"),
    SOLD("sold");

    public String status;

    PetStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
