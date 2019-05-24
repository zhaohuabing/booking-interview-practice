package com.zhaohuabing;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.zhaohuabing.HotelRankByReview.Hotel;

/**
 * Problem statement Given a set of hotels and its guests reviews, sort the hotels based on a list
 * of words specified by a user. The criteria to sort the hotels should be how many times the words
 * specified by the user is mentioned in the hotel reviews.
 *
 * Input The first line contains a space-separated set of words which we want to find mentions in
 * the hotel reviews.
 * 
 * The second line contains one integer M, which is the number of reviews.
 * 
 * This is followed by M+M lines, which alternates an hotel ID and a review belonging to that hotel.
 * 
 * Output A list of hotel IDs sorted, in descending order, by how many mentions they have of the
 * words specified in the input.
 * 
 * Notes – The words to be find will always be singe words line ‘breakfast’ or ‘noise’. Never double
 * words like ‘swimming pool’. – Hotel ud is a 4-byte integer. – Words match should be
 * case-insensitive. – Dots and commas should be ignored. – If a word appears in a review twice, it
 * should count twice. – If two hotels have the same number of mentions, they should be sorted in
 * the output based on their ID, smallest ID first. – In case one or more test cases time out,
 * consider revisiting the runtime complexity of your algorithms.
 *
 */
public class HotelRankByReview {
    public static void main(String[] args) {
        Set<String> dict = new HashSet<String>();
        Map<Integer, HotelRankByReview.Hotel> hotels = new HashMap<Integer, HotelRankByReview.Hotel>();

        InputStream fi = HotelRankByReview.class.getResourceAsStream("hotel-reviews");
        Scanner scanner = new Scanner(fi);
        String keywords = scanner.nextLine();
        String[] keyword = keywords.split(" ");
        for (int i = 0; i < keyword.length; i++) {
            System.out.println(keyword[i]);
            dict.add(keyword[i]);
        }

        int reviews = scanner.nextInt();
        scanner.nextLine();
        System.out.println(reviews);
        for (int i = 0; i < reviews; i++) {
            int hotelId = scanner.nextInt();
            scanner.nextLine();
            String review = scanner.nextLine().replaceAll("[,.'!?]", "").toLowerCase();
            String[] words = review.split(" ");
            int occurs = 0;
            for (int j = 0; j < words.length; j++) {
                if (dict.contains(words[j])) {
                    occurs++;
                }
            }
            HotelRankByReview.Hotel hotel = hotels.get(hotelId);
            if (hotel == null) {
                hotel = new HotelRankByReview.Hotel(hotelId, occurs);
            } else {
                hotel.addScore(occurs);
            }
            hotels.put(hotelId, hotel);
        }
        List<HotelRankByReview.Hotel> sorted = new ArrayList<HotelRankByReview.Hotel>(hotels.values());
        Collections.sort(sorted, new Comparator<HotelRankByReview.Hotel>() {

            @Override
            public int compare(Hotel o1, Hotel o2) {
                // TODO Auto-generated method stub
                return o2.score - o1.score;
            }
        });

        Iterator<Hotel> it = sorted.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }


        scanner.close();
    }

    static class Hotel {
        int hotelId;
        int score;

        /**
         * @param hotelId
         * @param occurs
         */
        public Hotel(int hotelId, int score) {
            this.hotelId = hotelId;
            this.score = score;
        }

        public void addScore(int score) {
            this.score += score;
        }

        /*
         * (non-Javadoc)
         * 
         * @see java.lang.Object#hashCode()
         */
        @Override
        public int hashCode() {
            return hotelId * 31 + score;
        }

        /*
         * (non-Javadoc)
         * 
         * @see java.lang.Object#equals(java.lang.Object)
         */
        @Override
        public boolean equals(Object obj) {
            Hotel another = (Hotel) obj;
            if (this.hotelId == another.hotelId) {
                return true;
            }
            return false;
        }

        /*
         * (non-Javadoc)
         * 
         * @see java.lang.Object#toString()
         */
        @Override
        public String toString() {
            // TODO Auto-generated method stub
            return "Hotele id: " + hotelId + " Score: " + score;
        }

    }
}
