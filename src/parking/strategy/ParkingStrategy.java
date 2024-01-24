package parking.strategy;

//import modals.Slot;

public interface ParkingStrategy {
    public void addSlot(Integer slot);
    public void removeSlot(Integer slot);
    public Integer getNextSlot();
}
