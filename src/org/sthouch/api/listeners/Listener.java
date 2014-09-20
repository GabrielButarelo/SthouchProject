package org.sthouch.api.listeners;
/**
 *
 * Este arquivo pertence (e faz parte) ao/do Sthouch Project, que est� Licenciado com a MIT Licence (MIT).
 *
 * Copyright (C) 2014 Sthouch Team <http://www.sthouch.org/ e contribuidores>
 *
 * A permissão é concedida, a título gratuito, a qualquer pessoa que obtenha uma cópia
 * deste software e arquivos de documentação associados (o "Software"), para negociar
 * o Software sem restrição, incluindo, sem limitação, os direitos
 * para usar, copiar, modificar, mesclar, publicar, distribuir, sublicenciar e/ou vender
 * cópias do Software, e permitir que as pessoas a quem o Software é
 * fornecido façam isso, sujeito ás seguintes condições:
 *
 * ---------
 *
 * O aviso de copyright acima, os avisos abaixo, e este aviso de permissão devem ser incluidos em todas as cópias ou partes
 * substanciais do Software, obrigatoriamente;
 *
 * Os Nome(s) dos detentores de direitos autorais acima deverá não poder ser usado em publicidade ou de outra forma para promover
 * a venda, uso ou outras negociações em Este Software sem autorização prévia por escrito, do Líder do Projeto.
 *
 * O Intitulado Contribuidor do Projeto (Citado acima, no Copyright), é/são aquele/aqueles que fazem, ou, por sua vez,
 * fizeram parte da equipe oficial, sendo assim então ou um dia, aceitos pela equipe oficial do  Sthouch como, por sua vez,
 * Contribu�ntes e Desenvolvedores do mesmo. Qualquer outro usuário que, por sua vez, não seja/esteja dentro/participando da
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
 **/

import org.sthouch.SthouchServer;
import org.sthouch.api.events.Event;
import org.sthouch.api.plugin.Plugin;
import org.sthouch.exceptions.AlreadyRegisteredEventException;
import org.sthouch.exceptions.AlreadyRegisteredListenerException;
import org.sthouch.exceptions.CannotCallNotRegisteredEvent;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by JonathanScripter on 19/09/14.
 */
public class Listener {
    private final List<Class<? extends Event>> eventsList = new ArrayList<Class<? extends Event>>();

    private final HashMap<Plugin, MinecraftListener> listenersList = new HashMap<Plugin, MinecraftListener>();

    /**
     * Registra o listener de seu plugin
     * @param plugin Plugin
     * @param listener Classe do Listener
     */
    public void registerListener(Plugin plugin, MinecraftListener listener){
        if(!listenersList.containsKey(listener)){
            listenersList.put(plugin, listener);
        }else{
            try{
                throw new AlreadyRegisteredListenerException("Error on register listener "+listener.getClass().getName()+" from plugin "+plugin.getPluginName());
            }catch(Throwable e){
                SthouchServer.logger.exception(e);
                return;
            }

        }
    }

    public void registerEvent(Class<? extends Event> event){
        if(!eventsList.contains(event)){
            eventsList.add(event);
        }else{
            try{
                throw new AlreadyRegisteredEventException("Error on register event "+event.getName());
            }catch(Throwable e){
                SthouchServer.logger.exception(e);
                return;
            }
        }
    }

    public void callEvent(Event event){

        if(!eventsList.contains(event.getClass())){
            try{
                throw new CannotCallNotRegisteredEvent("Cannot call event "+event.getClass().getCanonicalName()+", are event registered?");
            }catch(Throwable e){
                SthouchServer.logger.exception(e);
                return;
            }
        }
        Method[] methods;

        for(Map.Entry<Plugin, MinecraftListener> l : listenersList.entrySet()){
            Object o = l.getValue();
            Object[] classes = o.getClass().getClasses();
            System.out.println(o.getClass().getCanonicalName());
            for (Method m : o.getClass().getMethods()) {
                if (m.getAnnotation(RegisteredEvent.class) != null) {
                    Class[] requiredTypes = m.getParameterTypes();
                    try{
                        if (requiredTypes[0].isAssignableFrom(event.getClass())){
                            try{
                                m.invoke(o, event);
                            }catch(Exception ex){}
                        }
                    }catch(Exception e1){

                    }
                }
            }
        }
    }

    private static final Listener defaultListener = new Listener();

    private static Listener getDefaultListener(){
        return defaultListener;
    }


}
u