package com.example.cleanwave;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class DonationDashboardFragment extends Fragment {

    public DonationDashboardFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_donation_dashboard, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView btnBackDonationDashboard = view.findViewById(R.id.btnBackDonationDashboard);

        if (btnBackDonationDashboard != null) {
            btnBackDonationDashboard.setOnClickListener(v -> requireActivity().getSupportFragmentManager().popBackStack());
        }
    }
}