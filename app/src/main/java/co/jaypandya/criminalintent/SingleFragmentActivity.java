package co.jaypandya.criminalintent;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

/**
 * Created by Jay on 4/3/2016.
 */
public abstract class SingleFragmentActivity extends FragmentActivity {

    protected abstract Fragment createFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        /*   The FragmentManager is responsible for managing your fragments and adding their views to the activity’s view hierarchy   */
        FragmentManager fm = getSupportFragmentManager();

        //fragment_container will be the container in the main activity_fragment.xmlxml that holds any fragment we give it.
        Fragment fragment = fm.findFragmentById(R.id.fragment_container);

        /*   If 'fragment' which is 'fragment_container' is empty, then assign a CrimeFragment to 'fragment', and then start a transaction that takes 'fragment' (aka CrimeFragment) and uses it to fill the fragment_container in the main activity_fragment.xmlxml, then commit the transaction   */
        if(fragment == null){
            fragment = createFragment();
            fm.beginTransaction().add(R.id.fragment_container, fragment).commit();
        }
    }

}
