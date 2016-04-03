package co.jaypandya.criminalintent;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Jay on 4/3/2016.
 */

//a centralized data stash for Crime objects

/*A singleton exists as long as the application stays in memory, so storing the list in a singleton will keep the crime data available throughout any lifecycle changes in your activities and fragments.  The CrimeLab singleton is not a solution for long-term storage of data, but it does allow the app to have one owner of the crime data and provides a way to easily pass that data between controller classes. */

/*   To create a singleton, you create a class with a private constructor and a get() method. If the instance already exists, then get() simply returns the instance. If the instance does not exist yet, then get() will call the constructor to create it.   */
public class CrimeLab {
    // instance of CrimeLab being made here called sCrimeLab
    private static CrimeLab sCrimeLab;

    private List<Crime> mCrimes;

    /*   This is how the singleton makes sure you can only make one instance of CrimeLab:
    *    Basically, it's going to check here to see if CrimeLab exists by seeing if it's null.
    *    If sCrimeLab is null, it means it doesn't exist yet and we can create it.
    *    Else, we're just going to return the CrimeLab that already exists by returning sCrimeLab.
    *    */
    public static CrimeLab get(Context context){
        if(sCrimeLab == null){
            sCrimeLab = new CrimeLab(context);
        }
        return sCrimeLab;
    }
    private CrimeLab(Context context){
        mCrimes = new ArrayList<>();

        //using as an example of having 100 crimes. setting title and solved attributes then adding it to the list
        for (int i=0; i<100; i++){
            Crime crime = new Crime();
            crime.setmTitle("Crime # " + i);
            crime.setmSolved(i%2==0); // every other one; alternate
            mCrimes.add(crime);
        }
    }

    public List<Crime> getmCrimes(){
        return mCrimes;
    }

    // goes through the list of crimes. If a crime object's id (getId) matches the id we're passing in here, we'll return the crime object requested.
    public Crime getCrime(UUID id){
        for(Crime crime : mCrimes){
            if(crime.getmId().equals(id)){
                return crime;
            }
        }
        return null;
    }
}
