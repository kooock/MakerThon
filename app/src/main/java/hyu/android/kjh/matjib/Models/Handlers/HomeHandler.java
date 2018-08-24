package hyu.android.kjh.matjib.Models.Handlers;

import android.util.Log;

import java.util.ArrayList;

import hyu.android.kjh.matjib.Interfaces.Subject;
import hyu.android.kjh.matjib.Models.Infos.FrontMarket;

public class HomeHandler extends Subject {
    private static HomeHandler homeHandler = null;
    private ArrayList<FrontMarket> friendInfoList = new ArrayList<>();

    public static HomeHandler getInstance(){
        if(homeHandler == null)
            homeHandler = new HomeHandler();
        return homeHandler;
    }

    public void addInfo(FrontMarket frontMarket) {
        Log.e("Handler", "addInfo");
        friendInfoList.add(frontMarket);
        //adapterSort();
        notifyObservers();
    }

    public void loadInfos(ArrayList<FrontMarket> users) {
        friendInfoList = users;
        //sort
        notifyObservers();
    }
    public ArrayList<FrontMarket> getInfoList() {
        return friendInfoList;
    }
}
