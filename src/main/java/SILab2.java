import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Time {
    int hours;
    int minutes;
    int seconds;

    public Time(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getSeconds() {
        return seconds;
    }
};

public class SILab2 {

    public  static List<Integer> function(List<Time> timesList) {
        List<Integer> result = new ArrayList<>(); // 1


        for (int i = 0; i < timesList.size(); i++) { // 2
            int hr = timesList.get(i).getHours();
            int min = timesList.get(i).getMinutes();
            int sec = timesList.get(i).getSeconds();
            if (hr < 0 || hr > 24){ // 3
                if (hr < 0){ // 4
                    throw new RuntimeException("The hours are smaller than the minimum"); // 5
                }
                else {
                    throw new RuntimeException("The hours are grater than the maximum"); // 6
                }
            }
            else if (hr < 24) { // 7
                if (min < 0 || min > 59) // 8
                    throw new RuntimeException("The minutes are not valid!"); // 9
                else {
                    if (sec >= 0 && sec <= 59) // 10
                        result.add(hr * 3600 + min * 60 + sec); // 11
                    else
                        throw new RuntimeException("The seconds are not valid!"); // 12
                }
            }
            else if (hr == 24 && min == 0 && sec == 0) { // 13
                result.add(hr * 3600 + min * 60 + sec); // 14
            }
            else {
                throw new RuntimeException("The time is greater than the maximum"); // 15
            }
        }
        return result; // 16
    } // 17
}