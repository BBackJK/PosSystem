package PosProject.Sales;

import java.io.*;
import java.util.Vector;

public class SalesManage {
    private Vector<Sales> salesList = new Vector<Sales>();

    public SalesManage() {
        FileReader fr = null;
        try {
            fr = new FileReader("./PosProject/Sales/SalesManage.txt");
        } catch (FileNotFoundException e) {
            System.out.println("SalesManage.txt를 찾을 수 없습니다.");
        }

        BufferedReader br = new BufferedReader(fr);
        String data;
        try {
            while ((data = br.readLine()) != null) {
                String[] p = data.split(" / ");
                this.salesList.add(new Sales(p[0], Integer.parseInt(p[1]), p[2]));
            }
        } catch (IOException e) {
            System.out.println("SalesManage.txt를 readLine()으로 읽을 수 없습니다.");
        }
    }

    public void save() {
        FileWriter fw = null;

        try {
            fw = new FileWriter("./PosProject/Sales/SalesManage.txt");
        } catch (IOException e) {
            System.out.println("SalesManage.txt에 쓸 수 없습니다.");
        }

        PrintWriter pw = new PrintWriter(fw);
        for (Sales s : this.salesList) {
            String data = s.getDay() + " / " + s.getTodaySales() + " / " + s.getEmployee();
            pw.println(data);
        }
        pw.flush();
    }

    public void add(Sales s) {
        this.salesList.add(s);
    }

    public void monthDayOfPrint(String day, String month) {
        int i = 0;
        for (Sales s : this.salesList) {
            if (day.equals(s.getOnlyDay()) && month.equals(s.getOnlyMonth())) {
                s.print();
                i = 1;
            }
        }
        if (i == 0) {
            System.out.println("해당 [월]과 [일]에는 개시를 하지 않았습니다. 리스트를 보고 다시 입력해주세요!");
        }
    }

    public int monthTotalSalesPrint(String month) {
        int totalMonthSales = 0;
        int i = 0;
        for (Sales s : this.salesList) {
            if (month.equals(s.getOnlyMonth())) {
                i = 1;
                totalMonthSales += s.getTodaySales();
            }
        }
        if (i == 0) {
            return 0;
        }
        return totalMonthSales;
    }
}