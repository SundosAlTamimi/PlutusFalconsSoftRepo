package com.falconssoft.plutusapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Build;
import android.os.Bundle;
import android.view.View;

import com.falconssoft.plutusapp.databinding.ActivityWithDrawPageBinding;

public class WithdrawPage extends AppCompatActivity {

    private ActivityWithDrawPageBinding binding;
    private OnClickHandler onClickHandler;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_with_draw_page);

        binding.withdrawSeekbar.setAutofillHints("5", "10", "20", "50");
        binding.withdrawLinearOne.setVisibility(View.VISIBLE);
        binding.withdrawLinearTwo.setVisibility(View.GONE);

        onClickHandler = new OnClickHandler();
        binding.setClickHandler(onClickHandler);


    }

    public class OnClickHandler{
        public void onConfirmClicked(View view){
            binding.withdrawLinearOne.setVisibility(View.GONE);
            binding.withdrawLinearTwo.setVisibility(View.VISIBLE);
            binding.withdrawHeader.setCompoundDrawables(getResources().getDrawable(R.drawable.ic_baseline_arrow_back), null, null, null);
            binding.withdrawHeader.setCompoundDrawablePadding(5);
        }

        public void onBarcodeClicked(View view){
        }

        public void onQRBarcodeClicked(View view){
        }

        public void onWhereIGoClicked(View view){
        }

        public void onWithdrawClicked(View view){
            if (binding.withdrawLinearTwo.getVisibility() == View.VISIBLE){
                binding.withdrawLinearOne.setVisibility(View.VISIBLE);
                binding.withdrawLinearTwo.setVisibility(View.GONE);
                binding.withdrawHeader.setCompoundDrawables(getResources().getDrawable(R.drawable.ic_baseline_bubble), null, null, null);
                binding.withdrawHeader.setCompoundDrawablePadding(5);

            }
        }


    }
}