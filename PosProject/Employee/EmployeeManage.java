package PosProject.Employee;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

public class EmployeeManage {
    Vector<Employee> employeeList = new Vector<Employee>();

    public EmployeeManage() {
        FileReader fr = null;
        try {
            fr = new FileReader("./PosProject/Employee/EmployeeList.txt");
        } catch (FileNotFoundException e) {
            System.out.println("EmployeeList.txt를 읽을 수 없습니다.");
        }

        BufferedReader br = new BufferedReader(fr);

        String data;
        try {
            while ((data = br.readLine()) != null) {
                String[] p = data.split(" / ");
                employeeList.add(new Employee(p[0], p[1]));
            }
        } catch (IOException e) {
            System.out.println("EmployeeList.txt를 readline()으로 읽을 수 없습니다.");
        }
    }

    public void save() {
        FileWriter fw = null;
        try {
            fw = new FileWriter("./PosProject/Employee/EmployeeList.txt");
        } catch (IOException e) {
            System.out.println("EmployeeList.txt에 쓸 수 없습니다.");
        }

        PrintWriter pw = new PrintWriter(fw);

        for (Employee e : employeeList) {
            String data = e.getID() + " / " + e.getPW();
            pw.println(data);
        }
        pw.flush();
    }

    public void add(String id, String pw) {
        employeeList.add(new Employee(id, pw));
    }

    public void remove(String id) {
        for (int i = 0; i < employeeList.size(); i++) {
            if (id.equals(employeeList.get(i).getID())) {
                employeeList.remove(i);
                break;
            }
        }
    }

    public boolean loginCheck(String id, String pw) {
        for (Employee e : employeeList) {
            if (e.loginEquals(id, pw)) {
                return true;
            }
        }
        return false;
    }

    public boolean idCheck(String id) {
        for (Employee e : employeeList) {
            if (e.idEquals(id)) {
                return true;
            }
        }
        return false;
    }

    public void print() {
        if (employeeList.size() == 0) {
            System.out.println("등록된 직원이 없습니다. 직원을 등록해주세요!");
        } else {
            for (Employee e : employeeList) {
                e.print();
            }
        }
    }
}