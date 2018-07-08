package android.support.v7.p005a;

import android.content.Context;
import android.widget.ArrayAdapter;

class C0293r extends ArrayAdapter {
    public C0293r(Context context, int i, int i2, CharSequence[] charSequenceArr) {
        super(context, i, i2, charSequenceArr);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public boolean hasStableIds() {
        return true;
    }
}
