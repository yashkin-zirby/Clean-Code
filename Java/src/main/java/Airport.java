import Planes.ExperimentalPlane;
import models.MilitaryType;
import Planes.MilitaryPlane;
import Planes.PassengerPlane;
import Planes.Plane;
import org.testng.Assert;

import java.util.*;
import java.util.function.BiPredicate;
import java.util.function.Function;

// version: 1.1
// made by Vitali Shulha
// 4-Jan-2019

public class Airport {
    private final List<? extends Plane> planes;

    public Airport(List<? extends Plane> planes) {
        this.planes = planes;
    }

    public List<PassengerPlane> getPassengerPlane() {
        List<PassengerPlane> passengerPlanes = new ArrayList<>();
        for (Plane plane : this.planes) {if (plane instanceof PassengerPlane) {passengerPlanes.add((PassengerPlane) plane);}}
        return passengerPlanes;
    }

    public List<MilitaryPlane> getMilitaryPlanes() {
        List<MilitaryPlane> militaryPlanes = new ArrayList<>();
        for (Plane plane : planes) {
            if (plane instanceof MilitaryPlane) militaryPlanes.add((MilitaryPlane) plane);
        }
        return militaryPlanes;
    }

    public PassengerPlane getPassengerPlaneWithMaxPassengersCapacity() {
        List<PassengerPlane> passengerPlanes = getPassengerPlane();
        PassengerPlane planeWithMaxCapacity = passengerPlanes.get(0);
        for (int i = 1; i < passengerPlanes.size(); i++) {
            if (passengerPlanes.get(i).getPassengersCapacity() > planeWithMaxCapacity.getPassengersCapacity()) {
                planeWithMaxCapacity = passengerPlanes.get(i);
            }
        }
        return planeWithMaxCapacity;
    }

    public List<MilitaryPlane> getTransportMilitaryPlanes() {
        List<MilitaryPlane> transportMilitaryPlanes = new ArrayList<>();
        for (MilitaryPlane plane : getMilitaryPlanes()) {
            if (plane.getMilitaryType() == MilitaryType.TRANSPORT) transportMilitaryPlanes.add(plane);
        }
        return transportMilitaryPlanes;
    }

    public List<MilitaryPlane> getBomberMilitaryPlanes() {
        List<MilitaryPlane> bomberMilitaryPlanes = new ArrayList<>();
        for (MilitaryPlane plane : getMilitaryPlanes()) {
            if (plane.getMilitaryType() == MilitaryType.BOMBER) bomberMilitaryPlanes.add(plane);
        }
        return bomberMilitaryPlanes;
    }

    public List<ExperimentalPlane> getExperimentalPlanes() {
        List<ExperimentalPlane> experimentalPlanes = new ArrayList<>();
        for (Plane plane : planes) {
            if (plane instanceof ExperimentalPlane)experimentalPlanes.add((ExperimentalPlane) plane);
        }
        return experimentalPlanes;
    }

    public Airport sortByMaxDistance() {
        List<? extends Plane> sortedPlanes = new ArrayList<>(planes);
        sortedPlanes.sort((a,b)->a.getMaxFlightDistance()-b.getMaxFlightDistance());
        return new Airport(sortedPlanes);
    }

    public Airport sortByMaxSpeed() {
        List<? extends Plane> sortedPlanes = new ArrayList<>(planes);
        sortedPlanes.sort((a,b)->a.getMaxSpeed()-b.getMaxSpeed());
        return new Airport(sortedPlanes);
    }

    public Airport sortByMaxLoadCapacity() {
        List<? extends Plane> sortedPlanes = new ArrayList<>(planes);
        sortedPlanes.sort((a,b)->a.getMaxLoadCapacity()-b.getMaxLoadCapacity());
        return new Airport(sortedPlanes);
    }

    public List<? extends Plane> getPlanes() {
        return planes;
    }

    private void print(Collection<? extends Plane> collection) {
        for (Plane plane : collection) {
            System.out.println(plane);
        }
    }

    @Override
    public String toString() {
        return "Airport{" +
                "Planes=" + planes.toString() +
                '}';
    }

    public boolean planesAreSortedByCondition(BiPredicate<Plane,Plane> condition){
        for(int i = 0; i < planes.size()-1; i++){
            Plane currentPlane = planes.get(i);
            Plane nextPlane = planes.get(i + 1);
            if (!condition.test(currentPlane,nextPlane)) {
                return false;
            }
        }
        return true;
    }
}
