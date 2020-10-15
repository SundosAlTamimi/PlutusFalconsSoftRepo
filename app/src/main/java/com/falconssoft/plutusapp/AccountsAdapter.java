package com.falconssoft.plutusapp;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.falconssoft.plutusapp.databinding.WithdrawAccountsRowBinding;
import com.falconssoft.plutusapp.models.AccountInfoModel;

import java.util.List;

class AccountsAdapter extends RecyclerView.Adapter<AccountsAdapter.AccountsViewHolder> {
    private List<AccountInfoModel> list;

    public AccountsAdapter(List<AccountInfoModel> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public AccountsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        WithdrawAccountsRowBinding binding = WithdrawAccountsRowBinding.inflate(inflater, parent, false);
        return new AccountsViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull AccountsViewHolder holder, int position) {
        holder.binding(list.get(position));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class AccountsViewHolder extends RecyclerView.ViewHolder {
        WithdrawAccountsRowBinding binding;

        public AccountsViewHolder(WithdrawAccountsRowBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void binding(AccountInfoModel accountInfoModel) {
            binding.setAccountModel(accountInfoModel);
            binding.executePendingBindings();

        }
    }
}
