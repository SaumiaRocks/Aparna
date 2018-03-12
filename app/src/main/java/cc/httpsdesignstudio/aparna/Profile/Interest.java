package cc.httpsdesignstudio.aparna.Profile;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cc.httpsdesignstudio.aparna.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class Interest extends Fragment {


    public Interest() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_interest, container, false);
    }

}
