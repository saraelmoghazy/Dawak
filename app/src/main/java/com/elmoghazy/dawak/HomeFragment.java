package com.elmoghazy.dawak;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.elmoghazy.dawak.viewmodels.RegisterViewModel;
import com.google.android.material.snackbar.Snackbar;

public class HomeFragment extends Fragment {
    RegisterViewModel registerViewModel;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View fragment = inflater.inflate(R.layout.home_fragment, container, false);
//        fragment.findViewById(R.id.button_click_me).setOnClickListener(v -> Navigation.findNavController(fragment).navigate(R.id.action_fragmentC_to_fragmentA));
        return fragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        registerViewModel = ViewModelProviders.of(requireActivity()).get(RegisterViewModel.class);
        final NavController navController = Navigation.findNavController(view);
        registerViewModel.authenticationState.observe(getViewLifecycleOwner(),authenticationState -> {
            switch (authenticationState){
                case AUTHENTICATED:
                    showWelcomeMessage();
                    break;
                case UNAUTHENTICATED:
                    navController.navigate(R.id.register_fragment);
            }
        }
    );
    }
    public void showWelcomeMessage(){
        Toast.makeText(getContext(),"Hello world",Toast.LENGTH_LONG).show();
//        Toast.makeText(this,R.string.app_name,Toast.LENGTH_LONG).show();
    }
}
