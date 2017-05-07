package xyz.tectalk.jmaha.ara_hunt;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.google.zxing.client.android.CaptureActivity;

import techtalk.ara_hunt.R;

/**
 * Created by Jitendra on 08-08-2015.
 */
public class Main extends Activity {
    public static final int REQUEST_QR_SCAN =0;
   public static int MY_PERMISSIONS_REQUEST_1;
    private TextView abtv;
    private Button start;
   // private Spinner sp;
    private Button code;
    String content ="";
  // private String[] num={"Select Team","Team Steve Jobs","Team Berners-Lee","Team Gates","Team Gosling","Team Linus","Team Stallman","Team Sergey","Team Codd","Team Larry page","Team Elon Musk"};


    public void onActivityResult(int requestCode,int resultCode,Intent intent){
        if(requestCode==REQUEST_QR_SCAN && resultCode==RESULT_OK){
            content = intent.getStringExtra("CONTENT");
            String format =intent.getStringExtra("FORMAT");
            String type =intent.getStringExtra("TYPE");
            code.setText(content);
        }
        else if(requestCode==REQUEST_QR_SCAN && resultCode==RESULT_CANCELED){
            code.setText("Rescan");
            content="";
        }
    }

    @Override
 protected void onCreate(Bundle savedInstanceState) {
     super.onCreate(savedInstanceState);
     setContentView(R.layout.main);
        start =(Button)findViewById(R.id.strt);
        code=(Button)findViewById(R.id.scend);
        abtv=(TextView)findViewById(R.id.abtv);

        if (ContextCompat.checkSelfPermission(Main.this,
                Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {

            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(Main.this,
                    Manifest.permission.CAMERA)) {

                // Show an expanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.

            } else {

                // No explanation needed, we can request the permission.

                ActivityCompat.requestPermissions(Main.this,
                        new String[]{Manifest.permission.CAMERA},MY_PERMISSIONS_REQUEST_1);

                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }
        }
        code.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(getApplicationContext(),CaptureActivity.class);
                startActivityForResult(in, REQUEST_QR_SCAN);
            }
        });


        start.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                int qn = 1;
                if (content.equals("")) {
                    Context context = getApplicationContext();
                    CharSequence text = "Scan EndoSkeleton!!";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                } else {
                    String grp = "";
                    switch (content) {
                        case "Team Steve Jobs":
                            grp = "1";
                            break;
                        case "Team Berners-Lee":
                            grp = "2";
                            break;
                        case "Team Gates":
                            grp = "3";
                            break;
                        case "Team Gosling":
                            grp = "4";
                            break;
                        case "Team Linus":
                            grp = "5";
                            break;
                        case "Team Stallman":
                            grp = "6";
                            break;
                        case "Team Sergey":
                            grp = "7";
                            break;
                        case "Team Codd":
                            grp = "8";
                            break;
                        case "Team Larry page":
                            grp = "9";
                            break;
                        case "Team Elon Musk":
                            grp = "10";
                            break;
                        default:Context context = getApplicationContext();
                            CharSequence text = "Invalid Team!!";
                            int duration = Toast.LENGTH_SHORT;
                            Toast toast = Toast.makeText(context, text, duration);
                            toast.show();
                            return;
                    }
                    Intent myIntent = new Intent(Main.this, instr.class);
                    myIntent.putExtra("key", grp);
                    myIntent.putExtra("key1", qn);//Optional parameters
                    Main.this.startActivity(myIntent);
                }

            }


        });
        abtv.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(Main.this, about.class);
                Main.this.startActivity(myIntent);
            }

        });

    }
    public void onRequestPermissionsResult(int requestCode,
                                           String[] permissions,
                                           int[] grantResults) {
        if (requestCode == MY_PERMISSIONS_REQUEST_1) {
            if(grantResults.length == 1
                    && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // We can now safely use the API we requested access to

            } else {
                // Permission was denied or request was cancelled
            }
        }
    }

}



