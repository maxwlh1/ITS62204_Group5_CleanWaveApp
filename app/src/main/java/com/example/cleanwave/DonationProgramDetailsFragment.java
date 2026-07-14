package com.example.cleanwave;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.google.android.material.button.MaterialButton;

public class DonationProgramDetailsFragment extends Fragment {

    public DonationProgramDetailsFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_donation_program_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Map all elements
        TextView btnBackDonationDetails = view.findViewById(R.id.btnBackDonationDetails);
        MaterialButton btnGoToPayment = view.findViewById(R.id.btnGoToPayment);

        TextView txtDonationDetailTitle = view.findViewById(R.id.txtDonationDetailTitle);
        ImageView imgDonationDetailPhoto = view.findViewById(R.id.imgDonationDetailPhoto);
        TextView txtDonationDetailDesc = view.findViewById(R.id.txtDonationDetailDesc);

        // Check if we received specific donation data from the list
        if (getArguments() != null) {
            String title = getArguments().getString("DONATION_TITLE");
            int imageResId = getArguments().getInt("DONATION_IMAGE");
            String desc = getArguments().getString("DONATION_DESC");

            // Update the screen dynamically!
            if (txtDonationDetailTitle != null) txtDonationDetailTitle.setText(title);
            if (imgDonationDetailPhoto != null) imgDonationDetailPhoto.setImageResource(imageResId);
            if (txtDonationDetailDesc != null) txtDonationDetailDesc.setText(desc);
        }

        // Standard Back Button
        if (btnBackDonationDetails != null) {
            btnBackDonationDetails.setOnClickListener(v -> requireActivity().getSupportFragmentManager().popBackStack());
        }

        // Go to Payment Screen
        if (btnGoToPayment != null) {
            btnGoToPayment.setOnClickListener(v -> {
                requireActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, new DonationPaymentFragment())
                        .addToBackStack(null)
                        .commit();
            });
        }
    }
}