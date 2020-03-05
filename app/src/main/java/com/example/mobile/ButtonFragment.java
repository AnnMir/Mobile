package com.example.mobile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ButtonFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.button, container, false);
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
}


/*
        val view = inflater.inflate(R.layout.button, container, false)
        view.goButton.text = arguments?.getString("label") ?: "not found"
        view.goButton.setOnClickListener { arguments?.getString("text")?.let { it1 ->
            showFragment(
                it1
            )
        } }
        return view
    }

    fun showFragment(text: String){
        val fragment = TextFragment()
        fragment.arguments = Bundle().also{
            it.putString("text", text)
        }
        activity?.supportFragmentManager
            ?.beginTransaction()
            ?.replace(R.id.frame, fragment)
            ?.addToBackStack("Text")
            ?.commit()

    }*/