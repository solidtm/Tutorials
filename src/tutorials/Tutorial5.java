package tutorials;

// ADTs
public class Tutorial5 {
    public static void main(String[] args) {
        Boat b = new Boat();
//        Car c = new Car();
//        AirPlane a = new AirPlane();

        System.out.println(b.drive(new int[]{}));
//        System.out.println(c.drive(240));
//        System.out.println(a.drive(2800));


//        try{
//            System.out.println(array[6]);
//        }catch (IndexOutOfBoundsException ex){
//            System.out.println(ex.getMessage());
//        }

        Tutorial6 tut = new Tutorial6();


       boolean dv = tut.getBoolean();
        System.out.println(dv);
    }
}

interface Vehicle{

    String drive(int[] engine);

    int getNumberOfWheels();

    String getVehicleModel(String description);
}

class Boat implements Vehicle{

    @Override
    public String drive(int[] engine) {
        if(engine.length == 0) return "Invalid array please pass in a valid array";
        return "The boat has an engine of " + engine[0] + "hp and is sailing on the sea";
    }

    @Override
    public int getNumberOfWheels() {
        return 0;
    }

    @Override
    public String getVehicleModel(String description) {
        return description;
    }

    public void numOfDoors(){

    }
}

//class Car implements Vehicle{
//
//    @Override
//    public String drive(int engine) {
//        return "The car has an engine of " + engine + "hp and is running on the road";
//    }
//
//    @Override
//    public int getNumberOfWheels() {
//        return 0;
//    }
//
//    @Override
//    public String getVehicleModel(String description) {
//        return description + "2024";
//    }
//}
//
//class AirPlane implements Vehicle{
//
//    @Override
//    public String drive(int engine) {
//        return "The place has an engine of " + engine + "hp and is flying in the air";
//    }
//
//    @Override
//    public int getNumberOfWheels() {
//        return 0;
//    }
//
//    @Override
//    public String getVehicleModel(String description) {
//        return description;
//    }
//}
