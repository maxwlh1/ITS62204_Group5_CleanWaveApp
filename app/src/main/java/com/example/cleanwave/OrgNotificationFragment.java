package com.example.cleanwave;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class OrgNotificationFragment extends Fragment {
    public OrgNotificationFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_org_notification, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView btnBackOrgNotification = view.findViewById(R.id.btnBackOrgNotification);
        if (btnBackOrgNotification != null) {
            btnBackOrgNotification.setOnClickListener(v -> requireActivity().getSupportFragmentManager().popBackStack());
        }
    }
}