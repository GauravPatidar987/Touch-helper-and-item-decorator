package com.mycompany.myapp;

import android.app.Activity;
import android.content.Context;
import android.widget.*;
import android.view.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.*;
import java.io.File;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyVHolder> implements View.OnLongClickListener{
	private File list[];
private Context context;
	public MyAdapter(File list[],Context context) {
		this.list = list;
		this.context=context;
	}

	@Override
	public MyAdapter.MyVHolder onCreateViewHolder(ViewGroup p1, int p2) {
		View v = LayoutInflater.from(p1.getContext()).inflate(R.layout.abc, p1, false);
		return new MyVHolder(v);
	}

	@Override
	public void onBindViewHolder(MyAdapter.MyVHolder p1, int p2) {
		p1.txt.setText(list[p2].getName());
		p1.txt.setOnLongClickListener(this);
		if (p2 % 2 == 0)
			p1.rb.setChecked(true);
	}

	@Override
	public int getItemCount() {

		return list.length;
	}

	public class MyVHolder extends RecyclerView.ViewHolder {
		TextView txt;
		RadioButton rb;

		public MyVHolder(View v) {
			super(v);
			txt = v.findViewById(R.id.abcTextView);
			rb = v.findViewById(R.id.rb);
		}
	
	
	}
	@Override
	public boolean onLongClick(View arg0) {
MainActivity.frame.setVisibility(View.VISIBLE);
	FragmentManager fm=	((AppCompatActivity)context).getSupportFragmentManager();
	 fm.beginTransaction().replace(R.id.cont,new EdtFragment()).commit();
		Toast.makeText(arg0.getContext(),"hey"+fm.toString(),Toast.LENGTH_LONG).show();
		return true;
	}
}
