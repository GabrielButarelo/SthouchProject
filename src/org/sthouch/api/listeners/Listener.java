package org.sthouch.api.listeners;
/**
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
 **/

import org.sthouch.SthouchServer;
import org.sthouch.api.events.Event;
import org.sthouch.api.plugin.Plugin;
import org.sthouch.exceptions.AlreadyRegisteredEventException;
import org.sthouch.exceptions.AlreadyRegisteredListenerException;
<<<<<<< HEAD

=======
import org.sthouch.util.ClassUtils;

import java.lang.annotation.Annotation;
>>>>>>> origin/master
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by JonathanScripter on 19/09/14.
 */
<<<<<<< HEAD
@SuppressWarnings({})
public class Listener {

    private final List<Class<? extends Event>> eventsList = new ArrayList<Class<? extends Event>>();
=======
public class Listener {
    private final List<Class<? extends Event>> eventsList = new ArrayList<Class<? extends Event>>();

>>>>>>> origin/master
    private final HashMap<Plugin, MinecraftListener> listenersList = new HashMap<Plugin, MinecraftListener>();

    /**
     * Registra o listener de seu plugin
     * @param plugin Plugin
     * @param listener Classe do Listener
<<<<<<< HEAD
     * @author JonathanScripter
     */
    public void registerListener(Plugin plugin, MinecraftListener listener) {
        if (!listenersList.containsKey(listener)) {
            listenersList.put(plugin, listener);
        } else {
            try {
                throw new AlreadyRegisteredListenerException("Error on register listener "+listener.getClass().getName()+" from plugin "+plugin.getPluginName());
            } catch(Throwable e) {
=======
     */
    public void registerListener(Plugin plugin, MinecraftListener listener){
        if(!listenersList.containsKey(listener)){
            listenersList.put(plugin, listener);
        }else{
            try{
                throw new AlreadyRegisteredListenerException("Error on register listener "+listener.getClass().getName()+" from plugin "+plugin.getPluginName());
            }catch(Throwable e){
>>>>>>> origin/master
                SthouchServer.logger.exception(e);
            }

        }
    }

<<<<<<< HEAD
    public void registerEvent(Class<? extends Event> event) {
        if (!eventsList.contains(event)) {
            eventsList.add(event);
        } else {
            try {
                throw new AlreadyRegisteredEventException("Error on register event "+event.getName());
            } catch(Throwable e) {
=======
    public void registerEvent(Class<? extends Event> event){
        if(!eventsList.contains(event)){
            eventsList.add(event);
        }else{
            try{
                throw new AlreadyRegisteredEventException("Error on register event "+event.getName());
            }catch(Throwable e){
>>>>>>> origin/master
                SthouchServer.logger.exception(e);
            }
        }
    }

<<<<<<< HEAD
	public void callEvent(Event event) {
        for(Map.Entry<Plugin, MinecraftListener> l : listenersList.entrySet()) {
=======
    public void callEvent(Event event){
        for(Map.Entry<Plugin, MinecraftListener> l : listenersList.entrySet()){
>>>>>>> origin/master
            Class<?> clazz = l.getValue().getClass();
            //ClassUtils.getMethodsANN(clazz, RegisteredEvent.class);
        }
    }

    private static final Listener defaultListener = new Listener();
<<<<<<< HEAD
    public static void init() {

    }

    private static Listener getDefaultListener() {
        return defaultListener;
    }

}
=======
    public static void init(){

    }

    private static Listener getDefaultListener(){
        return defaultListener;
    }


}
>>>>>>> origin/master
