package firmanmujahidin.com.appintermediate.mainDetail;

import android.content.Context;
import android.widget.Toast;

import java.util.List;

import firmanmujahidin.com.appintermediate.R;
import firmanmujahidin.com.appintermediate.intreractor.DetailIntereface;
import firmanmujahidin.com.appintermediate.model.ExampleRetro;
import firmanmujahidin.com.appintermediate.service.ServiceApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by rezab on 15/05/2017.
 */

public class DetailInterefacePresenter implements DetailIntereface {

    private firmanmujahidin.com.appintermediate.mainHome.HomeInterfaceActivity HomeInterfaceActivity;
    private List<ExampleRetro> mExampleRetros;
    private Context mContext;
    private static final String BASE_URL = "https://private-4e4159-qurrata.apiary-mock.com/";
    private String ids;

    public DetailInterefacePresenter(DetailActivity homeInterfaceActivity, Context mContext) {
        HomeInterfaceActivity = (firmanmujahidin.com.appintermediate.mainHome.HomeInterfaceActivity) homeInterfaceActivity;
        this.mContext = mContext;
    }
    @Override
    public void getDataInfo(String id) {
        final String ids = id;
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
                String judul = mExampleRetros.get(Integer.parseInt(ids)).getJudul();
                String tipe = mExampleRetros.get(Integer.parseInt(ids)).getTentang();
                String isia = mExampleRetros.get(Integer.parseInt(ids)).getIsi();
                HomeInterfaceActivity.setinfo(judul,"\n Tipe : "+tipe+" \n Isi : "+isia);

            }

            @Override
            public void onFailure(Call<List<ExampleRetro>> call, Throwable t) {
                Toast.makeText(mContext, R.string.koneksierror, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
