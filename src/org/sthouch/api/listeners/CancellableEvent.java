package org.sthouch.api.listeners;

public abstract interface CancellableEvent {

	public abstract boolean isDenied();
	public abstract void setDenied(boolean denied);

}