import java.awt.*;
import javax.swing.*;
import javax.swing.Timer;

import java.awt.event.*;
import java.util.*;

class Cenario extends JButton{
    int posXobs;
    int posYobs = 500;
    int posXbird = 150;
    int posYbird = 100;
    int h, aux=0, qtd = 0, cont=0;
    Random random = new Random();
    //Obstaculo obs;
    Timer t;
    Rectangle rectangle1, rectangle2,rectangle3; 
    Vector<Integer> aleatorio = new Vector<Integer>();
    Vector<Integer> altura = new Vector<>();
    int verifica;
    int tam=410;
    Iterator e, hh;
    Cenario(){
     t = new Timer(70, new ActionListener() {
        public void actionPerformed(ActionEvent ae) {
                    decX();
                    incY();
                    qtd++;
                    if(qtd == 70){
                       qtd=0;
                        System.out.println("Criou");
                        h = random.nextInt(tam-9);
                        aleatorio.add(h);
                        altura.add(1000);
                        //dist+=100;
                        cont++;
                    }
                    
                }
            });
            
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
//-------------------bird--------------------
    g.setColor(new Color(255, 255, 0));
    g.fillRect(posXbird, posYbird, 30, 30);
    g.setColor(new Color(255, 255, 0));
    g.drawRect(posXbird, posYbird, 30, 30);

    g.setColor(new Color(0, 0, 0));
    g.fillRect(posXbird+20, posYbird+5, 4, 4);
    g.setColor(new Color(0,0,0));
    g.drawRect(posXbird+20, posYbird+5, 4, 4);
    rectangle3 = new Rectangle(posXbird, posYbird, 30, 30);
//-------------------obstaculo--------------------
         e = altura.iterator();
         hh = aleatorio.iterator();
        while(e.hasNext()){

           posXobs = (int) e.next();
            h = (int) hh.next();

        g.setColor(new Color(101, 67, 33));
        g.fillRect(posXobs, 0, 30, h);
        g.setColor(new Color(165, 113, 100));
        g.drawRect(posXobs, 0, 30, h);

        g.setColor(new Color(101, 67, 33));
        g.fillRect(posXobs, posYobs -tam  + h, 30, tam- h);
        g.setColor(new Color(165, 113, 100));
        g.drawRect(posXobs,posYobs - tam + h, 30, tam-h); 
        rectangle1 = new Rectangle (posXobs, 0, 30, h);
        rectangle2 = new Rectangle (posXobs,posYobs - tam + h, 30, tam-h);

        if(rectangle1.intersects(rectangle3) || rectangle2.intersects(rectangle3)){
           reinicia();
           //cont=0;
           repaint();
        };


        }
        }


        public void reinicia(){     
           
            for (int i = 0; i < altura.size(); i++) {
                altura.remove(i);
                aleatorio.remove(i);
            }
            
            cont = 0; 
            posXbird = 150;
            posYbird = 100;
            repaint(); 
        }





        //função de movimento
        public void incY() {
            posYbird+=5;
            repaint();
          } 

        public void decY() {
            posYbird-=20;
            repaint();
          } 

          public void decX() {
            int posicao = 0;
            Iterator e = altura.iterator();
            while(e.hasNext()){
                aux = (int)e.next() - 5;
                altura.set(posicao, aux);
                posicao++;
            }
            repaint();
          } 
    }
