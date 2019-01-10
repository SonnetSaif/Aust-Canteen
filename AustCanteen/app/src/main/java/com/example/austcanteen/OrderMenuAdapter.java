package com.example.austcanteen;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.List;

/**
 * Created by sifatnabil on 2/14/2018.
 */

public class OrderMenuAdapter extends RecyclerView.Adapter<OrderMenuAdapter.ViewHolder> {
    private List<ListItems> listItems;
    private Context context;
    private DatabaseHelper myDB;

    public OrderMenuAdapter(List<ListItems> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
        myDB = new DatabaseHelper(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_order_menu_list, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final ListItems obj = listItems.get(position);

        holder.orderMenuOrderNo.setText("Order Num: " + obj.getOrderNumber());
        holder.orderMenuPaidStatus.setText("Paid: " + obj.getPaid());
        holder.orderMenuReceivedStatus.setText("Received: " + obj.getReceived());
        holder.orderMenuShowItemsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, ShowOrderedItems.class);
                i.putExtra("foodname", obj.getName());
                context.startActivity(i);
            }
        });

        final ListItems it = listItems.get(position);

    }

    private void removeItem(ListItems it){
        int position = listItems.indexOf(it);
        listItems.remove(position);
        notifyItemRemoved(position);
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView orderMenuOrderNo;
        TextView orderMenuPaidStatus;
        TextView orderMenuReceivedStatus;
        Button orderMenuShowItemsBtn;
        //ImageButton mDeleteItemBtn;
        public ViewHolder(View itemView) {
            super(itemView);
            context = itemView.getContext();

            orderMenuOrderNo = (TextView) itemView.findViewById(R.id.orderMenuOrderNo);
            orderMenuPaidStatus = (TextView) itemView.findViewById(R.id.orderMenuPaidStatus);
            orderMenuReceivedStatus = (TextView) itemView.findViewById(R.id.orderMenuReceivedStatus);
            orderMenuShowItemsBtn = (Button) itemView.findViewById(R.id.orderMenuShowItemsbtn);
           // mDeleteItemBtn = (ImageButton)itemView.findViewById(R.id.deleteItemBtn);

        }
    }
}
