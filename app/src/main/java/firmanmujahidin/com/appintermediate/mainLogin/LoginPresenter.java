package firmanmujahidin.com.appintermediate.mainLogin;

import android.text.TextUtils;

import firmanmujahidin.com.appintermediate.intreractor.LoginInterface;

/**
 * Created by firma on 13-May-17.
 */

public class LoginPresenter implements LoinInterfacePresenter {

    private LoginInterface mLoginInterface;

    public LoginPresenter(LoginInterface mLoginInterface) {
        this.mLoginInterface = mLoginInterface;
    }

    @Override
    public void login(String username, String password) {
        if (TextUtils.isEmpty(username)|| TextUtils.isEmpty(password)){
            mLoginInterface.massageError();

        }else {
            if (username.equals("admin") && password.equals("admin")){
                mLoginInterface.loginsuccess(username);
            }else {

            }
        }
    }

}
