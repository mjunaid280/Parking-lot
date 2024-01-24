package modals;
import java.util.HashMap;

public class ParkingLot {
    private final HashMap<Integer, Car> slots;

    public ParkingLot(Integer capacity) {
        this.slots = new HashMap<>();
        for(int i = 1; i<=capacity; i++){
            slots.put(i, null);
        }
    }

    public HashMap<Integer, Car> getSlots() {
        return slots;
    }

    public Boolean parkCar(Car car, Integer freeSlot){
        if(slots.get(freeSlot)!=null) return false;
        slots.put(car.getSlot(), car);
        return true;
    }


    public Boolean unassignCar(Integer slotNumber){
        if(slots.get(slotNumber)==null) return false;
        else slots.put(slotNumber,null);
        return true;
    }
}
