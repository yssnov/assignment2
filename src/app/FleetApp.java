package app;
import vehicle.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FleetApp {

    private List<Vehicle> vehicles = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void run() {
        boolean running = true;

        while (running) {
            System.out.println("\n1.Print  2.Add Car  3.Add Bus  4.Insurance  5.Service  6.Quit");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    printAll();
                    break;
                case 2:
                    addCar();
                    break;
                case 3:
                    addBus();
                    break;
                case 4:
                    showInsurance();
                    break;
                case 5:
                    serviceAll();
                    break;
                case 6:
                    running = false;
                    break;
            }
        }
    }

    private void printAll() {
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles");
            return;
        }
        for (Vehicle v : vehicles) {
            System.out.println(v);
        }
    }

    private void addCar() {
        System.out.print("Model: ");
        String model = scanner.nextLine();
        System.out.print("Year: ");
        int year = scanner.nextInt();
        System.out.print("Price: ");
        double price = scanner.nextDouble();
        System.out.print("Doors: ");
        int doors = scanner.nextInt();
        scanner.nextLine();

        vehicles.add(new Car(model, year, price, doors));
    }

    private void addBus() {
        System.out.print("Model: ");
        String model = scanner.nextLine();
        System.out.print("Year: ");
        int year = scanner.nextInt();
        System.out.print("Price: ");
        double price = scanner.nextDouble();
        System.out.print("Capacity: ");
        int cap = scanner.nextInt();
        scanner.nextLine();

        vehicles.add(new Bus(model, year, price, cap));
    }

    private void showInsurance() {
        double sum = 0;
        for (Vehicle v : vehicles) {
            sum += v.calculateInsuranceFee();
        }
        System.out.println("Total insurance: " + sum);
    }

    private void serviceAll() {
        for (Vehicle v : vehicles) {
            Servicable s = (Servicable) v;
            s.performService();
        }
    }

    public static void main(String[] args) {
        new FleetApp().run();
    }
}
