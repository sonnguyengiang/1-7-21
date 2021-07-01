package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import com.company.Fail.*;

public class ManagerStudents {
    Scanner input = new Scanner(System.in);
    ArrayList<Students> list = new ArrayList<>();

    public ArrayList<Students> docFile(){
        ArrayList<Students> list = new ArrayList<>();
        try {
            BufferedReader ois = new BufferedReader(new FileReader("src/com/company/QLHS.csv"));
            String line ="";
            while ((line = ois.readLine()) != null){
                String[] str = line.split(",");
                list.add(new Students(Integer.parseInt(str[0]),str[1],Integer.parseInt(str[2]),str[3],str[4],Integer.parseInt(str[5])));
            }
            ois.close();
        } catch (Exception e){
            System.out.println("file chưa có gì");
        }
        return list;
    }
    public void ghiFile(){
        try{
            BufferedWriter oos = new BufferedWriter(new FileWriter("src/com/company/QLHS.csv"));
            for (Students s : list){
                oos.write(s.display());
            }
            oos.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void add(){
        int id = getId();
        String name = getName();
        int tuoi = getAge();
        String gender = getGender();
        String address = getAddress();
        int average = getAverage();
        list.add(new Students(id,name,tuoi,gender,address,average));
    }

    public void show(){
        try{
            for(Students a: list){
                System.out.println(a);
            }
        } catch (Exception e){
            System.out.println("chưa có gì cả");
        }
    }

    public void update(){
        int checklist = -1;
        System.out.print("nhập id cần sửa: ");
        int idCheck = Integer.parseInt(input.nextLine());
        for (int i = 0; i < list.size(); i++){
            if (list.get(i).getId() == idCheck){
                checklist = 1;
                break;
            }
        }
        if (checklist > 0){
            int id = getId();
            String name = getName();
            int tuoi = getAge();
            String gender = getGender();
            String address = getAddress();
            int average = getAverage();
            list.add(new Students(id,name,tuoi,gender,address,average));
        } else {
            System.out.println("không tìm thấy id đó");
        }
    }

    public void remove(){
        System.out.print("nhập id sinh viên muốn cho ra đảo: ");
        int id = Integer.parseInt(input.nextLine());
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id){
                list.remove(i);
            }
        }
    }

    public void sort(){
        SortById sortById = new SortById();
        Collections.sort(list,sortById);
    }

    public void readToFile(){
        ArrayList<Students> arrayList = new ArrayList<>();
        arrayList = docFile();
        for (Students b: arrayList){
            System.out.println(b);
        }
    }


    private int getId() {
        while (true) {
            try {
                System.out.print("Nhập id: ");
                int id = Integer.parseInt(input.nextLine());
                if(list == null){
                    return id;
                }
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).getId() == id) {
                        throw new IdFail();
                    }
                }
                return id;
            } catch (IdFail e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("sai định dạng");

            }
        }
    }
    private String getName(){
        System.out.print("Nhập tên: ");
        String name = input.nextLine();
        return name;
    }
    private int getAge(){
        while (true){
            try{
                System.out.print("Nhập tuổi: ");
                int tuoi = Integer.parseInt(input.nextLine());
                return tuoi;
            } catch (Exception e){
                System.out.println("sai định dạng nhập lại: ");
            }
        }
    }
    private String getGender(){
        while (true){
            try{
                System.out.print("Nhập giới tính nam/nữ: ");
                String gender = input.nextLine();
                if (gender.equals("nam") || gender.equals("nữ")){
                    return gender;
                } else {
                    throw new GenderFail();
                }
            } catch (GenderFail e){
                System.out.println(e.getMessage());
            }
        }
    }
    private String getAddress(){
        System.out.print("Nhập địa chỉ: ");
        String address = input.nextLine();
        return address;
    }
    private int getAverage(){
        System.out.print("Nhập điểm trung bình");
        int average = Integer.parseInt(input.nextLine());
        return average;
    }

}
