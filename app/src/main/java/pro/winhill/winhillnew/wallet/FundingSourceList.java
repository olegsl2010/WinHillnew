package pro.winhill.winhillnew.wallet;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

import pro.winhill.winhillnew.adapter.PostItemAdapter;
import pro.winhill.winhillnew.data.InsertList;
import pro.winhill.winhillnew.R;
import pro.winhill.winhillnew.instance.PostData;

/**
 * Created by olegs_000 on 23.07.2015.
 */
public class FundingSourceList extends Fragment {

    View rootView;



    ListView ourListView;
    private ArrayList<PostData> listData;
    InsertList listWallet;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.wallet_list_menu, container, false);



        ourListView = (ListView) rootView.findViewById(R.id.listView);
        Log.d("ListMenu", ourListView.toString());
        listWallet = new InsertList();
        listData = new ArrayList<>();
        listData = listWallet.InsertList2();
        toList(listData);

        return rootView;
    }

    public void toList(ArrayList<PostData> listWallet) {
        PostItemAdapter itemAdapter = new PostItemAdapter(getActivity(), R.layout.postitem, listWallet);
        Log.d("To list wallet", String.valueOf(listWallet.size()));
        ourListView.setAdapter(itemAdapter);
    }
}
