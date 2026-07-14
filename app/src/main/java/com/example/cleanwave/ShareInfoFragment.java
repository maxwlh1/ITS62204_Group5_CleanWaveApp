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

public class ShareInfoFragment extends Fragment {
    public ShareInfoFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_share_info, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView btnBackShareInfo = view.findViewById(R.id.btnBackShareInfo);
        MaterialCardView btnUploadInfoPhoto = view.findViewById(R.id.btnUploadInfoPhoto);
        MaterialButton btnSubmitInfo = view.findViewById(R.id.btnSubmitInfo);

        if (btnBackShareInfo != null) btnBackShareInfo.setOnClickListener(v -> requireActivity().getSupportFragmentManager().popBackStack());

        if (btnUploadInfoPhoto != null) btnUploadInfoPhoto.setOnClickListener(v ->
                Toast.makeText(v.getContext(), "Opening gallery...", Toast.LENGTH_SHORT).show()
        );

        if (btnSubmitInfo != null) {
            btnSubmitInfo.setOnClickListener(v -> {
                Toast.makeText(v.getContext(), "Information Published!", Toast.LENGTH_SHORT).show();
                requireActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, new ShareInfoSuccessFragment())
                        .addToBackStack(null)
                        .commit();
            });
        }
    }
}