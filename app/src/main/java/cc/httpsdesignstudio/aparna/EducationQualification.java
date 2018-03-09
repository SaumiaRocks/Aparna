package cc.httpsdesignstudio.aparna;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class EducationQualification extends Fragment {


    EditText etEducationQualification, etSkills;
    public EducationQualification() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview = inflater.inflate(R.layout.fragment_education_qualification, container, false);
        etEducationQualification = getActivity().findViewById(R.id.etEducationQualification);
        etSkills = getActivity().findViewById(R.id.etSkills);
        return rootview;
    }

}
