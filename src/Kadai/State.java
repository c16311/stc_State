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
public interface State {
    public abstract void printState(Context context);      //現在の状態
    public abstract void doUse(Context context);           //使用
    public abstract void change(Context context);
}
