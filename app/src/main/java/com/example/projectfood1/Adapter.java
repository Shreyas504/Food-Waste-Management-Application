package com.example.projectfood1;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class Adapter extends ArrayAdapter<UserData> {

    private Activity context;
    private List<UserData> userData;

    public Adapter(Activity context , List<UserData> userData){
        super(context , R.layout.list_layout, userData);
        this.context = context;
        this.userData = userData;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();

        View listViewItem = inflater.inflate(R.layout.list_layout, null, true);

        TextView textViewAddress = listViewItem.findViewById(R.id.textViewAddress);
        TextView textViewArea = listViewItem.findViewById(R.id.textViewArea);
     TextView textViewMobile = listViewItem.findViewById(R.id.textViewMobile);
      TextView textViewType = listViewItem.findViewById(R.id.textViewType);
     UserData user = userData.get(position);

        textViewAddress.setText(user.getUadd());
        textViewArea.setText(user.getUarea());
        textViewMobile.setText(user.getUphn());
        textViewType.setText(user.getType());
        return listViewItem;
    }
}
