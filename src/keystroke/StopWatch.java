/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keystroke;

/**
 *
 * @author Gimhana
 */
public class StopWatch {
    long startTime=0;
    long stopTime=0;
    boolean running=false;
    
    public void start(){
        this.startTime=System.currentTimeMillis();
        this.running=true;
    }
    public void split(){
        this.stopTime=System.currentTimeMillis();        
    }
    public long getElapsedTimeinMilisec(){
        return stopTime-startTime;        
    }
    
}
