package kuzstu.com.Applications.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Students {
    public int id;
    public int classId;
    public String name_student;
    public Date dater;
    public String address;
    public boolean gender;

    public Students(int id, int classId, String name_student, String dater,String address, boolean gender) throws ParseException {
        this.id = id;
        this.classId = classId;
        this.name_student = name_student;
        DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        this.dater = formatter.parse(dater);
        this.address = address;
        this.gender = gender;

    }

    public int id() {
        return id;
    }

    public int classId() {
        return classId();
    }
}
