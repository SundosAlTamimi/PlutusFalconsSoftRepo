package com.falconssoft.plutusapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.smarteist.autoimageslider.DefaultSliderView;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderLayout;
import com.smarteist.autoimageslider.SliderView;

public class LogIn extends AppCompatActivity {

    SliderLayout sliderLayout;
    FloatingActionButton sighn_up_floatingBtn;
    Button button_logIn,button_sighnup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        initView();
        sliderLayout.setIndicatorAnimation(IndicatorAnimations.SWAP); //set indicator animation by using SliderLayout.IndicatorAnimations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderLayout.setSliderTransformAnimation(SliderAnimations.FADETRANSFORMATION);
        sliderLayout.setScrollTimeInSec(4); //set scroll delay in seconds :
        setSliderViews();
    }

    private void initView() {
        sliderLayout = findViewById(R.id.imageSlider_2);
        sighn_up_floatingBtn=findViewById(R.id.sighn_up_floatingBtn);
        sighn_up_floatingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // go to sighn up page
                Intent i=new Intent(LogIn.this,SighnUpShop.class);
                startActivity(i);
            }
        });
        button_logIn=findViewById(R.id.button_logIn);
        button_sighnup=findViewById(R.id.button_sighnup);
        button_logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(LogIn.this,MainActivity.class);
                startActivity(i);
            }
        });

        button_sighnup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(LogIn.this,SighnUpCustomer.class);
                startActivity(i);
            }
        });
    }
    private void setSliderViews() {
        for (int i = 0; i < 3; i++) {

            DefaultSliderView sliderView = new DefaultSliderView(this);
//            sliderView.setImageScaleType(ImageView.ScaleType.FIT_END);
            switch (i) {
                case 0:

                    sliderView.setImageDrawable(R.drawable.send);
                    sliderView.setImageScaleType(ImageView.ScaleType.CENTER_CROP);
                    sliderView.setDescription("Plutus App  Enables you to withdraw and deposit money in cash ." );
                    break;
                case 1:
                    sliderView.setImageScaleType(ImageView.ScaleType.CENTER_CROP);
                    sliderView.setDescription("Plutus App  Enables you to safely deal in all parts of the country and with all people." );
                    sliderView.setImageDrawable(R.drawable.scantowscreen);
                    break;
                case 2:
                    sliderView.setDescription("Plutus App  Enables you to withdraw cash bu your phone  at any time and anywhere." );
                    sliderView.setImageDrawable(R.drawable.scantowscreen);
                    sliderView.setImageDrawable(R.drawable.walet);
                    break;
                case 3:
                    sliderView.setImageDrawable(R.drawable.transaction);
                    break;
            }

//            sliderView.setImageScaleType(ImageView.ScaleType.CENTER_CROP);
//            sliderView.setDescription("The Gas System produst by Falcons Soft Companey." +
//                    "  " + (i + 1));
            final int finalI = i;

            sliderView.setOnSliderClickListener(new SliderView.OnSliderClickListener() {
                @Override
                public void onSliderClick(SliderView sliderView) {
                    Toast.makeText(LogIn.this, "This is slider " + (finalI + 1), Toast.LENGTH_SHORT).show();

                }
            });

            //at last add this view in your layout :
            sliderLayout.addSliderView(sliderView);
        }
    }
}
