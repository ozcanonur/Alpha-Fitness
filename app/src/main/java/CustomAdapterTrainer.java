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
public class CustomAdapterTrainer extends ArrayAdapter<Trainer> {
    public CustomAdapterTrainer(Context context, ArrayList<Trainer> trainers) {
        super(context, 0, trainers);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Trainer trainerList = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.listentry, parent, false);
        }
        TextView trainer = (TextView) convertView.findViewById(R.id.listEntry);

        String trainerInfo = trainerList.name +", "+trainerList.gender+", "+trainerList.age;
        trainer.setText(trainerInfo);

        return convertView;
    }
}
