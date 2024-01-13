package kuzstu.com.Applications.model;

public record Card(    int id,
                       Long concentration,
                       boolean student,
                       Long gallery,
                       boolean green,
                       CardScheme scheme,
                       double drink) {

}
