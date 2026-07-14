package com.example.cleanwave;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;

public class OrgHomeFragment extends Fragment {

    // Store the current state of our filters
    private String currentFilter = "All";
    private String currentSearchText = "";

    public OrgHomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_org_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Map all UI elements
        MaterialButton btnPublishEvent = view.findViewById(R.id.btnPublishEvent);
        MaterialButton btnLaunchDonation = view.findViewById(R.id.btnLaunchDonation);
        MaterialButton btnShareInfo = view.findViewById(R.id.btnShareInfo);
        MaterialButton btnOrgNotification = view.findViewById(R.id.btnOrgNotification);
        TextView btnOrgNotificationIcon = view.findViewById(R.id.btnOrgNotificationIcon);
        MaterialButton btnOrgProfile = view.findViewById(R.id.btnOrgProfile);

        MaterialCardView cvOrgEvent = view.findViewById(R.id.cvOrgEvent);
        MaterialCardView cvOrgDonation = view.findViewById(R.id.cvOrgDonation);

        // Map the new Search and Filter items
        TextView tvFilterType = view.findViewById(R.id.tvFilterType);
        EditText etSearchBox = view.findViewById(R.id.etSearchBox);

        // --- FILTER DROPDOWN LOGIC ---
        if (tvFilterType != null) {
            tvFilterType.setOnClickListener(v -> {
                PopupMenu popup = new PopupMenu(requireContext(), tvFilterType);
                popup.getMenu().add("All");
                popup.getMenu().add("Events");
                popup.getMenu().add("Donations");

                popup.setOnMenuItemClickListener(item -> {
                    currentFilter = item.getTitle().toString();
                    tvFilterType.setText(currentFilter + " ▼");
                    applyFilters(cvOrgEvent, cvOrgDonation);
                    return true;
                });
                popup.show();
            });
        }

        // --- SEARCH BAR LOGIC ---
        if (etSearchBox != null) {
            etSearchBox.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    currentSearchText = s.toString().toLowerCase().trim();
                    applyFilters(cvOrgEvent, cvOrgDonation);
                }

                @Override
                public void afterTextChanged(Editable s) { }
            });
        }

        // --- ROUTING LOGIC (Same as before) ---
        if (btnPublishEvent != null) btnPublishEvent.setOnClickListener(v -> navigateTo(new PublishEventFragment()));
        if (btnLaunchDonation != null) btnLaunchDonation.setOnClickListener(v -> navigateTo(new LaunchDonationFragment()));
        if (btnShareInfo != null) btnShareInfo.setOnClickListener(v -> navigateTo(new ShareInfoFragment()));
        if (btnOrgNotification != null) btnOrgNotification.setOnClickListener(v -> navigateTo(new OrgNotificationFragment()));
        if (btnOrgNotificationIcon != null) btnOrgNotificationIcon.setOnClickListener(v -> navigateTo(new OrgInboxFragment()));
        if (btnOrgProfile != null) btnOrgProfile.setOnClickListener(v -> Toast.makeText(v.getContext(), "Opening Organization Profile...", Toast.LENGTH_SHORT).show());

        // Make the cards clickable so they open their details pages
        if (cvOrgEvent != null) cvOrgEvent.setOnClickListener(v -> navigateTo(new OrgEventDetailsFragment()));
        if (cvOrgDonation != null) cvOrgDonation.setOnClickListener(v -> navigateTo(new OrgDonationDetailsFragment()));
    }

    // Helper method to evaluate both the dropdown AND the search text at the same time
    private void applyFilters(MaterialCardView cvEvent, MaterialCardView cvDonation) {
        if (cvEvent == null || cvDonation == null) return;

        boolean showEvent = true;
        boolean showDonation = true;

        // 1. Evaluate Dropdown Filter
        if (currentFilter.equals("Events")) {
            showDonation = false;
        } else if (currentFilter.equals("Donations")) {
            showEvent = false;
        }

        // 2. Evaluate Search Text Filter
        if (!currentSearchText.isEmpty()) {
            if (!"coastal beach cleanup".contains(currentSearchText)) {
                showEvent = false;
            }
            if (!"save the turtles fund".contains(currentSearchText)) {
                showDonation = false;
            }
        }

        // 3. Apply Visibility
        cvEvent.setVisibility(showEvent ? View.VISIBLE : View.GONE);
        cvDonation.setVisibility(showDonation ? View.VISIBLE : View.GONE);
    }

    // Helper method to make routing code cleaner
    private void navigateTo(Fragment fragment) {
        requireActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .addToBackStack(null)
                .commit();
    }
}