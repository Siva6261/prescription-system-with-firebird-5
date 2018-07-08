package android.support.v4.widget;

import android.database.DataSetObserver;

class C0256p extends DataSetObserver {
    final /* synthetic */ C0242m f1147a;

    private C0256p(C0242m c0242m) {
        this.f1147a = c0242m;
    }

    public void onChanged() {
        this.f1147a.f1092a = true;
        this.f1147a.notifyDataSetChanged();
    }

    public void onInvalidated() {
        this.f1147a.f1092a = false;
        this.f1147a.notifyDataSetInvalidated();
    }
}
