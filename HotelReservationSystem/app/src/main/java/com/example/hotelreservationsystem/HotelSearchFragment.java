package com.example.hotelreservationsystem;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class HotelSearchFragment extends Fragment {
    View view;
    ConstraintLayout mainLayout;
    TextView titleTextView, searchConfirmTextView;
    EditText guestsEditText;
    Button confirmSearchButton, searchButton;
    DatePicker checkInDatePicker;
    DatePicker checkOutDatePicker;
    String checkInDate, checkOutDate, numberOfGuests;

    @Nullable
    @Override

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.hotel_search_layout, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mainLayout = view.findViewById(R.id.main_layout);

        titleTextView = view.findViewById(R.id.title_text_view);
        titleTextView.setText(R.string.welcome_text);
        guestsEditText = view.findViewById(R.id.number_of_guests_edit_text);
        searchConfirmTextView = view.findViewById(R.id.search_confirm_text_view);

        checkInDatePicker = view.findViewById(R.id.check_in_date_picker);
        checkOutDatePicker = view.findViewById(R.id.check_out_date_picker);

        confirmSearchButton = view.findViewById(R.id.confirm_my_search_button);
        confirmSearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String checkInDate = getDateFromDatePicker(checkInDatePicker);
                String checkOutDate = getDateFromDatePicker(checkOutDatePicker);
                String numberOfGuests = guestsEditText.getText().toString();
                searchConfirmTextView.setText("The check-in date is " + checkInDate +
                        " and checkout date is " + checkOutDate + " and the number of guests are " + numberOfGuests);
            }});

        searchButton = view.findViewById(R.id.search_button);
        //Search Button click Listener
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkInDate = getDateFromDatePicker(checkInDatePicker);
                checkOutDate = getDateFromDatePicker(checkOutDatePicker);
                //Get input of guests count
                numberOfGuests = guestsEditText.getText().toString();

                Bundle bundle = new Bundle();
                bundle.putString("check_in_date", checkInDate);
                bundle.putString("check_out_date", checkOutDate);
                bundle.putString("guests_count", numberOfGuests);


                // set Fragment class Arguments
                HotelListFragment hotelsListFragment = new HotelListFragment();
                hotelsListFragment.setArguments(bundle);

                assert getFragmentManager() != null;
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.main_layout, hotelsListFragment);
                fragmentTransaction.remove(HotelSearchFragment.this);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        }

    private String getDateFromDatePicker(DatePicker datePicker) {
        int day = datePicker.getDayOfMonth();
        int month = datePicker.getMonth();
        int year = datePicker.getYear();

        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");

        return simpleDateFormat.format(calendar.getTime());

    }
}
