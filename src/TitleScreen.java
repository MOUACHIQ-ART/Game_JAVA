//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.border.AbstractBorder;

public class TitleScreen {
    private JFrame frame = new JFrame("Ecran Titre");
    private JLabel titleLabel;
    private JButton startButton;
    private boolean soundPlayed = false;

    public TitleScreen(Runnable onStartGame) {
        this.frame.setSize(645, 360);
        this.frame.setDefaultCloseOperation(3);
        this.frame.setLocationRelativeTo((Component)null);
        JLayeredPane layeredPane = new JLayeredPane();
        this.frame.setContentPane(layeredPane);
        layeredPane.setLayout((LayoutManager)null);
        ImageIcon background = new ImageIcon("./img/start.jpg");
        JLabel backgroundLabel = new JLabel(background);
        backgroundLabel.setBounds(0, 0, this.frame.getWidth(), this.frame.getHeight());
        layeredPane.add(backgroundLabel, 0);
        this.titleLabel = new JLabel("Dungeon Crawler", 0);
        this.titleLabel.setFont(new Font("Arial", 1, 32));
        this.titleLabel.setForeground(new Color(0, 102, 204));
        int titleWidth = this.titleLabel.getPreferredSize().width;
        int titleHeight = this.titleLabel.getPreferredSize().height;
        int titleX = (this.frame.getWidth() - titleWidth) / 2;
        int titleY = (this.frame.getHeight() - titleHeight) / 2;
        this.titleLabel.setBounds(titleX, titleY, titleWidth, titleHeight);
        layeredPane.add(this.titleLabel, 1);
        this.startButton = new JButton("Commencer");
        this.startButton.setFont(new Font("Arial", 0, 24));
        this.startButton.setBackground(new Color(0, 102, 204));
        this.startButton.setForeground(Color.BLACK);
        this.startButton.setBorder(BorderFactory.createEmptyBorder());
        this.startButton.setFocusPainted(false);
        this.startButton.setContentAreaFilled(false);
        this.startButton.setOpaque(true);
        this.startButton.setPreferredSize(new Dimension(200, 50));
        this.startButton.setBounds(this.frame.getWidth() / 2 - 100, this.frame.getHeight() - 100, 200, 50);
        if (!this.soundPlayed) {
            SoundPlayer.playSound("./resources/music.wav");
            this.soundPlayed = true;
        }

        this.startButton.addActionListener((e) -> {
            this.frame.dispose();
            //SoundPlayer.stopSound();
            onStartGame.run();
        });
        this.startButton.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                TitleScreen.this.startButton.setBackground(new Color(0, 128, 255));
            }

            public void mouseExited(MouseEvent evt) {
                TitleScreen.this.startButton.setBackground(new Color(0, 102, 204));
            }
        });
        layeredPane.add(this.startButton, 2);
        this.frame.setVisible(true);
    }

    class RoundedBorder extends AbstractBorder {
        private int radius;

        public RoundedBorder(int radius) {
            this.radius = radius;
        }

        public Insets getBorderInsets(Component c) {
            return new Insets(this.radius, this.radius, this.radius, this.radius);
        }

        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            g.setColor(new Color(255, 215, 0));
            g.fillRoundRect(x, y, width - 1, height - 1, this.radius, this.radius);
        }
    }
}
