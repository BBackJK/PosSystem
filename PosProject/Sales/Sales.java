package PosProject.Sales;

public class Sales {
    private String day;
    private int todaySales;
    private String employee;

    public Sales(String day, int todaySales, String employee) {
        this.day = day;
        this.todaySales = todaySales;
        this.employee = employee;
    }

    public int getTodaySales() {
        return this.todaySales;
    }

    public String getDay() {
        return this.day;
    }
    
    public String getEmployee() {
        return this.employee;
    }

    public String getOnlyDay() {
        String[] onlyDay = this.day.split("-");

        return onlyDay[2];
    }

    public String getOnlyMonth() {
        String[] onlyMonth = this.day.split("-");

        return onlyMonth[1];
    }

    public void setTodaySales(int todaySales) {
        this.todaySales = todaySales;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public void print() {
        System.out.println("판매 날짜: " + this.day + " / 매출액 : " + this.todaySales + " / 근무자 : " + this.employee);
    }
}
