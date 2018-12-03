package xyz.bolitao.exp04;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class BFragment extends Fragment {
    private Spinner spinner;
    private CheckBox reading;
    private CheckBox exercise;
    private RadioButton male;
    private RadioButton female;
    private RadioGroup sex;
    private String[] address = {"湖南", "上海", "湖北", "北京"};
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public BFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BFragment newInstance(String param1, String param2) {
        BFragment fragment = new BFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO: View.findViewByID 和 Activity.findViewByID 的区别
        View rootView = inflater.inflate(R.layout.fragment_b, container, false);
        reading = getActivity().findViewById(R.id.reading);
        exercise = getActivity().findViewById(R.id.exercise);
        View.OnClickListener onLikeClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = "您选择的爱好是：";
                if (v.getId() == reading.getId()) {
                    str += reading.getText();
                } else if (v.getId() == exercise.getId()) {
                    str += exercise.getText();
                }
                Toast.makeText(getActivity(), str, Toast.LENGTH_SHORT).show();
            }
        };
        reading.setOnClickListener(onLikeClickListener);
        exercise.setOnClickListener(onLikeClickListener);
        male = getActivity().findViewById(R.id.male);
        female = getActivity().findViewById(R.id.female);
        sex.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == male.getId()) {
                    Toast.makeText(getActivity(), "您的性别是" + male.getText(), Toast.LENGTH_SHORT).show();
                } else if (checkedId == female.getId()) {
                    Toast.makeText(getActivity(), "您的性别是" + female.getText(), Toast.LENGTH_SHORT).show();
                }
            }
        });
        ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, address);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner = getActivity().findViewById(R.id.spinner);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(), "您的地址是" + address[position], Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        // Inflate the layout for this fragment
        return rootView;
    }
}
