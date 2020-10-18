package com.falconssoft.plutusapp;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import java.io.File;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class MainActivityShop extends AppCompatActivity {
Button withDrawButton ;
TextView scanBarcode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_shop);

        initial();

//        withDrawButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent withDrawIntent=new Intent(MainActivityShop.this,WithdrawPage.class);
//                startActivity(withDrawIntent);
//            }
//        });
        scanBarcode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                readBarCode();
            }
        });

    }


    public void readBarCode() {

//        flag = 1;
////        barCodTextTemp = itemCodeText;
        Log.e("barcode_099", "in");
        IntentIntegrator intentIntegrator = new IntentIntegrator(MainActivityShop.this);
        intentIntegrator.setDesiredBarcodeFormats(intentIntegrator.ALL_CODE_TYPES);
        intentIntegrator.setBeepEnabled(false);
        intentIntegrator.setCameraId(0);
        intentIntegrator.setPrompt("SCAN");
        intentIntegrator.setBarcodeImageEnabled(false);
        intentIntegrator.initiateScan();


    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

            IntentResult Result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
            if (Result != null) {
                if (Result.getContents() == null) {
                    Log.d("MainActivity", "cancelled scan");
                    Toast.makeText(this, "cancelled", Toast.LENGTH_SHORT).show();
//                TostMesage(getResources().getString(R.string.cancel));
                } else {

                    Log.e("MainActivity", "" + Result.getContents());
                    Toast.makeText(this, "Scan ___" + Result.getContents(), Toast.LENGTH_SHORT).show();

//                    new SweetAlertDialog(MainActivityShop.this, SweetAlertDialog.SUCCESS_TYPE)
//                            .setTitleText("")
////                            .setContentText(MainActivityShop.this.getResources().getString(R.string.CHEQUE_NOT_FOR_YOU))
////                            .setConfirmText(MainActivityShop.this.getResources().getString(R.string.ok))
//                            .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
//                                @SuppressLint("WrongConstant")
//                                @Override
//                                public void onClick(SweetAlertDialog sDialog) {
//                                    sDialog.dismissWithAnimation();
//                                }
//                            }).show();



                    final Dialog dialog = new Dialog(MainActivityShop.this,R.style.Theme_Dialog);
                    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                    dialog.setContentView(R.layout.yes_dialog);
                    dialog.setCancelable(false);
                    dialog.setCanceledOnTouchOutside(true);

                    Button okButton=dialog.findViewById(R.id.okButton);

                    okButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            dialog.dismiss();

                        }
                    });

                    dialog.show();


                }

            } else {
                super.onActivityResult(requestCode, resultCode, data);
            }



    }

    private void initial() {

        withDrawButton=findViewById(R.id.withDrawButton);
        scanBarcode=findViewById(R.id.scanBarcode);
    }
}