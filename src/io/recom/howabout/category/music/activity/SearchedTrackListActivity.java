package io.recom.howabout.category.music.activity;

import io.recom.howabout.R;
import io.recom.howabout.category.music.fragment.SearchedTrackListFragment;
import roboguice.inject.ContentView;
import android.content.res.Configuration;
import android.os.Bundle;

import com.actionbarsherlock.app.ActionBar;

@ContentView(R.layout.activity_track_list)
public class SearchedTrackListActivity extends TrackListActivity {

	protected SearchedTrackListFragment searchedTrackListFragment;

	protected String searchKeyword;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		Bundle bundle = getIntent().getExtras();
		searchKeyword = bundle.getString("searchKeyword");

		ActionBar actionBar = getSupportActionBar();
		actionBar.setTitle(R.string.menu_search);
		actionBar.setSubtitle(searchKeyword);

		searchedTrackListFragment = new SearchedTrackListFragment();
		Bundle recommendedTrackListFragmentBundle = new Bundle();
		recommendedTrackListFragmentBundle.putString("searchKeyword",
				searchKeyword);
		searchedTrackListFragment
				.setArguments(recommendedTrackListFragmentBundle);

		getSupportFragmentManager()
				.beginTransaction()
				.replace(R.id.contentView, searchedTrackListFragment,
						"music_search").commit();
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
	}

}
