package Game.GameStates;


import Main.Handler;
import Resources.Images;
import UI.ClickListlener;
import UI.UIImageButton;
import UI.UIManager;

import java.awt.*;

/**
 * Created by AlexVR on 7/1/2018.
 */
public class Game_Over_State extends State {

    private UIManager uiManager;

    public Game_Over_State(Handler handler) {
        super(handler);
        uiManager = new UIManager(handler);
        handler.getMouseManager().setUimanager(uiManager);

        
        uiManager.addObjects(new UIImageButton(handler.getWidth()/2-64, handler.getHeight()/2+170, 128, 64, Images.BTitle, new ClickListlener() {
            @Override
            public void onClick() {
                handler.getMouseManager().setUimanager(null);
                handler.getGame().reStart();
                State.setState(handler.getGame().menuState);
            }
        }));
    }

    @Override
    public void tick() {
        handler.getMouseManager().setUimanager(uiManager);
        uiManager.tick();

    }

    @Override
    public void render(Graphics g) {
    	
        g.setColor(Color.darkGray);
        g.fillRect(0,0,handler.getWidth(),handler.getHeight());
        g.drawImage(Images.GameOver,0,0,handler.getWidth(),handler.getHeight(),null);
        g.drawOval(handler.getWidth()/2-69, handler.getHeight()/2+170, 128, 64);//background del title butt
        g.setColor(Color.RED);
        g.fillOval(handler.getWidth()/2-69, handler.getHeight()/2+170, 128, 64);
        

        uiManager.Render(g);
        

    }


}
