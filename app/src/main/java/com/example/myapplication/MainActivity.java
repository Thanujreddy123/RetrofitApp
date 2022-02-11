package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import java.util.*;
public class MainActivity extends AppCompatActivity {
    TextView tv;
    String url="https://jsonplaceholder.typicode.com/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv=(TextView) findViewById(R.id.tv);
        tv.setText("");
        Retrofit re=new Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build();
        myapi api=re.create(myapi.class);
        Call<List<Model>> call=api.getmodels();
        call.enqueue(new Callback<List<Model>>() {
            @Override
            public void onResponse(Call<List<Model>> call, Response<List<Model>> response) {
                List<Model>data=response.body();
                for(int i=0;i<data.size();i++){
                    tv.append(" "+data.get(i).getId()+" "+data.get(i).getTitle()+"\n\n\n");
                }
            }

            @Override
            public void onFailure(Call<List<Model>> call, Throwable t) {

            }
        });
    }
}