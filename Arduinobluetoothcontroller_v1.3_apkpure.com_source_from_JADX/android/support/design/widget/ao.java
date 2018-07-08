package android.support.design.widget;

import android.graphics.drawable.Drawable;

class ao implements bh {
    final /* synthetic */ FloatingActionButton f328a;

    private ao(FloatingActionButton floatingActionButton) {
        this.f328a = floatingActionButton;
    }

    public float mo76a() {
        return ((float) this.f328a.getSizeDimension()) / 2.0f;
    }

    public void mo77a(int i, int i2, int i3, int i4) {
        this.f328a.f275h.set(i, i2, i3, i4);
        this.f328a.setPadding(this.f328a.f273f + i, this.f328a.f273f + i2, this.f328a.f273f + i3, this.f328a.f273f + i4);
    }

    public void mo78a(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    public boolean mo79b() {
        return this.f328a.f274g;
    }
}
