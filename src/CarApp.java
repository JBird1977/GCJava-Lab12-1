import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

//ask the user how many cars they want to enter
//take details for each car
//print table of cars at the end
public class CarApp {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Car> carList = new ArrayList<>();
        int numCars = 0;

        printTitle();
        numCars = queryNumCars(scan);
        carDetail(scan, numCars, carList);
        printList(carList);

    } // end main

    // prints the opening title for our program
    private static void printTitle() {
        System.out.println("Welceome to the Grand Circus Motors admin console!");
    }

    // takes user input for the number of cars to process and returns user response
    // to main
    private static int queryNumCars(Scanner scan) {
        int in = 0;
        int valid = 0;
        do {
            try { // take and validate input
                System.out.println("How many cars are you entering? ");
                in = scan.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Please enter a number.");
                scan.nextLine();
                continue;
            } // end catch
            valid = 1;
        } while (valid == 0); // continue looping until valid input is presented
        return in;
    }

    // takes user input for car data and stores it into the carList arraylist - it
    // cycles a number of times based on user input from queryNumCars
    private static void carDetail(Scanner scan, int num, List<Car> carList) {
        Car userCar;
        String make = "";
        String model = "";
        int year = 0;
        double price = 0.0;
        for (int i = 0; i < num; i++) {
            scan.nextLine();
            System.out.println("Please enter the make of the car: ");
            make = scan.nextLine();
            System.out.println("Please enter the model of the car: ");
            model = scan.nextLine();
            System.out.println("Please enter the year of the car: ");
            year = scan.nextInt();
            System.out.println("Please enter the price of the car: ");
            price = scan.nextDouble();
            carList.add(new Car(make, model, year, price));
        } // end for
    } // end carDetail

    // prints out the data stored in our carList arraylist
    private static void printList(List<Car> carList) {
        int i = 0; // set i to 0. I tried setting carList.get to count but it didn't like that I
                   // didn't have an int in there. Hence this int :).

        for (Car count : carList) { // run though all the cars stored in the arraylist
            
            System.out.printf("%-10s \t", carList.get(i).makeGet());
            System.out.printf("%-10s \t", carList.get(i).modelGet());
            System.out.printf("%-7d \t", carList.get(i).yearGet());
            System.out.printf("$%-6.2f \n", carList.get(i).priceGet());
            i++; //I'd like to learn if there's a way to get the object at the specified index without having to resort to creating an int just for this purpose....
        } // end for

    } // end printList
} // end class
