package com.company;

/*
Описать класс «автостоянка» для хранения сведений об автомобилях.
Для каждого автомобиля записываются госномер, цвет, фамилия владельца и признак присутствия на стоянке.
Обеспечить возможность поиска автомобиля по разным критериям, вывода списка присутствующих
и отсутствующих на стоянке автомобилей, доступа к имеющимся сведениям по номеру места.
Написать программу, демонстрирующую все разработанные элементы класса.
 */

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Parking {
    ParkingPlace[] parking;
    Scanner scanner;
    double price;

    public Parking(int placeAmount, double price) {
        this.parking = new ParkingPlace[placeAmount];
        scanner = new Scanner(System.in);
        this.price = price;
        createParking();
    }

    public void createParking() {
        for (int i = 0; i < parking.length; i++) {
            parking[i] = new ParkingPlace(i + 1);
        }

        int choose;

        do {
            System.out.println("\nEnter: 1 - report, 2 - in, 3 - out, 4 - Search, 5 - remove,  0 - exit!");
            choose = scanner.nextInt();

            switch (choose) {
                case 1:
                    report();
                    break;
                case 2:
                    in();
                    break;
                case 3:
                    out();
                    break;
                case 4:
                    searchCar();
                    break;
                case 5:
                    remove();
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Сделайте выбор: ");
            }
        } while (choose != 0);
    }

    private void remove() {
        System.out.println("Введите гос номер автомобиля для удаления с парковки: ");
        String carNumber = scanner.next();
        for (int i = 0; i < parking.length; i++) {
            if (parking[i].free == false && parking[i].carNumber.equals(carNumber)) {
                parking[i].free = true;
                parking[i].carNumber = "";
                parking[i].driverName = "";
                parking[i].present = false;
                parking[i].color = "";
                System.out.println("Автомобиль с номером '" + carNumber + "' удален из базы данных");
                break;
            }
            if (i == (parking.length - 1)) {
                System.out.println("Автомобиль с номером '" + carNumber + "' не зарегестрирован!");
            }
        }
    }

    private void searchCar() {
        int chooseSearchType;

        do {
            System.out.println("Выберите критерий поиска: 1 - по госномеру, 2 - по имени владельца, " +
                    "3 - присутствующие авто, 4 - отсутствующие авто");
            chooseSearchType = scanner.nextInt();
            switch (chooseSearchType) {
                case 1:
                    System.out.println("Введите госномер автомобиля: ");
                    String carNumber = scanner.next();
                    for (int i = 0; i < parking.length; i++) {
                        if (parking[i].free == false && parking[i].carNumber.equals(carNumber)) {
                            System.out.println(parking[i]);
                            break;
                        }
                        if (i == (parking.length - 1)) {
                            System.out.println("Автомобиля с госномером '" + carNumber + "' нет в базе!");
                            break;
                        }
                    }
                    break;
                case 2:
                    System.out.println("Введите имя владельца: ");
                    String driverName = scanner.next();
                    for (int i = 0; i < parking.length; i++) {
                        if (parking[i].free == false && parking[i].driverName.equals(driverName)) {
                            System.out.println(parking[i]);
                            break;
                        }
                        if (i == (parking.length - 1)) {
                            System.out.println("Владельца с имененем " + driverName + " нет в базе!");
                            break;
                        }
                    }
                    break;
                case 3:
                    for (int i = 0; i < parking.length; i++) {
                        if (parking[i].free == false && parking[i].present == true) {
                            System.out.println(parking[i]);
                        }
                    }
                    break;
                case 4:
                    for (int i = 0; i < parking.length; i++) {
                        if (parking[i].free == false && parking[i].present == false) {
                            System.out.println(parking[i]);
                        }
                    }
                    break;
                default:
                    System.out.println("Сделайте правильный выбор!");
            }
        } while (chooseSearchType <= 0 || chooseSearchType > 4);
    }

    private void out() {
        System.out.println("Введите гос номер автомобиля для выезда: ");
        String carNumber = scanner.next();
        for (int i = 0; i < parking.length; i++) {
            if (parking[i].free == false && parking[i].carNumber.equals(carNumber)) {
                double debt = getDebt(carNumber);
                if (debt > 0) {
                    System.out.println("Ваш долг = " + debt);
                } else {
                    System.out.println("Выпустить машину!");
                }
                break;
            }
            if (i == (parking.length) - 1) {
                System.out.println("Ошибка! Автомобиль с гос номером '" + carNumber + "' не зарегестрирован в базе" +
                        " данных!");

            }

        }
    }

    private double getDebt(String carNumber) {
        double debt = 0;
        for (int i = 0; i < parking.length; i++) {
            if (parking[i].free == false && parking[i].carNumber.equals(carNumber)) {
                return (((new GregorianCalendar().getTime().getTime() - parking[i].startTime.getTime().getTime()) /
                        (1000 * 60 * 60 * 24)) * price) - parking[i].payment;
            }
        }
        return debt;
    }

    private void in() {

        System.out.println("Введите госномер автомобиля: ");
        String carNumber = scanner.next();
        for (int i = 0; i < parking.length; i++) {
            if (carNumber.equals(parking[i].carNumber)) {
                System.out.println("Автомобиль с госномером " + carNumber + " зарегестрирован!\nВпустить!!!");
                break;
            }
            if (i == (parking.length - 1)) {
                System.out.println("Автомобиля с госномером " + carNumber + " нет в базе!\nЗарегестрировать!");
                for (int j = 0; j < parking.length; j++) {
                    if (parking[j].free == true) {
                        System.out.println("Enter color: ");
                        parking[j].color = scanner.next();
                        System.out.println("Enter driver name: ");
                        parking[j].driverName = scanner.next();
                        parking[j].carNumber = carNumber;
                        parking[j].free = false;
                        parking[j].present = true;
                        parking[j].payment = 30 * price;
                        parking[j].startTime = new GregorianCalendar();
                        //todo взять предоплату
                        System.out.println("Машина зарегестрирована. Впустить!");
                        break;
                    }
                }
            }
        }
    }

    private void report() {
        for (int i = 0; i < parking.length; i++) {
            System.out.println(parking[i]);
        }
    }
}
