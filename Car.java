public class Car{
    String make;
    String model;
    int year;
    int speedx;
    int speedy;
    int speedz;
    int x, y, z;

    public Car(String make, String model, int year, int speedx,int speedy, int x, int y, int z) {
        super();
        this.make = make;
        this.model = model;
        this.year = year;
        this.speedx = speedx;
        this.speedy = speedy;
        //this.speedz = speedz;
        this.x = x;
        this.y = y;
        this.z = z;

    }

    // accelerate the Car by speed_increment
    public void accelerate_x(int speed_increment) {
        speedx += speed_increment;
    }
    
    public void accelerate_y(int speed_increment) {
        speedy += speed_increment;
    }
    
    
    // Decrease the speed of Car by speed_decriment
    public void brake(int speed_decrement) {
        speedx -= speed_decrement;
        speedy -= speed_decrement;
    }
   
    // Move the Car

    public void move() {
        x = x + speedx;
        y = y + speedy;
        z = z + speedz;
    }

    // Detect if collision happens

    public boolean detect_collision(Car car2) {
        int distance = (int) Math
                .sqrt(Math.pow(x - car2.getX(), 2) + Math.pow(y - car2.getY(), 2) + Math.pow(z - car2.getZ(), 2));

        return distance <= 0;
    }
    // Calculate time for collision

     
    public double time_to_collision(Car car2) {

        if (!this.detect_collision(car2)) {

            return 0;
        }

        

        int relativeCarSpeed = speed - car2.getSpeed();

        int distance = (int) Math
                .sqrt(Math.pow(x - car2.getX(), 2) + Math.pow(y - car2.getY(), 2) + Math.pow(z - car2.getZ(), 2));

        return (double) (distance / relativeCarSpeed);

    }

    int speed = (int) Math.sqrt(speedx * speedx + speedy * speedy + speedz*speedz);
    public int getSpeed() {
        return speed;

    }
   /*  public int getSpeedy() {
        return speedy;

    }*/


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }
    // Test the car class

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Car carl = new Car("Maruti", "SX4", 1998, 30,10, 0, 0, 0);
        Car car2 = new Car("Honda", "City", 2020, 20,5, 50, 50, 50);

        Car car3 = new Car("Jaguar", "XF", 2022, 100,70, 0, 0, 0);
        Car car4 = new Car("Nano", "XTA", 2020, 60,20, 70, 70, 70);


        //int accelerate = (int) Math.sqrt(acceleratex * acceleratex + acceleratey * acceleratey + acceleratez*acceleratez);

        carl.accelerate_x(20);
        carl.accelerate_y(10);
        car2.brake(10);
        carl.move();
        car2.move();

        car3.accelerate_x(40);
        car3.accelerate_y(15);
        car4.brake(10);
        car3.move();
        car4.move();

        // System.out.println("" + carl.getSpeed() + " " + car1.getX());
        // System.out.println("" + car2.getSpeed() + " " + car2.getX());

        if (carl.detect_collision(car2)) {
            System.out.println("Car1 and Car2 has been collided");
        } else {
            System.out.println("Car1 and Car2 has not been collided");
        }

        if (car3.detect_collision(car4)) {
            System.out.println("Car3 and Car4 has been collided");
        } else {
            System.out.println("Car3 and Car4 has not been collided");
        }

        
        double timeforCollision = carl.time_to_collision(car2);
        System.out.println("Time taken by Car1 and Car2 to collide is: " + timeforCollision + " hr");

        timeforCollision = car3.time_to_collision(car4);
        System.out.println("Time taken by Car3 and Car4 to collide is: " + timeforCollision + " hr");
    }
}
