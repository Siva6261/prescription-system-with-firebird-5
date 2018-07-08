package android.support.v7.p005a;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.CursorAdapter;
import android.widget.ListView;

class C0288m extends CursorAdapter {
    final /* synthetic */ ListView f1418a;
    final /* synthetic */ C0280e f1419b;
    final /* synthetic */ C0286k f1420c;
    private final int f1421d;
    private final int f1422e;

    C0288m(C0286k c0286k, Context context, Cursor cursor, boolean z, ListView listView, C0280e c0280e) {
        this.f1420c = c0286k;
        this.f1418a = listView;
        this.f1419b = c0280e;
        super(context, cursor, z);
        Cursor cursor2 = getCursor();
        this.f1421d = cursor2.getColumnIndexOrThrow(this.f1420c.f1385I);
        this.f1422e = cursor2.getColumnIndexOrThrow(this.f1420c.f1386J);
    }

    public void bindView(View view, Context context, Cursor cursor) {
        ((CheckedTextView) view.findViewById(16908308)).setText(cursor.getString(this.f1421d));
        this.f1418a.setItemChecked(cursor.getPosition(), cursor.getInt(this.f1422e) == 1);
    }

    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f1420c.f1391b.inflate(this.f1419b.f1332I, viewGroup, false);
    }
}
