package com.falconssoft.plutusapp;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.falconssoft.plutusapp.databinding.WithdrawAccountsRowBinding;
import com.falconssoft.plutusapp.models.AccountInfoModel;

import java.util.List;

class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {
    private List<AccountInfoModel> list;

    public CategoryAdapter(List<AccountInfoModel> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public CategoryAdapter.CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        WithdrawAccountsRowBinding binding = WithdrawAccountsRowBinding.inflate(inflater, parent, false);
        return new CategoryAdapter.CategoryViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAdapter.CategoryViewHolder holder, int position) {
        holder.binding(list.get(position));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class CategoryViewHolder extends RecyclerView.ViewHolder {
        WithdrawAccountsRowBinding binding;

        public CategoryViewHolder(WithdrawAccountsRowBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void binding(AccountInfoModel accountInfoModel) {
            binding.setAccountModel(accountInfoModel);
            binding.executePendingBindings();

        }
    }
}
