package com.example.mobile;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

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
            Log.i("MobileApp", String.valueOf(count));
            count = count + 1;
            Log.i("MobileApp", String.valueOf(count));
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
            Log.i("MobileApp", String.valueOf(count));
            count = count - 1;
            Log.i("MobileApp", String.valueOf(count));
            textView.setText(String.valueOf(count));
        }catch (NullPointerException e){
            e.printStackTrace();
        }
        super.onDestroyView();
    }
}
