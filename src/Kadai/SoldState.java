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
public class SoldState implements State{
    private static SoldState sigleton = new SoldState();
    private int count;
    private SoldState(){
        count=3;
    }
    
    public static State getInstance(){return sigleton;}
    @Override
    public void printState(Context context) {
        System.out.println("待機中....");
    }

    @Override
    public void doUse(Context context) {
        if(count<=0){
            context.changeState(SoldOutState.getInstance());
        }else{
            count--;
            System.out.println("がチャを回します。残り"+count);
            
        }
    }

    @Override
    public void change(Context context) {
        context.changeState(NoCoinState.getInstance());
    }
    @Override
    public String toString(){
        return"[販売]";
    }
    public int getCount(){return this.count;}
}
