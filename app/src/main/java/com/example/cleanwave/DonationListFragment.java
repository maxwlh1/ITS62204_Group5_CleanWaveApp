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

public class DonationListFragment extends Fragment {

    public DonationListFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_donation_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView btnBackDonationList = view.findViewById(R.id.btnBackDonationList);
        EditText etSearchDonation = view.findViewById(R.id.etSearchDonation); // New search bar

        MaterialCardView cvDonationItem1 = view.findViewById(R.id.cvDonationItem1);
        MaterialCardView cvDonationItem2 = view.findViewById(R.id.cvDonationItem2);
        MaterialCardView cvDonationItem3 = view.findViewById(R.id.cvDonationItem3);

        if (btnBackDonationList != null) {
            btnBackDonationList.setOnClickListener(v -> requireActivity().getSupportFragmentManager().popBackStack());
        }

        // Add Search Filter Logic
        if (etSearchDonation != null) {
            etSearchDonation.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    String query = s.toString().toLowerCase().trim();

                    // Show or hide cards based on whether their title matches the search
                    if (cvDonationItem1 != null) cvDonationItem1.setVisibility("save the turtles fund".contains(query) ? View.VISIBLE : View.GONE);
                    if (cvDonationItem2 != null) cvDonationItem2.setVisibility("ocean rescue initiative".contains(query) ? View.VISIBLE : View.GONE);
                    if (cvDonationItem3 != null) cvDonationItem3.setVisibility("clean water for all".contains(query) ? View.VISIBLE : View.GONE);
                }

                @Override
                public void afterTextChanged(Editable s) { }
            });
        }

        // Routing Logic (Clicking cards opens details)
        if (cvDonationItem1 != null) {
            cvDonationItem1.setOnClickListener(v -> openDonationDetails(
                    "Save The Turtles Fund", R.drawable.donation_pic1,
                    "🎯 Target: RM 50,000\n💰 Raised: RM 12,450\n\nYour donation will go directly towards protecting endangered sea turtles and their nesting grounds along the eastern coast. Funds are used for habitat restoration and anti-poaching patrols."
            ));
        }

        if (cvDonationItem2 != null) {
            cvDonationItem2.setOnClickListener(v -> openDonationDetails(
                    "Ocean Rescue Initiative", R.drawable.donation_pic2,
                    "🎯 Target: RM 100,000\n💰 Raised: RM 45,200\n\nHelp us fund large-scale ocean cleanups! We deploy advanced netting systems to remove plastic islands from our oceans. Every RM 10 removes 1kg of plastic."
            ));
        }

        if (cvDonationItem3 != null) {
            cvDonationItem3.setOnClickListener(v -> openDonationDetails(
                    "Clean Water For All", R.drawable.donation_pic3,
                    "🎯 Target: RM 25,000\n💰 Raised: RM 22,100\n\nProvide clean, filtered drinking water to rural communities affected by river pollution. Your contribution helps build sustainable water filtration systems for entire villages."
            ));
        }
    }

    private void openDonationDetails(String title, int imageRes, String description) {
        DonationProgramDetailsFragment detailsFragment = new DonationProgramDetailsFragment();
        Bundle args = new Bundle();
        args.putString("DONATION_TITLE", title);
        args.putInt("DONATION_IMAGE", imageRes);
        args.putString("DONATION_DESC", description);
        detailsFragment.setArguments(args);

        requireActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, detailsFragment)
                .addToBackStack(null)
                .commit();
    }
}