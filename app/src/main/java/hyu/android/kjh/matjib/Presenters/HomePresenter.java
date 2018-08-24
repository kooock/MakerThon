package hyu.android.kjh.matjib.Presenters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Iterator;

import hyu.android.kjh.matjib.Adapters.HomeAdapter;
import hyu.android.kjh.matjib.Models.Handlers.HomeHandler;

public class HomePresenter {
    private HomePresenter.View view;
    private Context context;
    //private AppCompatActivity activity;

    private FirebaseUser mFirebaseUser;
    private FirebaseAuth mFirebaseAuth;
    private FirebaseDatabase mFirebaseDB;
    private DatabaseReference mFriendsDBRef;
    private DatabaseReference mUserDBRef;

    private HomeAdapter adapter;

    private HomeHandler friendHandler;


    public interface View {
        void showAdapter(HomeAdapter adapter);

    }

    public void setContext(Context context) {
        this.context = context;

    }

    public HomePresenter(View view) {
        this.view = view;

        friendHandler = new HomeHandler().getInstance();

        mFirebaseAuth = FirebaseAuth.getInstance();
        mFirebaseUser = mFirebaseAuth.getCurrentUser();
        mFirebaseDB = FirebaseDatabase.getInstance();

        mFriendsDBRef = mFirebaseDB.getReference("users").child(mFirebaseUser.getUid()).child("friends");
        mUserDBRef = mFirebaseDB.getReference("users");
    }

    public RecyclerView.Adapter getAdapter() {
        return adapter;
    }

    public void setAdapter() {
        view.showAdapter(adapter);
    }

    public void setRecyclerView() {
        //adapter = new HomeAdapter(homeHandler.getInfoList());
        friendHandler.attach(adapter);
    }
}