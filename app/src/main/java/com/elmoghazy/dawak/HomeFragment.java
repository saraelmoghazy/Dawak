package com.elmoghazy.dawak;

import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
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

public class HomeFragment extends Fragment{
    TextView hiTextView;
    RegisterViewModel registerViewModel;
    ImageButton cameraImage, speakerImage, doctorImage;

    //vars
    GestureDetector gestureDetector;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View fragment = inflater.inflate(R.layout.home_fragment, container, false);
        return fragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        hiTextView = view.findViewById(R.id.hiTextView);
        cameraImage = view.findViewById(R.id.image_camera);
        speakerImage = view.findViewById(R.id.image_speaker);
        doctorImage = view.findViewById(R.id.image_doctor);
        registerViewModel = ViewModelProviders.of(requireActivity()).get(RegisterViewModel.class);
        registerViewModel.usernameLiveData.observe(getViewLifecycleOwner(),username -> hiTextView.setText("Hello " + username));
        cameraImage.setOnClickListener(v -> {
            Intent intent = new Intent();
        });

    }

}
