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

public class TextFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.text, container, false);
        try{
            Log.i("Mobile", "onAttach");
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
        TextView textView = view.findViewById(R.id.textView);
        String text = this.getArguments().getString("text");
        if(!text.equals(""))
            textView.setText(text);
        else
            textView.setText("not found");
        return view;
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