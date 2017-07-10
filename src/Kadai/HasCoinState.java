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
public class HasCoinState implements State{

    private static HasCoinState sigleton = new HasCoinState();
    private HasCoinState(){
    }
    
    public static State getInstance(){return sigleton;}
    @Override
    public void printState(Context context) {
        System.out.println("待機中....");
    }

    @Override
    public void doUse(Context context) {
        System.out.println("硬化が投入されました。");   
    }

    @Override
    public void change(Context context) {
        context.changeState(SoldState.getInstance());
    }
    @Override
    public String toString(){
        return"[投入]";
    }
    
}
