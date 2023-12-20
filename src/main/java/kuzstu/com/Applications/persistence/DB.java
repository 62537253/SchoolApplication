package kuzstu.com.Applications.persistence;

import kuzstu.com.Applications.model.Classes;
import kuzstu.com.Applications.model.Students;
import java.util.List;
import java.text.ParseException;


public class DB {

    private List<Students> studentsList;

    public static List<Students> getStudentList() throws ParseException {
        Students student1 = new Students(1, 1, "Kazarinov Konstantin", "03.07.2002", "Serfdom Street", false);
        Students student2 = new Students(2, 2, "Kutergin Vadim", "24.09.2005", "Rossiyskaya Street", false);
        Students student3 = new Students(3, 1, "Romanova Anastasia", "15.12.2002", "Nagornaya Street", true);
        Students student4 = new Students(4, 2, "Nikolaev Dmitry", "19.01.2002", "Novostroynaya Street", false);
        return List.of(student1, student2, student3, student4);
    }

    public static List<Classes> getClassesList() throws ParseException{

        Classes classes1 = new Classes(1, "11A", 30, "Petrushin Sergey");
        Classes classes2 = new Classes(2, "9В", 23, "Artamonova Ksenia");

        return List.of(classes1, classes2);
    }

}
