package android.support.v7.widget;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;

public abstract class eg {
    @Deprecated
    public void m4506a(Canvas canvas, RecyclerView recyclerView) {
    }

    public void m4507a(Canvas canvas, RecyclerView recyclerView, ev evVar) {
        m4506a(canvas, recyclerView);
    }

    @Deprecated
    public void m4508a(Rect rect, int i, RecyclerView recyclerView) {
        rect.set(0, 0, 0, 0);
    }

    public void m4509a(Rect rect, View view, RecyclerView recyclerView, ev evVar) {
        m4508a(rect, ((ej) view.getLayoutParams()).m4360e(), recyclerView);
    }

    @Deprecated
    public void m4510b(Canvas canvas, RecyclerView recyclerView) {
    }

    public void m4511b(Canvas canvas, RecyclerView recyclerView, ev evVar) {
        m4510b(canvas, recyclerView);
    }
}
