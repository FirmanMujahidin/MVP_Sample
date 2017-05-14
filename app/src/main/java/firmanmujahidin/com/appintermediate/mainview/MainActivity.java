package firmanmujahidin.com.appintermediate.mainview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import firmanmujahidin.com.appintermediate.R;
import firmanmujahidin.com.appintermediate.intreractor.InterfaceMain;
import firmanmujahidin.com.appintermediate.intreractor.InterfacePresenter;

public class MainActivity extends AppCompatActivity implements InterfaceMain {

    private EditText mTxtusername;
    private EditText mTxtpassword;
    private Button mBtnLogin;
    private InterfacePresenter mInterfacePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTxtusername = (EditText) findViewById(R.id.mTextUsername);
        mTxtpassword = (EditText) findViewById(R.id.mTextPassword);
        mBtnLogin = (Button) findViewById(R.id.mBtnLogin);

        mInterfacePresenter = new  MainPresenter(this);

        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mInterfacePresenter.login(mTxtusername.getText().toString(),
                        mTxtpassword.getText().toString());
            }
        });
    }

    @Override
    public void showError() {

    }

    @Override
    public void massageError() {
        Toast.makeText(this,"Username atau Password tidak boleh kosong", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginError() {
        Toast.makeText(this,"Username atau Password salah", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginsuccess() {
        Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
        intent.putExtra("username", mTxtusername.getText().toString());
        startActivity(intent);
        Toast.makeText(this,"Login Berhasil", Toast.LENGTH_SHORT).show();
    }

}
