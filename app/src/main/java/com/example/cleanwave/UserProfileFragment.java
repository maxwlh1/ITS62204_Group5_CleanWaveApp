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

public class UserProfileFragment extends Fragment {

    public UserProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_user_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Map the UI elements
        TextView btnBack = view.findViewById(R.id.btnBack);
        MaterialButton btnEditProfile = view.findViewById(R.id.btnEditProfile);
        MaterialButton btnWallet = view.findViewById(R.id.btnWallet);

        // Click listeners based on Figure 5.5.4 requirements
        if (btnBack != null) {
            btnBack.setOnClickListener(v -> {
                // Returns to the previous screen (Home Dashboard)
                requireActivity().getSupportFragmentManager().popBackStack();
            });
        }

        if (btnEditProfile != null) {
            btnEditProfile.setOnClickListener(v ->
                    Toast.makeText(v.getContext(), "Navigating to Edit Profile...", Toast.LENGTH_SHORT).show()
            );
        }

        if (btnWallet != null) {
            btnWallet.setOnClickListener(v ->
                    Toast.makeText(v.getContext(), "Opening Wallet...", Toast.LENGTH_SHORT).show()
            );
        }
    }
}