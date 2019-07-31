package sp2016.cs310.com.traningtrackingsystem;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TabHost;

import java.util.ArrayList;

public class ClientInterface extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_interface);

        TabHost host = (TabHost)findViewById(R.id.clientTabHost);
        host.setup();

        TabHost.TabSpec spec = host.newTabSpec("Profile");
        spec.setContent(R.id.ProfileTab);
        spec.setIndicator("Profile");
        host.addTab(spec);

        spec = host.newTabSpec("Trainers");
        spec.setContent(R.id.TrainersTab);
        spec.setIndicator("Trainers");
        host.addTab(spec);
        ///////////////////////////////////////////
        final ArrayList<User> arrayOfUsers = new ArrayList<>();
        CustomAdapterUser userAdapter = new CustomAdapterUser(this, arrayOfUsers);
        ListView userListView = (ListView) findViewById(R.id.profileListView);
        userListView.setAdapter(userAdapter);

        userAdapter.add(new User("Onur Ozcan", User.Gender.Male,25,"1",182,90));
        ////////////////////////////////////////
        ///////////////////////////////////////
        final ArrayList<Exercise> arrayOfExercises = new ArrayList<>();
        CustomAdapterExercise exerciseAdapter = new CustomAdapterExercise(this, arrayOfExercises);
        ListView exerciseListView = (ListView) findViewById(R.id.listViewNextExercise);
        exerciseListView.setAdapter(exerciseAdapter);

        exerciseAdapter.add(new Exercise("Bench Press","Chest",3,12,60));
        exerciseAdapter.add(new Exercise("Squat","Legs",3,12,100));
        exerciseAdapter.add(new Exercise("Deadlift","Back",3,12,100));
        exerciseAdapter.add(new Exercise("Shoulder Press","Shoulder",3,12,50));
        exerciseAdapter.add(new Exercise("Biceps Curl","Biceps",3,12,30));
        exerciseAdapter.add(new Exercise("X Curl","Biceps",3,12,30));
        exerciseAdapter.add(new Exercise("Y Curl","Biceps",3,12,30));
        exerciseAdapter.add(new Exercise("Triple Shoulder from the Back Reverse DeadCurl","Biceps",3,12,30));
        exerciseAdapter.add(new Exercise("Nice","Biceps",3,12,30));
        ////////////////////////////////////////////////////
        ArrayList<Trainer> arrayOfTrainers = new ArrayList<>();
        CustomAdapterTrainer trainerAdapter = new CustomAdapterTrainer(this,arrayOfTrainers);
        ListView trainerListView = (ListView) findViewById(R.id.trainersListView);
        trainerListView.setAdapter(trainerAdapter);

        trainerAdapter.add(new Trainer("Kazım Kazım",User.Gender.Female,30));
        trainerAdapter.add(new Trainer("La Li",User.Gender.Female,30));
        trainerAdapter.add(new Trainer("Lu Le",User.Gender.Male,25));
        trainerAdapter.add(new Trainer("Lo Li",User.Gender.Male,45));
        trainerAdapter.add(new Trainer("Lu Le",User.Gender.Female,98));
        trainerAdapter.add(new Trainer("Lo Li",User.Gender.Male,12));
        ////////////////////////////////////////////////////////
        Button exerciseProgramButton = (Button) findViewById(R.id.exerciseProgramButton);
        assert exerciseProgramButton != null;

        exerciseProgramButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent navTrainingProgram = new Intent(ClientInterface.this,ExerciseProgram.class);
                navTrainingProgram.putParcelableArrayListExtra("exerciseProgram",arrayOfExercises);
                ClientInterface.this.startActivity(navTrainingProgram);
            }
        });
        //////////////////////////////////////////////////////////
        Button scheduleButton = (Button) findViewById(R.id.scheduleButton);
        assert scheduleButton != null;

        scheduleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent navSchedule = new Intent(ClientInterface.this,ScheduleActivity.class);
                String userID = arrayOfUsers.get(0).getId();
                navSchedule.putExtra("ID",userID);
                ClientInterface.this.startActivity(navSchedule);
            }
        });
        ////////////////////////////////////////////////////////////
        final Button updateButton = (Button) findViewById(R.id.updateProfileButton);
        assert updateButton != null;

        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent navUpdate = new Intent(ClientInterface.this,UpdateProfile.class);
                ClientInterface.this.startActivity(navUpdate);
            }
        });
        /////////////////////////////////////////////////////////////

    }
}
