package xyz.tectalk.jmaha.ara_hunt;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import techtalk.ara_hunt.R;

/**
 * Created by Jitendra on 11-03-2016.
 */
public class instr extends Activity {
    Button pl;
    String grp;
    int qn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        grp = intent.getStringExtra("key");
        qn=intent.getIntExtra("key1", qn);
        setContentView(R.layout.instr);
        pl=(Button)findViewById(R.id.btn);

        pl.setOnClickListener(new View.OnClickListener() {

                                  @Override
                                  public void onClick(View view) {
                                      Intent myIntent = new Intent(instr.this, question.class);
                                      myIntent.putExtra("key", grp);
                                      myIntent.putExtra("key1", qn);
                                      instr.this.startActivity(myIntent);
                                  }}
        );

    }
}
