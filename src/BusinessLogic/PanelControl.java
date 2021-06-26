/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import javax.swing.JPanel;

/**
 *
 * @author Erick Siguache
 */
public class PanelControl {
    private JPanel container;
    private JPanel content;
    public PanelControl(JPanel container,JPanel content){
        this.container=container;
        this.content=content;
        this.container.removeAll();
        this.container.revalidate();
        this.container.repaint();
        
        this.container.add(this.content);
        this.container.revalidate();
        this.container.repaint();
    }
    
}
