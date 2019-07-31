package sp2016.cs310.com.traningtrackingsystem;

import java.util.Date;

/**
 * Created by Onur on 5/3/2016.
 */
public class ScheduledClass {

    public String className;
    public Date date;
    public Trainer trainer;

    ScheduledClass(String className,Date date,Trainer trainer){

        this.className = className;
        this.date = date;
        this.trainer = trainer;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }
}
