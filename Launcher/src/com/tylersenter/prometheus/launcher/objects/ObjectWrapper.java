package com.tylersenter.prometheus.launcher.objects;

public final class ObjectWrapper<T> {

	private T obj;

	public ObjectWrapper() {
		obj = null;
	}

	public ObjectWrapper(T obj) {
		this.obj = obj;
	}
	
	public T getObject() {
		return obj;
	}
	
	public ObjectWrapper<T> setObject(T obj) {
		this.obj = obj;
		return this;
	}

}