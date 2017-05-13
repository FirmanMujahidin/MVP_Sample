package firmanmujahidin.com.appintermediate.mainview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import firmanmujahidin.com.appintermediate.R;

public class HomeActivity extends AppCompatActivity {

    private TextView mTextusername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mTextusername = (TextView) findViewById(R.id.mTextUsername);

        Intent mintent = getIntent();
        String username = mintent.getStringExtra("username");
        mTextusername.setText(username);
    }
}
