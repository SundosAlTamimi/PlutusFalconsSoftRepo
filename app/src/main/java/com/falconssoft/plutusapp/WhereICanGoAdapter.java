package com.falconssoft.plutusapp;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.List;

class WhereICanGoAdapter extends RecyclerView.Adapter<WhereICanGoAdapter.WhereIGoViewHolder> {

    private List<String> list;
    private Activity activity;

    public WhereICanGoAdapter(Activity activity, List<String> list) {
        this.list = list;
        this.activity = activity;
    }


    @NonNull
    @Override
    public WhereIGoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // inflate layout and retrieve binding
//        ListItemBinding binding = DataBindingUtil.inflate(host.getLayoutInflater(),
//                R.layout.list_item, parent, false);
//
//        return new ItemViewHolder(binding);
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.location_shop_adapter_row, parent, false);
        return new WhereICanGoAdapter.WhereIGoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WhereIGoViewHolder holder, final int position) {

//        holder.chequeNo.setText(list.get(position));
//        holder.accountNo.setText(list.get(position));

//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent trackInTENT=new Intent(activity,TrackingCheque.class);
//                trackInTENT.putExtra("Tracking", list.get(position));
//                activity.startActivity(trackInTENT);
//
//            }
//        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class WhereIGoViewHolder extends RecyclerView.ViewHolder {
        TextView chequeNo, accountNo;

        public WhereIGoViewHolder(@NonNull View itemView) {
            super(itemView);
//
//            chequeNo = itemView.findViewById(R.id.owner_raw_chequeNo);
//            accountNo = itemView.findViewById(R.id.owner_raw_accountNo);
//

        }
    }
}
