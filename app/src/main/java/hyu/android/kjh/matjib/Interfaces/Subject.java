package hyu.android.kjh.matjib.Interfaces;

import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject {
    private List<RecyclerView.Adapter> observers = new ArrayList<RecyclerView.Adapter>();

    public void attach(RecyclerView.Adapter adapter){
        observers.add(adapter);
    }

    public void notifyObservers(){
        for(RecyclerView.Adapter o : observers){
            o.notifyDataSetChanged();
        }
    }
}