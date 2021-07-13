package com.example.hotelreservationsystem;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class HotelListFragment extends Fragment implements ItemClickListener{
    View view;
    TextView headingTextView;
    RecyclerView recyclerView;
    List<HotelListData> hotelListData;
    ProgressBar progressBar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.hotel_list_fragment, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        headingTextView = view.findViewById(R.id.heading_text_view);
        assert getArguments() != null;
        String checkInDate = getArguments().getString("check_in_date");
        String checkOutDate = getArguments().getString("check_out_date");
        String guestsCount = getArguments().getString("guests_count");
        int guestsCountInt = Integer.parseInt(guestsCount);
        Resources res = getResources();
        String guestsCountFormatted = res.getQuantityString(R.plurals.number_of_guests, guestsCountInt, guestsCountInt);
        String headingText = getString(R.string.heading_text, checkInDate, checkOutDate, guestsCountFormatted);
        headingTextView.setText(headingText);
        progressBar = view.findViewById(R.id.hotel_list_progress_bar);


//        ArrayList<HotelListData> hotelListData = initHotelListData();
//        recyclerView = view.findViewById(R.id.hotel_list_recycler_view);
//        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
//        HotelListAdapter hotelListAdapter = new HotelListAdapter(getActivity(), hotelListData);
//        recyclerView.setAdapter(hotelListAdapter);
        getHotelListData();
    }


//    public ArrayList<HotelListData> initHotelListData() {
//
//        ArrayList<HotelListData> list = new ArrayList<>();
//
//        list.add(new HotelListData("Sunview", "$20", "true"));
//        list.add(new HotelListData("Halifax Regional Hotel", "2000$", "true"));
//        list.add(new HotelListData("Hotel Pearl", "500$", "false"));
//        list.add(new HotelListData("Hotel Amano", "800$", "true"));
//        list.add(new HotelListData("San Jones", "250$", "false"));
//
//        return list;
//    }



    public void getHotelListData(){
        progressBar.setVisibility(View.VISIBLE);
        Api.getClient().getHotelsList(new Callback<List<HotelListData>>() {
            @Override
            public void success(List<HotelListData> userListResponse, Response response) {
                hotelListData = userListResponse;

                setUpRecyclerView();
            }

            @Override
            public void failure(RetrofitError error) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(getActivity(), error.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }

    private void setUpRecyclerView(){
        progressBar.setVisibility(View.GONE);
        recyclerView = view.findViewById(R.id.hotel_list_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        HotelListAdapter hotelListAdapter = new HotelListAdapter(getActivity(), hotelListData);
        recyclerView.setAdapter(hotelListAdapter);

        hotelListAdapter.setClickListener(this);
    }

    @Override
    public void onClick(View view, int position) {
        HotelListData hotelData = hotelListData.get(position);

        String hotelName = hotelData.getHotelName();
        String price = hotelData.getPrice();
        String availability = hotelData.getAvailability();

        Bundle bundle = new Bundle();
        bundle.putString("hotel_name", hotelName);
        bundle.putString("price", price);
        bundle.putString("availability", availability);

        HotelGuestDetailsFragment hotelGuestDetailsFragment = new HotelGuestDetailsFragment();
        hotelGuestDetailsFragment.setArguments(bundle);

        assert getFragmentManager() != null;
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.remove(HotelListFragment.this);
        fragmentTransaction.replace(R.id.main_layout, hotelGuestDetailsFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commitAllowingStateLoss();

    }
}
