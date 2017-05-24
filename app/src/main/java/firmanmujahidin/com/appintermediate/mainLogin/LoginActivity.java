package firmanmujahidin.com.appintermediate.mainLogin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import firmanmujahidin.com.appintermediate.R;
import firmanmujahidin.com.appintermediate.intreractor.LoginInterface;
import firmanmujahidin.com.appintermediate.mainHome.HomeActivity;

public class LoginActivity extends AppCompatActivity implements LoginInterface {

    private EditText mTxtusername;
    private EditText mTxtpassword;
    private Button mBtnLogin;
    private LoinInterfacePresenter mLoinInterfacePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTxtusername = (EditText) findViewById(R.id.mTextUsername);
        mTxtpassword = (EditText) findViewById(R.id.mTextPassword);
        mBtnLogin = (Button) findViewById(R.id.mBtnLogin);

        mLoinInterfacePresenter = new LoginPresenter(this);

        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mLoinInterfacePresenter.login(mTxtusername.getText().toString(),
                        mTxtpassword.getText().toString());
            }
        });
    }

    @Override
    public void showError() {

    }

    @Override
    public void massageError() {
        Toast.makeText(this,R.string.logininvalid, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginError() {
        Toast.makeText(this,R.string.loginempty, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginsuccess(String username) {
        Toast.makeText(this, R.string.loginsukses, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this,HomeActivity.class);
        intent.putExtra("username",username);
        startActivity(intent);

    }


}
