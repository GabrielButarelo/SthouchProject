/*
 * 
  * Este arquivo pertence (e faz parte) ao/do Sthouch Project, que est� Licenciado com a MIT Licence (MIT).
  * 
  * Copyright (C) 2014 Sthouch Team <http://www.sthouch.org/ e contribuidores>
  * 
  * A permiss�o � concedida, a t�tulo gratuito, a qualquer pessoa que obtenha uma c�pia
  * deste software e arquivos de documenta��o associados (o "Software"), para negociar
  * o Software sem restri��o, incluindo, sem limita��o, os direitos
  * para usar, copiar, modificar, mesclar, publicar, distribuir, sublicenciar e/ou vender
  * c�pias do Software, e permitir que as pessoas a quem o Software �
  * fornecido fa�am isso, sujeito �s seguintes condi��es:
  *
  * ---------
  *
  * O aviso de copyright acima, os avisos abaixo, e este aviso de permiss�o devem ser inclu�dos em todas as c�pias ou partes 
  * substanciais do Software, obrigatoriamente;
  * 
  * Os Nome(s) dos detentores de direitos autorais acima dever� n�o poder ser usado em publicidade ou de outra forma para promover
  * a venda, uso ou outras negocia��es em Este Software sem autoriza��o pr�via por escrito, do L�der do Projeto.
  * 
  * O Intitulado Contribuidor do Projeto (Citado acima, no Copyright), �/s�o aquele/aqueles que fazem, ou, por sua vez,
  * fizeram parte da equipe oficial, sendo assim ent�o ou um dia, aceitos pela equipe oficial do  Sthouch como, por sua vez,
  * Contribu�ntes e Desenvolvedores do mesmo. Qualquer outro usu�rio que, por sua vez, n�o seja/esteja dentro/participando da
  * equipe oficial, ou nunca tenha participado oficialmente da equipe, n�o tem direitos como "contribuidores" ou "contribuinte" do
  * projeto Sthouch (ou Sthouch Project).
  * 
  * ---------
  * 
  * O SOFTWARE � FORNECIDO "COMO EST�", SEM GARANTIA DE QUALQUER TIPO, EXPRESSA OU IMPL�CITA, INCLUINDO, SEM LIMITA��O, 
  * AS GARANTIAS DE COMERCIALIZA��O,ADEQUA��O A UM DETERMINADO FIM E N�O VIOLA��O.
  * EM NENHUM CASO A AUTORES OU DETENTORES DOS DIREITOS AUTORAIS SER� RESPONS�VEL POR QUALQUER RECLAMA��O, DANOS OU OUTRAS
  * RESPONSABILIDADE, SEJA EM UMA A��O DE CUMPRIMENTO DE CONTRATO OU QUALQUER OUTRO MEIO, DE OU EM CONEX�O COM O SOFTWARE OU O 
  * USO OU OUTRAS NEGOCIA��ES O SOFTWARE.
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

			str = str.replaceAll("�", "[o1]");
			str = str.replaceAll("�", "[o2]");
			str = str.replaceAll("�", "[o3]");
			str = str.replaceAll("�", "[a1]");
			str = str.replaceAll("�", "[a2]");
			str = str.replaceAll("�", "[a3]");
			str = str.replaceAll("�", "[a4]");
			str = str.replaceAll("�", "[c]");
			str = str.replaceAll("�", "[i]");
			str = str.replaceAll("�", "[e1]");
			str = str.replaceAll("�", "[e2]");
			str = str.replaceAll("�", "[u]");

			str = str.replaceAll("�", "[O1]");
			str = str.replaceAll("�", "[O2]");
			str = str.replaceAll("�", "[O3]");
			str = str.replaceAll("�", "[A1]");
			str = str.replaceAll("�", "[A2]");
			str = str.replaceAll("�", "[A3]");
			str = str.replaceAll("�", "[A4]");
			str = str.replaceAll("�", "[C]");
			str = str.replaceAll("�", "[I]");
			str = str.replaceAll("�", "[E1]");
			str = str.replaceAll("�", "[E2]");
			str = str.replaceAll("�", "[U]");

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