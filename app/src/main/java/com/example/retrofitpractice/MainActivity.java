package com.example.retrofitpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.retrofitpractice.data.DoApi;
import com.example.retrofitpractice.data.ModelDo;
import com.example.retrofitpractice.data.RetrofitBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    private TextView newActivity;
    private TextView priceOfActivity;
    private Button doSomething;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        newActivity = findViewById(R.id.new_activity);
        priceOfActivity = findViewById(R.id.price);
        doSomething = findViewById(R.id.doSomething);

        doSomething.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DoApi doApi = RetrofitBuilder.getInstance();

                Call<ModelDo> modelDoCall = doApi.getActivities();
                modelDoCall.enqueue(new Callback<ModelDo>() {

                    @Override
                    public void onResponse(Call<ModelDo> call, Response<ModelDo> response) {

                        if(!response.isSuccessful()){
                            newActivity.setText("Code: " + response.code());
                        }

                        ModelDo modelDo = response.body();
                        newActivity.setText(modelDo.getActivity());

                        priceOfActivity.setText(modelDo.getPrice() + "");
                    }

                    @Override
                    public void onFailure(Call<ModelDo> call, Throwable t) {
                        newActivity.setText(t.getMessage());
                    }

                });
            }
        });

    }
}