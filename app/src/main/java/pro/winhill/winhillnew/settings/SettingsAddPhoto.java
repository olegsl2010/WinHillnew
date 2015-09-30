package pro.winhill.winhillnew.settings;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pro.winhill.winhillnew.R;


/**
 * Created by olegs_000 on 24.07.2015.
 */
public class SettingsAddPhoto extends Fragment {

    View rootView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.add_photo, container, false);


        return rootView;
    }
}
