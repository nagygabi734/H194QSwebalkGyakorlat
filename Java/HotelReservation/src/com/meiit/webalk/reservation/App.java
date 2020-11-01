package com.meiit.webalk.reservation;

import java.util.Scanner;

import com.meiit.webalk.reservation.domain.*;
import com.meiit.webalk.reservation.service.*;
import com.meiit.webalk.reservation.view.*;

public abstract class App implements View {
	// not bad but you need to split as the UML defined use the methods for the separations
	public static void main(String[] args) {
		RSMethods rsmethods = new RSMethods();
		VMethods vmethods = new VMethods();

		rsmethods.saveBookingPerson(vmethods.readBookingPerson());
		vmethods.printWelcomeMessage(rsmethods.findBookingPerson());
		vmethods.printBalance(rsmethods.findBookingPerson());
		
		do {

			vmethods.printRooms(rsmethods.findAllHotels());
			Room room = vmethods.selectRoom(rsmethods.findAllHotels());

			if (vmethods.parseCheck()) {

				if (rsmethods.findBookingPerson().getBalance().intValue() >= room.getPrice().intValue()) {
					Reservation reservation = new Reservation();
					reservation.setActive(false);
					reservation.setAmmount(room.getPrice());
					reservation.setBookingperson(rsmethods.findBookingPerson());
					reservation.setFrom(null);
					reservation.setTo(null);
					reservation.setProcessed(false);
					reservation.setCurrency(rsmethods.findBookingPerson().getCurrency());
					rsmethods.findBookingPerson().setBalance(rsmethods.findBookingPerson().getBalance().subtract(reservation.getAmmount()));
					rsmethods.saveReservation(reservation);
					vmethods.printReservationSaved(reservation);
					vmethods.printReservationDetails(rsmethods.findAllHotels(), Integer.parseInt(vmethods.sroom) - 1);
				} else {
					vmethods.printNotEnoughBalance(rsmethods.findBookingPerson());
				}
				vmethods.printBalance(rsmethods.findBookingPerson());

			}

		} while (vmethods.parseCheck());
		vmethods.printReservedRooms(rsmethods.findAllHotels(), rsmethods.findAllReservations());
		vmethods.printCheckIn(rsmethods.findAllReservations());
		vmethods.printCheckOut(rsmethods.findBookingPerson(), rsmethods.findAllReservations());
	}
<<<<<<< HEAD
=======
		//NEver leav unsused code in the repo
		/*
		 * switch (rsmethods.findBookingPerson().getCurrency()) { case HUF: { do {
		 * 
		 * vmethods.printRooms(rsmethods.findAllHotels()); Room room =
		 * vmethods.selectRoom(rsmethods.findAllHotels());
		 * 
		 * if (vmethods.parseCheck()) {
		 * 
		 * if (rsmethods.findBookingPerson().getBalance() >= room.getPrice()) {
		 * Reservation reservation = new Reservation(); reservation.setActive(false);
		 * reservation.setAmmount(room.getPrice());
		 * reservation.setBookingperson(rsmethods.findBookingPerson());
		 * reservation.setFrom(null); reservation.setTo(null);
		 * reservation.setProcessed(false);
		 * reservation.setCurrency(rsmethods.findBookingPerson().getCurrency());
		 * rsmethods.findBookingPerson().setBalance(rsmethods.findBookingPerson().
		 * getBalance() - reservation.getAmmount());
		 * rsmethods.saveReservation(reservation);
		 * vmethods.printReservationSaved(reservation);
		 * vmethods.printReservationDetails(rsmethods.findAllHotels(),
		 * Integer.parseInt(vmethods.sroom) - 1); } else {
		 * vmethods.printNotEnoughBalance(rsmethods.findBookingPerson()); }
		 * vmethods.printBalance(rsmethods.findBookingPerson());
		 * 
		 * }
		 * 
		 * } while (vmethods.parseCheck());
		 * vmethods.printReservedRooms(rsmethods.findAllHotels(),
		 * rsmethods.findAllReservations());
		 * vmethods.printCheckIn(rsmethods.findAllReservations());
		 * vmethods.printCheckOut(rsmethods.findBookingPerson(),
		 * rsmethods.findAllReservations()); break; } case EUR: { do {
		 * 
		 * vmethods.printRooms(rsmethods.findAllHotels()); Room room =
		 * vmethods.selectRoom(rsmethods.findAllHotels());
		 * 
		 * if (vmethods.parseCheck()) {
		 * 
		 * if (rsmethods.findBookingPerson().getBalance() >= room.getPrice()) {
		 * Reservation reservation = new Reservation(); reservation.setActive(false);
		 * reservation.setAmmount(room.getPrice());
		 * reservation.setBookingperson(rsmethods.findBookingPerson());
		 * reservation.setFrom(null); reservation.setTo(null);
		 * reservation.setProcessed(false);
		 * reservation.setCurrency(rsmethods.findBookingPerson().getCurrency());
		 * rsmethods.findBookingPerson().setBalance(rsmethods.findBookingPerson().
		 * getBalance() - reservation.getAmmount());
		 * rsmethods.saveReservation(reservation);
		 * vmethods.printReservationSaved(reservation);
		 * vmethods.printReservationDetails(rsmethods.findAllHotels(),
		 * Integer.parseInt(vmethods.sroom) - 1); } else {
		 * vmethods.printNotEnoughBalance(rsmethods.findBookingPerson()); }
		 * vmethods.printBalance(rsmethods.findBookingPerson());
		 * 
		 * }
		 * 
		 * } while (vmethods.parseCheck());
		 * vmethods.printReservedRooms(rsmethods.findAllHotels(),
		 * rsmethods.findAllReservations());
		 * vmethods.printCheckIn(rsmethods.findAllReservations());
		 * vmethods.printCheckOut(rsmethods.findBookingPerson(),
		 * rsmethods.findAllReservations()); break; } case USD: { do {
		 * vmethods.printRooms(rsmethods.findAllHotels()); Room room =
		 * vmethods.selectRoom(rsmethods.findAllHotels());
		 * 
		 * if (vmethods.parseCheck()) {
		 * 
		 * if (rsmethods.findBookingPerson().getBalance() >= room.getPrice()) {
		 * Reservation reservation = new Reservation(); reservation.setActive(false);
		 * reservation.setAmmount(room.getPrice());
		 * reservation.setBookingperson(rsmethods.findBookingPerson());
		 * reservation.setFrom(null); reservation.setTo(null);
		 * reservation.setProcessed(false);
		 * reservation.setCurrency(rsmethods.findBookingPerson().getCurrency());
		 * rsmethods.findBookingPerson().setBalance(rsmethods.findBookingPerson().
		 * getBalance() - reservation.getAmmount());
		 * rsmethods.saveReservation(reservation);
		 * vmethods.printReservationSaved(reservation);
		 * vmethods.printReservationDetails(rsmethods.findAllHotels(),
		 * Integer.parseInt(vmethods.sroom) - 1); } else {
		 * vmethods.printNotEnoughBalance(rsmethods.findBookingPerson()); }
		 * vmethods.printBalance(rsmethods.findBookingPerson());
		 * 
		 * }
		 * 
		 * } while (vmethods.parseCheck());
		 * vmethods.printReservedRooms(rsmethods.findAllHotels(),
		 * rsmethods.findAllReservations());
		 * vmethods.printCheckIn(rsmethods.findAllReservations());
		 * vmethods.printCheckOut(rsmethods.findBookingPerson(),
		 * rsmethods.findAllReservations()); break; }
		 */

		

>>>>>>> 1e1e5cea61bca8e9086527ebe4871191f8f316d7
}
