package firmanmujahidin.com.appintermediate.mainHome;

import android.content.Context;

import java.util.ArrayList;

import firmanmujahidin.com.appintermediate.intreractor.HomeInterface;
import firmanmujahidin.com.appintermediate.model.HomeModel;

/**
 * Created by firma on 14-May-17.
 */

public class HomePresenter implements HomeInterface{

    private Context mContext;
    private ArrayList<HomeModel> mHomeModel;

    public HomePresenter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public void showList(ArrayList<HomeModel> homeModels) {

        mHomeModel = homeModels;

        mHomeModel.add(new HomeModel("Firman","jakarta","firmanMujahidin@gmail.com","08989725807"));
        mHomeModel.add(new HomeModel("Arya","jakarta","arya@gmail.com","085477362353"));
        mHomeModel.add(new HomeModel("Martin","Tanggrang","Martin@gmail.com","08577723467"));
        mHomeModel.add(new HomeModel("Samuel","Tanggrang","samuel@gmail.com","08989725807"));
        mHomeModel.add(new HomeModel("Jawa","jakarta","Jawa@gmail.com","08989725807"));
        mHomeModel.add(new HomeModel("venta","jakarta","venta@gmail.com","085477362353"));
        mHomeModel.add(new HomeModel("Rindang","jakarta","Rindang@gmail.com","08989725807"));
    }
}
