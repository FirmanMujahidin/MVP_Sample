package firmanmujahidin.com.appintermediate.service;

import java.util.List;

import firmanmujahidin.com.appintermediate.model.ExampleRetro;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by firma on 14-May-17.
 */

public interface ServiceApi {
    String END_POINT = "questions";

    @GET(END_POINT)
    Call<List<ExampleRetro>>getData();
}
