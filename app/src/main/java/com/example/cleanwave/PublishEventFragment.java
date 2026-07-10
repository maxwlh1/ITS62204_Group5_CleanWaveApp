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
        MaterialButton btnSubmitEvent = view.findViewById(R.id.btnSubmitEvent);

        if (btnBackPublish != null) {
            btnBackPublish.setOnClickListener(v -> requireActivity().getSupportFragmentManager().popBackStack());
        }

        // Navigate to the Success screen
        if (btnSubmitEvent != null) {
            btnSubmitEvent.setOnClickListener(v -> {
                requireActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, new UploadSuccessFragment())
                        .addToBackStack(null)
                        .commit();
            });
        }
    }
}