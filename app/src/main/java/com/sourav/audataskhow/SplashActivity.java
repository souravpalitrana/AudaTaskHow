package com.sourav.audataskhow;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class SplashActivity extends AppCompatActivity {


    CustomRecyclerAdapter adapter;
    RecyclerView recyclerView;
    int height=0;
    final long totalScrollTime = Long.MAX_VALUE; //total scroll time. I think that 300 000 000 years is close enouth to infinity. if not enought you can restart timer in onFinish()
    int alreadyScrolledHeight = 0;
    final int scrollPeriod = 20; // every 20 ms scoll will happened. smaller values for smoother
    ListView list;
    final int heightToScroll = 20;
    LinearLayoutManager linearLayoutManager;
    ArrayList<String> data;
    CountDownTimer autoscrollTimer;
    ImageView settingCircle;

    boolean stopFinal =false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        recyclerView=(RecyclerView)findViewById(R.id.recycler);
        settingCircle=(ImageView)findViewById(R.id.setting_circle);
        data=new ArrayList<String>();
        data.add("asd");
        data.add("asd");
        data.add("asd");

        data.add("asd");
        data.add("asd");

        adapter=new CustomRecyclerAdapter(getApplicationContext(),data);
        linearLayoutManager=new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
        Animation myanimation = AnimationUtils.loadAnimation(this, R.anim.rotate);
        settingCircle.startAnimation(myanimation);


        autoscrollTimer = startAutoscroll(recyclerView);




        new AsyncTaskRunner().execute();

    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev){

        //Ignore scroll events.
        if(ev.getAction() == MotionEvent.ACTION_MOVE)
            return true;

        //Dispatch event for non-scroll actions, namely clicks!
        return super.dispatchTouchEvent(ev);
    }




    private CountDownTimer startAutoscroll(RecyclerView listView) {

        final long totalScrollTime = 5000;
        final int scrollPeriod = 40;
        final int heightToScroll = 4;


        final CountDownTimer timer = new CountDownTimer(totalScrollTime,
                scrollPeriod) {
            private int height;

            public void onTick(long millisUntilFinished) {

                recyclerView.smoothScrollBy(0, heightToScroll);
                //   Log.d("Position abul",linearLayoutManager.findLastCompletelyVisibleItemPosition()+"");

                if(linearLayoutManager.findLastVisibleItemPosition()==data.size()-1){
                    //Its at bottom ..
                    // recyclerView.scrollToPosition(0);
                    showToast();
                }

            }

            public void onFinish() {
                // saving scroled height, and starting this timer again
                alreadyScrolledHeight = height;
                if(!stopFinal)
                    this.start();
            }
        };

        recyclerView.post(new Runnable() {
            @Override
            public void run() {
                timer.start();
            }
        });
        return timer;
    }




    private void stopAutoscroll(CountDownTimer autoscrollTimer) {
        autoscrollTimer.cancel();
        // this will reset scrolled height
        // if you want to pause this - just don't reset this field;
        alreadyScrolledHeight = 0;
    }
    public void showToast()
    {
        //Toast.makeText(getApplicationContext(),"At last",Toast.LENGTH_LONG).show();
        stopAutoscroll(autoscrollTimer);
        recyclerView.scrollToPosition(0);

    }



    public class	AsyncTaskRunner extends AsyncTask<String, String, String>
    {
        @Override
        protected String doInBackground(String... arg0) {
            // TODO Auto-generated method stub

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return null;
        }

        protected void onPostExecute(String string)
        {

            stopFinal=true;
            stopAutoscroll(autoscrollTimer);

            Intent intent= new Intent(SplashActivity.this,DetailActivity.class);
            startActivity(intent);
            finish();
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);

        }



    }




}
