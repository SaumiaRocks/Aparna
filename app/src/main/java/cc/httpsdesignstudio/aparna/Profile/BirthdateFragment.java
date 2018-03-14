package cc.httpsdesignstudio.aparna.Profile;


import android.annotation.TargetApi;
import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

import cc.httpsdesignstudio.aparna.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class BirthdateFragment extends Fragment  {

    TextView tvPicDate;
    DatePickerDialog.OnDateSetListener onDateSetListener;

    public BirthdateFragment() {
        // Required empty public constructor

    }



    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View RootView = inflater.inflate(R.layout.fragment_birthdate, container, false);

        tvPicDate =  RootView.findViewById(R.id.picDate);

        tvPicDate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        getActivity(),
                        android.R.style.Theme,
                        onDateSetListener,
                        year, month, day
                );

                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        onDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;

                String date = day + "/" + month + "/" + year;
                tvPicDate.setText(date);

            }
        };


        return RootView;
    }

}
