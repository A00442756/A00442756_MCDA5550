package com.example.hotelreservationsystem;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HotelGuestDetailsFragment extends Fragment {
    View view;
    RecyclerView guestRecyclerView;
    ArrayList<GuestData> arrayList = new ArrayList<>();


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
            GuestData guestData = new GuestData();
            guestData.setFirstName("");
            guestData.setLastName("");
            guestData.setGender(GenderData.MALE);
            arrayList.add(guestData);
        }

        HotelGuestDetailsAdapter hotelGuestDetailsAdapter = new HotelGuestDetailsAdapter(getActivity(), arrayList);
        guestRecyclerView.setAdapter(hotelGuestDetailsAdapter);

        guestNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<GuestData> guestArrayList = hotelGuestDetailsAdapter.getArrayList();

                for (int i = 0; i < guestArrayList.size(); i++) {

                    Log.e("First Name " + i, guestArrayList.get(i).getFirstName() + "");
                    Log.e("Last Name " + i, guestArrayList.get(i).getLastName() + "");
                    Log.e("Gender " + i, guestArrayList.get(i).getGender() + "");

                }
                Log.e("Hotel name", hotelName);
                Log.e("Check in", checkInDate);
                Log.e("Check out", checkOutDate);
                reservationConfirmation(hotelName, checkInDate, checkOutDate, guestArrayList);



            }
        });

//        setUpRecyclerView();


    }
    ApiInterface apiInterface;
    private void reservationConfirmation (String hotelName, String checkInDate, String checkOutDate, ArrayList<GuestData> guestDataArrayList) {
        final ReservationData reservation = new ReservationData(hotelName, checkInDate, checkOutDate, guestDataArrayList);
        apiInterface = Api.getClient().create(ApiInterface.class);
        Call<ReservationData> call1 = apiInterface.getReservationNumber(reservation);
        call1.enqueue(new Callback<ReservationData>() {
            @Override
            public void onResponse(@NonNull Call<ReservationData> call, @NonNull Response<ReservationData> response) {
                ReservationData reservationData = response.body();

                Log.e("Reservation", "reservation --> " + reservationData);
                if (reservationData != null) {
                    Log.e("Confirmation", "getConfirmationNumber  -->  " + reservationData.getConfirmationNumber());

                    Bundle bundle = new Bundle();
                    bundle.putInt("confirmation_number", reservationData.getConfirmationNumber());

                    ReservationFragment reservationFragment = new ReservationFragment();
                    reservationFragment.setArguments(bundle);

                    FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
                    fragmentTransaction.remove(HotelGuestDetailsFragment.this);
                    fragmentTransaction.replace(R.id.main_layout, reservationFragment);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commitAllowingStateLoss();

                }
            }

            @Override
            public void onFailure(@NonNull Call<ReservationData> call, @NonNull Throwable t) {
                Toast.makeText(getActivity(), t.toString(), Toast.LENGTH_LONG).show();
                call.cancel();
            }
        });
    }



    private void setUpRecyclerView(){
        guestRecyclerView = view.findViewById(R.id.guest_details_recycler_view);
        guestRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        HotelGuestDetailsAdapter hotelGuestDetailsAdapter = new HotelGuestDetailsAdapter(getActivity(), arrayList);
        guestRecyclerView.setAdapter(hotelGuestDetailsAdapter);
    }
}
