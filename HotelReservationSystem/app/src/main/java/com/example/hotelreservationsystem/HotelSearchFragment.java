package com.example.hotelreservationsystem;

import android.content.Context;
import android.content.SharedPreferences;
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
import java.util.Objects;

public class HotelSearchFragment extends Fragment {
    View view;
    ConstraintLayout mainLayout;
    TextView titleTextView, searchConfirmTextView;
    EditText guestCountEditText, guestNameEditText;
    Button confirmSearchButton, searchButton, clearButton, retrieveButton;
    DatePicker checkInDatePicker;
    DatePicker checkOutDatePicker;
    String checkInDate, checkOutDate, numberOfGuests;

    SharedPreferences sharedPreferences;
    public static final String name = "nameKey";
    public static final String guestsCount = "guestsCount";
    public static final String myPref = "myPref";

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
        searchConfirmTextView = view.findViewById(R.id.search_confirm_text_view);

        guestNameEditText = view.findViewById(R.id.guest_name_edit_text);
        guestCountEditText = view.findViewById(R.id.number_of_guests_edit_text);

        checkInDatePicker = view.findViewById(R.id.check_in_date_picker);
        checkOutDatePicker = view.findViewById(R.id.check_out_date_picker);



        confirmSearchButton = view.findViewById(R.id.confirm_my_search_button);
        confirmSearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String checkInDate = getDateFromDatePicker(checkInDatePicker);
                String checkOutDate = getDateFromDatePicker(checkOutDatePicker);
                String numberOfGuests = guestCountEditText.getText().toString();
                String guestName = guestNameEditText.getText().toString();
                searchConfirmTextView.setText("Hey " + guestName + "! Your check-in date is " + checkInDate +
                        " and checkout date is " + checkOutDate + " and there are " + numberOfGuests + " guest(s)") ;

                sharedPreferences = requireActivity().getSharedPreferences(myPref, Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(name, guestName);
                editor.putString(guestsCount, numberOfGuests);
                editor.apply();

            }});

        searchButton = view.findViewById(R.id.search_button);
        //Search Button click Listener
        searchButton.setOnClickListener(v -> {
            checkInDate = getDateFromDatePicker(checkInDatePicker);
            checkOutDate = getDateFromDatePicker(checkOutDatePicker);
            //Get input of guests count
            numberOfGuests = guestCountEditText.getText().toString();

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
        });

        retrieveButton = view.findViewById(R.id.retrieve_button);
        retrieveButton.setOnClickListener(v -> {
            sharedPreferences = requireActivity().getSharedPreferences(myPref, Context.MODE_PRIVATE);
            if(sharedPreferences.contains(name)) {
                guestNameEditText.setText(sharedPreferences.getString(name, ""));
            }
            if (sharedPreferences.contains(guestsCount)) {
                guestCountEditText.setText(sharedPreferences.getString(guestsCount, ""));
            }

        });

        clearButton = view.findViewById(R.id.clear_button);
        clearButton.setOnClickListener(v -> {
            guestNameEditText.setText("");
            guestCountEditText.setText("");
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
