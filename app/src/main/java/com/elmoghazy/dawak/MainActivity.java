package com.elmoghazy.dawak;

import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.elmoghazy.dawak.adapters.MyAdapter;
import com.elmoghazy.dawak.viewmodels.DrugViewModel;

import java.util.ArrayList;

//import io.reactivex.disposables.CompositeDisposable;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    //vars
    //private RecyclerView.LayoutManager layoutManager;
    private ArrayList<String> names = new ArrayList<>();
    private ArrayList<String> urls = new ArrayList<>();
    RecyclerView recyclerView;
    RecyclerView.Adapter recAdapter;

//    @NonNull
//    private CompositeDisposable compositeDisposable;
    private DrugViewModel drugViewModel = new DrugViewModel();

    private void initDrugs(){
        Log.d(TAG, "initDrugs data");
        names.add("Panadol Extra");
        urls.add("https://dawak1.000webhostapp.com/panadol_extra.jpg");
        names.add("Panadol Extra 2");
        urls.add("https://dawak1.000webhostapp.com/panadol_extra.jpg");
        initRecyclerView();
    }
    private void initRecyclerView(){
        Log.d(TAG,"init recycler View");
        //recyclerView.setHasFixedSize(true);
        //old working example without MVVM
//        recAdapter = new MyAdapter(this,this.names,this.urls);
        recAdapter = new MyAdapter(this, drugViewModel.getLiveDatadrugs().getValue());
        recyclerView.setAdapter(recAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        drugViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(DrugViewModel.class);
        drugViewModel.init();
        initDrugs();

        drugViewModel.getLiveDatadrugs().observe(this, drugList ->  {
            /* new Observer<List<Drug>>() : Anonymous new Observer<List<Drug>>() can be replaced with lambda less... (Ctrl+F1)
                Inspection info: Reports all anonymous classes which can be replaced with lambda expressions
                Lambda syntax is not supported under Java 1.7 or earlier JVMs
                d by implement interface feh method wa7da ely hya @Override
                public void onChanged(@Nullable List<Drug> drugList) {
                w bltaly bnst5dm lambda experession fl 7ala d
            */
//            Log.d(TAG,"drugs observer");
            recAdapter.notifyDataSetChanged();
        });
        drugViewModel.getErrorMessage().observe(this, errorMessage->{
            Toast.makeText(this,errorMessage,Toast.LENGTH_LONG);
        });
        drugViewModel.getIsLoading().observe(this, isLoading->{
            if(isLoading == true){
//                Log.d(TAG,"is loading true");
                Toast.makeText(this,"loading",Toast.LENGTH_SHORT);
            }
            else{
//                Log.d(TAG,"is loading false");
                Toast.makeText(this,"not loading",Toast.LENGTH_SHORT);
            }
        });

    }

}