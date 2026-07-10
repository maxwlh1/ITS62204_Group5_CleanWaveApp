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

        // This is the newly upgraded Profile button!
        MaterialButton btnUserProfile = view.findViewById(R.id.btnUserProfile);

        if (btnUserProfile != null) {
            btnUserProfile.setOnClickListener(v -> {
                // Navigate to the UserProfileFragment
                requireActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, new UserProfileFragment())
                        .addToBackStack(null) // This allows the "Back" arrow to work
                        .commit();
            });
        }

        // Basic interactivity for the other buttons
        if (btnReport != null) {
            btnReport.setOnClickListener(v ->
                    Toast.makeText(v.getContext(), "Navigating to Report Issue...", Toast.LENGTH_SHORT).show()
            );
        }

        if (btnVolunteer != null) {
            btnVolunteer.setOnClickListener(v ->
                    Toast.makeText(v.getContext(), "Opening Volunteer Events...", Toast.LENGTH_SHORT).show()
            );
        }

        if (btnDonation != null) {
            btnDonation.setOnClickListener(v ->
                    Toast.makeText(v.getContext(), "Opening Donations...", Toast.LENGTH_SHORT).show()
            );
        }

        if (btnInfo != null) {
            btnInfo.setOnClickListener(v ->
                    Toast.makeText(v.getContext(), "Loading Information...", Toast.LENGTH_SHORT).show()
            );
        }

        if (btnNotification != null) {
            btnNotification.setOnClickListener(v ->
                    Toast.makeText(v.getContext(), "Checking Notifications...", Toast.LENGTH_SHORT).show()
            );
        }
    }
}