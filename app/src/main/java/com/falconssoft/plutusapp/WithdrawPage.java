package com.falconssoft.plutusapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;

import com.etiennelawlor.discreteslider.library.ui.DiscreteSlider;
import com.falconssoft.plutusapp.databinding.ActivityWithDrawPageBinding;
import com.falconssoft.plutusapp.models.AccountInfoModel;

import java.util.ArrayList;
import java.util.List;

public class WithdrawPage extends AppCompatActivity {

    private ActivityWithDrawPageBinding binding;
    private OnClickHandler onClickHandler;
    private AccountsAdapter adapter;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_with_draw_page);

        binding.withdrawLinearOne.setVisibility(View.VISIBLE);
        binding.withdrawLinearTwo.setVisibility(View.GONE);
        binding.withdrawSeekbar.setOnDiscreteSliderChangeListener(new DiscreteSlider.OnDiscreteSliderChangeListener() {
            @Override
            public void onPositionChanged(int position) {
                switch (position){
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
        });

        onClickHandler = new OnClickHandler();
        binding.setClickHandler(onClickHandler);
        binding.setAmount("5 JD");

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

    public class OnClickHandler implements DiscreteSlider.OnDiscreteSliderChangeListener{
        public void onConfirmClicked(View view){
            binding.withdrawLinearOne.setVisibility(View.GONE);
            binding.withdrawLinearTwo.setVisibility(View.VISIBLE);
            binding.withdrawHeader.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(R.drawable.ic_baseline_arrow_back), null, null, null);
            binding.withdrawHeader.setCompoundDrawablePadding(5);

            Animation animation1 = AnimationUtils.loadAnimation(WithdrawPage.this, R.anim.fade_out);
            binding.withdrawLinearOne.startAnimation(animation1);
        }

        public void onBarcodeClicked(View view){
            binding.withdrawBarcodeButton.setBackgroundResource(R.drawable.fill_color_background);
            binding.withdrawQrbarcodeButton.setBackgroundResource(android.R.color.transparent);
            binding.withdrawBarcode.setImageResource(R.drawable.barcode);

        }

        public void onQRBarcodeClicked(View view){
            binding.withdrawQrbarcodeButton.setBackgroundResource(R.drawable.fill_color_background);
            binding.withdrawBarcodeButton.setBackgroundResource(android.R.color.transparent);
            binding.withdrawBarcode.setImageResource(R.drawable.qr);

        }

        public void onWhereIGoClicked(View view){
        }

        public void onWithdrawClicked(View view){
            if (binding.withdrawLinearTwo.getVisibility() == View.VISIBLE){
                binding.withdrawLinearOne.setVisibility(View.VISIBLE);
                binding.withdrawLinearTwo.setVisibility(View.GONE);
                binding.withdrawHeader.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(R.drawable.ic_baseline_bubble), null, null, null);
                binding.withdrawHeader.setCompoundDrawablePadding(5);

                Animation animation1 = AnimationUtils.loadAnimation(WithdrawPage.this, R.anim.fade_in);
                binding.withdrawLinearTwo.startAnimation(animation1);

            }
        }

        @Override
        public void onPositionChanged(int position) {
            switch (position){
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


}