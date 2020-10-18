package com.falconssoft.plutusapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Toast;

import com.etiennelawlor.discreteslider.library.ui.DiscreteSlider;
import com.falconssoft.plutusapp.databinding.ActivityWithDrawPageBinding;
import com.falconssoft.plutusapp.models.AccountInfoModel;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.Writer;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.oned.Code128Writer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.journeyapps.barcodescanner.BarcodeEncoder;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class WithdrawPage extends AppCompatActivity {

    private ActivityWithDrawPageBinding binding;
    private OnClickHandler onClickHandler;
    private AccountsAdapter adapter;
    private AccountInfoModel accountInfoModel;
    private Bitmap bitmap;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_with_draw_page);

        binding.withdrawLinearOne.setVisibility(View.VISIBLE);
        binding.withdrawLinearTwo.setVisibility(View.GONE);
        accountInfoModel = new AccountInfoModel();
        binding.setAccountInfoModel(accountInfoModel);
        onClickHandler = new OnClickHandler();
        binding.setClickHandler(onClickHandler);

        binding.withdrawSeekbar.setOnDiscreteSliderChangeListener(new DiscreteSlider.OnDiscreteSliderChangeListener() {
            @Override
            public void onPositionChanged(int position) {
                accountInfoModel.setAmount(((position + 1) * 5) + " JD");
            }
        });

        accountInfoModel.setAmount("5 JD");

        List<AccountInfoModel> list = new ArrayList<>();
        list.add(new AccountInfoModel("BOJ", ""));
        list.add(new AccountInfoModel("Arab Bank", ""));
        list.add(new AccountInfoModel("JoMoPay", ""));
        list.add(new AccountInfoModel("National Wallet", ""));
        list.add(new AccountInfoModel("Cairo Bank", ""));
        list.add(new AccountInfoModel("Housing Bank", ""));

        adapter = new AccountsAdapter(list);
        binding.withdrawAccounts.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, true));
        binding.withdrawAccounts.setAdapter(adapter);


    }

    public class OnClickHandler implements DiscreteSlider.OnDiscreteSliderChangeListener {
        public void onConfirmClicked(View view) {
            Animation animation1 = AnimationUtils.loadAnimation(WithdrawPage.this, R.anim.fade_in);
            binding.withdrawLinearOne.setVisibility(View.GONE);
            binding.withdrawLinearTwo.setVisibility(View.VISIBLE);
            binding.withdrawHeader.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(R.drawable.ic_baseline_arrow_back), null, null, null);
            binding.withdrawHeader.setCompoundDrawablePadding(5);
            binding.withdrawLinearTwo.startAnimation(animation1);
            generateBarcode();
        }

        public void onBarcodeClicked(View view) {
            binding.withdrawBarcodeButton.setBackgroundResource(R.drawable.fill_color_background);
            binding.withdrawQrbarcodeButton.setBackgroundResource(android.R.color.transparent);
            generateBarcode();

        }

        public void onQRBarcodeClicked(View view) {
            binding.withdrawQrbarcodeButton.setBackgroundResource(R.drawable.fill_color_background);
            binding.withdrawBarcodeButton.setBackgroundResource(android.R.color.transparent);
            String text = "112569845338522";// Whatever you need to encode in the QR code
            MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
            try {
                BitMatrix bitMatrix = multiFormatWriter.encode(text, BarcodeFormat.QR_CODE, 200, 200);
                BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
                bitmap = barcodeEncoder.createBitmap(bitMatrix);
                binding.withdrawBarcode.setImageBitmap(bitmap);
            } catch (WriterException e) {
                e.printStackTrace();
            }

        }

        public void onWhereIGoClicked(View view) {

            Intent withDrawIntent = new Intent(WithdrawPage.this, WhereIGo.class);
            startActivity(withDrawIntent);

        }

        public void onWithdrawClicked(View view) {
            if (binding.withdrawLinearTwo.getVisibility() == View.VISIBLE) {
                Animation animation1 = AnimationUtils.loadAnimation(WithdrawPage.this, R.anim.fade_out);
                binding.withdrawLinearOne.setVisibility(View.VISIBLE);
                binding.withdrawLinearTwo.setVisibility(View.GONE);
                binding.withdrawHeader.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(R.drawable.ic_baseline_bubble), null, null, null);
                binding.withdrawHeader.setCompoundDrawablePadding(5);

                binding.withdrawLinearOne.startAnimation(animation1);

            }
        }

        public void onCoinSelected(View view) {
            switch (view.getId()) {
                case R.id.withdraw_fiveJD:
                    accountInfoModel.setAmount("5 JD");
                    break;
                case R.id.withdraw_tenJD:
                    accountInfoModel.setAmount("10 JD");
                    break;
                case R.id.withdraw_twentyJD:
                    accountInfoModel.setAmount("20 JD");
                    break;
                case R.id.withdraw_fiftyJD:
                    accountInfoModel.setAmount("50 JD");
                    break;
            }

        }

        @Override
        public void onPositionChanged(int position) {
            switch (position) {
                case 0:
                    binding.setAmount("5 JD");
                    break;
                case 1:
                    binding.setAmount("10 JD");
                    break;
                case 2:
                    binding.setAmount("20 JD");
                    break;
                case 3:
                    binding.setAmount("50 JD");
                    break;
            }

        }
    }

    public void generateBarcode() {
        try {
            String productId = "112569845338522";
            Hashtable<EncodeHintType, ErrorCorrectionLevel> hintMap = new Hashtable<EncodeHintType, ErrorCorrectionLevel>();
            hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
            Writer codeWriter;
            codeWriter = new Code128Writer();
            BitMatrix byteMatrix = codeWriter.encode(productId, BarcodeFormat.CODE_128, 400, 200, hintMap);
            int width = byteMatrix.getWidth();
            int height = byteMatrix.getHeight();
            bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            for (int i = 0; i < width; i++) {
                for (int j = 0; j < height; j++) {
                    bitmap.setPixel(i, j, byteMatrix.get(i, j) ? Color.BLACK : Color.WHITE);
                }
            }
            binding.withdrawBarcode.setImageBitmap(bitmap);
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

}