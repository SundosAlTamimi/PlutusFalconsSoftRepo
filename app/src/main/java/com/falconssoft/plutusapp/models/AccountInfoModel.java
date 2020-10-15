package com.falconssoft.plutusapp.models;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.falconssoft.plutusapp.BR;

public class AccountInfoModel extends BaseObservable {

    private String wallet;
    private String walletImage;

    public AccountInfoModel() {
    }

    public AccountInfoModel(String wallet, String walletImage) {
        this.wallet = wallet;
        this.walletImage = walletImage;
    }

    @Bindable
    public String getWallet() {
        return wallet;
    }

    public void setWallet(String wallet) {
        this.wallet = wallet;
        notifyPropertyChanged(BR.wallet);
    }

    @Bindable
    public String getWalletImage() {
        return walletImage;
    }

    public void setWalletImage(String walletImage) {
        this.walletImage = walletImage;
        notifyPropertyChanged(BR.walletImage);
    }
}