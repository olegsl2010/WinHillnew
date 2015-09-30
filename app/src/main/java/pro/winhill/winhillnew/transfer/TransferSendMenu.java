package pro.winhill.winhillnew.transfer;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pro.winhill.winhillnew.R;


public class TransferSendMenu extends Fragment {

    View rootView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.transfer_send, container, false);


        return rootView;
    }
}
