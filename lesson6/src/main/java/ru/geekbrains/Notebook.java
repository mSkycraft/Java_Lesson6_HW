package ru.geekbrains;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Notebook {
    private int id;
    private String model;
    private String os;
    private int memory;
    private int hdd;
    private String color;
    private int price;



    public int getPrice() {
        return price;
    }


    public void setPrice(int price) {
        this.price = price;
    }


    public Notebook(int id, String model, String os, int memory, int hdd, String color, int price) {
        this.id = id;
        this.model = model;
        this.os = os;
        this.memory = memory;
        this.hdd = hdd;
        this.color = color;
        this.price = price;
    }
    

    public Notebook(String model) {
        this.model = model;
    }


    public String getColor() {
        return color;
    }


    public void setColor(String color) {
        this.color = color;
    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public String getModel() {
        return model;
    }


    public void setModel(String model) {
        this.model = model;
    }


    public int getMemory() {
        return memory;
    }


    public void setMemory(int memory) {
        this.memory = memory;
    }


    public int getHdd() {
        return hdd;
    }


    public void setHdd(int hdd) {
        this.hdd = hdd;
    }


    public String getOs() {
        return os;
    }


    public void setOs(String os) {
        this.os = os;
    }


    @Override
    public String toString() {
        return "\nNotebook [id=" + id 
                            + ", os=" + os 
                            +", hdd=" + hdd 
                            + ", memory=" + memory 
                            + ", model=" + model 
                            + ", color=" + color + "]";
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + ((model == null) ? 0 : model.hashCode());
        return result;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Notebook other = (Notebook) obj;
        if (id != other.id)
            return false;
        if (model == null) {
            if (other.model != null)
                return false;
        } else if (!model.equals(other.model))
            return false;
        return true;
    }

    private static void printMenu(){
        System.out.println("Введите номер графы для фильтрации:");
        System.out.println("1: ID");
        System.out.println("2: Model");
        System.out.println("3: OS");
        System.out.println("4: Memory");
        System.out.println("5: HDD");
        System.out.println("6: Color");
        System.out.println("7: Price");
        System.out.println("8: Accept");
        System.out.println("9: Exit");
    }
    public static void filter(Set<Notebook> inputNote){
        Set<Notebook> filter = new HashSet<>();
        Scanner scn = new Scanner(System.in);
        int enteredKey;
        HashMap<String,Object> fmap = new HashMap<>(Map.of("id","","model","","os","","memory","","hdd","","color","","price",""));
        while(true){
            printMenu();
            enteredKey = scn.nextInt();
            switch (enteredKey) {
                case 1:
                    System.out.println("Введите ID");
                    fmap.put("id", scn.nextInt());
                    break;
                case 2:
                    System.out.println("Введите model");
                    fmap.put("model", scn.next());
                    break;
                case 3:
                    System.out.println("Введите OS");
                    fmap.put("os", scn.next());
                    break;
                case 4:
                    System.out.println("Введите memory");
                    fmap.put("memory", scn.nextInt());
                    break;
                case 5:
                    System.out.println("Введите HDD");
                    fmap.put("hdd", scn.nextInt());
                    break;
                case 6:
                    System.out.println("Введите Color");
                    fmap.put("color", scn.next());
                    break;    
                case 7:
                    System.out.println("Введите Price");
                    fmap.put("price", scn.nextInt());
                    break;
                case 8:
                    for (Notebook notebook : inputNote) {
                        boolean flag = false;
                        if(fmap.get("id")!=""){
                            if((int)fmap.get("id")==notebook.getId()){
                                flag = true;
                            }
                        }                        
                        if(fmap.get("model")!=""){
                            if(((String)fmap.get("model")).equals(notebook.getModel())){
                                flag = true;
                            }else {
                                flag = false;
                            }
                        }                        
                        if(fmap.get("os")!=""){
                            if(((String)fmap.get("os")).equals(notebook.getOs())){
                                flag = true;
                            } else {
                                flag = false;
                            }
                        }                        
                        if(fmap.get("memory")!=""){
                            if((int)fmap.get("memory")==notebook.getMemory()){
                                flag = true;
                            }else {
                                flag = false;
                            }
                        }                        
                        if(fmap.get("hdd")!=""){
                            if((int)fmap.get("hdd")==notebook.getHdd()){
                                flag = true;
                            }else {
                                flag = false;
                            }
                        }                        
                        if(fmap.get("color")!=""){
                            if(((String)fmap.get("color")).equals(notebook.getColor())){
                                flag = true;
                            }else {
                                flag = false;
                            }
                        }                        
                        if(fmap.get("price")!=""){
                            if((int)fmap.get("price")==notebook.getPrice()){
                                flag = true;
                            }else {
                                flag = false;
                            }
                        }                        
                        if(flag == true){
                            filter.add(notebook);
                        }
                    }
                    System.out.println("Текущий фильтр");
                    System.out.println(fmap);
                    System.out.println(filter);
                    break;
                case 9:
                    break;
                default:
                    System.out.println("Не корректный ввод");
                    break;
            }
            if(enteredKey==9) {
                scn.close();
                break;
            }
        }
        
    }
    
    public static void main(String[] args) {
        Set<Notebook> set = new HashSet<>();
        set.add(new Notebook("HP Pavillion g10"));
        set.add(new Notebook(1, "TUF Gaming g1", "None", 16, 500, "black",30000));
        set.add(new Notebook(2, "TUF Gaming g2", "None", 8, 480, "silver",29000));
        set.add(new Notebook(3, "TUF Gaming g3", "Windows", 32, 1024, "black",100000));
        set.add(new Notebook(4, "TUF Gaming g4", "RedHat", 8, 256, "red",28000));
        set.add(new Notebook(5, "TUF Gaming g5", "None", 4, 500, "white",24000));
        set.add(new Notebook(6, "TUF Gaming g6", "None", 8, 500, "silver",26000));
        System.out.println(set);
        filter(set);
    }
}
