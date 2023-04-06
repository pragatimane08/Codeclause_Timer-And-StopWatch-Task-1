import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Stopwatch implements ActionListener{

    JFrame frame = new JFrame();
    JButton starButton = new JButton("START");
    JButton recetButton = new JButton("RESET");
    JLabel timeLable = new JLabel();
    int elapsedTime = 0;
    int seconds =0;
    int minutes =0;
    int hours = 0;
    boolean started = false;
    String seconds_String = String.format("%02d", seconds);
    String minutes_String = String.format("%02d", minutes);
    String hours_String = String.format("%02d", hours);

    Timer timer = new Timer(1000, new ActionListener() {

        public  void actionPerformed(ActionEvent e){
            
            elapsedTime = elapsedTime + 1000;
            hours = (elapsedTime/3600000);
            minutes = (elapsedTime/60000) % 60;
            seconds = (elapsedTime/1000) % 60;
            seconds_String = String.format("%02d", seconds);
            minutes_String = String.format("%02d", minutes);
            hours_String = String.format("%02d", hours);
            timeLable.setText(hours_String+":"+minutes_String+":"+seconds_String);
        }
    });

    Stopwatch(){
      
        timeLable.setText(hours_String+":"+minutes+":"+seconds_String);
        timeLable.setBounds(100,100,200,100);
        timeLable.setFont(new Font("Verdana",Font.PLAIN,35));
        timeLable.setBorder(BorderFactory.createBevelBorder(1));
        timeLable.setOpaque(true);
        timeLable.setHorizontalAlignment(JTextField.CENTER);

        starButton.setBounds(100,200,100,50);
        starButton.setFont(new Font("Ink Free",Font.PLAIN,20));
        starButton.setFocusable(false);
        starButton.addActionListener(this);

        recetButton.setBounds(200,200,100,50);
        recetButton.setFont(new Font("Ink Free",Font.PLAIN,20));
        recetButton.setFocusable(false);
        recetButton.addActionListener(this);

        frame.add(starButton);
        frame.add(recetButton);
        frame.add(timeLable);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.setLayout(null);
        frame.setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== starButton){
            if(started==false){
                started=true;
                starButton.setText("STOP");
                start();
            }
            else{
                started=false;
                starButton.setText("START");
                stop();
            }
        }
        if(e.getSource()==recetButton){
               started=false;
               starButton.setText("START");
               recet();
        }
    }
    
   void start(){
    timer.start();
   }

   void stop(){
     timer.stop();
   }

   void recet(){
      timer.stop();
      elapsedTime=0;
      seconds=0;
      minutes=0;
      hours=0;
      seconds_String = String.format("%02d", seconds);
      minutes_String = String.format("%02d", minutes);
      hours_String = String.format("%02d", hours);
      timeLable.setText(hours_String+":"+minutes_String+":"+seconds_String);
   }
}
