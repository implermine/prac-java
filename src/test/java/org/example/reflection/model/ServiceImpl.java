package org.example.reflection.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ServiceImpl extends Service{

    private String idCode = "100";
    private String height;

    private String getPrivate(){
        return "How did you get this";
    }

    private String getOtherPrivate(int thisInt, String thatString){
        return "How did you get here" + thisInt + " " + thatString;
    }

    public ServiceImpl(int number, String randString){
        super();
        System.out.println("You sent: " + number + " " + randString);
    }

    public ServiceImpl(){
        super();
        System.out.println("You called default constructor");
    }

    public ServiceImpl(Repository repository){
        super(repository);
    }
}
