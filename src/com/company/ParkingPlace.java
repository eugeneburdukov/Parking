package com.company;

/*
Описать класс «автостоянка» для хранения сведений об автомобилях.
Для каждого автомобиля записываются госномер, цвет, фамилия владельца и признак присутствия на стоянке.
Обеспечить возможность поиска автомобиля по разным критериям, вывода списка присутствующих
и отсутствующих на стоянке автомобилей, доступа к имеющимся сведениям по номеру места.
Написать программу, демонстрирующую все разработанные элементы класса.
 */

import java.util.Calendar;

public class ParkingPlace {
    int number;
    String carNumber;
    String color;
    String driverName;
    boolean free;
    boolean present;
    double payment;
    Calendar startTime;

    public ParkingPlace(int number) {
        this.number = number;
        this.free = true;
    }

    @Override
    public String toString() {
        return "ParkingPlace{" +
                "number=" + number +
                ", carNumber='" + carNumber + '\'' +
                ", color='" + color + '\'' +
                ", driverName='" + driverName + '\'' +
                ", free=" + free +
                ", present=" + present +
                '}';
    }
}
