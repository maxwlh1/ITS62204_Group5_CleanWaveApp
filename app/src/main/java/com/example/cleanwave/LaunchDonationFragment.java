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
import com.google.android.material.card.MaterialCardView;

public class LaunchDonationFragment extends Fragment {
    public LaunchDonationFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_launch_donation, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView btnBackLaunchDonation = view.findViewById(R.id.btnBackLaunchDonation);
        MaterialCardView btnUploadDonationPhoto = view.findViewById(R.id.btnUploadDonationPhoto);
        MaterialButton btnSubmitDonation = view.findViewById(R.id.btnSubmitDonation);

        if (btnBackLaunchDonation != null) btnBackLaunchDonation.setOnClickListener(v -> requireActivity().getSupportFragmentManager().popBackStack());

        if (btnUploadDonationPhoto != null) btnUploadDonationPhoto.setOnClickListener(v ->
                Toast.makeText(v.getContext(), "Opening gallery...", Toast.LENGTH_SHORT).show()
        );

        if (btnSubmitDonation != null) {
            btnSubmitDonation.setOnClickListener(v -> {
                Toast.makeText(v.getContext(), "Donation Program Launched!", Toast.LENGTH_SHORT).show();
                requireActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, new OrgDonationDetailsFragment())
                        .addToBackStack(null)
                        .commit();
            });
        }
    }
}