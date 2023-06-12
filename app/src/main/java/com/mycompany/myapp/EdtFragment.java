package com.mycompany.myapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.fragment.app.Fragment;

public class EdtFragment extends Fragment{
	@Override
	public View onCreateView(LayoutInflater arg0, ViewGroup arg1, Bundle arg2) {
		 super.onCreateView(arg0, arg1, arg2);
	View view=arg0.inflate(R.layout.edt,arg1,false);
		 return view;
	}
}