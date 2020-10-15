package com.falconssoft.plutusapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
Button withDrawButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initial();

        withDrawButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent withDrawIntent=new Intent(MainActivity.this,WithdrawPage.class);
                startActivity(withDrawIntent);
            }
        });

    }

    private void initial() {

        withDrawButton=findViewById(R.id.withDrawButton);

    }
}