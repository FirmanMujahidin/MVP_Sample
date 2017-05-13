package firmanmujahidin.com.appintermediate.mainview;

import android.text.TextUtils;

import firmanmujahidin.com.appintermediate.intreractor.InterfaceMain;
import firmanmujahidin.com.appintermediate.intreractor.InterfacePresenter;

/**
 * Created by firma on 13-May-17.
 */

public class MainPresenter implements InterfacePresenter{

    private InterfaceMain mInterfaceMain;

    public MainPresenter(InterfaceMain mInterfaceMain) {
        this.mInterfaceMain = mInterfaceMain;
    }

    @Override
    public void login(String username, String password) {
        if (TextUtils.isEmpty(username)|| TextUtils.isEmpty(password)){
            mInterfaceMain.massageError();

        }else {
            if (username.equals("Firman") && password.equals("firman")){
                mInterfaceMain.loginsuccess();
            }else {

            }
        }
    }

}
