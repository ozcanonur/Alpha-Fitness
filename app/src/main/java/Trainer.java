package sp2016.cs310.com.traningtrackingsystem;

/**
 * Created by Onur on 5/3/2016.
 */
public class Trainer extends User {

    public Trainer(String name,Gender gender,int age) {
        super(name,gender,age);
    }

    public Trainer(String name,Gender gender,int age, String id,int height,int weight) {
        super(name,gender,age,id,height,weight);

    }
}
