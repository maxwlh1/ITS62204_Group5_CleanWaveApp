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

public class DonationPaymentFragment extends Fragment {

    public DonationPaymentFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_donation_payment, container, false);
        return inflate;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView btnBackDonationPayment = view.findViewById(R.id.btnBackDonationPayment);
        MaterialButton btnPayTNG = view.findViewById(R.id.btnPayTNG);
        MaterialButton btnPayCard = view.findViewById(R.id.btnPayCard);
        MaterialButton btnPayOnline = view.findViewById(R.id.btnPayOnline);
        MaterialButton btnConfirmDonation = view.findViewById(R.id.btnConfirmDonation);

        if (btnBackDonationPayment != null) {
            btnBackDonationPayment.setOnClickListener(v -> requireActivity().getSupportFragmentManager().popBackStack());
        }

        // Simulating Payment Selections
        if (btnPayTNG != null) btnPayTNG.setOnClickListener(v -> Toast.makeText(v.getContext(), "Touch'n Go Selected", Toast.LENGTH_SHORT).show());
        if (btnPayCard != null) btnPayCard.setOnClickListener(v -> Toast.makeText(v.getContext(), "Card Selected", Toast.LENGTH_SHORT).show());
        if (btnPayOnline != null) btnPayOnline.setOnClickListener(v -> Toast.makeText(v.getContext(), "Online Banking Selected", Toast.LENGTH_SHORT).show());

        // Final Donate action
        if (btnConfirmDonation != null) {
            btnConfirmDonation.setOnClickListener(v -> {
                Toast.makeText(v.getContext(), "Redirecting to third-party payment gateway...", Toast.LENGTH_LONG).show();
                // After gateway simulation, return to dashboard
                requireActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, new UserHomeFragment())
                        .commit();
            });
        }
    }
}