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

public class UserHomeFragment extends Fragment {

    public UserHomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_user_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Map all UI elements
        MaterialButton btnReport = view.findViewById(R.id.btnReport);
        MaterialButton btnVolunteer = view.findViewById(R.id.btnVolunteer);
        MaterialButton btnDonation = view.findViewById(R.id.btnDonation);
        MaterialButton btnInfo = view.findViewById(R.id.btnInfo);
        TextView btnNotification = view.findViewById(R.id.btnNotification);
        MaterialButton btnUserProfile = view.findViewById(R.id.btnUserProfile);

        // 1. Profile Route
        if (btnUserProfile != null) {
            btnUserProfile.setOnClickListener(v -> {
                requireActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, new UserProfileFragment())
                        .addToBackStack(null)
                        .commit();
            });
        }

        // 2. Notification Bell Route
        if (btnNotification != null) {
            btnNotification.setOnClickListener(v -> {
                requireActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, new UserNotificationFragment())
                        .addToBackStack(null)
                        .commit();
            });
        }

        // 3. Report Water Issue Route
        if (btnReport != null) {
            btnReport.setOnClickListener(v -> {
                requireActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, new ReportIssueFragment())
                        .addToBackStack(null)
                        .commit();
            });
        }

        // 4. Volunteer Events Route
        if (btnVolunteer != null) {
            btnVolunteer.setOnClickListener(v -> {
                requireActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, new EventListFragment())
                        .addToBackStack(null)
                        .commit();
            });
        }

        // 5. Donation Programs Route (The new feature!)
        if (btnDonation != null) {
            btnDonation.setOnClickListener(v -> {
                requireActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, new DonationListFragment())
                        .addToBackStack(null)
                        .commit();
            });
        }

        // Placeholder interactivity for the final info button
        if (btnInfo != null) {
            btnInfo.setOnClickListener(v ->
                    Toast.makeText(v.getContext(), "Loading Information...", Toast.LENGTH_SHORT).show()
            );
        }
    }
}