package com.caceres.bejar.david.bicicletasprac1;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.caceres.bejar.david.bicicletasprac1.dummy.DummyContent;

import java.util.ArrayList;
import java.util.List;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class ItemFragment extends Fragment  {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    private OnListFragmentInteractionListener OnListFragmentInteractionListener;
    MyItemRecyclerViewAdapter adapter;

    private List<Bike> bikes = new ArrayList<Bike>();


    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ItemFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static ItemFragment newInstance(int columnCount) {
        ItemFragment fragment = new ItemFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }

            //Añade el conjunto de elementos iniciales
            bikes.add(new Bike("Bike1", "First Bike"));
            bikes.add(new Bike("Bike2", "Second Bike"));
            bikes.add(new Bike("Bike3", "Third Bike"));
            bikes.add(new Bike("Bike4", "Fourth Bike"));
            bikes.add(new Bike("Bike5", "Fifth Bike"));
            bikes.add(new Bike("Bike6", "Sixth Bike"));


            adapter = new MyItemRecyclerViewAdapter(bikes, OnListFragmentInteractionListener);
            recyclerView.setAdapter(adapter);
        }
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            OnListFragmentInteractionListener = (OnListFragmentInteractionListener) context;
            Log.d("Fragmento", "Evento onAttach");
        } else {
            Log.d("Fragmento", "OnAttach con error");
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");

        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        OnListFragmentInteractionListener = null;
    }

    public void add_bike_fragment(String descrip){
        int identificador = bikes.size()+1;
        bikes.add(new Bike("Bike"+Integer.toString(identificador), descrip));
        Log.d("Fragmento", "Evento add_bike_fragment");
        //Notifica al adaptador de los nuevos cambios para actualizar la lista
        adapter.notifyDataSetChanged();
    }


    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        void click(Bike item);
    }
}
