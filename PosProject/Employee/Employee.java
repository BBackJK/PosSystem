package PosProject.Employee;

public class Employee {
    private String id;
    private String pw;

    Employee(String id, String pw) {
        this.id = id;
        this.pw = pw;
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