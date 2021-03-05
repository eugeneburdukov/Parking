package com.company;

/*
Описать класс «автостоянка» для хранения сведений об автомобилях.
Для каждого автомобиля записываются госномер, цвет, фамилия владельца и признак присутствия на стоянке.
Обеспечить возможность поиска автомобиля по разным критериям, вывода списка присутствующих
и отсутствующих на стоянке автомобилей, доступа к имеющимся сведениям по номеру места.
Написать программу, демонстрирующую все разработанные элементы класса.
 */

import java.util.List;
import java.util.Scanner;

public class Parking {
    ParkingPlace[] parking;

    public Parking(int placeAmount) {
        this.parking = new ParkingPlace[placeAmount];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < parking.length; i++) {
            System.out.println("Enter Car Number: ");
            int number = scanner.nextInt();
            parking[i] = new ParkingPlace(number);
        }


    }

    public void openParking(){

    }
}
