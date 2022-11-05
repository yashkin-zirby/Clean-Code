package Planes;

import java.util.Objects;

public class PassengerPlane extends Plane{
    private final int passengersCapacity;

    public PassengerPlane(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity, int passengersCapacity) {
        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.passengersCapacity = passengersCapacity;
    }

    public int getPassengersCapacity() {
        return passengersCapacity;
    }

    @Override
    public String toString() {
        return super.toString().replace("}",
                ", passengersCapacity=" + passengersCapacity +
                        '}');
    }

    @Override
    public boolean equals(Object o) {
        if(!(o instanceof PassengerPlane))return false;
        return super.equals(o) && ((PassengerPlane) o).passengersCapacity == passengersCapacity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), passengersCapacity);
    }
}
