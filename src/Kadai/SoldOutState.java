/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kadai;

/**
 *
 * @author c16311
 */
public class SoldOutState implements State{
    private static SoldOutState sigleton = new SoldOutState();
    private SoldOutState(){
    }
    
    public static State getInstance(){return sigleton;}
    @Override
    public void printState(Context context) {
        System.out.println("待機中....");
    }

    @Override
    public void doUse(Context context) {
        System.out.println("もうありません。");
    }

    @Override
    public void change(Context context) {
        context.changeState(NoCoinState.getInstance());
    }
    @Override
    public String toString(){
        return"[売切]";
    }
    
}
