package pro.winhill.winhillnew.settings;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import pro.winhill.winhillnew.R;


/**
 * Created by apple on 29.07.15.
 */
public class SettingsTable extends Fragment implements View.OnClickListener {

    View rootView;
    Button photo;
    FragmentTransaction fragManager;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.settings_main, container, false);

        photo= (Button) rootView.findViewById(R.id.addPhoto);

        photo.setOnClickListener(this);

        return rootView;
    }

    @Override
    public void onClick(View v) {
        fragManager = getFragmentManager().beginTransaction();

        switch (v.getId()) {
            case R.id.addPhoto:

                fragManager.addToBackStack(null);
                fragManager.replace(R.id.drawer_layout, new SettingsAddPhoto());

                break;
        }
        fragManager.commit();

    }
}
