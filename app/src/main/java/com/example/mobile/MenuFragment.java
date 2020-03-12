package com.example.mobile;

import android.content.Context;
import android.os.Bundle;
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
        return inflater.inflate(R.layout.menu, container, false);
    }

    @Override
    public void onAttach(Context context) {
        try{
            TextView textView = this.getActivity().findViewById(R.id.counter);
            String c = textView.getText().toString();
            Integer count = Integer.getInteger(c);
            count = count + 1;
            Toast.makeText(context, count, Toast.LENGTH_LONG).show();
            textView.setText(count);
        }catch (NullPointerException e){
            e.printStackTrace();
        }
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        try{
            TextView textView = this.getActivity().findViewById(R.id.counter);
            String c = textView.getText().toString();
            Integer count = Integer.getInteger(c);
            count = count - 1;
            Toast.makeText(this.getContext(), count, Toast.LENGTH_LONG).show();
            textView.setText(count);
        }catch (NullPointerException e){
            e.printStackTrace();
        }
    }
}
