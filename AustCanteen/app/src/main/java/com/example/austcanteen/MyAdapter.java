package com.example.austcanteen;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Iterator;
import java.util.List;

/**
 * Created by sifatnabil on 1/22/2018.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{
    private List <ListItems> listItems;
    private Context context;
    private String available;
    TextView mcost;

    public MyAdapter(List<ListItems> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
    }

    public MyAdapter(List<ListItems> listItems, Context context, TextView costTextView) {
        this.listItems = listItems;
        this.context = context;
        mcost = costTextView;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_list_items, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final ListItems obj = listItems.get(position);

        holder.nameTv.setText(obj.getName());
        holder.priceTv.setText(obj.getPrice());
        holder.ratingBar.setRating(obj.getRating());
        mcost.setText(CartMenu.totalFoodCost + " Taka");
        available = obj.getAvailibility();
        if(available.equals("Yes")){
            holder.availableTV.setText("Available");
            holder.availableTV.setTextColor(ContextCompat.getColor(context, R.color.available));
        } else{
            holder.availableTV.setText("Not Available");
            holder.availableTV.setTextColor(ContextCompat.getColor(context, R.color.notAvailable));
        }

        holder.imageView.setImageBitmap(obj.getBmp());

        holder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int price = Integer.parseInt(holder.priceTv.getText().toString());
                Bitmap bitmap = ((BitmapDrawable)holder.imageView.getDrawable()).getBitmap();
                ListItems obj = new ListItems(holder.nameTv.getText().toString(), holder.priceTv.getText().toString(), holder.ratingBar.getRating(), bitmap);
                if(holder.checkBox.isChecked()){
                    CartMenu.totalFoodCost = CartMenu.totalFoodCost + price;
                    CartMenu.listItems.add(obj);
                    Toast.makeText(context, String.valueOf(CartMenu.totalFoodCost), Toast.LENGTH_SHORT).show();
                }

                else  {
                    CartMenu.totalFoodCost = Math.abs(CartMenu.totalFoodCost - price);
                    deleteFromCartItems(obj);
                }
                mcost.setText(String.valueOf(CartMenu.totalFoodCost) + " Taka");
            }
        });

    }

    private void deleteFromCartItems(ListItems obj) {
        Iterator<ListItems> it = CartMenu.listItems.iterator();
        while(it.hasNext()){
            ListItems o = it.next();
            if(obj.getName().equals(o.getName())) it.remove();
        }
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView nameTv;
        TextView priceTv;
        ImageView imageView;
        RatingBar ratingBar;
        TextView availableTV;
        CheckBox checkBox;
        TextView totalAmount;
        public ViewHolder(View itemView) {
            super(itemView);

            this.setIsRecyclable(false);

            nameTv = (TextView)itemView.findViewById(R.id.nameTV);
            priceTv = (TextView)itemView.findViewById(R.id.priceTV);
            imageView = (ImageView) itemView.findViewById(R.id.imageIV);
            ratingBar = (RatingBar) itemView.findViewById(R.id.ratingRB);
            availableTV = (TextView) itemView.findViewById(R.id.availableTV);
            checkBox = (CheckBox) itemView.findViewById(R.id.checkbox);
            totalAmount = (TextView) itemView.findViewById(R.id.totalAmount);
        }
    }
}
