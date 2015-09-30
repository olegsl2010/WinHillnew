package pro.winhill.winhillnew.wallet;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
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
 * Created by olegs_000 on 22.07.2015.
 */
public class WalletListMenu extends Fragment {

    View rootView;
    FragmentTransaction fragManager;
    private String TAG="WalletListMenu";


    ListView ourListView;
    private ArrayList<PostData> listData;
    InsertList listWallet;
    private String title;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.wallet_list_menu, container, false);


        ourListView = (ListView) rootView.findViewById(R.id.listView);
        listWallet = new InsertList();
        listData = new ArrayList<>();
        listData = listWallet.InsertList();
        toList(listData);


//        ourListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Log.d(TAG, String.valueOf(position));
//                title = listData.get(position).getPostTitle();
//
//                ItemList itemList= new ItemList();
//
//                itemList.setTextForView(title);
//
//                fragManager = getFragmentManager().beginTransaction()
//                        .setCustomAnimations(R.animator.gla_there_come,R.animator.gla_there_gone);
//                fragManager.replace(R.id.listMenu, itemList, "ListItem");
//                fragManager.commit();
//            }
//        });


        return rootView;
    }

    public void toList(ArrayList<PostData> listWallet) {
        PostItemAdapter itemAdapter = new PostItemAdapter(getActivity(), R.layout.postitem, listWallet);
        Log.d("To list wallet", String.valueOf(listWallet.size()));
        ourListView.setAdapter(itemAdapter);
    }

}

