package com.example.cleanwave;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class OrgEventDetailsFragment extends Fragment {

    public OrgEventDetailsFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_org_event_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView btnBackOrgEventDetails = view.findViewById(R.id.btnBackOrgEventDetails);

        if (btnBackOrgEventDetails != null) {
            btnBackOrgEventDetails.setOnClickListener(v -> requireActivity().getSupportFragmentManager().popBackStack());
        }
    }
}