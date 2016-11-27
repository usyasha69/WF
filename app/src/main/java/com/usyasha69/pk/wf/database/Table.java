package com.usyasha69.pk.wf.database;

import android.net.Uri;

public interface Table {
    String getName();

    String getColumnId();

    Uri getItemUri(long id);
}
