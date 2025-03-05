import java.util.Scanner;

public class Bai64DaysOfAMonth {
    public static void main(String[] args) {
        int days;
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Please enter the year: ");
        int year = Integer.valueOf(keyboard.nextLine());
        while (year < 0) {
            System.out.println("Invalid year, please enter year again:");
            year = Integer.valueOf(keyboard.nextLine());
        }

        System.out.println("Please enter the month of that year:");
        String inputmonth = keyboard.nextLine();
        int checkvalid_month = 0; // default false value

        while (checkvalid_month == 0) {
            if (inputmonth.equals("January") || inputmonth.equals("Jan.")
                    || inputmonth.equals("Jan")
                    || inputmonth.equals("1")) {
                checkvalid_month = 1;
                break;
            } else if (inputmonth.equals("Febuary") || inputmonth.equals("Feb.")
                    || inputmonth.equals("Feb")
                    || inputmonth.equals("2")) {
                checkvalid_month = 2;
                break;
            } else if (inputmonth.equals("March") || inputmonth.equals("Mar.")
                    || inputmonth.equals("Mar")
                    || inputmonth.equals("3")) {
                checkvalid_month = 3;
                break;
            } else if (inputmonth.equals("April") || inputmonth.equals("Apr.")
                    || inputmonth.equals("Apr")
                    || inputmonth.equals("4")) {
                checkvalid_month = 4;
                break;
            } else if (inputmonth.equals("May")
                    || inputmonth.equals("5")) {
                checkvalid_month = 5;
                break;
            } else if (inputmonth.equals("June") || inputmonth.equals("Jun")
                    || inputmonth.equals("6")) {
                checkvalid_month = 3;
                break;
            } else if (inputmonth.equals("July") || inputmonth.equals("Jul")
                    || inputmonth.equals("7")) {
                checkvalid_month = 7;
                break;
            } else if (inputmonth.equals("August") || inputmonth.equals("Aug.")
                    || inputmonth.equals("Aug")
                    || inputmonth.equals("8")) {
                checkvalid_month = 8;
                break;
            } else if (inputmonth.equals("September") || inputmonth.equals("Sep.")
                    || inputmonth.equals("Sep")
                    || inputmonth.equals("9")) {
                checkvalid_month = 9;
                break;
            } else if (inputmonth.equals("October") || inputmonth.equals("Oct.")
                    || inputmonth.equals("Oct")
                    || inputmonth.equals("10")) {
                checkvalid_month = 10;
                break;
            } else if (inputmonth.equals("November") || inputmonth.equals("Nov.")
                    || inputmonth.equals("Nov")
                    || inputmonth.equals("11")) {
                checkvalid_month = 11;
                break;
            } else if (inputmonth.equals("December") || inputmonth.equals("Dec.")
                    || inputmonth.equals("Dec")
                    || inputmonth.equals("12")) {
                checkvalid_month = 12;
                break;
            }
            System.out.println("Invalid month, please enter the month of that year:");
            inputmonth = keyboard.nextLine();

        }
        int month = checkvalid_month;
        if (year % 100 == 0 && year % 400 != 0) {
            // not lean
            days = NormalYearDays(month);
        } else if (year % 4 == 0) {
            // leap
            days = LeapYearDays(month);
        } else {
            // not leap
            days = NormalYearDays(month);
        }
        
        System.out.println("month "+month + " of " + year + " has " + days + " days");
        keyboard.close();
    }

    public static int NormalYearDays(int month) {
        int days;
        if (month == 1 || month == 3 || month == 5 || month == 7
                || month == 8 || month == 10 || month == 12) {
            days = 31;
        } else if (month == 2) {
            days = 28;
        } else {
            days = 30;
        }
        return days; 
    }

    public static int LeapYearDays(int month) {
        int days;
        if (month == 2) {
            days = 29;
            return days;
        } else {
            return NormalYearDays(month);
        }
    }
}
