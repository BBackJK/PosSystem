package PosProject.Employee;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

public class CommuteManage {
    private SimpleDateFormat format = new SimpleDateFormat("HH:mm");
    private Vector<Commute> commuteList = new Vector<Commute>();

    public CommuteManage() {
        FileReader fr = null;
        try {
            fr = new FileReader("./PosProject/Employee/CommuteList.txt");
        } catch (FileNotFoundException e) {
            System.out.println("CommuteList.txt를 읽을 수 없습니다.");
        }

        BufferedReader br = new BufferedReader(fr);

        String data;
        try {
            while ((data = br.readLine()) != null) {
                String[] p = data.split(" / ");
                this.commuteList.add(new Commute(p[0], p[1], p[2]));
            }
        } catch (IOException e) {
            System.out.println("CommuteManage.txt를 readline으로 가져올 수 없습니다.");
        }
    }

    public void save() {
        FileWriter fw = null;
        try {
            fw = new FileWriter("./PosProject/Employee/CommuteList.txt");
        } catch (IOException e) {
            System.out.println("CommuteList.txt에 쓸 수 없습니다.");
        }

        PrintWriter pw = new PrintWriter(fw);

        for (Commute c : this.commuteList) {
            String data = c.getLoginID() + " / " + c.getStartTime() + " / " + c.getEndTime();
            pw.println(data);
        }
        pw.flush();
    }

    public void add(Commute c) {
        this.commuteList.add(c);
    }

    public void totalPrint() {
        for(Commute c : this.commuteList) {
            c.print();
        }
    }

    public void setEndTime(String loginId, String startTime, String endTime) {
        int idx = -1;
        for(int i = 0; i < this.commuteList.size(); i++) {
            if (loginId.equals(this.commuteList.get(i).getLoginID()) && (startTime.equals(this.commuteList.get(i).getStartTime())) && (this.commuteList.get(i).getEndTime() == "0")) {
                idx = i;
                break;
            }
        }

        if (idx < 0) {
            System.out.println("로그인하신 직원은 출근 시간이 기록되어 있질 않습니다. 다시 확인해 주세요");
            return ;
        }
        
        this.commuteList.get(idx).setEndTime(endTime);
    }

    public boolean checkName(String name) {
        for(Commute c : this.commuteList) {
            if (name.equals(c.getLoginID())) {
                return true;
            }
        }
        return false;
    }

    public void monthAndDayPrint(String name, String month, String day) {
        int i = 0;
        for (Commute c : this.commuteList) {
            if((month.equals(c.getOnlyMonth())) && (day.equals(c.getOnlyDay())) && (name.equals(c.getLoginID()))) {
                c.print();
                i = 1;
            }
        }
        if (i == 0) {
            System.out.println(name + " 직원은 해당 [월]과 해당 [일]에는 일하지 않았습니다.");
        }
    }

    public double checkMonthlyTime(String name, String month) {
        long diff;
        double hour1;
        for(Commute c : this.commuteList) {
            if(month.equals(c.getOnlyMonth()) && name.equals(c.getLoginID()) && (!c.getEndTime().equals("0"))) {
                System.out.println(c.getOnlyStartTime());
                System.out.println(c.getOnlyEndTime());
                try {
                    Date endTime = format.parse(c.getOnlyEndTime());
                    Date startTime = format.parse(c.getOnlyStartTime());
                    diff = endTime.getTime() - startTime.getTime();
                    hour1 = diff / (double)3600000;
                    return (Math.round(hour1*10)/10.0);     // 반올림
                } catch (Exception e) {
                    System.out.println("예외 에러처리");
                }
            }
        }
        return (Double) null;
    }
}