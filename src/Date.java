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
        this(ld.getYear(), ld.getMonthValue(), ld.getDayOfMonth());
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
        return new Date(toLocalDate().plusDays(d));
    }
    public Date minusDays(int d) {
        return new Date(toLocalDate().minusDays(d));
    }
    public boolean isLeap(Date date){
        return date.toLocalDate().isLeapYear();
    }
    public boolean isAfter(Date date1, Date date2){ return date1.toLocalDate().isAfter(date2.toLocalDate()); }
    public boolean isBefore(Date date1, Date date2){ return date1.toLocalDate().isBefore(date2.toLocalDate()); }
    public boolean isEqual(Date date1, Date date2){ return date1.toLocalDate().isEqual(date2.toLocalDate()); }
    public int daysBetween(Date date1, Date date2) {
        LocalDate ldate1 = date1.toLocalDate();
        LocalDate ldate2 = date2.toLocalDate();
        return (int) ChronoUnit.DAYS.between(ldate1, ldate2);
    }
}
