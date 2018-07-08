package android.support.v7.widget;

import android.database.Observable;

class dy extends Observable {
    dy() {
    }

    public void m4496a() {
        for (int size = this.mObservers.size() - 1; size >= 0; size--) {
            ((dz) this.mObservers.get(size)).mo767a();
        }
    }

    public void m4497a(int i, int i2) {
        for (int size = this.mObservers.size() - 1; size >= 0; size--) {
            ((dz) this.mObservers.get(size)).mo768a(i, i2);
        }
    }
}
