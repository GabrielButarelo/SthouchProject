package org.sthouch.pastebin;

import java.net.URL;

import org.eclipse.jdt.annotation.Nullable;

@SuppressWarnings("unused")
public class PasteError {

	private Exception s = null;
	private URL link = null;
	private String id = "";

	private PasteError() {}
	public PasteError(Exception s) {
		this.s = s;
	}

	public void send() {
		Pastebin pb = new Pastebin(s.getMessage(), new String[] {
			"Mensagem > " + s.getMessage(),
			"Mensagem Localizada > " + s.getLocalizedMessage(),
			"Tipo de Exceção > " + s.getClass(),
			" ",
			"Este documento será excluído automaticamente em 1hr."
		});
		pb.send();
		link = pb.getPasteLink();
		id = pb.getPasteId();
	}

	@Nullable
	public URL getPasteLink() {
		return link;
	}

	@Nullable
	public String getPasteId() {
		return id;
	}

}