package com.example.hotelreservationsystem;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HotelGuestDetailsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    LayoutInflater layoutInflater;
    ArrayList<GuestData> arrayList;

    public HotelGuestDetailsAdapter(Context context, ArrayList<GuestData> arrayList) {
        this.layoutInflater = LayoutInflater.from(context);
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.hotel_guest_details_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public ArrayList<GuestData> getArrayList() {
        return arrayList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        EditText firstName, lastName;
        GenderData gender;
        final RadioGroup radio;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            firstName = itemView.findViewById(R.id.guest_details_first_name_edit_text);
            lastName = itemView.findViewById(R.id.guest_details_last_name_edit_text);
            radio = itemView.findViewById(R.id.gender_radio_group);
            radio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {

                    View radioButton = radio.findViewById(checkedId);
                    int index = radio.indexOfChild(radioButton);

                    // Add logic here
                    GuestData guestData;

                    switch (index) {
                        case 0: // first button

                            gender = GenderData.MALE;
                            guestData = arrayList.get(getAbsoluteAdapterPosition());
                            guestData.setGender(gender);
                            arrayList.set(getAbsoluteAdapterPosition(), guestData);

                            break;
                        case 1: // second button

                            gender = GenderData.FEMALE;
                            guestData = arrayList.get(getAbsoluteAdapterPosition());
                            guestData.setGender(gender);
                            arrayList.set(getAbsoluteAdapterPosition(), guestData);
                            break;
                    }
                }
            });

            firstName.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                    GuestData guestData = arrayList.get(getAbsoluteAdapterPosition());
                    guestData.setFirstName(charSequence + "");
                    arrayList.set(getAbsoluteAdapterPosition(), guestData);

                }

                @Override
                public void afterTextChanged(Editable editable) {

                }
            });

            lastName.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                    GuestData guestData = arrayList.get(getAbsoluteAdapterPosition());
                    guestData.setLastName(charSequence + "");
                    arrayList.set(getAbsoluteAdapterPosition(), guestData);


                }

                @Override
                public void afterTextChanged(Editable editable) {

                }
            });

        }
    }
}
