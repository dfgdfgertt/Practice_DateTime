import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] main) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();

        //System.out.print("Ngày: ");
        //int day = input.nextInt();

        //System.out.print("Tháng: ");
        //int month = input.nextInt();

        //System.out.print("Năm: ");
        //int year = input.nextInt();

        //System.out.print("Giờ: ");
        //int hour = input.nextInt();

        //System.out.print("Phút: ");
        //int min = input.nextInt();

        //System.out.print("Giây: ");
        //int sec = input.nextInt();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        int day = random.nextInt(27)+1;
        int month = random.nextInt(11);
        int year = random.nextInt(200);
        int hour = random.nextInt(23)+1;
        int min = random.nextInt(59)+1;
        int sec = random.nextInt(59)+1;
        System.out.format("%d/%d/%d %d:%d:%d\n",day,month+1,year+1900,hour,min,sec);

        Date date = new Date();
        System.out.println(formatter.format(date));
        date.setDate(day);
        date.setMonth(month);
        date.setYear(year);
        date.setHours(hour);
        date.setMinutes(min);
        date.setSeconds(sec);

       // System.out.println("Tính sang giây bằng: "+toSec(day,month+1,year+1900,hour,min,sec)+" giây");


        System.out.println(formatter.format(date));
        long ts = date.getTime()/1000;
        System.out.println(ts);


    }

    public static boolean yearCheck(int year){
        if ((year%4 == 0 && year%100 != 0) || (year%400 == 0))
        {
            return true;
        }
        else{
            return false;
        }
    }

    public static int days(int month, int year){
        if (month > 12 || month < 1)
            return 0;
        else if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)
            return 31;
        else if (month == 4 || month == 6 || month == 9 || month == 11)
            return 30;
        else if (((year%4 == 0 && year%100 != 0) || (year%400 == 0))  && month == 2 )
            return 29;
        else
            return 28;
    }

    public static long toSec(int day, int month , int year , int hour , int min , int sec){
        //System.out.format("%d/%d/%d %d:%d:%d\n",day,month,year,hour,min,sec);
        long result = 0;
        // trong 1 ngày nè
        result += sec + (min*60) + (hour*60*60) + (day*24*60*60);
        //tháng/ năm nhuận nè
        for (int i = 1; i <= month; i++) {
            result+=(days(i,year))*24*60*60;
        }
        //nam tu do den gio
        for (int i = 1970; i < year; i++) {
            if (yearCheck(i)) {
                result+= 366*24*60*60;
            }
            else
                result+= 365*24*60*60;
        }
        return result;
    }

    public static void secToDate(long sec){

    }

}
