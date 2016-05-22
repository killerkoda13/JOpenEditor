package me.killerkoda13.JOpenEditor.Modules;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;

/***
 *		---------------------------------
 *		@Author Killerkoda13 (Alex Jones)
 *		@date Apr 11, 2016
 *		---------------------------------
 */
public class JTabbedPaneCloseButton extends JTabbedPane{
	
	
	public JTabbedPaneCloseButton(int tabPlacement)
	{
		this.setTabPlacement(tabPlacement);
	}
	
	 @Override
	    public void addTab(String title, Icon icon, Component component, String tip) {
	        super.addTab(title, icon, component, tip);
	        int count = this.getTabCount() - 1;
	        setTabComponentAt(count, new CloseButtonTab(component, title, icon));
	    }

	    @Override
	    public void addTab(String title, Icon icon, Component component) {
	        addTab(title, icon, component, null);
	    }

	    @Override
	    public void addTab(String title, Component component) {
	        addTab(title, null, component);
	    }

	    /* addTabNoExit */
	    public void addTabNoExit(String title, Icon icon, Component component, String tip) {
	        super.addTab(title, icon, component, tip);
	    }

	    public void addTabNoExit(String title, Icon icon, Component component) {
	        addTabNoExit(title, icon, component, null);
	    }

	    public void addTabNoExit(String title, Component component) {
	        addTabNoExit(title, null, component);
	    }

	    /* Button */
	    public class CloseButtonTab extends JPanel {
	        private Component tab;

	        public CloseButtonTab(final Component tab, String title, Icon icon) {
	            this.tab = tab;
	            setOpaque(false);
	            FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER, 3, 3);
	            setLayout(flowLayout);
	            JLabel jLabel = new JLabel(title);
	            jLabel.setIcon(icon);
                Component add = add(jLabel);
                URL imageurl = getClass().getResource("/me/killerkoda13/JOpenEditor/Assets/closeiconshade2.png");
                JButton button = new JButton(new ImageIcon(Toolkit.getDefaultToolkit().getImage(imageurl)));
                button.setMargin(new Insets(0, 0, 0, 0));
                button.addMouseListener(new CloseListener(tab));
                add(button);
            }
	    }
	    /* ClickListener */
	    public class CloseListener implements MouseListener
	    {
	        private Component tab;

	        public CloseListener(Component tab){
	            this.tab=tab;
	        }

	        @Override
	        public void mouseClicked(MouseEvent e) {
	            if(e.getSource() instanceof JButton){
	                JButton clickedButton = (JButton) e.getSource();
	                JTabbedPane tabbedPane = (JTabbedPane) clickedButton.getParent().getParent().getParent().getParent().getParent();
	                tabbedPane.remove(tab);
	            }
	        }

	        @Override
	        public void mousePressed(MouseEvent e) {}

	        @Override
	        public void mouseReleased(MouseEvent e) {}

	        @Override
	        public void mouseEntered(MouseEvent e) {
	            if(e.getSource() instanceof JButton){
	                JButton clickedButton = (JButton) e.getSource();
	             //   clickedButton.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY,3));
	            }
	        }

	        @Override
	        public void mouseExited(MouseEvent e) {
	            if(e.getSource() instanceof JButton){
	                JButton clickedButton = (JButton) e.getSource();
	             //   clickedButton.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY,3));
	            }
	        }
	    }
	}


