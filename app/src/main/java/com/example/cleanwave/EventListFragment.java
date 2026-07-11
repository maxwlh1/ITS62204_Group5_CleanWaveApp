package com.example.cleanwave;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.google.android.material.card.MaterialCardView;

public class EventListFragment extends Fragment {

    public EventListFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_event_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView btnBackEventList = view.findViewById(R.id.btnBackEventList);
        MaterialCardView cvEventItem1 = view.findViewById(R.id.cvEventItem1);

        if (btnBackEventList != null) {
            btnBackEventList.setOnClickListener(v -> requireActivity().getSupportFragmentManager().popBackStack());
        }

        // Clicking the first event card opens the Event Details
        if (cvEventItem1 != null) {
            cvEventItem1.setOnClickListener(v -> {
                requireActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, new EventDetailsFragment())
                        .addToBackStack(null)
                        .commit();
            });
        }
    }
}