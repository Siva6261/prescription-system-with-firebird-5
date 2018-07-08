package android.support.v4.widget;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class as extends C0242m {
    private int f1101j;
    private int f1102k;
    private LayoutInflater f1103l;

    public as(Context context, int i, Cursor cursor, boolean z) {
        super(context, cursor, z);
        this.f1102k = i;
        this.f1101j = i;
        this.f1103l = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    public View mo442a(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f1103l.inflate(this.f1101j, viewGroup, false);
    }

    public View mo443b(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f1103l.inflate(this.f1102k, viewGroup, false);
    }
}
