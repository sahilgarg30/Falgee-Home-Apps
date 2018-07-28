package com.example.sahil.jsonpassingretrofitapi;

import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Movie;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends Activity {

    private ListView mListView;

        private static final String TAG = MainActivity.class.getSimpleName();

        // TODO - insert your themoviedb.org API KEY here
        private final static String API_KEY = "3b662345950ed2c5f1354a75d0ef7536";


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            mListView = (ListView)findViewById(R.id.listview);
            final ProgressDialog mProgressDialog = new ProgressDialog(MainActivity.this);
            mProgressDialog.setMessage("Loading...");
            mProgressDialog.show();
//My JSON link = "http://api.themoviedb.org/3/movie/top_rated?api_key=3b662345950ed2c5f1354a75d0ef7536"

            if (API_KEY.isEmpty()) {
                Toast.makeText(getApplicationContext(), "Please obtain your API KEY first from themoviedb.org", Toast.LENGTH_LONG).show();
                mProgressDialog.dismiss();
                return;
            }

            ApiInterface apiService =
                    APIClient.getClient().create(ApiInterface.class);

            Call<MoviesResponse> call = apiService.getTopRatedMovies(API_KEY);
            call.enqueue(new Callback<MoviesResponse>() {
                @Override
                public void onResponse(Call<MoviesResponse>call, Response<MoviesResponse> response) {
                    int statusCode = response.code();
                    List<Result> movies = response.body().getResults();
                    mListView.setAdapter(new MoviesAdapter((ArrayList<Result>) movies,MainActivity.this));
                    mProgressDialog.dismiss();
                    Log.d(TAG, "Number of movies received: " + movies.size());
                }

                @Override
                public void onFailure(Call<MoviesResponse>call, Throwable t) {
                    // Log error here since request failed
                    Log.e(TAG, t.toString());
                    mProgressDialog.dismiss();
                }
            });
        }
    }
