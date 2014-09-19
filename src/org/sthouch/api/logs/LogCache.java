package org.sthouch.api.logs;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Gerenciador do Cachê dos Logs atuais.</p>
 * @author Pedro
 *
 */
public class LogCache {

	private static final List<String> logs = new ArrayList<>();

	public void save() {
		
	}

	public void reset() {
		logs.clear();
	}

}