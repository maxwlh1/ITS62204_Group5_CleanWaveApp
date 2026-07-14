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
import com.google.android.material.card.MaterialCardView;

public class PublishEventFragment extends Fragment {

    public PublishEventFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_publish_event, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView btnBackPublish = view.findViewById(R.id.btnBackPublish);
        MaterialCardView btnUploadEventPhoto = view.findViewById(R.id.btnUploadEventPhoto);
        MaterialButton btnSubmitEvent = view.findViewById(R.id.btnSubmitEvent);

        if (btnBackPublish != null) {
            btnBackPublish.setOnClickListener(v -> requireActivity().getSupportFragmentManager().popBackStack());
        }

        // Simulate Photo Upload
        if (btnUploadEventPhoto != null) {
            btnUploadEventPhoto.setOnClickListener(v ->
                    Toast.makeText(v.getContext(), "Opening gallery to upload photo...", Toast.LENGTH_SHORT).show()
            );
        }

        // Submit Button transitions to the Org Event Details page
        if (btnSubmitEvent != null) {
            btnSubmitEvent.setOnClickListener(v -> {
                Toast.makeText(v.getContext(), "Event Published Successfully!", Toast.LENGTH_SHORT).show();
                requireActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, new OrgEventDetailsFragment())
                        .addToBackStack(null)
                        .commit();
            });
        }
    }
}