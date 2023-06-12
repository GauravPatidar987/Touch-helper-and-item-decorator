package com.mycompany.myapp;
import android.widget.*;
import android.view.*;
import androidx.recyclerview.widget.*;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyVHolder>
{

	@Override
	public MyAdapter.MyVHolder onCreateViewHolder(ViewGroup p1, int p2)
	{
		View v=LayoutInflater.from(p1.getContext()).inflate(R.layout .abc
		,p1,false);
		return new MyVHolder(v);
	}

	@Override
	public void onBindViewHolder(MyAdapter.MyVHolder p1, int p2)
	{
		p1.txt.setText("Item : "+(p2+1));
	}

	@Override
	public int getItemCount()
	{
		
		return 5;
	}
	

	public class MyVHolder extends RecyclerView.ViewHolder{
		TextView txt;
		public MyVHolder(View v){
			super(v);
			txt=v.findViewById(R.id.abcTextView);
		}
	}
}
