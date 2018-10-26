package lingaro;

import org.apache.catalina.User;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

import java.util.List;

public interface VehicleClient {
    @GET("/v1/collection/vehicle")
    public Call<List<Vehicle>> getVehicles();


}
