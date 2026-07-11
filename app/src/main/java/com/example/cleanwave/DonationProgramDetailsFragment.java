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

public class DonationProgramDetailsFragment extends Fragment {

    public DonationProgramDetailsFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_donation_program_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView btnBackDonationDetails = view.findViewById(R.id.btnBackDonationDetails);
        MaterialButton btnGoToPayment = view.findViewById(R.id.btnPayTNG);

        if (btnBackDonationDetails != null) {
            btnBackDonationDetails.setOnClickListener(v -> requireActivity().getSupportFragmentManager().popBackStack());
        }

        // Clicking Donate goes to the Payment Screen
        if (btnGoToPayment != null) {
            btnGoToPayment.setOnClickListener(v -> {
                requireActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, new DonationPaymentFragment())
                        .addToBackStack(null)
                        .commit();
            });
        }
    }
}