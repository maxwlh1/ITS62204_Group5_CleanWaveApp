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

        // Map the blue text links
        TextView btnMoreEvents = view.findViewById(R.id.btnMoreEvents);
        TextView btnMoreDonations = view.findViewById(R.id.btnMoreDonations);

        // Profile Route
        if (btnUserProfile != null) {
            btnUserProfile.setOnClickListener(v -> {
                requireActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, new UserProfileFragment())
                        .addToBackStack(null)
                        .commit();
            });
        }

        // Notification Bell Route
        if (btnNotification != null) {
            btnNotification.setOnClickListener(v -> {
                requireActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, new UserNotificationFragment())
                        .addToBackStack(null)
                        .commit();
            });
        }

        // Report Water Issue Route
        if (btnReport != null) {
            btnReport.setOnClickListener(v -> {
                requireActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, new ReportIssueFragment())
                        .addToBackStack(null)
                        .commit();
            });
        }

        // --- THE EVENT ROUTES ---
        // Both the Grid Button AND the Blue Text link to the Event List
        View.OnClickListener goToEvents = v -> {
            requireActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new EventListFragment())
                    .addToBackStack(null)
                    .commit();
        };
        if (btnVolunteer != null) btnVolunteer.setOnClickListener(goToEvents);
        if (btnMoreEvents != null) btnMoreEvents.setOnClickListener(goToEvents);


        // --- THE DONATION ROUTES ---
        // Both the Grid Button AND the Blue Text link to the Donation List
        View.OnClickListener goToDonations = v -> {
            requireActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new DonationListFragment())
                    .addToBackStack(null)
                    .commit();
        };
        if (btnDonation != null) btnDonation.setOnClickListener(goToDonations);
        if (btnMoreDonations != null) btnMoreDonations.setOnClickListener(goToDonations);


        // Info Hub Route
        if (btnInfo != null) {
            btnInfo.setOnClickListener(v -> {
                requireActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, new InfoListFragment())
                        .addToBackStack(null)
                        .commit();
            });
        }
    }
}