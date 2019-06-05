package com.zhaohuabing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * You are building a small command-line application to calculate hotel availability for a city. Your application reads in two (2) data files, and outputs its answer to STDOUT. 
*Your application will read in: 
*· a list of hotels along with how many rooms each contains (in no particular order) 
*· a list of bookings that have been made (in no particular order) 
*Your application will then print the list of all hotels which have availability for check-in and check- out date range, if any. 
*Do not worry about whether a specific room is available in a hotel for the entire booking period without switching rooms: availability is defined as the hotel having at least one (1) available room for each night of the target stay, regardless of whether it's the same room from day to day. 
*
*Data Files 
*hotels.csv 
*# Name, Rooms 
*Westin, 10 
*Best Western, 20 
*Hilton, 10 
*... 
*
*bookings.csv 
*# Name, Checkin, Checkout 
*Hilton, 2015-04-02, 2015-04-03 
*Hilton, 2015-04-02, 2015-04-04 
*Westin, 2015-05-01, 2015-05-20
 *
 */
public class HotelAvailability {
    Map<String, Integer> hotels = new HashMap<String, Integer>();
    List<Reservation> reservations = new ArrayList<Reservation>();

    public static void main(String args[]) {
        HotelAvailability r = new HotelAvailability();
        r.addHotel("WilliamHotel", 4);
        r.addHotel("RomaHotel", 10);
        r.addReservation(1, 2, "WilliamHotel");
        r.addReservation(1, 4, "RomaHotel");
        r.addReservation(2, 5, "RomaHotel");
        r.solve(1, 19);
    }

    private void solve(int startDate, int endDate) {
        Iterator<Reservation> reservation = reservations.iterator();
        while (reservation.hasNext()) {
            Reservation r = reservation.next();
            if (r.isConflict(startDate, endDate)) {
                hotels.put(r.hotel, hotels.get(r.hotel) - 1);
            }
        }

        Iterator<String> hotel = hotels.keySet().iterator();
        while (hotel.hasNext()) {
            String hotelName = hotel.next();
            System.out.println("Available rooms of " + hotelName + "： " + hotels.get(hotelName));
        }

    }

    private void addReservation(int startDate, int endDate, String hotel) {
        reservations.add(new Reservation(startDate, endDate, hotel));
    }

    private void addHotel(String name, int room) {
        hotels.put(name, room);
    }
}


class Reservation {
    int startDate;
    int endDate;
    String hotel;

    public Reservation(int startDate, int endDate, String hotel) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.hotel = hotel;
    }

    /**
     * @param startDate2
     * @param endDate2
     * @return
     */
    public boolean isConflict(int startDate2, int endDate2) {
        if (this.startDate >= startDate2 && this.endDate <= endDate2) {
            return true;
        }
        return false;
    }
}


