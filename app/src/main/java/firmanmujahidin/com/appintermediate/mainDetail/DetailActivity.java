package firmanmujahidin.com.appintermediate.mainDetail;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import firmanmujahidin.com.appintermediate.R;
import firmanmujahidin.com.appintermediate.intreractor.DetailIntereface;
import firmanmujahidin.com.appintermediate.mainHome.HomeInterfaceActivity;

public class DetailActivity extends AppCompatActivity implements HomeInterfaceActivity{

    private DetailIntereface mDetailIntereface;
    private TextView isi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        setTitle(R.string.loading);
        Intent intent = getIntent();
        String i = intent.getStringExtra("id");
        mDetailIntereface = new DetailInterefacePresenter(this,this);
        mDetailIntereface.getDataInfo(i);
    }

    @Override
    public void initView() {

    }

    @Override
    public void next(int id) {

    }

    @Override
    public void setinfo(String title, String body) {
        setTitle(title);
        isi = (TextView) findViewById(R.id.mTVdetail);
        isi.setText(body);
    }
}
