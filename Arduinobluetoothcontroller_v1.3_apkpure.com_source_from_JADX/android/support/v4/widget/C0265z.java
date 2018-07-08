package android.support.v4.widget;

import android.widget.ListView;

public class C0265z extends C0240a {
    private final ListView f1151a;

    public C0265z(ListView listView) {
        super(listView);
        this.f1151a = listView;
    }

    public void mo471a(int i, int i2) {
        aa.m2594a(this.f1151a, i2);
    }

    public boolean mo472e(int i) {
        return false;
    }

    public boolean mo473f(int i) {
        ListView listView = this.f1151a;
        int count = listView.getCount();
        if (count == 0) {
            return false;
        }
        int childCount = listView.getChildCount();
        int firstVisiblePosition = listView.getFirstVisiblePosition();
        int i2 = firstVisiblePosition + childCount;
        if (i > 0) {
            if (i2 >= count && listView.getChildAt(childCount - 1).getBottom() <= listView.getHeight()) {
                return false;
            }
        } else if (i >= 0) {
            return false;
        } else {
            if (firstVisiblePosition <= 0 && listView.getChildAt(0).getTop() >= 0) {
                return false;
            }
        }
        return true;
    }
}
