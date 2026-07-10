package com.example.cleanwave;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.google.android.material.button.MaterialButton;

public class EditProfileFragment extends Fragment {

    public EditProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_edit_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        MaterialButton btnDoneEdit = view.findViewById(R.id.btnDoneEdit);

        if (btnDoneEdit != null) {
            btnDoneEdit.setOnClickListener(v -> {
                Toast.makeText(getContext(), "Profile Updated!", Toast.LENGTH_SHORT).show();
                // Pop back to the main profile screen
                requireActivity().getSupportFragmentManager().popBackStack();
            });
        }
    }
}