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

public class OrgNotificationFragment extends Fragment {

    public OrgNotificationFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_org_notification, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Map UI elements
        TextView btnBackOrgNotification = view.findViewById(R.id.btnBackOrgNotification);
        MaterialButton btnSendNotification = view.findViewById(R.id.btnSendNotification);

        // Back button returns to Org Dashboard
        if (btnBackOrgNotification != null) {
            btnBackOrgNotification.setOnClickListener(v -> requireActivity().getSupportFragmentManager().popBackStack());
        }

        // Send Button logic
        if (btnSendNotification != null) {
            btnSendNotification.setOnClickListener(v -> {
                // Show a success message pretending it was sent
                Toast.makeText(v.getContext(), "Notification successfully broadcasted to all volunteers!", Toast.LENGTH_LONG).show();

                // Pop back to the Dashboard
                requireActivity().getSupportFragmentManager().popBackStack();
            });
        }
    }
}