package PosProject.Employee;

import java.io.*;
import java.util.Vector;

public class EmployeeManage {
    Vector<Employee> employeeList = new Vector<Employee>();

    public EmployeeManage() {
        FileReader fr = null;
        try {
            fr = new FileReader("./PosProject/Employee/employeeList.txt");
        } catch (FileNotFoundException e) {
            System.out.println("employeeList.txt를 읽을 수 없습니다.");
        }

        BufferedReader br = new BufferedReader(fr);

        String data;
        try {
            while ((data = br.readLine()) != null) {
                String[] p = data.split(" / ");
                this.employeeList.add(new Employee(p[0], p[1], Integer.parseInt(p[2])));
            }
        } catch (IOException e) {
            System.out.println("employeeList.txt를 readline()으로 읽을 수 없습니다.");
        }
    }

    public void save() {
        FileWriter fw = null;
        try {
            fw = new FileWriter("./PosProject/Employee/employeeList.txt");
        } catch (IOException e) {
            System.out.println("employeeList.txt에 쓸 수 없습니다.");
        }

        PrintWriter pw = new PrintWriter(fw);

        for (Employee e : this.employeeList) {
            String data = e.getID() + " / " + e.getPW() + " / " + e.getHourlyPay();
            pw.println(data);
        }
        pw.flush();
    }

    public void add(Employee e) {
        this.employeeList.add(e);
    }

    public void remove(String id) {
        for (int i = 0; i < this.employeeList.size(); i++) {
            if (id.equals(this.employeeList.get(i).getID())) {
                this.employeeList.remove(i);
                break;
            }
        }
    }

    public boolean loginCheck(String id, String pw) {
        for (Employee e : this.employeeList) {
            if (e.loginEquals(id, pw)) {
                return true;
            }
        }
        return false;
    }

    public boolean idCheck(String id) {
        for (Employee e : this.employeeList) {
            if (e.idEquals(id)) {
                return true;
            }
        }
        return false;
    }

    public int getEmployeeHourlyPay(String id) {
        for(Employee e : this.employeeList) {
            if(id.equals(e.getID())) {
                return e.getHourlyPay();
            }
        } 
        return 0;
    }

    public void print() {
        if (this.employeeList.size() == 0) {
            System.out.println("등록된 직원이 없습니다. 직원을 등록해주세요!");
        } else {
            for (Employee e : this.employeeList) {
                e.print();
            }
        }
    }

    public void hourlyPayPrint() {
        for (Employee e : this.employeeList) {
            System.out.println("직원: " + e.getID() + " / 시급: " + e.getHourlyPay());
        }
    }

    public void setHourlyPay(String id, int pay) {
        int idx = -1;
        for(int i = 0; i < this.employeeList.size(); i++) {
            if (id.equals(this.employeeList.get(i).getID())) {
                idx = 1;
                break;
            }
        }

        if (idx < 0) {
            System.out.println("해당 직원은 없는 직원입니다. 다시 확인하고 입력해주세요! ");
            return;
        }

        this.employeeList.get(idx).setHourlyPay(pay);
    }
}