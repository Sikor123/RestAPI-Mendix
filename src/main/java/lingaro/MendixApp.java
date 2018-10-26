package lingaro;

import okhttp3.OkHttpClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.List;

@SpringBootApplication
public class MendixApp {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);



        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost:8081") //ctr+w
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();

        VehicleClient service = retrofit.create(VehicleClient.class);
        Call<List<Vehicle>> callSync = service.getVehicles();
        System.out.print("jestem\n" );
        try {
            Response<List<Vehicle>> response = callSync.execute();
            List<Vehicle> v =  response.body();
            //System.out.print("\nw srodku \n" +v.get(0).getMake()+"\n" + v.size());
            for (Vehicle ve:v) {
                System.out.println("Make: " + ve.getMake());
                System.out.println("model: " + ve.getModel());
                System.out.println("color: " + ve.getColor());
                System.out.println("year: " + ve.getYear());
               // System.out.println("style: " + ());
            }
        } catch (Exception ex) {System.out.print(ex); }

    }
}
