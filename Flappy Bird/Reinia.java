import java.awt.*;
import javax.swing.*;
import javax.swing.Timer;

import java.awt.event.*;
import java.util.*;

class Reinia extends JFrame{
    Vector<Integer> aleatorio;
    Vector<Integer> altura;
    Rectangle rectangle3;

    Reinia(Vector<Integer> aleatorio, Vector<Integer> altura, Rectangle rectangle3){
        this.aleatorio = aleatorio;
        this.altura = altura;
        this.rectangle3 = rectangle3;

        for (int i = 0; i < altura.size(); i++) {
            altura.remove(i);
            aleatorio.remove(i);
          }

          rectangle3.add(150, 100);
          
    }

    

}