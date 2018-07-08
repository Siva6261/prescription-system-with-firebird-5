package android.support.v7.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.p010d.p011a.C0106a;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import java.lang.reflect.Field;

public class dk extends ListView {
    private static final int[] f2166g = new int[]{0};
    final Rect f2167a = new Rect();
    int f2168b = 0;
    int f2169c = 0;
    int f2170d = 0;
    int f2171e = 0;
    protected int f2172f;
    private Field f2173h;
    private dl f2174i;

    public dk(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        try {
            this.f2173h = AbsListView.class.getDeclaredField("mIsChildViewEnabled");
            this.f2173h.setAccessible(true);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    public int m4387a(int i, int i2, int i3, int i4, int i5) {
        int listPaddingTop = getListPaddingTop();
        int listPaddingBottom = getListPaddingBottom();
        getListPaddingLeft();
        getListPaddingRight();
        int dividerHeight = getDividerHeight();
        Drawable divider = getDivider();
        ListAdapter adapter = getAdapter();
        if (adapter == null) {
            return listPaddingTop + listPaddingBottom;
        }
        listPaddingBottom += listPaddingTop;
        if (dividerHeight <= 0 || divider == null) {
            dividerHeight = 0;
        }
        int i6 = 0;
        View view = null;
        int i7 = 0;
        int count = adapter.getCount();
        int i8 = 0;
        while (i8 < count) {
            View view2;
            listPaddingTop = adapter.getItemViewType(i8);
            if (listPaddingTop != i7) {
                int i9 = listPaddingTop;
                view2 = null;
                i7 = i9;
            } else {
                view2 = view;
            }
            view = adapter.getView(i8, view2, this);
            LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = generateDefaultLayoutParams();
                view.setLayoutParams(layoutParams);
            }
            view.measure(i, layoutParams.height > 0 ? MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824) : MeasureSpec.makeMeasureSpec(0, 0));
            view.forceLayout();
            listPaddingTop = (i8 > 0 ? listPaddingBottom + dividerHeight : listPaddingBottom) + view.getMeasuredHeight();
            if (listPaddingTop >= i4) {
                return (i5 < 0 || i8 <= i5 || i6 <= 0 || listPaddingTop == i4) ? i4 : i6;
            } else {
                if (i5 >= 0 && i8 >= i5) {
                    i6 = listPaddingTop;
                }
                i8++;
                listPaddingBottom = listPaddingTop;
            }
        }
        return listPaddingBottom;
    }

    protected void m4388a(int i, View view) {
        boolean z = true;
        Drawable selector = getSelector();
        boolean z2 = (selector == null || i == -1) ? false : true;
        if (z2) {
            selector.setVisible(false, false);
        }
        m4393b(i, view);
        if (z2) {
            Rect rect = this.f2167a;
            float exactCenterX = rect.exactCenterX();
            float exactCenterY = rect.exactCenterY();
            if (getVisibility() != 0) {
                z = false;
            }
            selector.setVisible(z, false);
            C0106a.m1333a(selector, exactCenterX, exactCenterY);
        }
    }

    protected void m4389a(int i, View view, float f, float f2) {
        m4388a(i, view);
        Drawable selector = getSelector();
        if (selector != null && i != -1) {
            C0106a.m1333a(selector, f, f2);
        }
    }

    protected void m4390a(Canvas canvas) {
        if (!this.f2167a.isEmpty()) {
            Drawable selector = getSelector();
            if (selector != null) {
                selector.setBounds(this.f2167a);
                selector.draw(canvas);
            }
        }
    }

    protected boolean mo726a() {
        return false;
    }

    protected void m4392b() {
        Drawable selector = getSelector();
        if (selector != null && m4394c()) {
            selector.setState(getDrawableState());
        }
    }

    protected void m4393b(int i, View view) {
        Rect rect = this.f2167a;
        rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        rect.left -= this.f2168b;
        rect.top -= this.f2169c;
        rect.right += this.f2170d;
        rect.bottom += this.f2171e;
        try {
            boolean z = this.f2173h.getBoolean(this);
            if (view.isEnabled() != z) {
                this.f2173h.set(this, Boolean.valueOf(!z));
                if (i != -1) {
                    refreshDrawableState();
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    protected boolean m4394c() {
        return mo726a() && isPressed();
    }

    protected void dispatchDraw(Canvas canvas) {
        m4390a(canvas);
        super.dispatchDraw(canvas);
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        setSelectorEnabled(true);
        m4392b();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.f2172f = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setSelector(Drawable drawable) {
        this.f2174i = drawable != null ? new dl(drawable) : null;
        super.setSelector(this.f2174i);
        Rect rect = new Rect();
        if (drawable != null) {
            drawable.getPadding(rect);
        }
        this.f2168b = rect.left;
        this.f2169c = rect.top;
        this.f2170d = rect.right;
        this.f2171e = rect.bottom;
    }

    protected void setSelectorEnabled(boolean z) {
        if (this.f2174i != null) {
            this.f2174i.m4401a(z);
        }
    }
}
