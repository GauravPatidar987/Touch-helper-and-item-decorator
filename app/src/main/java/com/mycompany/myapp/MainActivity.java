package com.mycompany.myapp;

import android.Manifest;
import android.app.*;
import android.os.*;
import android.widget.*;
import android.widget.AdapterView.*;
import android.view.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.*;
import androidx.recyclerview.widget.RecyclerView.*;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;
import java.io.File;

public class MainActivity extends AppCompatActivity {
	RecyclerView lst;
	MyAdapter adapter;
	GridLayoutManager gm;
	public static FrameLayout frame;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		lst = findViewById(R.id.lst);
		frame = findViewById(R.id.cont);
		Dexter.withActivity(this).withPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
				.withListener(new PermissionListener() {
					@Override
					public void onPermissionGranted(PermissionGrantedResponse response) {
						File dir = Environment.getExternalStorageDirectory();
						File list[] = dir.listFiles();
						adapter = new MyAdapter(list, MainActivity.this);
						lst.setAdapter(adapter);
						gm = new GridLayoutManager(MainActivity.this, 1);
						lst.setLayoutManager(gm);
						DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(lst.getContext(),
								gm.getOrientation());
						lst.addItemDecoration(dividerItemDecoration);
						ItemTouchHelper itemTouchHelper = new ItemTouchHelper(
								new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {

									@Override
									public boolean onMove(RecyclerView p1, RecyclerView.ViewHolder p2,
											RecyclerView.ViewHolder p3) {
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

					@Override
					public void onPermissionDenied(PermissionDeniedResponse response) {
						/* ... */}

					@Override
					public void onPermissionRationaleShouldBeShown(PermissionRequest permission,
							PermissionToken token) {
						/* ... */}

				}).check();
	}
}
