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
}
