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
public class NoCoinState implements State{

    private static NoCoinState sigleton = new NoCoinState();
    private NoCoinState(){
    }
    
    public static State getInstance(){return sigleton;}
    @Override
    public void printState(Context context) {
        System.out.println("待機中....");
    }

    @Override
    public void doUse(Context context) {
        System.out.println("お金が入っていません....");
    }

    @Override
    public void change(Context context) {
        context.changeState(HasCoinState.getInstance());
    }
    @Override
    public String toString(){
        return"[未投入]";
    }
    
}
