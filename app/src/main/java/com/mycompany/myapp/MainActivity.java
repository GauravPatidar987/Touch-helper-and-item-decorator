package com.mycompany.myapp;

import android.app.*;
import android.os.*;
import android.widget.*;
import android.widget.AdapterView.*;
import android.view.*;
import androidx.recyclerview.widget.*;
import androidx.recyclerview.widget.RecyclerView.*;

public class MainActivity extends Activity 
{
	RecyclerView lst;
	MyAdapter adapter;
	GridLayoutManager gm;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        lst=findViewById(R.id.lst);
		adapter=new MyAdapter();
		lst.setAdapter(adapter);	
		gm=new GridLayoutManager(this,1);
		lst.setLayoutManager(gm);
		DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(lst.getContext(),
																				gm.getOrientation());
		lst.addItemDecoration(dividerItemDecoration);
		ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {

				@Override
				public boolean onMove(RecyclerView p1, RecyclerView.ViewHolder p2, RecyclerView.ViewHolder p3)
				{
					// TODO: Implement this method
					return false;
				}
				
				@Override
				public void onSwiped(RecyclerView.ViewHolder viewHolder, int swipeDir) {
					// Remove item from backing list here
					adapter.notifyDataSetChanged();
				}
				
			});

		itemTouchHelper.attachToRecyclerView(lst);
	}
}
