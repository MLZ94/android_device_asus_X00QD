package com.asus.zenparts;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.service.quicksettings.TileService;

import com.android.internal.logging.nano.MetricsProto;
import com.android.settings.R;
import com.android.settings.SettingsPreferenceFragment;

import com.asus.zenparts.fragments.team.TeamActivity;

import com.asus.zenparts.DeviceSettings;
import com.asus.zenparts.DeviceSettingsActivity;

public class ZenpartsTile extends TileService {

    @Override
    public void onClick() {
        try {
            Intent intent = new Intent(this, DeviceSettingsActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivityAndCollapse(intent);
        } catch (ActivityNotFoundException ignored) {
            // At this point, the app is most likely hidden and set to only open from Settings
            Intent intent = new Intent(this, DeviceSettings.class);
            startActivityAndCollapse(intent);
        }
            @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		menu.add(0, 0, 0, R.string.dialog_team_title);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
	    if (item.getItemId() == 0) {
		    Intent intent = new Intent(mContext, TeamActivity.class);
		    mContext.startActivity(intent);
		    return true;
	    }
	    return false;
    }
}