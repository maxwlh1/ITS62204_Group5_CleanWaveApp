package com.example.cleanwave;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

        // Map the specific NGO buttons
        MaterialButton btnPublishEvent = view.findViewById(R.id.btnPublishEvent);
        MaterialButton btnLaunchDonation = view.findViewById(R.id.btnLaunchDonation);
        MaterialButton btnShareInfo = view.findViewById(R.id.btnShareInfo);
        MaterialButton btnOrgNotification = view.findViewById(R.id.btnOrgNotification);

        // Note: The "Org" label is now static UI, so we don't map it or make it clickable!

        // Interactivity for the grid buttons
        if (btnPublishEvent != null) {
            btnPublishEvent.setOnClickListener(v ->
                    Toast.makeText(v.getContext(), "Navigating to Publish Event...", Toast.LENGTH_SHORT).show()
            );
        }

        if (btnLaunchDonation != null) {
            btnLaunchDonation.setOnClickListener(v ->
                    Toast.makeText(v.getContext(), "Navigating to Launch Donation...", Toast.LENGTH_SHORT).show()
            );
        }

        if (btnShareInfo != null) {
            btnShareInfo.setOnClickListener(v ->
                    Toast.makeText(v.getContext(), "Navigating to Share Info...", Toast.LENGTH_SHORT).show()
            );
        }

        if (btnOrgNotification != null) {
            btnOrgNotification.setOnClickListener(v ->
                    Toast.makeText(v.getContext(), "Checking NGO Notifications...", Toast.LENGTH_SHORT).show()
            );
        }
    }
}