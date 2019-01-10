package com.example.austcanteen;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import java.util.List;


/**
 * Created by sifatnabil on 2/6/2018.
 */

public class CartMenuAdapter extends RecyclerView.Adapter<CartMenuAdapter.ViewHolder> {
    private List<ListItems> listItems;
    private Context context;
    private TextView mcost;
    private Button confirmBtn;

    public CartMenuAdapter(List<ListItems> listItems, Context context, TextView totalCost) {
        this.listItems = listItems;
        this.context = context;
        mcost = totalCost;
    }

    public CartMenuAdapter(List<ListItems> listItems, Context context, TextView totalCost, Button confirmButton) {
        this.listItems = listItems;
        this.context = context;
        mcost = totalCost;
        confirmBtn = confirmButton;
    }


    @Override
    public CartMenuAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_cart_item_list, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final CartMenuAdapter.ViewHolder holder, final int position) {
        final ListItems obj = listItems.get(position);

        holder.foodNameTV.setText(obj.getName());
        holder.foodPriceTV.setText(obj.getPrice());
        holder.ratingRB.setRating(obj.getRating());
        holder.imageView.setImageBitmap(obj.getBmp());

        if(CartMenu.totalFoodCost <= 0) confirmBtn.setEnabled(false);

        mcost.setText(CartMenu.totalFoodCost + " Taka");

        final ListItems it = listItems.get(position);

        holder.removeItemBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                removeItem(it);
                if(CartMenu.totalFoodCost <= 0) confirmBtn.setEnabled(false);
                mcost.setText(CartMenu.totalFoodCost + " Taka");
            }
        });
    }

    private void removeItem(ListItems it){
        int position = listItems.indexOf(it);
        listItems.remove(position);
        notifyItemRemoved(position);
        CartMenu.totalFoodCost = Math.abs(CartMenu.totalFoodCost - (Integer.parseInt(it.getPrice())));
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView foodNameTV;
        TextView foodPriceTV;
        RatingBar ratingRB;
        ImageView imageView;
        ImageButton removeItemBtn;
        Button confirmBtn;
        public ViewHolder(View itemView) {
            super(itemView);

            imageView = (ImageView) itemView.findViewById(R.id.imageIV);
            foodNameTV = (TextView) itemView.findViewById(R.id.nameTV);
            foodPriceTV = (TextView) itemView.findViewById(R.id.priceTV);
            ratingRB = (RatingBar) itemView.findViewById(R.id.ratingRB);
            removeItemBtn = (ImageButton) itemView.findViewById(R.id.deleteItem);
            confirmBtn = (Button) itemView.findViewById(R.id.confirmBtn);
        }
    }
}
