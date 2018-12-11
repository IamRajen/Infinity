package com.infinity.infinity;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class FunctionDetails extends AppCompatActivity {

    private ViewPager mSlideViewPager;
    private LinearLayout mDotLayout;
    private TextView[] mDots;

    Button next;
    Button back;
    public int mCurrentPage;


    private SliderAdapter sliderAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_function_details);
        getSupportActionBar().hide();
        next = findViewById(R.id.button);
        back = findViewById(R.id.button2);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mCurrentPage==4)
                {
                    startActivity(new Intent(FunctionDetails.this,LogInPage.class));
                }else {
                    mSlideViewPager.setCurrentItem(mCurrentPage + 1);
                }
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    mSlideViewPager.setCurrentItem(mCurrentPage-1);

            }
        });
        mDotLayout = (LinearLayout)findViewById(R.id.dotsLayout);
        mSlideViewPager =(ViewPager)findViewById(R.id.slideViewPager);
        sliderAdapter = new SliderAdapter(this);

        mSlideViewPager.setAdapter(sliderAdapter);
        addDotsIndicator(0);


        mSlideViewPager.addOnPageChangeListener(viewListener);
    }


    public void addDotsIndicator(int position)
    {
        mDots = new TextView[5];
        mDotLayout.removeAllViews();
        for(int i=0;i<mDots.length;i++)
        {
            mDots[i]= new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226;"));
            mDots[i].setTextSize(35);
            mDots[i].setTextColor(getResources().getColor(R.color.dots));

            mDotLayout.addView(mDots[i]);
        }


        if(mDots.length>0)
        {
            mDots[position].setTextColor(getResources().getColor(R.color.dots));
        }
    }




    ViewPager.OnPageChangeListener viewListener =new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
                addDotsIndicator(position);

                mCurrentPage=position;

                if(position==0)
                {
                    next.setEnabled(true);
                    back.setEnabled(false);
                    back.setVisibility(View.INVISIBLE);
                    next.setText("Next");
                    back.setText("");
                }
                else if(position == mDots.length -1){

                    next.setEnabled(true);
                    back.setEnabled(true);
                    back.setVisibility(View.VISIBLE);

                    next.setText("Finish");
                    back.setText("Back");
            }
            else{
                    next.setEnabled(true);
                    back.setEnabled(true);
                    back.setVisibility(View.VISIBLE);

                    next.setText("Next");
                    back.setText("Back");
                }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}
