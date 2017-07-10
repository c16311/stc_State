
package Kadai;

/**
 *
 * @author c16311
 */
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 *
 * @author c16311
 */
public class SafeMachine extends JFrame implements ActionListener,Context{

    private TextField textClock = new TextField(60);
    private TextArea textScreen = new TextArea(10,60);
    //private Button NoCoinUse = new Button("未投入");
    private Button CoinUse = new Button("100円投入");
    private Button Sold = new Button("ガチャ");
    //private Button SoldOut = new Button("売切");
    private Button buttonExit = new Button("終了");
    
    private State state = NoCoinState.getInstance();
    
    public SafeMachine(String title){
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    //画面左上のボタンが使用できるようになる。
        
        this.setBackground(Color.GRAY);
        this.setLayout(new BorderLayout());
        this.add(textClock,BorderLayout.NORTH);
        this.textClock.setEditable(false);
        this.add(textScreen,BorderLayout.CENTER);
        this.textScreen.setEditable(false);
        
        //パネルにボタンを配置
        Panel panel = new Panel();
        //panel.add(NoCoinUse);
        panel.add(CoinUse);
        panel.add(Sold);
        //panel.add(SoldOut);
        panel.add(buttonExit);
        add(panel,BorderLayout.SOUTH);   
        //表示
        this.pack();
        this.setVisible(true);
        //リスナーの設定
        //NoCoinUse.addActionListener(this);
        CoinUse.addActionListener(this);
        Sold.addActionListener(this);
        //SoldOut.addActionListener(this);
        buttonExit.addActionListener(this);
        
        state.printState(this);
        this.Sold.setEnabled(false);
    }

    @Override
    public void changeState(State state) {
        System.out.println(this.state + "から" + state +"へ状態が変化しました。");
        textScreen.append(this.state + "から" + state +"へ状態が変化しました。\n");
        this.state = state;
    }
    
    @Override
    public void printState() {
        textScreen.append("現在の状態" + this.state + "\n");
    }

    @Override
    public void actionPerformed(ActionEvent e){
        System.out.println(e.toString());
        if(e.getSource() == CoinUse){
            state.change(this);
            this.Sold.setEnabled(true);
            state.doUse(this);
            state.change(this);
        }else if(e.getSource() == Sold){
            state.doUse(this);
            state.change(this);
            this.Sold.setEnabled(false);
        }else if(e.getSource() == buttonExit){
            System.exit(0);
        }else{
            System.out.println("?");
        }
    }
}
