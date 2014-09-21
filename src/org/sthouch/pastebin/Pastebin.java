/*
 * 
  * Este arquivo pertence (e faz parte) ao/do Sthouch Project, que está Licenciado com a MIT Licence (MIT).
  * 
  * Copyright (C) 2014 Sthouch Team <http://www.sthouch.org/ e contribuidores>
  * 
  * A permissão é concedida, a título gratuito, a qualquer pessoa que obtenha uma cópia
  * deste software e arquivos de documentação associados (o "Software"), para negociar
  * o Software sem restrição, incluindo, sem limitação, os direitos
  * para usar, copiar, modificar, mesclar, publicar, distribuir, sublicenciar e/ou vender
  * cópias do Software, e permitir que as pessoas a quem o Software é
  * fornecido façam isso, sujeito às seguintes condições:
  *
  * ---------
  *
  * O aviso de copyright acima, os avisos abaixo, e este aviso de permissão devem ser incluídos em todas as cópias ou partes 
  * substanciais do Software, obrigatoriamente;
  * 
  * Os Nome(s) dos detentores de direitos autorais acima deverá não poder ser usado em publicidade ou de outra forma para promover
  * a venda, uso ou outras negociações em Este Software sem autorização prévia por escrito, do Líder do Projeto.
  * 
  * O Intitulado Contribuidor do Projeto (Citado acima, no Copyright), é/são aquele/aqueles que fazem, ou, por sua vez,
  * fizeram parte da equipe oficial, sendo assim então ou um dia, aceitos pela equipe oficial do  Sthouch como, por sua vez,
  * Contribuíntes e Desenvolvedores do mesmo. Qualquer outro usuário que, por sua vez, não seja/esteja dentro/participando da
  * equipe oficial, ou nunca tenha participado oficialmente da equipe, não tem direitos como "contribuidores" ou "contribuinte" do
  * projeto Sthouch (ou Sthouch Project).
  * 
  * ---------
  * 
  * O SOFTWARE É FORNECIDO "COMO ESTÁ", SEM GARANTIA DE QUALQUER TIPO, EXPRESSA OU IMPLÍCITA, INCLUINDO, SEM LIMITAÇÃO, 
  * AS GARANTIAS DE COMERCIALIZAÇÃO,ADEQUAÇÃO A UM DETERMINADO FIM E NÃO VIOLAÇÃO.
  * EM NENHUM CASO A AUTORES OU DETENTORES DOS DIREITOS AUTORAIS SERÁ RESPONSÁVEL POR QUALQUER RECLAMAÇÃO, DANOS OU OUTRAS
  * RESPONSABILIDADE, SEJA EM UMA AÇÃO DE CUMPRIMENTO DE CONTRATO OU QUALQUER OUTRO MEIO, DE OU EM CONEXÃO COM O SOFTWARE OU O 
  * USO OU OUTRAS NEGOCIAÇÕES O SOFTWARE.
  * 
  * MIT Licence (MIT), Fonte: < http://pt.wikipedia.org/wiki/Licen%C3%A7a_MIT >
 */

package org.sthouch.pastebin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class Pastebin {

	private String title = "";
	private String[] args = {};
	private String id = "";
	private Result result = Result.WAITING_ACTION;

	public Pastebin(String title, String[] args) {
		this.args=args;
		this.title=title;
	}

	public void send() {
		result = Result.PROCESSING;
		String code = "";
		String index = title;
		index = index.replaceAll("&", "[e]");
		index = index.replaceAll("=", "[compare]");
		index = index.replaceAll(" ", "[space]");

		for (String str : args) {
			str = str.replaceAll("&", "[e]");
			str = str.replaceAll("=", "[compare]");
			str = str.replaceAll(" ", "[space]");

			str = str.replaceAll("ó", "[o1]");
			str = str.replaceAll("õ", "[o2]");
			str = str.replaceAll("ô", "[o3]");
			str = str.replaceAll("á", "[a1]");
			str = str.replaceAll("ã", "[a2]");
			str = str.replaceAll("â", "[a3]");
			str = str.replaceAll("à", "[a4]");
			str = str.replaceAll("ç", "[c]");
			str = str.replaceAll("í", "[i]");
			str = str.replaceAll("é", "[e1]");
			str = str.replaceAll("ê", "[e2]");
			str = str.replaceAll("ú", "[u]");

			str = str.replaceAll("Ó", "[O1]");
			str = str.replaceAll("Õ", "[O2]");
			str = str.replaceAll("Ô", "[O3]");
			str = str.replaceAll("Á", "[A1]");
			str = str.replaceAll("Ã", "[A2]");
			str = str.replaceAll("Â", "[A3]");
			str = str.replaceAll("À", "[A4]");
			str = str.replaceAll("Ç", "[C]");
			str = str.replaceAll("Í", "[I]");
			str = str.replaceAll("É", "[E1]");
			str = str.replaceAll("Ê", "[E2]");
			str = str.replaceAll("Ú", "[U]");

			str += "[line]";
			code += str;
		}

		try {
			URL url = new URL("http://provider.atomgamers.com/sthouch/pastebin.php?title=" + index + "&paste=" + code);
			URLConnection con = url.openConnection();
			con.setConnectTimeout(7000);
			con.setReadTimeout(7000);
			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String response = br.readLine();
			result = Result.SUCCESSFULLY;
			setPasteId(response.split(".com/")[1]);
			return;
		} catch (MalformedURLException e) {
			e.printStackTrace();
			result = Result.URL_ERROR;
			return;
		} catch (IOException e) {
			e.printStackTrace();
			result = Result.CONNECTION_ERROR;
			return;
		}
	}

	private void setPasteId(String paste) {
		id=paste;
	}

	public String getPasteId() {
		return id;
	}

	public Result getResultOfAction() {
		return result;
	}

	public URL getPasteLink() {
		try {
			return new URL("http://www.pastebin.com/" + getPasteId());
		} catch (IOException e) {
			return null;
		}
	}

	public void rebuild(String[] args) {
		this.args=args;
	}

	public static enum Result {
		SUCCESSFULLY,
		URL_ERROR,
		CONNECTION_ERROR,
		PROCESSING,
		WAITING_ACTION
	}

}