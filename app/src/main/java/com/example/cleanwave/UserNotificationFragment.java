package com.example.cleanwave;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class UserNotificationFragment extends Fragment {
    public UserNotificationFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_user_notification, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView btnBackUserNotification = view.findViewById(R.id.btnBackUserNotification);
        if (btnBackUserNotification != null) {
            btnBackUserNotification.setOnClickListener(v -> requireActivity().getSupportFragmentManager().popBackStack());
        }
    }
}