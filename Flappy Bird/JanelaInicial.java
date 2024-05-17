import javax.swing.*;

class JanelaInicial extends JDialog{
    Menu menu;
    JButton b1 = new JButton("Iniciar");
    JButton b2 = new JButton("Opções");

    JanelaInicial(Menu menu){
        this.menu = menu;

        getContentPane().add(b1);  
        setLocationRelativeTo(null);
        b1.setSize(100, 80);
        setSize(200, 150);
        setVisible(true);
       
       
    }

}