package com.example.hotelreservationsystem;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class HotelGuestDetailsFragment extends Fragment {
    View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.hotel_guest_details_fragment, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView hotelRecapTextView = view.findViewById(R.id.hotel_recap_text_view);

        assert getArguments() != null;
        String hotelName = getArguments().getString("hotel_name");
        String price = getArguments().getString("price");
        String availability = getArguments().getString("availability");

        String hotelRecap = getString(R.string.hotel_recap, hotelName, price, availability);
        hotelRecapTextView.setText(hotelRecap);

    }
}
