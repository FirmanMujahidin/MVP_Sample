package firmanmujahidin.com.appintermediate.mainHome;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.ArrayList;

import firmanmujahidin.com.appintermediate.R;
import firmanmujahidin.com.appintermediate.adapter.HomeAdapter;
import firmanmujahidin.com.appintermediate.intreractor.HomeInterfaceData;
import firmanmujahidin.com.appintermediate.mainDetail.DetailActivity;
import firmanmujahidin.com.appintermediate.model.HomeModel;

public class HomeActivity extends AppCompatActivity implements HomeInterfaceActivity{

    private TextView mTVtitle;
    private RecyclerView mRecyclerView;
    private HomeAdapter mHomeAdapter;
    private HomeInterfaceData mHomeInterfaceData;
    private ArrayList<HomeModel> mHomeModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Intent intent = getIntent();
        setTitle("Selamat Datang " + intent.getStringExtra("username")+ " Di Movie-21");
        mHomeInterfaceData =  new HomePresenter(this, this);
        mHomeModel = new ArrayList<>();
        mHomeInterfaceData.showList(mHomeModel);
        mHomeInterfaceData.getData();
    }



    public void initView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.mRecyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(HomeActivity.this);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setHasFixedSize(true);
        mHomeAdapter = new HomeAdapter(this, mHomeModel);
        mRecyclerView.setAdapter(mHomeAdapter);
    }

    @Override
    public void setinfo(String title, String body) {

    }

    @Override
    public void next(int id) {
        Intent intent = new Intent(this,DetailActivity.class);
        intent.putExtra("id",id);
        startActivity(intent);
    }
}
