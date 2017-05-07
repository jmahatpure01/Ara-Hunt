package xyz.tectalk.jmaha.ara_hunt;

import android.location.Location;
import android.support.v4.app.FragmentActivity;
import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import com.google.zxing.client.android.CaptureActivity;

import techtalk.ara_hunt.R;


/**
 * Created by Jitendra on 08-08-2015.
 */
public class map extends Activity implements OnMapReadyCallback {
    public static final int REQUEST_QR_SCAN = 0;
    public static int REQUEST_LOCATION;
    private EditText code;
    private Button chkcode;
   // private ImageView img;
    String grp;
    private ImageButton kb;
    int qn;
    static int ncd;
    String content = "";
    private String cd;
    private GoogleMap mMap;
    private double lat,log;


    @Override
    public void onBackPressed() {

    }

    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == REQUEST_QR_SCAN && resultCode == RESULT_OK) {
            content = intent.getStringExtra("CONTENT");
            String format = intent.getStringExtra("FORMAT");
            String type = intent.getStringExtra("TYPE");
            code.setText(content);
        } else if (requestCode == REQUEST_QR_SCAN && resultCode == RESULT_CANCELED) {
            code.setHint("Rescan");
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        grp = intent.getStringExtra("key");
        qn = intent.getIntExtra("key1", qn);
        ncd = intent.getIntExtra("key2", ncd);

        setContentView(R.layout.map);
        code = (EditText) findViewById(R.id.code);
        chkcode = (Button) findViewById(R.id.chkcode);
        kb = (ImageButton) findViewById(R.id.imageButton);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        MapFragment mapFragment = (MapFragment) getFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        if ((qn == 1 && grp.equals("1")) || (qn == 3 && grp.equals("2")) || (qn == 5 && grp.equals("3")) || (qn == 7 && grp.equals("4")) || (qn == 9 && grp.equals("5")) || (qn == 11 && grp.equals("6")) || (qn == 2 && grp.equals("7")) || (qn == 4 && grp.equals("8")) || (qn == 6 && grp.equals("9")) || (qn == 8 && grp.equals("10"))) {
          lat= 23.309005;log= 77.387542;
            cd = "C13579";
        }
        if ((qn == 2 && grp.equals("1")) || (qn == 11 && grp.equals("2")) || (qn == 4 && grp.equals("3")) || (qn == 6 && grp.equals("4")) || (qn == 8 && grp.equals("5")) || (qn == 10 && grp.equals("6")) || (qn == 3 && grp.equals("7")) || (qn == 5 && grp.equals("8")) || (qn == 7 && grp.equals("9")) || (qn == 9 && grp.equals("10"))) {
         lat =23.309456;log= 77.387033;
            cd = "W211468";
        }
        if ((qn == 3 && grp.equals("1")) || (qn == 5 && grp.equals("2")) || (qn == 7 && grp.equals("3")) || (qn == 9 && grp.equals("4")) || (qn == 11 && grp.equals("5")) || (qn == 2 && grp.equals("6")) || (qn == 4 && grp.equals("7")) || (qn == 6 && grp.equals("8")) || (qn == 8 && grp.equals("9")) || (qn == 10 && grp.equals("10"))) {
         lat= 23.309429;log= 77.386512;
            cd = "S357911";
        }
        if ((qn == 4 && grp.equals("1")) || (qn == 6 && grp.equals("2")) || (qn == 8 && grp.equals("3")) || (qn == 10 && grp.equals("4")) || (qn == 1 && grp.equals("5")) || (qn == 3 && grp.equals("6")) || (qn == 5 && grp.equals("7")) || (qn == 7 && grp.equals("8")) || (qn == 9 && grp.equals("9")) || (qn == 11 && grp.equals("10"))) {
         lat=23.309197;log= 77.386523;
            cd = "O468101";
        }
        if ((qn == 5 && grp.equals("1")) || (qn == 7 && grp.equals("2")) || (qn == 9 && grp.equals("3")) || (qn == 11 && grp.equals("4")) || (qn == 2 && grp.equals("5")) || (qn == 4 && grp.equals("6")) || (qn == 6 && grp.equals("7")) || (qn == 8 && grp.equals("8")) || (qn == 10 && grp.equals("9")) || (qn == 3 && grp.equals("10"))) {
            lat=23.308776;log= 77.386477;
            cd = "B579112";
        }
        if ((qn == 6 && grp.equals("1")) || (qn == 8 && grp.equals("2")) || (qn == 10 && grp.equals("3")) || (qn == 3 && grp.equals("4")) || (qn == 5 && grp.equals("5")) || (qn == 7 && grp.equals("6")) || (qn == 9 && grp.equals("7")) || (qn == 11 && grp.equals("8")) || (qn == 1 && grp.equals("9")) || (qn == 2 && grp.equals("10"))) {
           lat=23.308459;log= 77.386515;
            cd = "N681035";
        }
        if ((qn == 7 && grp.equals("1")) || (qn == 9 && grp.equals("2")) || (qn == 11 && grp.equals("3")) || (qn == 2 && grp.equals("4")) || (qn == 6 && grp.equals("5")) || (qn == 8 && grp.equals("6")) || (qn == 10 && grp.equals("7")) || (qn == 1 && grp.equals("8")) || (qn == 3 && grp.equals("9")) || (qn == 5 && grp.equals("10"))) {
          lat=23.307720;log= 77.386496;
            cd = "G791126";
        }
        if ((qn == 8 && grp.equals("1")) || (qn == 10 && grp.equals("2")) || (qn == 3 && grp.equals("3")) || (qn == 5 && grp.equals("4")) || (qn == 7 && grp.equals("5")) || (qn == 9 && grp.equals("6")) || (qn == 11 && grp.equals("7")) || (qn == 2 && grp.equals("8")) || (qn == 4 && grp.equals("9")) || (qn == 6 && grp.equals("10"))) {
           lat=23.307920;log= 77.386838;
            cd = "A810357";
        }
        if ((qn == 9 && grp.equals("1")) || (qn == 2 && grp.equals("2")) || (qn == 6 && grp.equals("3")) || (qn == 4 && grp.equals("4")) || (qn == 10 && grp.equals("5")) || (qn == 5 && grp.equals("6")) || (qn == 7 && grp.equals("7")) || (qn == 9 && grp.equals("8")) || (qn == 2 && grp.equals("9")) || (qn == 1 && grp.equals("10"))) {
          lat=23.308184;log= 77.387112;
            cd = "P926410";
        }
        if ((qn == 10 && grp.equals("1")) || (qn == 1 && grp.equals("2")) || (qn == 2 && grp.equals("3")) || (qn == 8 && grp.equals("4")) || (qn == 3 && grp.equals("5")) || (qn == 1 && grp.equals("6")) || (qn == 8 && grp.equals("7")) || (qn == 3 && grp.equals("8")) || (qn == 5 && grp.equals("9")) || (qn == 4 && grp.equals("10"))) {
          lat=23.307407;log= 77.385973;
            cd = "F101283";
        }
        if ((qn == 11 && grp.equals("1")) || (qn == 4 && grp.equals("2")) || (qn == 1 && grp.equals("3")) || (qn == 1 && grp.equals("4")) || (qn == 4 && grp.equals("5")) || (qn == 6 && grp.equals("6")) || (qn == 1 && grp.equals("7")) || (qn == 10 && grp.equals("8")) || (qn == 11 && grp.equals("9")) || (qn == 7 && grp.equals("10"))) {
           lat=23.308588;log= 77.385997;
            cd = "C114114";
        }


        code.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), CaptureActivity.class);
                startActivityForResult(in, REQUEST_QR_SCAN);
            }
        });
        kb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);
            }
        });


        chkcode.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {


                if (content.equals(cd)) {
                    qn += 1;
                    ncd += 1;
                    Context context = getApplicationContext();
                    CharSequence text = "Correct Code....Next Question!!!";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                    Intent myIntent;
                    if (qn == 12) {
                        myIntent = new Intent(map.this, thnku.class);
                    } else {
                        myIntent = new Intent(map.this, question.class);
                    }
                    myIntent.putExtra("key", grp);
                    myIntent.putExtra("key1", qn);
                    myIntent.putExtra("key2", ncd);//Optional parameters
                    map.this.startActivity(myIntent);


                } else {
                    Context context = getApplicationContext();
                    CharSequence text = "Wrong Code";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
            }


        });

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            // Check Permissions Now
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    REQUEST_LOCATION);
        } else {
            // permission has been granted, continue as usual
            mMap.setMyLocationEnabled(true);
        }
        // Add a marker in Sydney and move the camera

        LatLng sydney = new LatLng(lat, log);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Location"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney,18.0f));

    }
    public void onRequestPermissionsResult(int requestCode,
                                           String[] permissions,
                                           int[] grantResults) {
        if (requestCode == REQUEST_LOCATION) {
            if(grantResults.length == 1
                    && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // We can now safely use the API we requested access to

            } else {
                // Permission was denied or request was cancelled
            }
        }
    }

}
