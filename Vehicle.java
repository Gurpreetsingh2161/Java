 class Main {
    public static void main(String[] args) {
        
    Petrol_V v1=new Petrol_V();
    v1.runsOn();
    Vehicle v2=new Electric_V();
    v2.runsOn();
}
}

abstract class Vehicle{
    int no_of_tires;
    String type;
    abstract void runsOn();
}

class Petrol_V extends Vehicle{
    float mile_age;
    float power_output;
    void runsOn(){
        System.out.println("Runs on Petrol.");
    }
}

class Electric_V extends Vehicle{
    int charging_time;
    float mile_age;
    void runsOn(){
        System.out.println("Runs on Electricity.");
    }
}