package com.elmoghazy.dawak;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

/**
 * Created by Sara Elmoghazy.
 */
public class Splash extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.splash_fragment, container, false);
        view.findViewById(R.id.button).setOnClickListener(view1 -> Navigation.findNavController(view).navigate(R.id.action_splashFragment_to_registerFragment));
        return view;
    }
}
