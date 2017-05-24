package firmanmujahidin.com.appintermediate.intreractor;

import java.util.ArrayList;

import firmanmujahidin.com.appintermediate.model.HomeModel;

/**
 * Created by firma on 18-May-17.
 */

public interface HomeInterfaceData {
    void showList(ArrayList<HomeModel> homeModels);
    void getData();
}