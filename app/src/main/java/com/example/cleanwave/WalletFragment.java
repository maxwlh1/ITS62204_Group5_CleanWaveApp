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

public class WalletFragment extends Fragment {

    public WalletFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_wallet, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView btnBackWallet = view.findViewById(R.id.btnBackWallet);
        MaterialButton btnAddBank = view.findViewById(R.id.btnAddBank);
        MaterialButton btnAddCard = view.findViewById(R.id.btnAddCard);

        if (btnBackWallet != null) {
            btnBackWallet.setOnClickListener(v ->
                    requireActivity().getSupportFragmentManager().popBackStack()
            );
        }

        if (btnAddBank != null) {
            btnAddBank.setOnClickListener(v ->
                    Toast.makeText(getContext(), "Add Bank Account Clicked", Toast.LENGTH_SHORT).show()
            );
        }

        if (btnAddCard != null) {
            btnAddCard.setOnClickListener(v ->
                    Toast.makeText(getContext(), "Add Card Clicked", Toast.LENGTH_SHORT).show()
            );
        }
    }
}