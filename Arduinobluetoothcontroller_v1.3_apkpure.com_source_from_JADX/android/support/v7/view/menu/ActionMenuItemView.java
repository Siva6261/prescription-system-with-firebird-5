package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.bv;
import android.support.v7.p018b.C0299c;
import android.support.v7.p018b.C0308l;
import android.support.v7.widget.C0324u;
import android.support.v7.widget.bq;
import android.support.v7.widget.dc;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.Toast;

public class ActionMenuItemView extends bq implements aa, C0324u, OnClickListener, OnLongClickListener {
    private C0337m f1501a;
    private CharSequence f1502b;
    private Drawable f1503c;
    private C0325k f1504d;
    private dc f1505e;
    private C0331c f1506f;
    private boolean f1507g;
    private boolean f1508h;
    private int f1509i;
    private int f1510j;
    private int f1511k;

    public ActionMenuItemView(Context context) {
        this(context, null);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Resources resources = context.getResources();
        this.f1507g = resources.getBoolean(C0299c.abc_config_allowActionMenuItemTextWithIcon);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0308l.ActionMenuItemView, i, 0);
        this.f1509i = obtainStyledAttributes.getDimensionPixelSize(C0308l.ActionMenuItemView_android_minWidth, 0);
        obtainStyledAttributes.recycle();
        this.f1511k = (int) ((resources.getDisplayMetrics().density * 32.0f) + 0.5f);
        setOnClickListener(this);
        setOnLongClickListener(this);
        this.f1510j = -1;
    }

    private void m3303e() {
        int i = 0;
        int i2 = !TextUtils.isEmpty(this.f1502b) ? 1 : 0;
        if (this.f1503c == null || (this.f1501a.m3477m() && (this.f1507g || this.f1508h))) {
            i = 1;
        }
        setText((i2 & i) != 0 ? this.f1502b : null);
    }

    public void mo24a(C0337m c0337m, int i) {
        this.f1501a = c0337m;
        setIcon(c0337m.getIcon());
        setTitle(c0337m.m3457a((aa) this));
        setId(c0337m.getItemId());
        setVisibility(c0337m.isVisible() ? 0 : 8);
        setEnabled(c0337m.isEnabled());
        if (c0337m.hasSubMenu() && this.f1505e == null) {
            this.f1505e = new C0330b(this);
        }
    }

    public boolean mo25a() {
        return true;
    }

    public boolean m3306b() {
        return !TextUtils.isEmpty(getText());
    }

    public boolean mo583c() {
        return m3306b() && this.f1501a.getIcon() == null;
    }

    public boolean mo584d() {
        return m3306b();
    }

    public C0337m getItemData() {
        return this.f1501a;
    }

    public void onClick(View view) {
        if (this.f1504d != null) {
            this.f1504d.mo585a(this.f1501a);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (VERSION.SDK_INT >= 8) {
            super.onConfigurationChanged(configuration);
        }
        this.f1507g = getContext().getResources().getBoolean(C0299c.abc_config_allowActionMenuItemTextWithIcon);
        m3303e();
    }

    public boolean onLongClick(View view) {
        if (m3306b()) {
            return false;
        }
        int[] iArr = new int[2];
        Rect rect = new Rect();
        getLocationOnScreen(iArr);
        getWindowVisibleDisplayFrame(rect);
        Context context = getContext();
        int width = getWidth();
        int height = getHeight();
        int i = iArr[1] + (height / 2);
        width = (width / 2) + iArr[0];
        if (bv.m2031h(view) == 0) {
            width = context.getResources().getDisplayMetrics().widthPixels - width;
        }
        Toast makeText = Toast.makeText(context, this.f1501a.getTitle(), 0);
        if (i < rect.height()) {
            makeText.setGravity(8388661, width, (iArr[1] + height) - rect.top);
        } else {
            makeText.setGravity(81, 0, height);
        }
        makeText.show();
        return true;
    }

    protected void onMeasure(int i, int i2) {
        boolean b = m3306b();
        if (b && this.f1510j >= 0) {
            super.setPadding(this.f1510j, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(i, i2);
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        int measuredWidth = getMeasuredWidth();
        size = mode == Integer.MIN_VALUE ? Math.min(size, this.f1509i) : this.f1509i;
        if (mode != 1073741824 && this.f1509i > 0 && measuredWidth < size) {
            super.onMeasure(MeasureSpec.makeMeasureSpec(size, 1073741824), i2);
        }
        if (!b && this.f1503c != null) {
            super.setPadding((getMeasuredWidth() - this.f1503c.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return (this.f1501a.hasSubMenu() && this.f1505e != null && this.f1505e.onTouch(this, motionEvent)) ? true : super.onTouchEvent(motionEvent);
    }

    public void setCheckable(boolean z) {
    }

    public void setChecked(boolean z) {
    }

    public void setExpandedFormat(boolean z) {
        if (this.f1508h != z) {
            this.f1508h = z;
            if (this.f1501a != null) {
                this.f1501a.m3472h();
            }
        }
    }

    public void setIcon(Drawable drawable) {
        this.f1503c = drawable;
        if (drawable != null) {
            float f;
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (intrinsicWidth > this.f1511k) {
                f = ((float) this.f1511k) / ((float) intrinsicWidth);
                intrinsicWidth = this.f1511k;
                intrinsicHeight = (int) (((float) intrinsicHeight) * f);
            }
            if (intrinsicHeight > this.f1511k) {
                f = ((float) this.f1511k) / ((float) intrinsicHeight);
                intrinsicHeight = this.f1511k;
                intrinsicWidth = (int) (((float) intrinsicWidth) * f);
            }
            drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        }
        setCompoundDrawables(drawable, null, null, null);
        m3303e();
    }

    public void setItemInvoker(C0325k c0325k) {
        this.f1504d = c0325k;
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        this.f1510j = i;
        super.setPadding(i, i2, i3, i4);
    }

    public void setPopupCallback(C0331c c0331c) {
        this.f1506f = c0331c;
    }

    public void setTitle(CharSequence charSequence) {
        this.f1502b = charSequence;
        setContentDescription(this.f1502b);
        m3303e();
    }
}
