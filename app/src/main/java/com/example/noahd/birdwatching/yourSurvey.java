package com.example.noahd.birdwatching;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.Image;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import java.util.ArrayList;


public class yourSurvey extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {

    private ListView listView;
    private ListAdapter listAdapter;
    ArrayList<Products> products = new ArrayList<>();
    Button btnPlaceOrder;
    ArrayList<Products> productOrders = new ArrayList<>();




    private void placeOrder()
    {
        productOrders.clear();
        for(int i=0;i<listAdapter.listProducts.size();i++)
        {
            if(listAdapter.listProducts.get(i).CartQuantity > 0)
            {
                Products products = new Products(
                        listAdapter.listProducts.get(i).ProductName
                        ,listAdapter.listProducts.get(i).ProductPrice
                        ,listAdapter.listProducts.get(i).ProductImage
                );
                products.CartQuantity = listAdapter.listProducts.get(i).CartQuantity;
                productOrders.add(products);
            }
        }
    }

    public void getProduct() {
        products.add(new Products("Pigeon",10.0d,R.mipmap.pigeon));
        products.add(new Products("Peacock",11.0d,R.mipmap.peacock));
        products.add(new Products("Eagle",12.0d,R.mipmap.eagle));
        products.add(new Products("Hadeda",13.0d,R.mipmap.hadeda));
        products.add(new Products("Cow",14.0d,R.mipmap.cow));
        products.add(new Products("HDMI Cable",16.0d,R.mipmap.hdmi));
        products.add(new Products("Headphones",11.0d,R.mipmap.headphones));
        products.add(new Products("I Mac",15.0d,R.mipmap.imac));
        products.add(new Products("I Pad",17.0d,R.mipmap.ipad));
        products.add(new Products("Keyboard",67.0d,R.mipmap.keyboard));
        products.add(new Products("Laptop",41.0d,R.mipmap.laptop));
        products.add(new Products("LCD",16.0d,R.mipmap.lcd));
        products.add(new Products("Light Bulb",18.0d,R.mipmap.light_bulb));
        products.add(new Products("Mac Mini",121.0d,R.mipmap.mac_mini));
        products.add(new Products("Monitor",122.0d,R.mipmap.monitor));
        products.add(new Products("Mouse",14.0d,R.mipmap.mouse));
        products.add(new Products("Movie Camera",51.0d,R.mipmap.movie_camera));
        products.add(new Products("Music Player",12.0d,R.mipmap.music_player));
        products.add(new Products("PC",16.0d,R.mipmap.pc));
        products.add(new Products("Playstation",12.0d,R.mipmap.playstation));
        products.add(new Products("Printer",17.0d,R.mipmap.printer));
        products.add(new Products("Remote",12.0d,R.mipmap.remote));
        products.add(new Products("Smart Watch",18.0d,R.mipmap.smart_watch));
        products.add(new Products("Smartphone",19.0d,R.mipmap.smartphone));
        products.add(new Products("Tablet",21.0d,R.mipmap.tablet));
        products.add(new Products("USB",87.0d,R.mipmap.usb));
        products.add(new Products("Webcam",87.0d,R.mipmap.webcam));
        products.add(new Products("Windows Phone",123.0d,R.mipmap.windows_phone));
        products.add(new Products("Zerox",85.0d,R.mipmap.zerox));
    }

    TextView recieve;
    ImageView cameraImageView;


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your_observations);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Button completeSurvey = (Button) findViewById(R.id.btnPlaceOrder);

        //list code
        getProduct();
        listView = (ListView) findViewById(R.id.customListView);
        listAdapter = new ListAdapter(this,products);
        listView.setAdapter(listAdapter);
        btnPlaceOrder = (Button) findViewById(R.id.btnPlaceOrder);
        btnPlaceOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                placeOrder();
            }
        });
        //end of list code

        Spinner spinner = findViewById(R.id.routeSpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.routeNames, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);


        recieve = (TextView) findViewById(R.id.recieve);
//        cameraImageView = (ImageView) findViewById(R.id.cameraImageView);

        findViewById(R.id.btnPlaceOrder).setOnClickListener(this);


        Intent intent = getIntent();
        String recieveSpecies = intent.getStringExtra("createSpecies");
        String recieveTime = intent.getStringExtra("createTimes");
        String recieveLong = intent.getStringExtra("createLong");
        String recieveLat = intent.getStringExtra("createLat");
        Bitmap bitmap = intent.getParcelableExtra("Bitmap");
       // Bitmap bitmap = (Bitmap)this.getIntent().getParcelableExtra("Bitmap");
//        cameraImageView.setImageBitmap(bitmap);

        recieve.setText("Current Species: " + recieveSpecies + "\n" +
                "Current Time: " + recieveTime + "\n" +
                "Current Longtitude: " + recieveLong + "\n" +
                "Current Latitude: " + recieveLat + "\n");





        //   Bundle extras = getIntent().getExtras();

     //  recieve.setText(recieve1);

    //   recieve.setText(getIntent().getStringExtra("createOb"));

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnPlaceOrder:
                Toast.makeText(view.getContext(), "Survey Completed, saved to storage", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, HomePageActivity.class));
                break;


        }
    }
}
