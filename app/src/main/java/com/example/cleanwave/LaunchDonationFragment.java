package com.example.cleanwave;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.google.android.material.button.MaterialButton;

public class LaunchDonationFragment extends Fragment {

    public LaunchDonationFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_launch_donation, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView btnBackDonation = view.findViewById(R.id.btnBackDonation);
        MaterialButton btnSubmitDonation = view.findViewById(R.id.btnSubmitDonation);

        if (btnBackDonation != null) {
            btnBackDonation.setOnClickListener(v -> requireActivity().getSupportFragmentManager().popBackStack());
        }

        // Navigate to the Success screen
        if (btnSubmitDonation != null) {
            btnSubmitDonation.setOnClickListener(v -> {
                requireActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, new DonationSuccessFragment())
                        .addToBackStack(null)
                        .commit();
            });
        }
    }
}