package PosProject.Employee;

public class Employee {
    private String id;
    private String pw;
    private int hourlyPay;

    public Employee(String id, String pw, int pay) {
        this.id = id;
        this.pw = pw;
        this.hourlyPay = pay;
    }

    public String getID() {
        return this.id;
    }

    public void setID(String id) {
        this.id = id;
    }

    public String getPW() {
        return this.pw;
    }

    public void setPW(String pw) {
        this.pw = pw;
    }

    public int getHourlyPay() {
        return this.hourlyPay;
    }

    public void setHoulyPay(int pay) {
        this.hourlyPay = pay;
    }

    public void print() {
        System.out.println("ID(이름): " + this.id + " / PW(생년월일): " + this.pw);
    }

    public boolean loginEquals(String id, String pw) {
        if (id.equals(this.id) && pw.equals(this.pw)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean idEquals(String id) {
        if (id.equals(this.id)) {
            return true;
        } else {
            return false;
        }
    }
}