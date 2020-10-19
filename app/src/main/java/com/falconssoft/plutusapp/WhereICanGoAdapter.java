package com.falconssoft.plutusapp;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
        holder.shopName.setText(list.get(position));


        switch (position){
//            case 0:
//                break;
            case 1:
                holder.imag.setImageDrawable(activity.getResources().getDrawable(R.drawable.alqeser));
                break;
            case 2:
                holder.imag.setImageDrawable(activity.getResources().getDrawable(R.drawable.burger_maker));
                break;
            case 3:
                holder.imag.setImageDrawable(activity.getResources().getDrawable(R.drawable.gold));
                break;
            case 4:
                holder.imag.setImageDrawable(activity.getResources().getDrawable(R.drawable.almosaly));
                break;
            case 5:
                holder.imag.setImageDrawable(activity.getResources().getDrawable(R.drawable.paradise));
                break;
        }

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent trackInTENT=new Intent(activity,ExploreActivity.class);
//                trackInTENT.putExtra("Tracking", list.get(position));
//                activity.startActivity(trackInTENT);

                final Dialog dialog = new Dialog(activity,R.style.Theme_Dialog);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.where_i_go_information);
                dialog.setCancelable(false);
                dialog.setCanceledOnTouchOutside(true);

                TextView ShopName=dialog.findViewById(R.id.ShopName);
                ShopName.setText(list.get(position));
                Button withDrawButoon=dialog.findViewById(R.id.withDrawButoon);

                withDrawButoon.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        final Dialog dialogWithDraw = new Dialog(activity,R.style.Theme_Dialog);
                        dialogWithDraw.requestWindowFeature(Window.FEATURE_NO_TITLE);
                        dialogWithDraw.setContentView(R.layout.activity_with_draw_page_dialog);
                        dialogWithDraw.setCancelable(false);
                        dialogWithDraw.setCanceledOnTouchOutside(true);
                        final ImageView withdraw_barcode;
                 final TextView withdraw_qrbarcode_button,withdraw_barcode_button;

                        withdraw_qrbarcode_button=dialogWithDraw.findViewById(R.id.withdraw_qrbarcode_button);
                        withdraw_barcode_button=dialogWithDraw.findViewById(R.id.withdraw_barcode_button);

                        withdraw_barcode=dialogWithDraw.findViewById(R.id.withdraw_barcode);


                        withdraw_barcode_button.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                withdraw_barcode_button.setBackgroundResource(R.drawable.fill_color_background);
                                withdraw_qrbarcode_button.setBackgroundResource(android.R.color.transparent);
                                withdraw_barcode.setImageResource(R.drawable.barcode);

                            }
                        });


                        withdraw_qrbarcode_button.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                withdraw_qrbarcode_button.setBackgroundResource(R.drawable.fill_color_background);
                                withdraw_barcode_button.setBackgroundResource(android.R.color.transparent);
                                withdraw_barcode.setImageResource(R.drawable.qr);

                            }
                        });


                        dialogWithDraw.show();

                    }
                });

                dialog.show();

            }
        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class WhereIGoViewHolder extends RecyclerView.ViewHolder {
        TextView shopName, accountNo;
        LinearLayout linearLayout;
        ImageView imag;

        public WhereIGoViewHolder(@NonNull View itemView) {
            super(itemView);
//
            shopName = itemView.findViewById(R.id.shopName);
            imag= itemView.findViewById(R.id.imag);
//            accountNo = itemView.findViewById(R.id.owner_raw_accountNo);
//
            linearLayout= itemView.findViewById(R.id.linearLayout);

        }
    }



}
