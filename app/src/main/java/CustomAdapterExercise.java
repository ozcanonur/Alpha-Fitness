package sp2016.cs310.com.traningtrackingsystem;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Onur on 5/2/2016.
 */
public class CustomAdapterExercise extends ArrayAdapter<Exercise> {
    public CustomAdapterExercise(Context context, ArrayList<Exercise> exercises) {
        super(context, 0, exercises);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Exercise exercise = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.listentry, parent, false);
        }
        TextView nextExercise = (TextView) convertView.findViewById(R.id.listEntry);
        String exerciseList = exercise.exerciseName+", "+exercise.bodyPart+", "+exercise.setAmount+
                " sets, "+exercise.weightAmount+" kg, "+exercise.repetitions+" reps";

        nextExercise.setText(exerciseList);

        return convertView;
    }
}
