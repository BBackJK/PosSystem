package PosProject.Sales;

public class Sales {
    private String day;
    private int todaySales;

    public Sales(String day, int todaySales) {
        this.day = day;
        this.todaySales = todaySales;
    }

    public int getTodaySales() {
        return this.todaySales;
    }

    public String getDay() {
        return this.day;
    }

    public String getOnlyDay() {
        String[] onlyDay = this.day.split("-");

        return onlyDay[2];
    }

    public String getOnlyMonth() {
        String[] onlyDay = this.day.split("-");

        return onlyDay[1];
    }

    public void setTodaySales(int todaySales) {
        this.todaySales = todaySales;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public void print() {
        System.out.println("판매 날짜: " + this.day + " / 매출액 : " + this.todaySales);
    }
}
