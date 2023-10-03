import java.util.Scanner;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
public class Date {
    private byte year;
    private byte month;
    private byte day;
//Constructors
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
    public Date(int year, int month, int day){
        this.year = (byte) year;
        this.month = (byte) month;
        this.day = (byte) day;
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
    public Date addDays(int d){
        LocalDate ld = toLocalDate().plusDays(d);
        return new Date((byte) ld.getYear(), (byte) ld.getMonthValue(), (byte) ld.getDayOfMonth());
    }
    public Date minusDays(int d) {
        LocalDate ld = toLocalDate().minusDays(d);
        return new Date((byte) ld.getYear(), (byte) ld.getMonthValue(), (byte) ld.getDayOfMonth());
    }
    public boolean isLeap(Date date){
        LocalDate ldate = date.toLocalDate();
        if (ldate.isLeapYear()){
            return true;
        }
        return false;
    }
    public boolean isAfter(Date date1, Date date2){
        LocalDate ldate1 = date1.toLocalDate();
        LocalDate ldate2 = date2.toLocalDate();
        if (ldate1.isAfter(ldate2)) {
            return true;
        }
        return false;
    }
    public boolean isBefore(Date date1, Date date2){
        LocalDate ldate1 = date1.toLocalDate();
        LocalDate ldate2 = date2.toLocalDate();
        if (ldate1.isBefore(ldate2)) {
            return true;
        }
        return false;
    }
    public boolean isEqual(Date date1, Date date2){
        LocalDate ldate1 = date1.toLocalDate();
        LocalDate ldate2 = date2.toLocalDate();
        if (ldate1.isEqual(ldate2)) {
            return true;
        }
        return false;
    }
    public int daysBetween(Date date1, Date date2) {
        LocalDate ldate1 = date1.toLocalDate();
        LocalDate ldate2 = date2.toLocalDate();
        return (int) ChronoUnit.DAYS.between(ldate1, ldate2);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the first data (year.month.day): ");
        String inputDate1 = in.nextLine();
        Date date1 = new Date(inputDate1);
        System.out.print("Enter the second data (year.month.day): ");
        String inputDate2 = in.nextLine();
        Date date2 = new Date(inputDate2);

        System.out.println("Date 1: " + date1);
        System.out.println("Date 2: " + date2);

        System.out.println("Is Date 1 before Date 2: " + date1.isBefore(date1, date2));
        System.out.println("Is Date 1 after Date 2: " + date1.isAfter(date1, date2));
        System.out.println("Is Date 1 equal to Date 2: " + date1.isEqual(date1, date2));

        System.out.println("Enter the number of days: ");
        int d = in.nextInt();
        Date addate1 = date1.addDays(d);
        Date addate2 = date2.addDays(d);
        System.out.println("Date 1 after adding: " + addate1);
        System.out.println("Date 2 after adding: " + addate2);
        Date mindate1 = date1.minusDays(d);
        Date mindate2 = date2.minusDays(d);
        System.out.println("Date 1 after minus: " + mindate1);
        System.out.println("Date 2 after minus: " + mindate2);

        System.out.println("Is year of Date 1 leap: " + date1.isLeap(date1));
        System.out.println("Is year of Date 2 leap: " + date2.isLeap(date2));

        int db = date1.daysBetween(date1, date2);
        System.out.println("Amount of days between Date 1 and Date 2: " + db);
    }
}
