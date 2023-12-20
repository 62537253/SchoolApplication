package kuzstu.com.Applications.model;

import java.util.ArrayList;
import java.util.List;

public class Classes {
    public int id;
    public String name_class;
    public int quantity;
    public String headman;

    public Classes(int id, String name_class,int quantity, String headman){
        this.id = id;
        this.name_class = name_class;
        this.quantity = quantity;
        this.headman = headman;
    }

    public int id() {
        return id;
    }
}
