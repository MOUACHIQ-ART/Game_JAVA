import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class RenderEngine extends JPanel implements Engine{
    private ArrayList<Displayable> renderList;
    private int frames = 0;
    private int fps = 0;

    public RenderEngine(JFrame jFrame) {
        renderList = new ArrayList<>();
        new Timer(1000, e -> {
            fps = frames;
            frames = 0;  // Réinitialise le compteur de frames
        }).start();
    }

    public void addToRenderList(Displayable displayable){
        if (!renderList.contains(displayable)){
            renderList.add(displayable);
        }
    }

    public void addToRenderList(ArrayList<Displayable> displayable){
        if (!renderList.contains(displayable)){
            renderList.addAll(displayable);
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (Displayable renderObject:renderList) {
            renderObject.draw(g);
        }
        frames++;  // Incrémente le compteur de frames à chaque appel de paint

        // Affiche les FPS
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 16));
        g.drawString("FPS: " + fps, 10, 20); // Affichage du FPS en haut à gauche

    }

    @Override
    public void update(){
        this.repaint();
    }
}