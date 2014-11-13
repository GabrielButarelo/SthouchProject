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
package org.sthouch.logger;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.sthouch.api.listeners.Listener;

import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * Created by JonathanScripter on 19/SET/2014 on 00:30
 */

@SuppressWarnings({})
public final class Logger {

    private static final String startLog = "[$DATE $TIME] [$LEVEL/#$THREAD]$STRING_NAME$LOG";
    private String name = null;
    private File file = null;
    private boolean fileIsOpen = false;

    public Logger(){

    }

    public Logger(String name){
        this.name = name;
    }

    public Logger(File file){
        this.file = file;
    }

    public Logger(String name, File file){
        this.name = name;
        this.file = file;
    }

    /**
     * <p>Imprimir informações</p>
     * @param level Nivel da informção
     * @param log Informção a ser logada
     */
    public void log(LogLevel level, Object log){
        String logString = startLog;

        /**
         * Parse Vars
         */
        GregorianCalendar calendar = new GregorianCalendar(new Locale("pt_BR"));
        SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");

        SimpleDateFormat time = new SimpleDateFormat("HH:mm:ss");

        logString = logString.replace("$DATE", date.format(calendar.getTime()));

        logString = logString.replace("$TIME", time.format(calendar.getTime()));

        logString = logString.replace("$LEVEL", level.toString());

        logString = logString.replace("$THREAD", String.valueOf(Thread.currentThread().getId()));

        logString = logString.replace("$STRING_NAME", ((this.name != null) ? " "+this.name+" " : " "));

        logString = logString.replace("$LOG", String.valueOf(log));

        /**
         * End parse
         */
        System.out.println(logString);
        try{
            if(!file.exists()){
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file, true);
            fw.write(logString);
        }catch(Exception e){

        }

    }

    /**
     * <p>Imprime uma informação</p>
     * @param info Informação a ser logada
     */
    public void info(Object info){
        this.log(LogLevel.INFO, info);
    }

    /**
     * <p>Imprime uma informação geral</p>
     * @param all Informação geral a ser logada
     */
    public void all(Object all){
        this.log(LogLevel.ALL, all);
    }

    /**
     * <p>Imprime uma informação fora de contexto</p>
     * @param off Informação fora de contexto a ser logada
     */
    @Deprecated
    public void off(Object off){
        this.log(LogLevel.OFF, off);
    }

    /**
     * <p>Imprime uma informação leve</p>
     * @param fine Informação leve a ser logada
     */
    public void fine(Object fine){
        this.log(LogLevel.FINE, fine);
    }

    /**
     * <p>Imprime uma informação +leve</p>
     * @param finer Informação +leve a ser logada
     */
    public void finer(Object finer){
        this.log(LogLevel.FINER, finer);
    }

    /**
     * <p>Imprime uma informação ++leve</p>
     * @param finest Informação ++leve a ser logada
     */
    public void finest(Object finest){
        this.log(LogLevel.FINEST, finest);
    }

    /**
     * <p>Imprime uma informação de configuração</p>
     * @param config Informação de configuração a ser logada
     */
    public void config(Object config){
        this.log(LogLevel.CONFIG, config);
    }

    /**
     * <p>Imprime uma informação de erro e/ou aviso severo</p>
     * @param severe Informação de erro e/ou aviso severo a ser logada
     */
    public void severe(Object severe){
        this.log(LogLevel.SEVERE, severe);
    }

    /**
     * <p>Imprime uma exceção</p>
     * @param exception Exceção
     */
    public void exception(Throwable exception){
        this.log(LogLevel.EXCPETION, ExceptionUtils.getFullStackTrace(exception));
    }

    /**
     * <p>Imprime uma informação de perigo</p>
     * @param warning informação de perigo a ser logada
     */
    public void warning(Object warning){
        this.log(LogLevel.WARNING, warning);
    }


}
