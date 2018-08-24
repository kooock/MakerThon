package hyu.android.kjh.matjib.Views.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import hyu.android.kjh.matjib.Adapters.HomeAdapter;
import hyu.android.kjh.matjib.Presenters.HomePresenter;
import hyu.android.kjh.matjib.R;

public class HomeFragment extends Fragment implements HomePresenter.View {
    @BindView(R.id.HomeRecyclerview)
    RecyclerView recyclerView;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void showAdapter(HomeAdapter adapter) {

    }
}
