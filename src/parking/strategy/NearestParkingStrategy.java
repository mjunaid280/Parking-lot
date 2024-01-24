package parking.strategy;

//import modals.Slot;

import java.util.Set;
import java.util.TreeSet;

public class NearestParkingStrategy implements ParkingStrategy{
    private final TreeSet<Integer> parkingSlots;

    public NearestParkingStrategy() {
        this.parkingSlots = new TreeSet<>();
    }

    public Set<Integer> getParkingSlots() {
        return parkingSlots;
    }

    @Override
    public void addSlot(Integer slot) {
        this.parkingSlots.add(slot);
    }

    @Override
    public void removeSlot(Integer slot) {
        this.parkingSlots.remove(slot);
    }

    @Override
    public Integer getNextSlot() {
        if(parkingSlots.isEmpty()) return -1;
        return parkingSlots.first();
    }
}
