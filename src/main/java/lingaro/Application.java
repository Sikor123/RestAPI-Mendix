package lingaro;

import okhttp3.OkHttpClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);



        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/") //ctr+w
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();

        UserService service = retrofit.create(UserService.class);
        Call<User> callSync = service.getUser("Sztigar");
        System.out.print("jestem\n" );
        try {
            Response<User> response = callSync.execute();
            User user = response.body();
            System.out.print("srodek " + user.getLogin() + " " + user.getId() + " " + user.getUrl());
        } catch (Exception ex) {System.out.print("bad" ); }

    }
}
