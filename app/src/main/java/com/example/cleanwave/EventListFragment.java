package com.example.cleanwave;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
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
        EditText etSearchEvent = view.findViewById(R.id.etSearchEvent); // New search bar

        MaterialCardView cvEventItem1 = view.findViewById(R.id.cvEventItem1);
        MaterialCardView cvEventItem2 = view.findViewById(R.id.cvEventItem2);
        MaterialCardView cvEventItem3 = view.findViewById(R.id.cvEventItem3);

        if (btnBackEventList != null) {
            btnBackEventList.setOnClickListener(v -> requireActivity().getSupportFragmentManager().popBackStack());
        }

        // Add Search Filter Logic
        if (etSearchEvent != null) {
            etSearchEvent.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    String query = s.toString().toLowerCase().trim();

                    // Show or hide cards based on whether their title matches the search
                    if (cvEventItem1 != null) cvEventItem1.setVisibility("coastal beach cleanup".contains(query) ? View.VISIBLE : View.GONE);
                    if (cvEventItem2 != null) cvEventItem2.setVisibility("river restoration project".contains(query) ? View.VISIBLE : View.GONE);
                    if (cvEventItem3 != null) cvEventItem3.setVisibility("city park cleanup".contains(query) ? View.VISIBLE : View.GONE);
                }

                @Override
                public void afterTextChanged(Editable s) { }
            });
        }

        // Routing Logic (Clicking cards opens details)
        if (cvEventItem1 != null) {
            cvEventItem1.setOnClickListener(v -> openEventDetails(
                    "Coastal Beach Cleanup", R.drawable.volunteer_pic1,
                    "📍 Location: Pantai Redang Beach\n⏰ Time: 8:00 AM - 12:00 PM\n📅 Date: This Saturday\n\nJoin our community initiative to remove plastic waste from the shoreline. Gloves, trash bags, and refreshments will be provided to all registered volunteers."
            ));
        }

        if (cvEventItem2 != null) {
            cvEventItem2.setOnClickListener(v -> openEventDetails(
                    "River Restoration Project", R.drawable.volunteer_pic2,
                    "📍 Location: Klang River Sector B\n⏰ Time: 9:00 AM - 2:00 PM\n📅 Date: Next Sunday\n\nHelp us restore the local river ecosystem by clearing blockages and collecting pollution data. Please wear waterproof boots and comfortable clothing."
            ));
        }

        if (cvEventItem3 != null) {
            cvEventItem3.setOnClickListener(v -> openEventDetails(
                    "City Park Cleanup", R.drawable.volunteer_pic3,
                    "📍 Location: Central City Park\n⏰ Time: 7:30 AM - 10:30 AM\n📅 Date: 28th of the Month\n\nKeep our city green! We will be doing a sweep of the central park areas to clean up litter after the weekend festival. Great for families and first-time volunteers!"
            ));
        }
    }

    private void openEventDetails(String title, int imageRes, String description) {
        EventDetailsFragment detailsFragment = new EventDetailsFragment();
        Bundle args = new Bundle();
        args.putString("EVENT_TITLE", title);
        args.putInt("EVENT_IMAGE", imageRes);
        args.putString("EVENT_DESC", description);
        detailsFragment.setArguments(args);

        requireActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, detailsFragment)
                .addToBackStack(null)
                .commit();
    }
}