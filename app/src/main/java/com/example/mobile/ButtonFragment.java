package com.example.mobile;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ButtonFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.button, container, false);
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
        Button button = view.findViewById(R.id.goButton);
        String label = this.getArguments().getString("label");
        String text = this.getArguments().getString("text");
        if(!label.equals(""))
            button.setText(label);
        else button.setText("not found");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = getArguments().getString("text");
                showFragment(text);
        }});
        return view;
    }

        public void showFragment(String text){
            TextFragment fragment = new TextFragment();
            Bundle bundle = new Bundle();
            bundle.putString("text", text);
            fragment.setArguments(bundle);
            getFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frame, fragment)
                    .addToBackStack("Text")
                    .commit();
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