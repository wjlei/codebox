package org.badboy.browser;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

public class WebProgressBar extends LinearLayout {

	private ProgressBar bar;
	public WebProgressBar(Context context) {
		super(context);
		LayoutInflater factory = LayoutInflater.from(context);
		factory.inflate(R.layout.progress_bar, this);
		bar = (ProgressBar)findViewById(R.id.progress_bar);
	}
	public void setProgress(int newProgress){
		bar.setProgress(newProgress);
	}
	
}
