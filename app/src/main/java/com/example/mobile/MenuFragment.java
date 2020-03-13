package com.example.mobile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MenuFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        try{
            TextView textView = this.getActivity().findViewById(R.id.counter);
            String c = textView.getText().toString();
            int count = Integer.parseInt(c);
            count = count + 1;
            textView.setText(String.valueOf(count));
        }catch (NullPointerException e){
            e.printStackTrace();
        }
        return inflater.inflate(R.layout.menu, container, false);
    }

    @Override
    public void onDestroyView() {
        try{
            TextView textView = this.getActivity().findViewById(R.id.counter);
            String c = textView.getText().toString();
            int count = Integer.parseInt(c);
            count = count - 1;
            textView.setText(String.valueOf(count));
        }catch (NullPointerException e){
            e.printStackTrace();
        }
        super.onDestroyView();
    }
}
