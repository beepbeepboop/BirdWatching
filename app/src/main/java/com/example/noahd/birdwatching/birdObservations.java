package com.example.noahd.birdwatching;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.example.noahd.birdwatching.HTTPHandler.HttpHandler;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class birdObservations extends AppCompatActivity implements View.OnClickListener {

    Button backbutton;
    DrawerLayout mDrawerlayout;
    private ActionBarDrawerToggle mToggle;


    private String TAG = MainActivity.class.getSimpleName();
    private ListView birdListView;
    ArrayList<HashMap<String, String>> birdlistArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bird_observations);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mDrawerlayout = (DrawerLayout) findViewById(R.id.drawer);
        birdListView = (ListView) findViewById(R.id.birdList);
        backbutton = (Button) findViewById(R.id.backBtn);

        findViewById(R.id.backBtn).setOnClickListener(this);


        new GetBirdList().execute();
        birdListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent intent = new Intent(birdObservations.this, extraBirdInfo.class);
                intent.putExtra("bird",birdlistArray.get(position));
                startActivity(intent);
            }
        });
        birdlistArray = new ArrayList<>();
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.backBtn:
                startActivity(new Intent(this,HomePageActivity.class ));
                break;


        }

    }


    private class GetBirdList extends AsyncTask<Void, Void ,Void> {


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Toast.makeText(birdObservations.this, "JSON DOWNLOADING", Toast.LENGTH_LONG).show();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            ProgressDialog progressDialog = new ProgressDialog(birdObservations.this);
            progressDialog.setMessage("Loading Data...");
            progressDialog.show();

            HttpHandler handler = new HttpHandler();
            String baseUrl = "http://birdobservationservice.azurewebsites.net/Service1.svc/birds";
            String jsonString = handler.makeServiceCall(baseUrl);



            if(jsonString != null){
                try {
                    JSONArray birdlist = new JSONArray(jsonString);

                    for (int i = 0; i< birdlist.length(); i++) {
                        JSONObject o = birdlist.getJSONObject(i);

                        String id = o.getString("Id");
                        String danishName = o.getString("NameDanish");
                        String englishName = o.getString("NameEnglish");
                        String created = o.getString("Created");
                        String photoURL = o.getString("PhotoUrl");

                        HashMap<String, String> bird = new HashMap<>();
                        bird.put("id", id);
                        bird.put("DanishName", danishName);
                        bird.put("EnglishName", englishName);
                        bird.put("Created", created);
                        bird.put("PhotoUrl", photoURL);

                        birdlistArray.add(bird);


                    }

                    //// ERROR HANDLING ////
                } catch (final JSONException e) {
                    Log.e(TAG, "JSON PARSE FAILED: " + e.getMessage());
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(),
                                    "Json parsing error: " + e.getMessage(),
                                    Toast.LENGTH_LONG).show();
                        }
                    });

                }
            } else {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(),
                                "NO JSON FETCJED, CHECK LOG",
                                Toast.LENGTH_LONG).show();
                    }
                });

            }




            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            ListAdapter adapter = new SimpleAdapter(birdObservations.this, birdlistArray,
                    R.layout.rowlist, new String[]{"id", "DanishName", "EnglishName"},
                    new int[]{R.id.id, R.id.DanishName, R.id.EnglishName});
            birdListView.setAdapter(adapter);

        }
    }








}



