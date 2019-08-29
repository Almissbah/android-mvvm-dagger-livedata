package com.almissbah.wasit.data.remote;

import android.util.Log;
import io.reactivex.observers.DisposableObserver;

public abstract class CallbackWrapper<T> extends DisposableObserver<T> {
    protected abstract void onSuccess(T t);

    @Override
    public void onNext(T t) {


        onSuccess(t);
    }

    @Override
    public void onError(Throwable e) {
        Log.d(CallbackWrapper.class.getSimpleName(), e.toString());
    }

    @Override
    public void onComplete() {

    }
}
