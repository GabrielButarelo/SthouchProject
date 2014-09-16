package org.sthouch.api.listeners;

public abstract interface CancelledEvent {

	public abstract boolean isDenied();
	public abstract void setDenied(boolean denied);

}