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

public class OrgHomeFragment extends Fragment {

    public OrgHomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_org_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Map all UI elements
        MaterialButton btnPublishEvent = view.findViewById(R.id.btnPublishEvent);
        MaterialButton btnLaunchDonation = view.findViewById(R.id.btnLaunchDonation);
        MaterialButton btnShareInfo = view.findViewById(R.id.btnShareInfo);
        MaterialButton btnOrgNotification = view.findViewById(R.id.btnOrgNotification);
        TextView btnOrgBell = view.findViewById(R.id.btnOrgBell);

        // 1. Route for Publish Event
        if (btnPublishEvent != null) {
            btnPublishEvent.setOnClickListener(v -> {
                requireActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, new PublishEventFragment())
                        .addToBackStack(null)
                        .commit();
            });
        }

        // 2. Route for Launch Donation
        if (btnLaunchDonation != null) {
            btnLaunchDonation.setOnClickListener(v -> {
                requireActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, new LaunchDonationFragment())
                        .addToBackStack(null)
                        .commit();
            });
        }

        // 3. Route for Share Info
        if (btnShareInfo != null) {
            btnShareInfo.setOnClickListener(v -> {
                requireActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, new ShareInfoFragment())
                        .addToBackStack(null)
                        .commit();
            });
        }

        // 4. Route for Notifications (The Grid Button)
        if (btnOrgNotification != null) {
            btnOrgNotification.setOnClickListener(v -> {
                requireActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, new OrgNotificationFragment())
                        .addToBackStack(null)
                        .commit();
            });
        }

        // 5. Route for Notifications (The Bell Icon in Header)
        if (btnOrgBell != null) {
            btnOrgBell.setOnClickListener(v -> {
                requireActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, new OrgNotificationFragment())
                        .addToBackStack(null)
                        .commit();
            });
        }
    }
}