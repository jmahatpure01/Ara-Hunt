package xyz.tectalk.jmaha.ara_hunt;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import techtalk.ara_hunt.R;


/**
 * Created by Jitendra on 08-08-2015.
 */
public class question extends Activity {
    private TextView ques;
    private Button op1;
    private Button op2;
    private Button op3;
    private Button op4;
    private TextView time;
    String grp;
    int qn;
   static int ncd;
    long remti;
    CountDownTimer t;

    @Override
    public void onBackPressed() {
        Context context = getApplicationContext();
        CharSequence text = "You are not allowed to Back off";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        grp = intent.getStringExtra("key");
        qn = intent.getIntExtra("key1", qn);
        if (qn > 1)
            ncd = intent.getIntExtra("key2", ncd);
        setContentView(R.layout.question);
        time = (TextView) findViewById(R.id.t1);
          t = new CountDownTimer(30000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                remti = millisUntilFinished / 1000;
                time.setText("Time remaining :" + (millisUntilFinished / 1000) + " secs");
                if (remti == 10) {
                    time.setTextColor(getResources().getColor(R.color.tim));
                }

            }

            @Override
            public void onFinish() {
                time.setText("TimeUp!!!");
                Context context = getApplicationContext();
                CharSequence text = "Time Up next question";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
                qn += 1;
                Intent myIntent = new Intent(question.this, question.class);
                myIntent.putExtra("key", grp);
                myIntent.putExtra("key1", qn);
                myIntent.putExtra("key2", ncd);//Optional parameters
                question.this.startActivity(myIntent);

            }
        };
        t.start();


        ques = (TextView) findViewById(R.id.ques);
        op1 = (Button) findViewById(R.id.op1);
        op2 = (Button) findViewById(R.id.op2);
        op3 = (Button) findViewById(R.id.op3);
        op4 = (Button) findViewById(R.id.op4);



        if ((qn == 1 && grp.equals("1")) || (qn == 3 && grp.equals("2")) || (qn == 5 && grp.equals("3")) || (qn == 7 && grp.equals("4")) || (qn == 9 && grp.equals("5")) || (qn == 11 && grp.equals("6")) || (qn == 2 && grp.equals("7")) || (qn == 4 && grp.equals("8")) || (qn == 6 && grp.equals("9")) || (qn == 8 && grp.equals("10"))) {

            ques.setText(getResources().getString(R.string.ques1));
            op1.setText(getResources().getString(R.string.q1op1));
            op2.setText(getResources().getString(R.string.q1op2));
            op3.setText(getResources().getString(R.string.q1op3));
            op4.setText(getResources().getString(R.string.q1op4));

            op3.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    correct();
                }
            });
            op1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                   wrong();
                }
            });
            op2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    wrong();
                }
            });
            op4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    wrong();
                }
            });


        }
        if ((qn == 2 && grp.equals("1")) || (qn == 11 && grp.equals("2")) || (qn == 4 && grp.equals("3")) || (qn == 6 && grp.equals("4")) || (qn == 8 && grp.equals("5")) || (qn == 10 && grp.equals("6")) || (qn == 3 && grp.equals("7")) || (qn == 5 && grp.equals("8")) || (qn == 7 && grp.equals("9")) || (qn == 9 && grp.equals("10"))) {
            ques.setText(getResources().getString(R.string.ques2));
            op1.setText(getResources().getString(R.string.q2op1));
            op2.setText(getResources().getString(R.string.q2op2));
            op3.setText(getResources().getString(R.string.q2op3));
            op4.setText(getResources().getString(R.string.q2op4));

            op2.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    correct();
                }
            });
            op1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    wrong();
                }
            });
            op3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    wrong();
                }
            });
            op4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    wrong();
                }
            });

        }
        if ((qn == 3 && grp.equals("1")) || (qn == 5 && grp.equals("2")) || (qn == 7 && grp.equals("3")) || (qn == 9 && grp.equals("4")) || (qn == 11 && grp.equals("5")) || (qn == 2 && grp.equals("6")) || (qn == 4 && grp.equals("7")) || (qn == 6 && grp.equals("8")) || (qn == 8 && grp.equals("9")) || (qn == 10 && grp.equals("10"))) {
            ques.setText(getResources().getString(R.string.ques3));
            op1.setText(getResources().getString(R.string.q3op1));
            op2.setText(getResources().getString(R.string.q3op2));
            op3.setText(getResources().getString(R.string.q3op3));
            op4.setText(getResources().getString(R.string.q3op4));
            op1.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    correct();
                }
            });
            op3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    wrong();
                }
            });
            op2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    wrong();
                }
            });
            op4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    wrong();
                }
            });

        }
        if ((qn == 4 && grp.equals("1")) || (qn == 6 && grp.equals("2")) || (qn == 8 && grp.equals("3")) || (qn == 10 && grp.equals("4")) || (qn == 1 && grp.equals("5")) || (qn == 3 && grp.equals("6")) || (qn == 5 && grp.equals("7")) || (qn == 7 && grp.equals("8")) || (qn == 9 && grp.equals("9")) || (qn == 11 && grp.equals("10"))) {
            ques.setText(getResources().getString(R.string.ques4));
            op1.setText(getResources().getString(R.string.q4op1));
            op2.setText(getResources().getString(R.string.q4op2));
            op3.setText(getResources().getString(R.string.q4op3));
            op4.setText(getResources().getString(R.string.q4op4));
            op4.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    correct();
                }
            });
            op1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    wrong();
                }
            });
            op2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    wrong();
                }
            });
            op3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    wrong();
                }
            });

        }
        if ((qn == 5 && grp.equals("1")) || (qn == 7 && grp.equals("2")) || (qn == 9 && grp.equals("3")) || (qn == 11 && grp.equals("4")) || (qn == 2 && grp.equals("5")) || (qn == 4 && grp.equals("6")) || (qn == 6 && grp.equals("7")) || (qn == 8 && grp.equals("8")) || (qn == 10 && grp.equals("9")) || (qn == 3 && grp.equals("10"))) {
            ques.setText(getResources().getString(R.string.ques5));
            op1.setText(getResources().getString(R.string.q5op1));
            op2.setText(getResources().getString(R.string.q5op2));
            op3.setText(getResources().getString(R.string.q5op3));
            op4.setText(getResources().getString(R.string.q5op4));
            op2.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    correct();
                }
            });
            op1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    wrong();
                }
            });
            op3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    wrong();
                }
            });
            op4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    wrong();
                }
            });

        }

        if ((qn == 6 && grp.equals("1")) || (qn == 8 && grp.equals("2")) || (qn == 10 && grp.equals("3")) || (qn == 3 && grp.equals("4")) || (qn == 5 && grp.equals("5")) || (qn == 7 && grp.equals("6")) || (qn == 9 && grp.equals("7")) || (qn == 11 && grp.equals("8")) || (qn == 1 && grp.equals("9")) || (qn == 2 && grp.equals("10"))) {
            ques.setText(getResources().getString(R.string.ques6));
            op1.setText(getResources().getString(R.string.q6op1));
            op2.setText(getResources().getString(R.string.q6op2));
            op3.setText(getResources().getString(R.string.q6op3));
            op4.setText(getResources().getString(R.string.q6op4));
            op4.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    correct();
                }
            });
            op1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    wrong();
                }
            });
            op2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    wrong();
                }
            });
            op3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    wrong();
                }
            });

        }
        if ((qn == 7 && grp.equals("1")) || (qn == 9 && grp.equals("2")) || (qn == 11 && grp.equals("3")) || (qn == 2 && grp.equals("4")) || (qn == 6 && grp.equals("5")) || (qn == 8 && grp.equals("6")) || (qn == 10 && grp.equals("7")) || (qn == 1 && grp.equals("8")) || (qn == 3 && grp.equals("9")) || (qn == 5 && grp.equals("10"))) {
            ques.setText(getResources().getString(R.string.ques7));
            op1.setText(getResources().getString(R.string.q7op1));
            op2.setText(getResources().getString(R.string.q7op2));
            op3.setText(getResources().getString(R.string.q7op3));
            op4.setText(getResources().getString(R.string.q7op4));
            op3.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    correct();
                }
            });
            op1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    wrong();
                }
            });
            op2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    wrong();
                }
            });
            op4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    wrong();
                }
            });

        }
        if ((qn == 8 && grp.equals("1")) || (qn == 10 && grp.equals("2")) || (qn == 3 && grp.equals("3")) || (qn == 5 && grp.equals("4")) || (qn == 7 && grp.equals("5")) || (qn == 9 && grp.equals("6")) || (qn == 11 && grp.equals("7")) || (qn == 2 && grp.equals("8")) || (qn == 4 && grp.equals("9")) || (qn == 6 && grp.equals("10"))) {
            ques.setText(getResources().getString(R.string.ques8));
            op1.setText(getResources().getString(R.string.q8op1));
            op2.setText(getResources().getString(R.string.q8op2));
            op3.setText(getResources().getString(R.string.q8op3));
            op4.setText(getResources().getString(R.string.q8op4));
            op1.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    correct();
                }
            });
            op3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    wrong();
                }
            });
            op2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    wrong();
                }
            });
            op4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    wrong();
                }
            });

        }
        if ((qn == 9 && grp.equals("1")) || (qn == 2 && grp.equals("2")) || (qn == 6 && grp.equals("3")) || (qn == 4 && grp.equals("4")) || (qn == 10 && grp.equals("5")) || (qn == 5 && grp.equals("6")) || (qn == 7 && grp.equals("7")) || (qn == 9 && grp.equals("8")) || (qn == 2 && grp.equals("9")) || (qn == 1 && grp.equals("10"))) {
            ques.setText(getResources().getString(R.string.ques9));
            op1.setText(getResources().getString(R.string.q9op1));
            op2.setText(getResources().getString(R.string.q9op2));
            op3.setText(getResources().getString(R.string.q9op3));
            op4.setText(getResources().getString(R.string.q9op4));
            op4.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    correct();
                }
            });
            op1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    wrong();
                }
            });
            op2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    wrong();
                }
            });
            op3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    wrong();
                }
            });

        }
        if ((qn == 10 && grp.equals("1")) || (qn == 1 && grp.equals("2")) || (qn == 2 && grp.equals("3")) || (qn == 8 && grp.equals("4")) || (qn == 3 && grp.equals("5")) || (qn == 1 && grp.equals("6")) || (qn == 8 && grp.equals("7")) || (qn == 3 && grp.equals("8")) || (qn == 5 && grp.equals("9")) || (qn == 4 && grp.equals("10"))) {
            ques.setText(getResources().getString(R.string.ques10));
            op1.setText(getResources().getString(R.string.q10op1));
            op2.setText(getResources().getString(R.string.q10op2));
            op3.setText(getResources().getString(R.string.q10op3));
            op4.setText(getResources().getString(R.string.q10op4));
            op2.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    correct();
                }
            });
            op1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    wrong();
                }
            });
            op3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    wrong();
                }
            });
            op4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    wrong();
                }
            });

        }
        if ((qn == 11 && grp.equals("1")) || (qn == 4 && grp.equals("2")) || (qn == 1 && grp.equals("3")) || (qn == 1 && grp.equals("4")) || (qn == 4 && grp.equals("5")) || (qn == 6 && grp.equals("6")) || (qn == 1 && grp.equals("7")) || (qn == 10 && grp.equals("8")) || (qn == 11 && grp.equals("9")) || (qn == 7 && grp.equals("10"))) {
            ques.setText(getResources().getString(R.string.ques11));
            op1.setText(getResources().getString(R.string.q11op1));
            op2.setText(getResources().getString(R.string.q11op2));
            op3.setText(getResources().getString(R.string.q11op3));
            op4.setText(getResources().getString(R.string.q11op4));
            op3.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    correct();
                }
            });
            op1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    t.cancel();
                    Context context = getApplicationContext();
                    CharSequence text = "Wrong Answer!";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                    Intent myIntent = new Intent(question.this, thnku.class);
                    myIntent.putExtra("key", grp);
                    myIntent.putExtra("key1", qn);
                    myIntent.putExtra("key2", ncd);//Optional parameters
                    question.this.startActivity(myIntent);
                }
            });
            op2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    t.cancel();
                    Context context = getApplicationContext();
                    CharSequence text = "Wrong Answer!";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                    Intent myIntent = new Intent(question.this, thnku.class);
                    myIntent.putExtra("key", grp);
                    myIntent.putExtra("key1", qn);
                    myIntent.putExtra("key2", ncd);//Optional parameters
                    question.this.startActivity(myIntent);
                }
            });
            op4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    t.cancel();
                    Context context = getApplicationContext();
                    CharSequence text = "Wrong Answer!";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                    Intent myIntent = new Intent(question.this, thnku.class);
                    myIntent.putExtra("key", grp);
                    myIntent.putExtra("key1", qn);
                    myIntent.putExtra("key2", ncd);//Optional parameters
                    question.this.startActivity(myIntent);
                }
            });

        }

    }
    public void correct(){
        t.cancel();
        Context context = getApplicationContext();
        CharSequence text = "Correct Answer";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
        Intent myIntent = new Intent(question.this, map.class);
        myIntent.putExtra("key", grp);
        myIntent.putExtra("key1", qn);
        myIntent.putExtra("key2", ncd);//Optional parameters
        question.this.startActivity(myIntent);



    }
    public void wrong(){
        t.cancel();
        Context context = getApplicationContext();
        CharSequence text = "Wrong Answer! 1 question skipped";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
        qn += 1;
        Intent myIntent = new Intent(question.this, question.class);
        myIntent.putExtra("key", grp);
        myIntent.putExtra("key1", qn);
        myIntent.putExtra("key2", ncd);//Optional parameters
        question.this.startActivity(myIntent);


    }
}