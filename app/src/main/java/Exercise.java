package sp2016.cs310.com.traningtrackingsystem;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by Onur on 5/2/2016.
 */
public class Exercise implements Parcelable {

    public String exerciseName;
    public String bodyPart;
    public int setAmount;
    public int repetitions;
    public int weightAmount;


    public Exercise(String exerciseName,String bodyPart,int setAmount,int repetitions,int weightAmount){

        this.exerciseName = exerciseName;
        this.bodyPart = bodyPart;
        this.setAmount = setAmount;
        this.repetitions = repetitions;
        this.weightAmount = weightAmount;
    }

    public String getExerciseName() {
        return exerciseName;
    }

    public void setExerciseName(String exerciseName) {
        this.exerciseName = exerciseName;
    }

    public String getBodyPart() {
        return bodyPart;
    }

    public void setBodyPart(String bodyPart) {
        this.bodyPart = bodyPart;
    }

    public int getRepetitions() {
        return repetitions;
    }

    public void setRepetitions(int repetitions) {
        this.repetitions = repetitions;
    }

    public int getWeightAmount() {
        return weightAmount;
    }

    public void setWeightAmount(int weightAmount) {
        this.weightAmount = weightAmount;
    }

    public int getSetAmount() {
        return setAmount;
    }

    public void setSetAmount(int setAmount) {
        this.setAmount = setAmount;
    }

    protected Exercise(Parcel in) {
        exerciseName = in.readString();
        bodyPart = in.readString();
        setAmount = in.readInt();
        repetitions = in.readInt();
        weightAmount = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(exerciseName);
        dest.writeString(bodyPart);
        dest.writeInt(setAmount);
        dest.writeInt(repetitions);
        dest.writeInt(weightAmount);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Exercise> CREATOR = new Parcelable.Creator<Exercise>() {
        @Override
        public Exercise createFromParcel(Parcel in) {
            return new Exercise(in);
        }

        @Override
        public Exercise[] newArray(int size) {
            return new Exercise[size];
        }
    };
}