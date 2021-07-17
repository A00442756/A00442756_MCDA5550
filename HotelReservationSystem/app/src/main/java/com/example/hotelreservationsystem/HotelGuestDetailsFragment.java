package com.example.hotelreservationsystem;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HotelGuestDetailsFragment extends Fragment {
    View view;
    RecyclerView guestRecyclerView;
    ArrayList<GuestListData> arrayList = new ArrayList<>();


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
        Button guestNextButton = view.findViewById(R.id.guest_details_next_button);
        guestRecyclerView = view.findViewById(R.id.guest_details_recycler_view);
        guestRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        assert getArguments() != null;
        String hotelName = getArguments().getString("hotel_name");
        String price = getArguments().getString("price");
        String availability = getArguments().getString("availability");
        String checkInDate = getArguments().getString("check_in_date");
        String checkOutDate = getArguments().getString("check_out_date");
        String guestCount = getArguments().getString("guest_count");
        int guestCountInt = Integer.parseInt(guestCount);

        String hotelRecap = getString(R.string.hotel_recap, hotelName, checkInDate, checkOutDate, price);
        hotelRecapTextView.setText(hotelRecap);

        for (int i = 0; i < guestCountInt; i++) {
            GuestListData guestListData = new GuestListData();
            guestListData.setFirstName("");
            guestListData.setLastName("");
            guestListData.setGender(GenderData.MALE);
            arrayList.add(guestListData);
        }

        HotelGuestDetailsAdapter hotelGuestDetailsAdapter = new HotelGuestDetailsAdapter(getActivity(), arrayList);
        guestRecyclerView.setAdapter(hotelGuestDetailsAdapter);

        guestNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<GuestListData> guestArrayList = hotelGuestDetailsAdapter.getArrayList();

                for (int i = 0; i < guestArrayList.size(); i++) {

                    Log.e("First Name " + i, guestArrayList.get(i).getFirstName() + "");
                    Log.e("Last Name " + i, guestArrayList.get(i).getLastName() + "");
                    Log.e("Gender " + i, guestArrayList.get(i).getGender() + "");

                }
            }
        });

//        setUpRecyclerView();

    }

    private void setUpRecyclerView(){
        guestRecyclerView = view.findViewById(R.id.guest_details_recycler_view);
        guestRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        HotelGuestDetailsAdapter hotelGuestDetailsAdapter = new HotelGuestDetailsAdapter(getActivity(), arrayList);
        guestRecyclerView.setAdapter(hotelGuestDetailsAdapter);
    }
}
