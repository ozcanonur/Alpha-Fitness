package sp2016.cs310.com.traningtrackingsystem;

/**
 * Created by Onur on 5/2/2016.
 */
public class User {



    public String name;
    public Gender gender;
    public int weight;
    public int height;
    public int age;

    public enum Gender {
        Male, Female
    }

    public User(String name){
        this.name = name;
    }

    public User(String name,Gender gender,int age) {

        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public User(String name,Gender gender,int age,String id,int height,int weight) {

        this.id = id;
        this.name = name;
        this.gender = gender;
        this.weight = weight;
        this.height = height;
        this.age = age;
    }


    public String id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
