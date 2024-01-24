package modals;

public class Car {
    private final String registrationNumber;
    private final String color;

    private Integer slot;

    public Car(String registrationNo, String color) {
        this.registrationNumber = registrationNo;
        this.color = color;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public String getColor() {
        return color;
    }

    public Integer getSlot() {
        return slot;
    }

    public void setSlot(Integer slot) {
        this.slot = slot;
    }
}
