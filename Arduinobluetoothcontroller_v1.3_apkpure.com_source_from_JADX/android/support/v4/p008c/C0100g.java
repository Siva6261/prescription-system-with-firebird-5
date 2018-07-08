package android.support.v4.p008c;

import android.content.ComponentName;
import android.content.Intent;

class C0100g implements C0099f {
    C0100g() {
    }

    public Intent mo208a(ComponentName componentName) {
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.setComponent(componentName);
        intent.addCategory("android.intent.category.LAUNCHER");
        return intent;
    }
}
