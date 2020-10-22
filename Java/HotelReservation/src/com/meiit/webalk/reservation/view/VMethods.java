package com.meiit.webalk.reservation.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.meiit.webalk.reservation.domain.BookingPerson;
import com.meiit.webalk.reservation.domain.Currency;
import com.meiit.webalk.reservation.domain.Hotel;
import com.meiit.webalk.reservation.domain.Reservation;
import com.meiit.webalk.reservation.domain.Room;

public class VMethods {
	
	BookingPerson bperson = new BookingPerson();	
	Scanner sc = new Scanner(System.in);
	public  String sroom="";
	
	public boolean parseCheck() {
		try {
			Integer.parseInt(sroom);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
	
	public BookingPerson readBookingPerson() {
		System.out.println("What's your name?");
		bperson.setName(sc.nextLine());
		System.out.println("How much money do you have?");
		String bal = sc.nextLine();
		int balance = Integer.parseInt(bal);
		bperson.setBalance(balance);
		System.out.println("What is your currency? (HUF, EUR or USD)");
		String currency = sc.nextLine();
		bperson.setCurrency(Currency.valueOf(currency));
		return bperson;
	}

	public void printWelcomeMessage(BookingPerson a) {
		System.out.println("Welcome " + a.getName());
	}

	public void printBalance(BookingPerson a) {
		System.out.println("Your balance is " + a.getBalance() + " " + a.getCurrency().name());
	}

	public void printRooms(List<Hotel> a) {
		System.out.println("Where do you want to book?(Choose a number or press q for quit)");
			for (int i = 0; i < a.size(); i++) {

				for (int j = 0; j < a.get(i).getFloors().size(); j++) {

					for (int k = 0; k < a.get(i).getFloors().get(j).getWings().size(); k++) {

						for (int l = 0; l < a.get(i).getFloors().get(j).getWings().get(k).getRooms().size(); l++) {

							System.out.println(l+1 + ": Hotel name: " + a.get(i).getName() + ", Floor: "
									+ a.get(i).getFloors().get(j).getFloorNumber() + ", Wing: "
									+ a.get(i).getFloors().get(j).getWings().get(k).getRooms().get(l).getWing()
									+ ", Room Number: "
									+ a.get(i).getFloors().get(j).getWings().get(k).getRooms().get(l).getNumber()
									+ ", Beds: "
									+ a.get(i).getFloors().get(j).getWings().get(k).getRooms().get(l).getBeds()
									+ ", Room Price: "
									+ a.get(i).getFloors().get(j).getWings().get(k).getRooms().get(l).getPrice()+" "+bperson.getCurrency());
						}
					}
				}
			}
	}

	public Room selectRoom(List<Hotel> a) {
		Room room = null;	
		sroom = sc.nextLine();
		if (parseCheck()) {
		for (int i = 0; i < a.size(); i++) {
			for (int j = 0; j < a.get(i).getFloors().size(); j++) {
				for (int k = 0; k < a.get(i).getFloors().get(j).getWings().size(); k++) {
					for (int m = 0; m < a.get(i).getFloors().get(j).getWings().get(k).getRooms().size(); m++) {
						if (m == Integer.parseInt(sroom)-1) {
							room = a.get(i).getFloors().get(j).getWings().get(k).getRooms().get(m);
						}
					}
				}
			}
		}
	}
		return room;
	}

	public void printReservationSaved(Reservation a) {
		System.out.println("The reservation successfully saved!");
	}

	public void printNotEnoughBalance(BookingPerson a) {
		System.out.println("Sorry you dont have enough balance! Please choose anoter room!");
	}

	public void printCheckIn(List<Reservation> a) {
		System.out.println("Check in");
	}

	public void printCheckOut(BookingPerson a, List<Reservation> reservations) {
		System.out.println("Few days later");
		System.out.println("Check out! Surpeise you are the 10000th gest you got 10% refund");
		int moneyback = 0;
		for (int i = 0; i < reservations.size(); i++) {
			moneyback = (int) (moneyback + (reservations.get(i).getAmmount() * 0.1));
		}
		int money=a.getBalance()+moneyback;
		System.out.println("Your new balance is " + money +" "+ a.getCurrency() + " (balance after refund)");
	}
	
	public void printReservationDetails(List<Hotel> hotel, int index) {
		System.out.print("Reservation details: ");
		for (int i = 0; i < hotel.size(); i++) {

			for (int j = 0; j < hotel.get(i).getFloors().size(); j++) {

				for (int k = 0; k < hotel.get(i).getFloors().get(j).getWings().size(); k++) {

					System.out.println(hotel.get(i).getName() + ", Floor: " + hotel.get(i).getFloors().get(j).getFloorNumber()
							+ ", Wing: " + hotel.get(i).getFloors().get(j).getWings().get(k).getRooms().get(index).getWing()
							+ ", Room Number: "+ hotel.get(i).getFloors().get(j).getWings().get(k).getRooms().get(index).getNumber()
							+ ", Beds: "+ hotel.get(i).getFloors().get(j).getWings().get(k).getRooms().get(index).getBeds());
				}
			}
		}
	}
	
	public void printReservedRooms(List<Hotel> hotel, List<Reservation> reservation) {
		System.out.println("Your reservations:");
		for (int i = 0; i < reservation.size(); i++) {
			for (int j = 0; j < hotel.size(); j++) {

				for (int k = 0; k < hotel.get(j).getFloors().size(); k++) {

					for (int m = 0; m < hotel.get(j).getFloors().get(k).getWings().size(); m++) {

						System.out.println(
								hotel.get(j).getName() 
								+ ", Floor: "+ hotel.get(j).getFloors().get(k).getFloorNumber() 
								+ ", Wing: " + hotel.get(j).getFloors().get(k).getWings().get(m).getRooms().get(reservation.get(i).getID()).getWing()
								+ ", Room Number: "+ hotel.get(j).getFloors().get(k).getWings().get(m).getRooms().get(reservation.get(i).getID()).getNumber()
								+ ", Beds: " +  hotel.get(j).getFloors().get(k).getWings().get(m).getRooms().get(reservation.get(i).getID()).getBeds());
					}
				}
			}

		}
	}
}
