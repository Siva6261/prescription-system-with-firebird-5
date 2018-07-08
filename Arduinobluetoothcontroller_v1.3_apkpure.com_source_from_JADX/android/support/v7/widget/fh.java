package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.p005a.C0279d;
import android.support.v7.p018b.C0298b;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

class fh extends cq implements OnLongClickListener {
    final /* synthetic */ fd f2298a;
    private final int[] f2299b = new int[]{16842964};
    private C0279d f2300c;
    private TextView f2301d;
    private ImageView f2302e;
    private View f2303f;

    public fh(fd fdVar, Context context, C0279d c0279d, boolean z) {
        this.f2298a = fdVar;
        super(context, null, C0298b.actionBarTabStyle);
        this.f2300c = c0279d;
        gf a = gf.m4787a(context, null, this.f2299b, C0298b.actionBarTabStyle, 0);
        if (a.m4802f(0)) {
            setBackgroundDrawable(a.m4790a(0));
        }
        a.m4791a();
        if (z) {
            setGravity(8388627);
        }
        m4696a();
    }

    public void m4696a() {
        C0279d c0279d = this.f2300c;
        View c = c0279d.m3158c();
        if (c != null) {
            fh parent = c.getParent();
            if (parent != this) {
                if (parent != null) {
                    parent.removeView(c);
                }
                addView(c);
            }
            this.f2303f = c;
            if (this.f2301d != null) {
                this.f2301d.setVisibility(8);
            }
            if (this.f2302e != null) {
                this.f2302e.setVisibility(8);
                this.f2302e.setImageDrawable(null);
                return;
            }
            return;
        }
        if (this.f2303f != null) {
            removeView(this.f2303f);
            this.f2303f = null;
        }
        Drawable a = c0279d.m3156a();
        CharSequence b = c0279d.m3157b();
        if (a != null) {
            if (this.f2302e == null) {
                View imageView = new ImageView(getContext());
                LayoutParams crVar = new cr(-2, -2);
                crVar.f2139h = 16;
                imageView.setLayoutParams(crVar);
                addView(imageView, 0);
                this.f2302e = imageView;
            }
            this.f2302e.setImageDrawable(a);
            this.f2302e.setVisibility(0);
        } else if (this.f2302e != null) {
            this.f2302e.setVisibility(8);
            this.f2302e.setImageDrawable(null);
        }
        boolean z = !TextUtils.isEmpty(b);
        if (z) {
            if (this.f2301d == null) {
                imageView = new bq(getContext(), null, C0298b.actionBarTabTextStyle);
                imageView.setEllipsize(TruncateAt.END);
                crVar = new cr(-2, -2);
                crVar.f2139h = 16;
                imageView.setLayoutParams(crVar);
                addView(imageView);
                this.f2301d = imageView;
            }
            this.f2301d.setText(b);
            this.f2301d.setVisibility(0);
        } else if (this.f2301d != null) {
            this.f2301d.setVisibility(8);
            this.f2301d.setText(null);
        }
        if (this.f2302e != null) {
            this.f2302e.setContentDescription(c0279d.m3160e());
        }
        if (z || TextUtils.isEmpty(c0279d.m3160e())) {
            setOnLongClickListener(null);
            setLongClickable(false);
            return;
        }
        setOnLongClickListener(this);
    }

    public void m4697a(C0279d c0279d) {
        this.f2300c = c0279d;
        m4696a();
    }

    public C0279d m4698b() {
        return this.f2300c;
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(C0279d.class.getName());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        if (VERSION.SDK_INT >= 14) {
            accessibilityNodeInfo.setClassName(C0279d.class.getName());
        }
    }

    public boolean onLongClick(View view) {
        int[] iArr = new int[2];
        getLocationOnScreen(iArr);
        Context context = getContext();
        int width = getWidth();
        int height = getHeight();
        int i = context.getResources().getDisplayMetrics().widthPixels;
        Toast makeText = Toast.makeText(context, this.f2300c.m3160e(), 0);
        makeText.setGravity(49, (iArr[0] + (width / 2)) - (i / 2), height);
        makeText.show();
        return true;
    }

    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f2298a.f2286b > 0 && getMeasuredWidth() > this.f2298a.f2286b) {
            super.onMeasure(MeasureSpec.makeMeasureSpec(this.f2298a.f2286b, 1073741824), i2);
        }
    }

    public void setSelected(boolean z) {
        Object obj = isSelected() != z ? 1 : null;
        super.setSelected(z);
        if (obj != null && z) {
            sendAccessibilityEvent(4);
        }
    }
}
