package com.company;

/*
Описать класс «автостоянка» для хранения сведений об автомобилях.
Для каждого автомобиля записываются госномер, цвет, фамилия владельца и признак присутствия на стоянке.
Обеспечить возможность поиска автомобиля по разным критериям, вывода списка присутствующих
и отсутствующих на стоянке автомобилей, доступа к имеющимся сведениям по номеру места.
Написать программу, демонстрирующую все разработанные элементы класса.
 */

import java.util.Scanner;

public class Parking {
    ParkingPlace[] parking;

    public Parking(int placeAmount) {
        this.parking = new ParkingPlace[placeAmount];
        createParking();
    }

    public void createParking() {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < parking.length; i++) {
            System.out.println("Enter number: ");
            int number = scanner.nextInt();
            System.out.println("Enter Car number: ");
            String carNumber = scanner.next();
            System.out.println("Enter color: ");
            String color = scanner.next();
            System.out.println("Enter driver name: ");
            String driverName = scanner.next();
            parking[i] = new ParkingPlace(number, carNumber, color, driverName);
        }

    }
}
