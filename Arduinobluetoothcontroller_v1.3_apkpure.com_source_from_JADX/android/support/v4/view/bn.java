package android.support.v4.view;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;

public abstract class bn {
    private final DataSetObservable f675a = new DataSetObservable();
    private DataSetObserver f676b;

    public int m1136a(Object obj) {
        return -1;
    }

    public Parcelable mo187a() {
        return null;
    }

    public Object m1138a(View view, int i) {
        throw new UnsupportedOperationException("Required method instantiateItem was not overridden");
    }

    public Object mo188a(ViewGroup viewGroup, int i) {
        return m1138a((View) viewGroup, i);
    }

    void m1140a(DataSetObserver dataSetObserver) {
        synchronized (this) {
            this.f676b = dataSetObserver;
        }
    }

    public void mo189a(Parcelable parcelable, ClassLoader classLoader) {
    }

    public void m1142a(View view) {
    }

    public void m1143a(View view, int i, Object obj) {
        throw new UnsupportedOperationException("Required method destroyItem was not overridden");
    }

    public void mo190a(ViewGroup viewGroup) {
        m1142a((View) viewGroup);
    }

    public void mo191a(ViewGroup viewGroup, int i, Object obj) {
        m1143a((View) viewGroup, i, obj);
    }

    public abstract boolean mo192a(View view, Object obj);

    public float m1147b(int i) {
        return 1.0f;
    }

    public abstract int mo839b();

    public void m1149b(View view) {
    }

    public void m1150b(View view, int i, Object obj) {
    }

    public void mo193b(ViewGroup viewGroup) {
        m1149b((View) viewGroup);
    }

    public void mo194b(ViewGroup viewGroup, int i, Object obj) {
        m1150b((View) viewGroup, i, obj);
    }
}
