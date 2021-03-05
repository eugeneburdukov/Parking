package com.company;

/*
Описать класс «автостоянка» для хранения сведений об автомобилях.
Для каждого автомобиля записываются госномер, цвет, фамилия владельца и признак присутствия на стоянке.
Обеспечить возможность поиска автомобиля по разным критериям, вывода списка присутствующих
и отсутствующих на стоянке автомобилей, доступа к имеющимся сведениям по номеру места.
Написать программу, демонстрирующую все разработанные элементы класса.
 */

public class ParkingPlace {
    int number;
    String carNumber;
    String color;
    String driverName;
    boolean free;
    boolean present;

    public ParkingPlace(int number) {
        this.number = number;
    }

    public ParkingPlace(int number, String carNumber, String color, String driverName) {

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
