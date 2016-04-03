package co.jaypandya.criminalintent;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class CrimeListFragment extends Fragment {
    private RecyclerView mCrimeRecyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_crime_list, container, false);

        /*   RecyclerView’s only responsibilities are recycling TextViews and positioning them on the screen. But RecyclerView does not do the job of positioning items on the screen itself. It delegates that out to the LayoutManager. The LayoutManager handles the positioning of items and also defines the scrolling behavior. So if the LayoutManager is not there, RecyclerView will just fall over and die when it tries to do those things.   */
        mCrimeRecyclerView = (RecyclerView) view.findViewById(R.id.crime_recycler_view);
        mCrimeRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return view;
    }
}
