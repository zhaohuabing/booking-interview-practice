/**
 * Sort hotels by average score. Each line of input had the hotel ID and a review score.
 *
 * E.g.
 *
 * 1000 4 1000 7 2000 10 2000 8
 */
package com.zhaohuabing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Sort hotels by average score
 *
 */
public class HotelRankByScore {
    public static List<Hotel> Sort(String input) {
        Map<Integer, Hotel> hotels = new HashMap<Integer, Hotel>();

        Scanner scanner = new Scanner(input);
        while (scanner.hasNextLine()) {
            int hotelId = scanner.nextInt();
            int score = scanner.nextInt();

            Hotel hotel = hotels.get(hotelId);
            if (hotel == null) {
                hotel = new Hotel(hotelId);
            }
            hotel.addScore(score);
            hotels.put(hotelId, hotel);
        }
        scanner.close();
        List<Hotel> result = new ArrayList<Hotel>();
        Iterator<Hotel> it = hotels.values().iterator();
        while (it.hasNext()) {
            result.add(it.next());
        }
        Collections.sort(result);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }

        return result;
    }

    public static void main(String[] args) {
        String input = "1000 4";
        input += System.lineSeparator();
        input += "1000 7";
        input += System.lineSeparator();
        input += "2000 10";
        input += System.lineSeparator();
        input += "2000 8";
        HotelRankByScore.Sort(input);
    }
}


class Hotel implements Comparable<Hotel> {
    int id;
    double totalScore;
    double reviewCount;

    public Hotel(int id) {
        this.id = id;
    }

    public void addScore(int score) {
        this.totalScore += score;
        this.reviewCount += 1;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    @Override
    public int compareTo(Hotel o) {
        double diff = totalScore / reviewCount - o.totalScore / o.reviewCount;
        if (diff < 0) {
            return -1;
        } else if (diff == 0) {
            return 0;
        } else {
            return 1;
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Hotel [id=" + id + ", averge score=" + totalScore / reviewCount + "]";
    }


}
