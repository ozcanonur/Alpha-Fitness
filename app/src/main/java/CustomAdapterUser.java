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
public class CustomAdapterUser extends ArrayAdapter<User> {
    public CustomAdapterUser(Context context, ArrayList<User> users) {
        super(context, 0, users);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        User user = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.profiletextview, parent, false);
        }
        TextView name = (TextView) convertView.findViewById(R.id.name);
        TextView gender = (TextView) convertView.findViewById(R.id.gender);
        TextView age = (TextView) convertView.findViewById(R.id.age);
        TextView weight = (TextView) convertView.findViewById(R.id.weight);
        TextView height = (TextView) convertView.findViewById(R.id.height);

        name.setText(user.name);
        gender.setText(user.gender.toString());
        age.setText(Integer.toString(user.age));
        height.setText(Integer.toString(user.height) + " cm");
        weight.setText(Integer.toString(user.weight) +" kg");

        return convertView;
    }
}
