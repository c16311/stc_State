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
public interface Context {
    public abstract void changeState(State state);      //金庫使用
    public abstract void printState();                  //現在の状態
}
