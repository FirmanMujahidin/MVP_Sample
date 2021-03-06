package firmanmujahidin.com.appintermediate.mainHome;

import android.content.Context;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import firmanmujahidin.com.appintermediate.R;
import firmanmujahidin.com.appintermediate.intreractor.HomeInterfaceData;
import firmanmujahidin.com.appintermediate.model.ExampleRetro;
import firmanmujahidin.com.appintermediate.model.HomeModel;
import firmanmujahidin.com.appintermediate.service.ServiceApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by firma on 14-May-17.
 */

public class HomePresenter implements HomeInterfaceData{

    private Context mContext;
    private HomeActivity mHomeInterface;
    private ArrayList<HomeModel> mHomeModel;
    private List<ExampleRetro> mExampleRetros;
    private static final String BASE_URL = "https://private-4e4159-qurrata.apiary-mock.com/";

    public HomePresenter(HomeActivity mHomenterface, Context mContext) {
        this.mHomeInterface = mHomenterface;
        this.mContext = mContext;
    }

    public HomePresenter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public void showList(ArrayList<HomeModel> homeModels) {
        mHomeModel = homeModels;
    }

    public void getData(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ServiceApi serviceApi = retrofit.create(ServiceApi.class);
        Call<List<ExampleRetro>> call = serviceApi.getData();
        call.enqueue(new Callback<List<ExampleRetro>>() {
            @Override
            public void onResponse(Call<List<ExampleRetro>> call, Response<List<ExampleRetro>> response) {
                mExampleRetros = response.body();
                for (int i = 0; i < mExampleRetros.size() ; i++) {
                    String judul = mExampleRetros.get(i).getJudul();
                    String tipe = mExampleRetros.get(i).getTentang();
                    String isi = mExampleRetros.get(i).getIsi();
                    mHomeModel.add(new HomeModel(judul,"Genre :"+tipe," Deskripsi :",isi));
                }
                mHomeInterface.initView();
            }

            @Override
            public void onFailure(Call<List<ExampleRetro>> call, Throwable t) {
                Toast.makeText(mContext, R.string.koneksierror, Toast.LENGTH_SHORT).show();
            }
        });
    }

}
