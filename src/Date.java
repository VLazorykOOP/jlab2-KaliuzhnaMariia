import java.util.Scanner;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
public class Date {
    private byte year;
    private byte month;
    private byte day;
//Constructors
    public Date(){
        year = 0;
        month = 0;
        day = 0;
    }
    public Date(String dates){
        String[]parts = dates.split("\\.");
        if(parts.length == 3){
           this.year = Byte.parseByte(parts[0]);
            this.month = Byte.parseByte(parts[1]);
            this.day = Byte.parseByte(parts[2]);
        }else{
            System.out.println("Invalid date");
        }
    }
    public Date(LocalDate ld){
        this.year = (byte) ld.getYear();
        this.month = (byte) ld.getMonthValue();
        this.day = (byte) ld.getDayOfMonth();
    }

//Methods
    public byte getYear(){
        return year;
    }
    public void setDay(byte day) {
        this.day = day;
    }
    public byte getMonth() {
        return month;
    }
    public void setMonth(byte month) {
        this.month = month;
    }
    public byte getDay() {
        return day;
    }
    public void setYear(byte year) {
        this.year = year;
    }
    private LocalDate toLocalDate() {
        return LocalDate.of(year, month, day);
    }
    @Override
    public String toString() {
        return year + "." + month + "." + day;
    }

    //Operations
    public void addDate(int d){
        LocalDate ld = toLocalDate().plusDays(d);
        this.year = (byte) ld.getYear();
        this.month = (byte) ld.getMonthValue();
        this.day = (byte) ld.getDayOfMonth();
    }
    public void minusDate(int d) {
        LocalDate ld = toLocalDate().minusDays(d);
        this.year = (byte) ld.getYear();
        this.month = (byte) ld.getMonthValue();
        this.day = (byte) ld.getDayOfMonth();
    }
    public boolean isLeap(){
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
    public int compareDate(Date other){
        if (year != other.year){
            return Integer.compare(year, other.year);
        }
        if(month != other.month) {
            return Integer.compare(month, other.month);
        }
            return Integer.compare(day, other.day);
    }
    public int daysBetween(Date other) {
        LocalDate thisDate = toLocalDate();
        LocalDate otherDate = other.toLocalDate();
        return (int) ChronoUnit.DAYS.between(thisDate, otherDate);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the first data (year.month.day): ");
        String inputDate1 = in.nextLine();
        Date date1 = new Date(inputDate1);
        System.out.print("Enter the second data (year.month.day): ");
        String inputDate2 = in.nextLine();
        Date date2 = new Date(inputDate2);
        Date initialDate1 = new Date(date1.toString());
        Date initialDate2 = new Date(date2.toString());

        System.out.println("Date 1: " + date1);
        System.out.println("Date 2: " + date2);

        int res = date1.compareDate(date2);
        if (res < 0){
            System.out.println("Date 1 before Date 2");
        }else if(res > 0){
            System.out.println("Date 1 after Date 2");
        } else{
            System.out.println("Date 1 equal to Date 2");
        }

        System.out.println("Enter the number of days: ");
        int d = in.nextInt();
        date1.addDate(d);
        date2.addDate(d);
        System.out.println("Date 1 after adding: " + date1);
        System.out.println("Date 2 after adding: " + date2);
        date1 = initialDate1;
        date2 = initialDate2;
        date1.minusDate(d);
        date2.minusDate(d);
        System.out.println("Date 1 after minus: " + date1);
        System.out.println("Date 2 after minus: " + date2);
        date1 = initialDate1;
        date2 = initialDate2;

        System.out.println("Is year of Date 1 leap: " + date1.isLeap());
        System.out.println("Is year of Date 2 leap: " + date2.isLeap());

        int db = date1.daysBetween(date2);
        System.out.println("Amount of days between Date 1 and Date 2: " + db);
    }
}
