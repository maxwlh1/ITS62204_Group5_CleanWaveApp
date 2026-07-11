package com.example.cleanwave;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.google.android.material.button.MaterialButton;

public class EventDetailsFragment extends Fragment {

    public EventDetailsFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_event_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView btnBackEventDetails = view.findViewById(R.id.btnBackEventDetails);
        MaterialButton btnRegisterEvent = view.findViewById(R.id.btnRegisterEvent);

        if (btnBackEventDetails != null) {
            btnBackEventDetails.setOnClickListener(v -> requireActivity().getSupportFragmentManager().popBackStack());
        }

        if (btnRegisterEvent != null) {
            btnRegisterEvent.setOnClickListener(v -> {
                // Show success message and simulate sending info to organization dashboard
                Toast.makeText(v.getContext(), "Successfully registered! Information sent to organization.", Toast.LENGTH_LONG).show();
                requireActivity().getSupportFragmentManager().popBackStack();
            });
        }
    }
}