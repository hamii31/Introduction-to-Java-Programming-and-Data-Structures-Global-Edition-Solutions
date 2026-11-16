enum VehicleType {
    LAND,
    SEA,
    AIR,
    UNKNOWN
}

abstract class Vehicle {
    VehicleType type;
    Double weight; // in kgs
    Double dragCoefficient;
    Integer passengerNumber;

    abstract double topSpeed();

    public Object getType() {
        return type;
    }

    public void setType(VehicleType type) {
        this.type = type;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getDragCoefficient() {
        return dragCoefficient;
    }

    public void setDragCoefficient(Double dragCoefficient) {
        this.dragCoefficient = dragCoefficient;
    }

    public Integer getPassengerNumber() {
        return passengerNumber;
    }

    public void setPassengerNumber(Integer passengerNumber) {
        this.passengerNumber = passengerNumber;
    }

    public String toString() {
        return "This " + type.name() + " vehicle has a top speed of " + topSpeed() + " mph and can carry " + passengerNumber + " passengers.";
    }
}

class Car extends Vehicle {
    String carType;
    Double horsePower;
    Double frontArea;
    final private double p = 1.225; // air density at sea level

    Car(String carType, Double horsePower, Double frontArea, VehicleType type, Double weight, Double dragCoefficient, Integer passengerNumber) {
        this.carType = carType;
        this.horsePower = horsePower;
        this.frontArea = frontArea;
       
        this.type = type;
        this.weight = weight;
        this.dragCoefficient = dragCoefficient;
        this.passengerNumber = passengerNumber;
    }

    private double convertHPtoWatts() {
        return horsePower * 745.7;
    }

    @Override
    double topSpeed() {
        return Math.round(3.6 * Math.cbrt(
            (2 * 0.85 * convertHPtoWatts()) 
            /
            (p * dragCoefficient * frontArea)
        ));
    }

    @Override
    public String toString() {
        return "This " + type.name() + " vehicle is a " + carType + ", has a top speed of " + topSpeed() + " kph, and can carry " + passengerNumber + " passengers.";
    }
}

class Plane extends Vehicle {
    String planeType;
    Double enginePower; // in MWs
    Integer engineNumber; // how many engines on the aircraft
    Double wingArea; // in quadratic meters
    final private Double p = 0.414; // air density at cruising altitude (10_000m)

    Plane(String planeType, Double enginePower, Integer engineNumber, Double wingArea,
        VehicleType type, Double weight, Double dragCoefficient, Integer passengerNumber) {
        
        this.planeType = planeType;
        this.enginePower = enginePower;
        this.engineNumber = engineNumber;
        this.wingArea = wingArea;

        this.type = type;
        this.weight = weight;
        this.dragCoefficient = dragCoefficient;
        this.passengerNumber = passengerNumber;
    }

    private Double convertMWsToWatts() {
        return (engineNumber * enginePower) * 1_000_000;
    }

    @Override
    double topSpeed() {
        return Math.round(Math.cbrt(
                (2 * convertMWsToWatts())
                /
                (p * wingArea * dragCoefficient)));
    }

    @Override
    public String toString() {
        return "This " + type.name() + " vehicle is a " + planeType + " aircraft, has a top speed of " + topSpeed() + " kph, and can carry " + passengerNumber + " passengers.";
    }
}

class Ship extends Vehicle {
    String shipType;
    Double enginePower; // in MWs
    Integer engineNumber;

    Ship(String shipType, Double enginePower, Integer engineNumber,
    VehicleType type, Double weight, Double dragCoefficient, Integer passengerNumber) {
        this.shipType = shipType;
        this.enginePower = enginePower;
        this.engineNumber = engineNumber;

        this.type = type;
        this.weight = weight;
        this.dragCoefficient = dragCoefficient; // admiralty coefficient
        this.passengerNumber = passengerNumber;
    }

    private Double convertMWsToKWs() {
        return (engineNumber * enginePower) * 1_000;
    }

    private Double kilogramsToTonnes() {
        return weight / 1_000;
    }

    private Double computeDisplacement() {
        return Math.pow(kilogramsToTonnes(), 2/3.0);
    }

    @Override
    double topSpeed() {
        return Math.round(Math.cbrt(
            (dragCoefficient * convertMWsToKWs())
            /
            computeDisplacement()
        ));
    }

    
    @Override
    public String toString() {
        return "This " + type.name() + " vehicle is a " + shipType + " ship, has a top speed of " + topSpeed() * 1.852 + " kph, and can carry " + passengerNumber + " passengers.";
    }
}

public class CustomAbstractClass {
    public static void main(String[] args) {
        Car car = new Car("SUV", 250.0, 2.6, VehicleType.LAND, 3000.0, 0.30, 5);
        System.out.println(car.toString());

        Plane plane = new Plane("Commercial", 46.0, 2, 7.5, VehicleType.AIR, 172_000.0, 0.03, 165);
        System.out.println(plane.toString());

        Ship ship = new Ship("Cruiser", 15.0, 4, VehicleType.SEA, 9_600_000.0, 500.0, 2_000);
        System.out.println(ship.toString());
    }
}
