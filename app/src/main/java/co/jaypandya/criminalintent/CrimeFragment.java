package co.jaypandya.criminalintent;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Date;


public class CrimeFragment extends Fragment {
    private Crime mCrime;
    private EditText mTitleField;
    private Button mDateButton;
    private CheckBox mSolvedCheckBox;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        mCrime = new Crime();
    }

    /*   Getting references in Fragment.onCreateView(…) works nearly the same as in Activity.onCreate(…). The only difference is that you call View.findViewById(int) on the fragment’s view. The Activity.findViewById(int) method that you used before is a convenience method that calls View.findViewById(int) behind the scenes. The Fragment class does not have a corresponding convenience method, so you have to call the real thing.   */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        /*  You explicitly inflate the fragment’s view by calling LayoutInflater.inflate(…) and passing in the layout resource ID. The second parameter is your view’s parent, which is usually needed to configure the widgets properly. The third parameter tells the layout inflater whether to add the inflated view to the view’s parent. You pass in false because you will add the view in the activity’s code. */
        View v = inflater.inflate(R.layout.fragment_crime, container, false);

        mTitleField = (EditText)v.findViewById(R.id.crime_title);
        /*   you create an anonymous class that implements the TextWatcher listener interface. TextWatcher has three methods, but you only care about one: onTextChanged(…).   */
        mTitleField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // leave blank for now
            }

            /*   you call toString() on the CharSequence that is the user’s input. This method returns a string, which you then use to set the Crime’s title.   */
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mCrime.setmTitle(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                // leave blank too
            }
        });

        mDateButton = (Button)v.findViewById(R.id.crime_date);
        DateFormat df = new DateFormat();
        mDateButton.setText(df.format("ccc LLL yyyy HH:mm:ss", mCrime.getmDate()).toString());
        mDateButton.setEnabled(false); // enable the button later

        mSolvedCheckBox = (CheckBox)v.findViewById(R.id.crime_solved);
        mSolvedCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mCrime.setmSolved(isChecked);
            }
        });

        return v;
    }
}
