package sp2016.cs310.com.traningtrackingsystem;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class ExerciseProgram extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_program);

        ArrayList<Exercise> arrayOfExercises = getIntent().getParcelableArrayListExtra("exerciseProgram");

        CustomAdapterExercise exerciseAdapter = new CustomAdapterExercise(this, arrayOfExercises);
        ListView exerciseProgramListView = (ListView) findViewById(R.id.exerciseProgramListView);
        exerciseProgramListView.setAdapter(exerciseAdapter);

    }

}
