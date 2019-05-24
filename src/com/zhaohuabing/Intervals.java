package com.zhaohuabing;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Given a list of intervals,e.g.[1,4],[2,5],[6,7],merge overlapping intervals,e.g.*[1,5],[6,7].
 * 
 * @author Huabing Zhao
 *
 */
public class Intervals {
    public static Interval[] merge(Interval[] input) {
        Set<Interval> tmp = new TreeSet<Interval>();

        for (int i = 0; i < input.length; i++) {
            tmp.add(input[i]);
        }


        Interval[] intervals = new Interval[tmp.size()];

        tmp.toArray(intervals);
        for (int i = 0; i < intervals.length; i++) {
            System.out.println(intervals[i]);
        }
        System.out.println("******************");
        List<Interval> output = new ArrayList<Interval>();
        for (int i = 0; i < intervals.length;) {
            Interval interval = intervals[i];
            if (i == intervals.length - 1) {
                output.add(interval);
            }

            int j = i + 1;
            for (; j < intervals.length; j++) {
                if (interval.isOverlapped(intervals[j])) {
                    interval = interval.merge(intervals[j]);
                    if (j == intervals.length - 1) {
                        output.add(interval);
                    }
                } else {
                    output.add(interval);
                    break;
                }
            }
            i = j;
        }
        for (int i = 0; i < output.size(); i++) {
            System.out.println(output.get(i));
        }
        System.out.println("******************");
        return output.toArray(new Interval[output.size()]);

    }

    public static void main(String[] args) {
        Intervals.merge(new Interval[] {new Interval(6, 9), new Interval(10, 15), new Interval(1, 2),
                        new Interval(2, 3), new Interval(1, 2), new Interval(4, 7), new Interval(11, 20)});
    }
}


class Interval implements Comparable<Interval> {
    int start;
    int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public boolean isOverlapped(Interval another) {
        if (this.end < another.start) {
            return false;
        }
        if (another.end < this.start) {
            return false;
        }
        return true;
    }

    public Interval merge(Interval another) {
        if (!this.isOverlapped(another)) {
            throw new RuntimeException("No overlapping!");
        }
        int start;
        int end;
        if (this.start < another.start) {
            start = this.start;
        } else {
            start = another.start;
        }
        if (this.end > another.end) {
            end = this.end;
        } else {
            end = another.end;
        }
        return new Interval(start, end);
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this.start == ((Interval) obj).start && this.end == ((Interval) obj).end) {
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
        return "[" + this.start + ", " + this.end + "]";
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    @Override
    public int compareTo(Interval another) {
        if (this.start == another.start) {
            return this.end - another.end;
        }
        return this.start - another.start;
    }
}
