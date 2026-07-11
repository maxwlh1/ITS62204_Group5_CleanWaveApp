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

public class InfoListFragment extends Fragment {

    public InfoListFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_info_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView btnBackInfoList = view.findViewById(R.id.btnBackInfoList);
        MaterialCardView cvInfoItem1 = view.findViewById(R.id.cvInfoItem1);

        if (btnBackInfoList != null) {
            btnBackInfoList.setOnClickListener(v -> requireActivity().getSupportFragmentManager().popBackStack());
        }

        // Clicking the card opens the Info Details page
        if (cvInfoItem1 != null) {
            cvInfoItem1.setOnClickListener(v -> {
                requireActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, new InfoDetailsFragment())
                        .addToBackStack(null)
                        .commit();
            });
        }
    }
}