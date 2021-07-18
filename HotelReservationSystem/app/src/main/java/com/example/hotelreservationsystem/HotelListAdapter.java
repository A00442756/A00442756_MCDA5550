package com.example.hotelreservationsystem;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class HotelListAdapter extends RecyclerView.Adapter<HotelListAdapter.ViewHolder> {
    LayoutInflater layoutInflater;
    List<HotelListData> hotelListData;
    ItemClickListener clickListener;
    Context mContext;

    private static final String TAG = "HotelListAdapter";

    // constructor
    HotelListAdapter(Context context, List<HotelListData> hotelListData) {
        this.layoutInflater = LayoutInflater.from(context);
        this.hotelListData = hotelListData;
        this.mContext = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView hotelName, price, availability;
        CircleImageView hotelImage;
        public ViewHolder (View itemView) {
            super(itemView);
            hotelName = itemView.findViewById(R.id.hotel_name_text_view);
            price = itemView.findViewById(R.id.price_text_view);
            availability = itemView.findViewById(R.id.availability_text_view);
            hotelImage = itemView.findViewById(R.id.hotel_image_view);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if(clickListener != null) {
                clickListener.onClick(v, getAbsoluteAdapterPosition());
            }
        }
    }
    public void setClickListener(ItemClickListener clickListener){
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public HotelListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.hotel_list_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HotelListAdapter.ViewHolder holder, int position) {
        String hotelName = hotelListData.get(position).getHotelName();
        String hotelPrice = hotelListData.get(position).getPrice();
        String hotelAvailability = hotelListData.get(position).getAvailability();
        String hotelImageUrl = hotelListData.get(position).getPhotoUrl();

        Log.d(TAG, "hotelImageUrl: " + hotelImageUrl);

        Glide.with(mContext)
                .load(hotelImageUrl)
                .into(holder.hotelImage);

        holder.hotelName.setText(hotelName);
        holder.price.setText(hotelPrice);
        holder.availability.setText(hotelAvailability);

    }

    @Override
    public int getItemCount() {
        if (hotelListData != null) {
            return hotelListData.size();
        } else {
            return 0;
        }
    }
}
