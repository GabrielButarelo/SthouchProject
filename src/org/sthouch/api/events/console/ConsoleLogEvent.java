/**
 *
 * Este arquivo pertence (e faz parte) ao/do Sthouch Project, que estï¿½ Licenciado com a MIT Licence (MIT).
 *
 * Copyright (C) 2014 Sthouch Team <http://www.sthouch.org/ e contribuidores>
 *
 * A permissÃ£o Ã© concedida, a tÃ­tulo gratuito, a qualquer pessoa que obtenha uma cÃ³pia
 * deste software e arquivos de documentaÃ§Ã£o associados (o "Software"), para negociar
 * o Software sem restriÃ§Ã£o, incluindo, sem limitaÃ§Ã£o, os direitos
 * para usar, copiar, modificar, mesclar, publicar, distribuir, sublicenciar e/ou vender
 * cÃ³pias do Software, e permitir que as pessoas a quem o Software Ã©
 * fornecido faÃ§am isso, sujeito Ã¡s seguintes condiÃ§Ãµes:
 *
 * ---------
 *
 * O aviso de copyright acima, os avisos abaixo, e este aviso de permissÃ£o devem ser incluidos em todas as cÃ³pias ou partes
 * substanciais do Software, obrigatoriamente;
 *
 * Os Nome(s) dos detentores de direitos autorais acima deverÃ¡ nÃ£o poder ser usado em publicidade ou de outra forma para promover
 * a venda, uso ou outras negociaÃ§Ãµes em Este Software sem autorizaÃ§Ã£o prÃ©via por escrito, do LÃ­der do Projeto.
 *
 * O Intitulado Contribuidor do Projeto (Citado acima, no Copyright), Ã©/sÃ£o aquele/aqueles que fazem, ou, por sua vez,
 * fizeram parte da equipe oficial, sendo assim entÃ£o ou um dia, aceitos pela equipe oficial do  Sthouch como, por sua vez,
 * Contribuï¿½ntes e Desenvolvedores do mesmo. Qualquer outro usuÃ¡rio que, por sua vez, nÃ£o seja/esteja dentro/participando da
 * equipe oficial, ou nunca tenha participado oficialmente da equipe, nÃ£o tem direitos como "contribuidores" ou "contribuinte" do
 * projeto Sthouch (ou Sthouch Project).
 *
 * ---------
 *
 * O SOFTWARE Ã‰ FORNECIDO "COMO ESTÃ�", SEM GARANTIA DE QUALQUER TIPO, EXPRESSA OU IMPLÃ�CITA, INCLUINDO, SEM LIMITAÃ‡ÃƒO,
 * AS GARANTIAS DE COMERCIALIZAÃ‡ÃƒO,ADEQUAÃ‡ÃƒO A UM DETERMINADO FIM E NÃƒO VIOLAÃ‡ÃƒO.
 * EM NENHUM CASO A AUTORES OU DETENTORES DOS DIREITOS AUTORAIS SERÃ� RESPONSÃ�VEL POR QUALQUER RECLAMAÃ‡ÃƒO, DANOS OU OUTRAS
 * RESPONSABILIDADE, SEJA EM UMA AÃ‡ÃƒO DE CUMPRIMENTO DE CONTRATO OU QUALQUER OUTRO MEIO, DE OU EM CONEXÃƒO COM O SOFTWARE OU O
 * USO OU OUTRAS NEGOCIAÃ‡Ã•ES O SOFTWARE.
 *
 * MIT Licence (MIT), Fonte: < http://pt.wikipedia.org/wiki/Licen%C3%A7a_MIT >
 **/

package org.sthouch.api.events.console;

import org.sthouch.api.chating.Chat;
import org.sthouch.api.events.Event;

/**
 * Created by JonathanScripter on 20/set/2014 on 22:05
 */
public class ConsoleLogEvent implements Event {

    private final Chat chat;

    public ConsoleLogEvent(Chat chat){
        this.chat = chat;
    }

    public Chat getChat(){
        return this.chat;
    }

    public boolean isCancelled() {
        return false;
    }

    @Override
    public boolean isCancellable() {
        return false;
    }

    @Override
    public String getName() {
        return "ConsoleLogEvent";
    }

    public void setCancelled(boolean cancel) {

    }
}
