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

public class ReportIssueFragment extends Fragment {

    public ReportIssueFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_report_issue, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView btnBackReport = view.findViewById(R.id.btnBackReport);
        MaterialButton btnSubmitReport = view.findViewById(R.id.btnSubmitReport);

        if (btnBackReport != null) {
            btnBackReport.setOnClickListener(v -> requireActivity().getSupportFragmentManager().popBackStack());
        }

        // Navigate to the Success screen
        if (btnSubmitReport != null) {
            btnSubmitReport.setOnClickListener(v -> {
                requireActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, new ReportIssueSuccessFragment())
                        .addToBackStack(null)
                        .commit();
            });
        }
    }
}