package xyz.tectalk.jmaha.ara_hunt;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import techtalk.ara_hunt.R;

/**
 * Created by Jitendra on 22-08-2015.
 */
public class thnku extends Activity {
    private TextView nc;
    private TextView gr;
    String srt;
    String grp;
    int ncd;

    @Override
    public void onBackPressed(){
        this.finish();
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);

    }




    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        grp = intent.getStringExtra("key");
        ncd = intent.getIntExtra("key2",ncd);
        setContentView(R.layout.thanku);
        nc = (TextView) findViewById(R.id.textView);
        gr = (TextView) findViewById(R.id.textView6);
        switch(grp)
        {
            case "1" : srt="Team Steve Jobs";
                break;
            case  "2" : srt="Team Berners-Lee";
                break;
            case  "3" : srt="Team Gates";
                break;
            case  "4" : srt="Team Gosling";
                break;
            case  "5" : srt="Team Linus";
                break;
            case  "6" : srt="Team Stallman";
                break;
            case  "7" : srt="Team Sergey";
                break;
            case  "8" : srt="Team Codd";
                break;
            case  "9" : srt="Team Larry page";
                break;
            case  "10" : srt="Team Elon Musk";
        }
        nc.setText("No Of Correct Codes Scanned "+ncd);
        gr.setText(srt);
    }
}
