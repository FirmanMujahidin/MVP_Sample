package firmanmujahidin.com.appintermediate.mainview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import firmanmujahidin.com.appintermediate.R;
import firmanmujahidin.com.appintermediate.adapter.HomeAdapter;
import firmanmujahidin.com.appintermediate.intreractor.HomeInterface;
import firmanmujahidin.com.appintermediate.mainHome.HomePresenter;
import firmanmujahidin.com.appintermediate.model.ExampleRetro;
import firmanmujahidin.com.appintermediate.model.HomeModel;
import firmanmujahidin.com.appintermediate.service.ServiceApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeActivity extends AppCompatActivity {

    private TextView mTextusername;
    private RecyclerView mRecyclerView;
    private HomeAdapter mHomeAdapter;
    private HomeInterface mHomeInterface;
    private ArrayList<HomeModel> mHomeModel;


    private List<ExampleRetro> mExampleRetros;
    private static final String BASE_URL = "https://private-4e4159-qurrata.apiary-mock.com/";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mTextusername = (TextView) findViewById(R.id.mTextUsername);
        Intent mintent = getIntent();
        String username = mintent.getStringExtra("username");
        mTextusername.setText(username);
        mTextusername.setText(getString(R.string.app));

        mHomeInterface = new HomePresenter(this);
        mHomeModel = new ArrayList<>();
        mHomeInterface.showList(mHomeModel);
        initView();
        getData();
    }

    private  void initView(){
        mRecyclerView = (RecyclerView) findViewById(R.id.mRecyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(HomeActivity.this);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setHasFixedSize(true);
        mHomeAdapter = new HomeAdapter(this, mHomeModel);
        mRecyclerView.setAdapter(mHomeAdapter);
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
                    Toast.makeText(HomeActivity.this, "" + judul, Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<List<ExampleRetro>> call, Throwable t) {

            }
        });


    }
}
