package com.meiit.webalk.reservation.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.meiit.webalk.reservation.domain.BookingPerson;
import com.meiit.webalk.reservation.domain.Floor;
import com.meiit.webalk.reservation.domain.Hotel;
import com.meiit.webalk.reservation.domain.Reservation;
import com.meiit.webalk.reservation.domain.Room;
import com.meiit.webalk.reservation.domain.Wing;
import com.meiit.webalk.reservation.domain.WingType;

public class RSMethods {

	BookingPerson bperson = new BookingPerson();
	List<Reservation> reservations = new ArrayList<Reservation>();

	public void saveBookingPerson(BookingPerson a) {
		bperson = a;
	}

	public BookingPerson findBookingPerson() {
		return bperson;
	}

	public List<Hotel> findAllHotels() {
		List<Hotel> hotels = new ArrayList<Hotel>();
		hotels.add(Hotelfill());
		return hotels;
	}

	public Hotel Hotelfill() {
<<<<<<< HEAD

		BigDecimal r1price = BigDecimal.valueOf(5000);
		BigDecimal r2price = BigDecimal.valueOf(15000);
		BigDecimal r3price = BigDecimal.valueOf(2000);
		BigDecimal r4price = BigDecimal.valueOf(5000);

		Hotel hotel = new Hotel();
		hotel.setAdress("Hotelc�m:");
		hotel.setName("Hilton");
		hotel.setStars(4);

		List<Floor> floors = new ArrayList<Floor>();
		Floor fl1 = new Floor();
		fl1.setFloorNumber(1);
		fl1.setHotel(hotel);

		List<Wing> wings = new ArrayList<Wing>();
		Wing wing = new Wing();
		wing.setDescription("North");
		wing.setFloor(fl1);

		List<Room> rooms = new ArrayList<Room>();
		Room r1 = new Room();
		r1.setBalcon(true);
		r1.setBeds(2);
		r1.setNumber(1);
		r1.setPrice(r1price);
		r1.setWing(WingType.NORTH);
		rooms.add(r1);

		Room r2 = new Room();
		r2.setBalcon(true);
		r2.setBeds(4);
		r2.setNumber(2);
		r2.setPrice(r2price);
		r2.setWing(WingType.NORTH);
		rooms.add(r2);

		Room r3 = new Room();
		r3.setBalcon(true);
		r3.setBeds(1);
		r3.setNumber(3);
		r3.setPrice(r3price);
		r3.setWing(WingType.NORTH);
		rooms.add(r3);

		Room r4 = new Room();
		r4.setBalcon(true);
		r4.setBeds(2);
		r4.setNumber(4);
		r4.setPrice(r4price);
		r4.setWing(WingType.NORTH);
		rooms.add(r4);

		wing.setRooms(rooms);
		wings.add(wing);

		fl1.setWings(wings);
		floors.add(fl1);

		hotel.setFloors(floors);
		return hotel;

=======
		
		int r1price=5000;
		int r2price=15000;
		int r3price=2000;
		int r4price=5000;
		int euro=364;
		int usd=307;
		
		//Never use sitch case its risky..
		//Hotel data is not depends on the currency!! The switch case is useless in here
		switch (bperson.getCurrency()) {
		case HUF: {
			Hotel hotel = new Hotel();
			hotel.setAdress("Hotelcím:");
			hotel.setName("Hilton");
			hotel.setStars(4);

			List<Floor> floors = new ArrayList<Floor>();
			Floor fl1 = new Floor();
			fl1.setFloorNumber(1);
			fl1.setHotel(hotel);

			List<Wing> wings = new ArrayList<Wing>();
			Wing wing = new Wing();
			wing.setDescription("North");
			wing.setFloor(fl1);

			List<Room> rooms = new ArrayList<Room>();
			Room r1 = new Room();
			r1.setBalcon(true);
			r1.setBeds(2);
			r1.setNumber(1);
			r1.setPrice(r1price);
			r1.setWing(WingType.NORTH);
			rooms.add(r1);

			Room r2 = new Room();
			r2.setBalcon(true);
			r2.setBeds(4);
			r2.setNumber(2);
			r2.setPrice(r2price);
			r2.setWing(WingType.NORTH);
			rooms.add(r2);

			Room r3 = new Room();
			r3.setBalcon(true);
			r3.setBeds(1);
			r3.setNumber(3);
			r3.setPrice(r3price);
			r3.setWing(WingType.NORTH);
			rooms.add(r3);

			Room r4 = new Room();
			r4.setBalcon(true);
			r4.setBeds(2);
			r4.setNumber(4);
			r4.setPrice(r4price);
			r4.setWing(WingType.NORTH);
			rooms.add(r4);

			wing.setRooms(rooms);
			wings.add(wing);

			fl1.setWings(wings);
			floors.add(fl1);

			hotel.setFloors(floors);
		return hotel;
			
		}
		case EUR: {
			Hotel hotel = new Hotel();
			hotel.setAdress("Hotelcím:");
			hotel.setName("Hilton");
			hotel.setStars(4);

			List<Floor> floors = new ArrayList<Floor>();
			Floor fl1 = new Floor();
			fl1.setFloorNumber(1);
			fl1.setHotel(hotel);

			List<Wing> wings = new ArrayList<Wing>();
			Wing wing = new Wing();
			wing.setDescription("North");
			wing.setFloor(fl1);

			List<Room> rooms = new ArrayList<Room>();
			Room r1 = new Room();
			r1.setBalcon(true);
			r1.setBeds(2);
			r1.setNumber(1);
			r1.setPrice(r1price/euro);
			r1.setWing(WingType.NORTH);
			rooms.add(r1);

			Room r2 = new Room();
			r2.setBalcon(true);
			r2.setBeds(4);
			r2.setNumber(2);
			r2.setPrice(r2price/euro);
			r2.setWing(WingType.NORTH);
			rooms.add(r2);

			Room r3 = new Room();
			r3.setBalcon(true);
			r3.setBeds(1);
			r3.setNumber(3);
			r3.setPrice(r3price/euro);
			r3.setWing(WingType.NORTH);
			rooms.add(r3);

			Room r4 = new Room();
			r4.setBalcon(true);
			r4.setBeds(2);
			r4.setNumber(4);
			r4.setPrice(r4price/euro);
			r4.setWing(WingType.NORTH);
			rooms.add(r4);

			wing.setRooms(rooms);
			wings.add(wing);

			fl1.setWings(wings);
			floors.add(fl1);

			hotel.setFloors(floors);
		return hotel;
			
		}
		case USD: {
			Hotel hotel = new Hotel();
			hotel.setAdress("Hotelcím:");
			hotel.setName("Hilton");
			hotel.setStars(4);

			List<Floor> floors = new ArrayList<Floor>();
			Floor fl1 = new Floor();
			fl1.setFloorNumber(1);
			fl1.setHotel(hotel);

			List<Wing> wings = new ArrayList<Wing>();
			Wing wing = new Wing();
			wing.setDescription("North");
			wing.setFloor(fl1);

			List<Room> rooms = new ArrayList<Room>();
			Room r1 = new Room();
			r1.setBalcon(true);
			r1.setBeds(2);
			r1.setNumber(1);
			r1.setPrice(r1price/usd);
			r1.setWing(WingType.NORTH);
			rooms.add(r1);

			Room r2 = new Room();
			r2.setBalcon(true);
			r2.setBeds(4);
			r2.setNumber(2);
			r2.setPrice(r2price/usd);
			r2.setWing(WingType.NORTH);
			rooms.add(r2);

			Room r3 = new Room();
			r3.setBalcon(true);
			r3.setBeds(1);
			r3.setNumber(3);
			r3.setPrice(r3price/usd);
			r3.setWing(WingType.NORTH);
			rooms.add(r3);

			Room r4 = new Room();
			r4.setBalcon(true);
			r4.setBeds(2);
			r4.setNumber(4);
			r4.setPrice(r4price/euro);
			r4.setWing(WingType.NORTH);
			rooms.add(r4);

			wing.setRooms(rooms);
			wings.add(wing);

			fl1.setWings(wings);
			floors.add(fl1);

			hotel.setFloors(floors);
		return hotel;		
		}
		default:
			return Hotelfill();
		}
		
		
	}
>>>>>>> 1e1e5cea61bca8e9086527ebe4871191f8f316d7
	
	}

	public void saveReservation(Reservation r) {
		//Reservation is processed after check out
		r.setProcessed(true);
		reservations.add(r);

	}

	public List<Reservation> findAllReservations() {
		return reservations;
	}

	public void checkIn() {
		//1 person how able to check in more than 1 place? 
		for (int i = 0; i < reservations.size(); i++) {
			reservations.get(i).setActive(true);
		}
	}

	public void checkOut() {
		//same like check in
		//Refund should be here
		for (int i = 0; i < reservations.size(); i++) {
			reservations.get(i).setActive(false);
		}

	}
}
