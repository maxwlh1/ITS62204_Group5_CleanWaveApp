package com.example.cleanwave;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.google.android.material.card.MaterialCardView;

public class DonationListFragment extends Fragment {

    public DonationListFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_donation_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView btnBackDonationList = view.findViewById(R.id.btnBackDonationList);
        MaterialCardView cvDonationItem1 = view.findViewById(R.id.cvDonationItem1);

        if (btnBackDonationList != null) {
            btnBackDonationList.setOnClickListener(v -> requireActivity().getSupportFragmentManager().popBackStack());
        }

        // Clicking the first donation card opens the Details page
        if (cvDonationItem1 != null) {
            cvDonationItem1.setOnClickListener(v -> requireActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new DonationProgramDetailsFragment())
                    .addToBackStack(null)
                    .commit());
        }
    }
}