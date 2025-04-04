package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

            try {
                System.out.print("Room number: ");
                int number = sc.nextInt();
                System.out.print("Check-in date (dd/MM/yyyy): ");
                Date checkin = sdf.parse(sc.next());
                System.out.print("Check-out date (dd/MM/yyyy): ");
                Date checkout = sdf.parse(sc.next());

                Reservation reservation = new Reservation(number, checkin, checkout);
                System.out.println("Reservation: " + reservation);

                System.out.println();
                System.out.println("Enter data to update the reservation:");
                System.out.print("Check-in date (dd/MM/yyyy): ");
                checkin = sdf.parse(sc.next());
                System.out.print("Check-out date (dd/MM/yyyy): ");
                checkout = sdf.parse(sc.next());

                reservation.updateDates(checkin, checkout);
                System.out.println("Reservation: " + reservation);
            } catch (ParseException e) {
                System.out.println("Invalid date format."); // erro ja esperado
            } catch (DomainException e) {
                System.out.println("Reservation: " + e.getMessage()); // excecao personalizada
            } catch (RuntimeException e) {
                System.out.println("Unexpected error."); // Qualquer tipo de RuntimeException, nesse caso, InputMismatchException
            }

        sc.close();
    }
}