package com.example.cleanwave;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.google.android.material.button.MaterialButton;

public class EventDetailsFragment extends Fragment {

    public EventDetailsFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_event_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Map all elements
        TextView btnBackEventDetails = view.findViewById(R.id.btnBackEventDetails);
        MaterialButton btnRegisterEvent = view.findViewById(R.id.btnRegisterEvent);

        TextView txtEventDetailTitle = view.findViewById(R.id.txtEventDetailTitle);
        ImageView imgEventDetailPhoto = view.findViewById(R.id.imgEventDetailPhoto);
        TextView txtEventDetailDesc = view.findViewById(R.id.txtEventDetailDesc);

        // Check if we received specific event data from the list
        if (getArguments() != null) {
            String title = getArguments().getString("EVENT_TITLE");
            int imageResId = getArguments().getInt("EVENT_IMAGE");
            String desc = getArguments().getString("EVENT_DESC");

            // Update the screen with the specific event data!
            if (txtEventDetailTitle != null) txtEventDetailTitle.setText(title);
            if (imgEventDetailPhoto != null) imgEventDetailPhoto.setImageResource(imageResId);
            if (txtEventDetailDesc != null) txtEventDetailDesc.setText(desc);
        }

        // Standard Back Button
        if (btnBackEventDetails != null) {
            btnBackEventDetails.setOnClickListener(v -> requireActivity().getSupportFragmentManager().popBackStack());
        }

        // Standard Register Button
        if (btnRegisterEvent != null) {
            btnRegisterEvent.setOnClickListener(v -> {
                Toast.makeText(v.getContext(), "Successfully registered! Information sent to organization.", Toast.LENGTH_LONG).show();
                requireActivity().getSupportFragmentManager().popBackStack();
            });
        }
    }
}