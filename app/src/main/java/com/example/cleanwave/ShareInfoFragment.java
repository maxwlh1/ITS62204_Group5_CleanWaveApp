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

public class ShareInfoFragment extends Fragment {

    public ShareInfoFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_share_info, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView btnBackShareInfo = view.findViewById(R.id.btnBackShareInfo);
        MaterialButton btnSubmitShareInfo = view.findViewById(R.id.btnSubmitShareInfo);

        if (btnBackShareInfo != null) {
            btnBackShareInfo.setOnClickListener(v -> requireActivity().getSupportFragmentManager().popBackStack());
        }

        // Navigate to the Success screen
        if (btnSubmitShareInfo != null) {
            btnSubmitShareInfo.setOnClickListener(v -> {
                requireActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, new ShareInfoSuccessFragment())
                        .addToBackStack(null)
                        .commit();
            });
        }
    }
}