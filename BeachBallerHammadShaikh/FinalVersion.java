// The "FinalVersion" class.
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import hsa.Console;
import java.util.Random;

public class FinalVersion extends Applet implements MouseListener, MouseMotionListener, KeyListener, Runnable
{
    // Place instance variables here
    // Initialization of variables

    // declare two instance variables at the head of the program
    private Image dbImage;
    private Graphics dbg;

    //Declaring all images before use
    Image img;
    MediaTracker tr;
    private final String bgPath = "bg.png";
    Image background;
    int picWidth, picHeight;

    private final String spritePath = "beachball.gif";
    Image beachball;
    int picWidth2, picHeight2;

    private final String spikePath = "spikes.png";
    Image spikes;
    int picWidth3, picHeight3;

    private final String platformPath = "plat.png";
    Image platformPic;
    int picWidth4, picHeight4;

    private final String titlePath = "title.png";
    Image title;

    private final String playButton = "play.png";
    Image play;

    private final String howtoButton = "howto.png";
    Image howTo;

    private final String spacePath = "SPACE.png";
    Image space;

    private final String rightPath = "RIGHT.png";
    Image right;

    private final String leftPath = "LEFT.png";
    Image left;

    private final String instr2 = "jumpbounce.png";
    Image jumpbounce;

    private final String instr3 = "speedup.png";
    Image speedup;

    private final String instr4 = "slowdown.png";
    Image slowdown;

    private final String instr5 = "instructions.png";
    Image instructions;

    private final String backButton = "back.png";
    Image back;

    private final String chairPath = "chair.png";
    Image chair;

    private final String scorePath = "score.png";
    Image scorePic;

    private final String exitButton = "exit.png";
    Image exit;

    private final String livesPath = "lives.png";
    Image livesPic;

    private final String coinPath = "coin.gif";
    Image coinPic;

    private final String creditsButton = "credits.png";
    Image creditsPic;

    private final String seagullPath = "seagull2.gif";
    Image seagullPic;


    //applet size
    int appletsize_x = 1024;
    int appletsize_y = 600;

    //position of ball
    int x_pos = 0;         // x - Position of ball
    int y_pos = 500;        // y - Position of ball

    int radius = 0;        // Radius of ball

    int x_speed = 0;       //Speed of ball

    //condition to jump
    boolean jump = false;

    //declaring ints before use
    int seagullx = 512;
    int seagully = 70;
    double seagullspeed = 1;
    int plat1; //platform positions (x,y)
    int plat2; //platform positions (x,y)
    int plat3; //platform positions (x,y)
    int plat4; //platform positions (x,y)
    int plat5; //platform positions (x,y)
    int plat6; //platform positions (x,y)
    int plat7; //platform positions (x,y)
    int plat8; //platform positions (x,y)
    int sp1;   //spike positions
    int sp2;   //spike positions
    int sp3;   //spike positions
    int score;  //score counter
    int lives = 3;  //live counter
    int diff;
    int diff2;
    int adjust;
    int adjust2;
    // int xwait;

    int diff3; //spawning bug fixes
    int diff4; //spawning bug fixes
    int adjust3; //spawning bug fixes
    int adjust4; //spawning bug fixes
    int spikediff; //spawning bug fixes
    int spikeadjust; //spawning bug fixes

    int coinx; //coin positions
    int coinx2; //coin positions
    int coinx3; //coin positions
    int coiny; //coin positions
    int coiny2; //coin positions
    int coiny3; //coin positions

    // int jumpcount = 0;

    //declaring booleans before use
    boolean spawn = true;
    Random gen1 = new Random (); //random gen
    boolean menu = true;   //menu boolean
    boolean howto = false;  //how to boolean
    // boolean jumpwait = true;
    boolean touchground = true; //boolean for jump bugfix
    boolean coin1image = true; //make coin appear
    boolean coin2image = true; //make coin appear
    boolean coin3image = true; //make coin appear
    boolean tryagain = false; //Try again message
    boolean credits = false;  //credits boolean

    //creating/importing fonts
    Font score2 = new Font ("Rockwell Extra Bold", 0, 40);
    Font name = new Font ("Rockwell Extra Bold", 0, 20);
    Font creditsfont = new Font ("Rockwell Extra Bold", 0, 25);

    //creating audio clip objects
    AudioClip bgmusic; // background music
    AudioClip coinsound; //collecting coin sound
    AudioClip spikesound; //sound for hitting spikes
    AudioClip gameover;  //sound when game ends

    public void init ()
    {
	// Place the body of the initialization method here
	resize (1024, 600);

	// Initializing all images
	background = getToolkit ().getImage (bgPath);
	prepareImage (background, this);
	// Add the background to the list of images to be tracked
	MediaTracker tracker = new MediaTracker (this);
	tracker.addImage (background, 0);

	beachball = getToolkit ().getImage (spritePath);
	prepareImage (beachball, this);
	// Add the background to the list of images to be tracked
	MediaTracker tracker2 = new MediaTracker (this);
	tracker2.addImage (beachball, 0);

	spikes = getToolkit ().getImage (spikePath);
	prepareImage (spikes, this);
	// Add the background to the list of images to be tracked
	MediaTracker tracker3 = new MediaTracker (this);
	tracker3.addImage (spikes, 0);

	platformPic = getToolkit ().getImage (platformPath);
	prepareImage (platformPic, this);
	// Add the background to the list of images to be tracked
	MediaTracker tracker4 = new MediaTracker (this);
	tracker4.addImage (platformPic, 0);

	title = getToolkit ().getImage (titlePath);
	prepareImage (title, this);

	play = getToolkit ().getImage (playButton);
	prepareImage (play, this);

	howTo = getToolkit ().getImage (howtoButton);
	prepareImage (howTo, this);

	space = getToolkit ().getImage (spacePath);
	prepareImage (space, this);

	right = getToolkit ().getImage (rightPath);
	prepareImage (right, this);

	left = getToolkit ().getImage (leftPath);
	prepareImage (left, this);

	jumpbounce = getToolkit ().getImage (instr2);
	prepareImage (jumpbounce, this);

	speedup = getToolkit ().getImage (instr3);
	prepareImage (speedup, this);

	slowdown = getToolkit ().getImage (instr4);
	prepareImage (slowdown, this);

	instructions = getToolkit ().getImage (instr5);
	prepareImage (instructions, this);

	back = getToolkit ().getImage (backButton);
	prepareImage (back, this);

	chair = getToolkit ().getImage (chairPath);
	prepareImage (chair, this);

	scorePic = getToolkit ().getImage (scorePath);
	prepareImage (scorePic, this);

	exit = getToolkit ().getImage (exitButton);
	prepareImage (exit, this);

	livesPic = getToolkit ().getImage (livesPath);
	prepareImage (livesPic, this);

	coinPic = getToolkit ().getImage (coinPath);
	prepareImage (coinPic, this);

	creditsPic = getToolkit ().getImage (creditsButton);
	prepareImage (creditsPic, this);

	seagullPic = getToolkit ().getImage (seagullPath);
	prepareImage (seagullPic, this);

	//Takes away need to drag screen at beginning
	requestFocus ();

	//Initialize Mouse controls
	addMouseListener (this);
	addMouseMotionListener (this);
	addKeyListener (this);

	//Importing font
	Font score = new Font ("Impact", 0, 55);

	//Initializing Music/ sound effects
	bgmusic = getAudioClip (getDocumentBase (), "gamemusic.wav");
	bgmusic.loop (); //Playing music
	coinsound = getAudioClip (getDocumentBase (), "coinsound.wav");
	spikesound = getAudioClip (getDocumentBase (), "spikesound.wav");
	gameover = getAudioClip (getDocumentBase (), "gameover.wav");


    } // init method


    public void start ()
    {

	// define a new thread
	Thread th = new Thread (this);
	// start this thread
	th.start ();

    }


    public void stop ()
    {
	//nothing right now
    }


    public void destroy ()
    {
	//nothing right now
    }


    public void run ()

    {

	// lower ThreadPriority
	Thread.currentThread ().setPriority (Thread.MIN_PRIORITY);

	// run a long while (true) this means in our case "always"
	while (true)
	{
	    while (menu)
	    {
		x_speed = 0;   //making sure the ball doesn't move at menu
		x_pos = 0;
		y_pos = 510;
		// seagullx = seagullx + (-1);     //was going to add seagull
		// if (seagullx > appletsize_x)
		// {
		//     seagullx = 512;
		//
		// }

	    }
	    while (!menu)
	    {
		//Making sure RandomInts stay constant during a level,
		//using spawn boolean which is turned back on once user
		//reaches end of screen
		if (spawn)
		{
		    plat1 = gen1.nextInt (21) + 160;   //Platform will spawn in portion 1 of screen
		    plat2 = gen1.nextInt (200) + 200;
		    plat3 = gen1.nextInt (341) + 341;  //Platform will spawn in portion 2 of screen
		    plat4 = gen1.nextInt (200) + 200;
		    plat5 = gen1.nextInt (682) + 181;  //Platform will spawn in portion 3 of screen
		    plat6 = gen1.nextInt (200) + 200;
		    // plat7 = gen1.nextInt (704) + 160;   //Took out 4th platform was too crowded
		    // plat8 = gen1.nextInt (200) + 200;
		    sp1 = gen1.nextInt (192) + 160;
		    sp2 = gen1.nextInt (512) + 352;
		    // sp3 = gen1.nextInt (704) + 160;   //Took out 3rd spike it was too difficult
		    spawn = false;
		}
		// Configuring coin coordinates based on platform positions
		coinx = plat1 + 65;  //Want coins to spawn above platforms, not in the middle
		coiny = plat2 - 30;

		coinx2 = plat3 + 65;
		coiny2 = plat4 - 30;

		coinx3 = plat5 + 65;
		coiny3 = plat6 - 30;

		// Work-around I created to stop platforms from spawning too
		//close together
		diff = plat3 - plat1;  //finding difference between platform x positions
		adjust = 160 - diff;
		diff2 = plat5 - plat3;
		adjust2 = 160 - diff2;  //adding adjust variable to x will space them out

		if (diff < 160)
		    plat3 = plat3 + adjust + 20;   // if too close together, push them apart
		if (diff2 < 160)
		    plat5 = plat5 + adjust2 + 20;

		// Work-around I created to stop spikes from spawning too
		//close together
		diff3 = sp2 - sp1;     //Identical work-around to platforms for spikes
		adjust3 = 160 - diff3;

		spikediff = sp2 - (sp1 + 160);
		spikeadjust = 80 - spikediff;

		if (spikediff < 80)
		    sp2 = sp2 + spikediff + spikeadjust;

		if (diff3 < 160)
		    sp2 = sp2 + adjust3 + 70;

		//Creating hitboxes using Rectangle objects
		Rectangle sprite = new Rectangle (x_pos, y_pos, 60, 60); //hitbox for the ball
		Rectangle platform = new Rectangle (plat1, plat2, 160, 33); //hitboxes for the platforms
		Rectangle platform2 = new Rectangle (plat3, plat4, 160, 33);
		Rectangle platform3 = new Rectangle (plat5, plat6, 160, 33);
		// Rectangle platform4 = new Rectangle (plat7, plat8, 160, 33);
		Rectangle spike1 = new Rectangle (sp1, 540, 160, 33); //hitboxes for spikes
		Rectangle spike2 = new Rectangle (sp2, 540, 160, 33);

		//Hitboxes for coins
		Rectangle coin1 = new Rectangle (coinx, coiny, 30, 30);  //hitboxes for coins
		Rectangle coin2 = new Rectangle (coinx2, coiny2, 30, 30);
		Rectangle coin3 = new Rectangle (coinx3, coiny3, 30, 30);

		//Implementing new hitboxes using .intersects() method
		//Push ball aboves platforms when they intersect
		if (sprite.intersects (platform))
		{
		    y_pos = plat2 - 60;
		}
		if (sprite.intersects (platform2))
		{
		    y_pos = plat4 - 60;
		}
		if (sprite.intersects (platform3))
		{
		    y_pos = plat6 - 60;
		}

		//This boolean used to turn off coin image when collected
		//by user (multiple instances)
		//What happens when user hits coins
		if (coin1image) //Only want coin to be collected when image is true
		{

		    if (sprite.intersects (coin1))
		    {
			score++;            //when user hits coin
			coin1image = false; //make score go up
			coinsound.play ();  //play coin sound
		    }
		}
		if (coin2image) //Only want coin to be collected when image is true
		{
		    if (sprite.intersects (coin2))
		    {
			score++;             //when user hits coin
			coin2image = false;   //make score go up
			coinsound.play ();    //play coin sound
		    }
		}
		if (coin3image) //Only want coin to be collected when image is true
		{
		    if (sprite.intersects (coin3))
		    {
			score++;             //when user hits coin
			coin3image = false;    //make score go up
			coinsound.play ();    //play coin sound
		    }
		}

		//If user hits spikes
		if (sprite.intersects (spike1))
		{
		    x_pos = 0;     //reset position
		    x_speed = 0;   //make user stationary
		    lives -= 1;     //subtract a life
		    if (lives > 0)
			spikesound.play ();

		}
		if (sprite.intersects (spike2))
		{
		    x_pos = 0;
		    x_speed = 0;
		    lives -= 1;
		    if (lives > 0)
			spikesound.play ();
		}

		//resetting all values and images after user dies
		//and goes to main menu
		if (lives == 0)
		{
		    x_pos = 0;
		    y_pos = 0;
		    score = 0;
		    lives = 3;
		    coin1image = true;  //Want coins to respawn
		    coin2image = true;
		    coin3image = true;
		    spawn = true;
		    tryagain = true;  //tryagain message
		    menu = true;
		    gameover.play ();
		}
		if (x_pos > 500)
		    tryagain = false;

		//Boolean used to display and turn off TRY AGAIN message
		//when user dies
		if (x_pos > 512)
		    tryagain = false;

		//If user reaches end of screen reset images
		if (x_pos > appletsize_x - radius)
		{
		    x_pos = 0;
		    spawn = true;
		    coin1image = true;
		    coin2image = true;
		    coin3image = true;

		}

		// while (y_pos <= 500)
		//     touchground = false;

		//Jumping
		x_pos += x_speed;
		if (jump) //Jump made true from space bar
		{
		    if (y_pos >= 50)
			y_pos = y_pos - 15; //if less than ceiling, push up to ceiling
		    if (y_pos <= 50)
			jump = false;  //once ceiling is hit turn jump off
		}

		// if (y_pos <= 50)
		// {
		//     jump = false;
		// }

		//Gravity/Falling
		if (y_pos <= 500 && !jump)
		{
		    y_pos = y_pos + 10; //push ball down until back at ground level
		}

		repaint ();

		try
		{
		    // Stop thread for 20 milliseconds
		    Thread.sleep (20);
		}
		catch (InterruptedException ex)
		{
		    // do nothing
		}

		// set ThreadPriority to maximum value
		Thread.currentThread ().setPriority (Thread.MAX_PRIORITY);
	    }
	}

    }


    /** Update - Method, implements double buffering */
    public void update (Graphics g)
    {

	// initialize buffer
	if (dbImage == null)
	{
	    dbImage = createImage (this.getSize ().width, this.getSize ().height);
	    dbg = dbImage.getGraphics ();
	}

	// clear screen in background
	dbg.setColor (getBackground ());
	dbg.fillRect (0, 0, this.getSize ().width, this.getSize ().height);

	// draw elements in background
	dbg.setColor (getForeground ());
	paint (dbg);

	// draw image on the screen
	g.drawImage (dbImage, 0, 0, this);

    }


    public void mouseEntered (MouseEvent e)
    {
	//does nothing
    }


    public void mouseExited (MouseEvent e)
    {
	//does nothing
    }


    /*
	The mouseClicked method is activated whenever the mouse is clicked
    */
    public void mouseClicked (MouseEvent e)
    {
	int x = e.getX ();
	int y = e.getY ();
	repaint ();
	e.consume ();
	//If at menu screen
	if (menu)
	{
	    //Play button disables menu and starts game
	    if (x >= 436 && x <= 587 && y >= 325 && y <= 366)
	    {
		menu = false;
		tryagain = false; //get rid of tryagain message
		spawn = true;
		boolean coin1image = true; //make coin appear
		boolean coin2image = true; //make coin appear
		boolean coin3image = true; //make coin appear
	    }
	}
	if (menu)
	{
	    //How To button clicked
	    if (x >= 398 && x <= 627 && y >= 410 && y <= 451)
	    {
		howto = true;
		tryagain = false; //get rid of tryagain message
	    }
	}

	if (menu)
	{
	    //Exit game at menu screen
	    if (x >= 475 && x <= 575 && y >= 490 && y <= 590)
	    {
		System.exit (0);
	    }
	}

	if (menu)
	{
	    //If credits button clicked
	    if (x >= 0 && x <= 257 && y >= 0 && y <= 41)
	    {
		credits = true;
		tryagain = false; //get rid of tryagain message
	    }
	}
	//If back button is clicked (reset score and lives)
	if (x >= 863 && x <= 1024 && y >= 20 && y <= 61)
	{
	    howto = false;
	    credits = false;
	    menu = true;
	    score = 0;
	    lives = 3;
	    tryagain = false; //get rid of tryagain message
	    boolean coin1image = true; //make coin appear
	    boolean coin2image = true; //make coin appear
	    boolean coin3image = true; //make coin appear
	    spawn = true;
	}

    }


    /*
    The mousePressed method detects when the mouse button is pressed and coresponds them to different actions
	@param MouseEvent e - Recieves the location of the mouse in relation to the applet screen
    */

    public void mousePressed (MouseEvent e)
    {

    }


    /*
	The mouseReleased method is activated whenever the mouse is released after being pressed
    */
    public void mouseReleased (MouseEvent e)
    {

    }


    /*
       The mouseMoved method is activated whenever the mouse moves
    */
    public void mouseMoved (MouseEvent e)
    { // called during motion when no buttons are down
	repaint ();
	e.consume ();
    }


    /*
	The mouseDragged method is activated whenever the mouse is dragged
    */
    public void mouseDragged (MouseEvent e)
    { // called during motion with buttons down
	repaint ();
	e.consume ();
    }


    public void keyTyped (KeyEvent e)
    {
	// does nothing
    }


    /*keyPressed detects for specific keys pressed by the user and corresponds them to different actions
	@param KeyEvent e recieves the ASCII code value for the key character pressed by the user
    */
    public void keyPressed (KeyEvent e)
    {
	repaint ();
	//Variable to store the ASCII code values
	int key = e.getKeyCode ();

	//Button used to turn jump on
	if (key == KeyEvent.VK_SPACE)
	{
	    jump = true;
	    // jumpcount++;
	}

	//Right arrow key/ Speed up
	if (key == KeyEvent.VK_RIGHT)
	{
	    x_speed = 7;
	}

	//Left arrow key/ slow down
	if (key == KeyEvent.VK_LEFT)
	{
	    x_speed = 3;
	}
	// else
	// {
	//     /* Additionally the method prints out the ASCII - value if an other key is pressed. This is not necessary but a possibility for you to test which value a key has.*/
	//     System.out.println ("Character: " + (char) key + " Integer Value: " + key);
	// }

    }


    public void keyReleased (KeyEvent e)
    {
	//does nothing
    }


    /*updates screen to allow paint method to draw new graphics
	*@param Graphics g is the graphics console used for drawing images and text
    */





    // DON'T FORGET (although it has no meaning here)





    public void paint (Graphics g)
    {
	// Place the body of the drawing method here

	//Draw background
	g.drawImage (background, 0, 0, null);
	g.setColor (Color.black);
	//change font
	g.setFont (score2);

	//Draw sprite for user
	g.drawImage (beachball, x_pos, y_pos, null);

	//Drawing platforms
	g.drawImage (platformPic, plat1, plat2, null);
	g.drawImage (platformPic, plat3, plat4, null);
	g.drawImage (platformPic, plat5, plat6, null);

	//Drawing spikes
	g.drawImage (spikes, sp1, 540, null);
	g.drawImage (spikes, sp2, 540, null);

	//Draw back button
	g.drawImage (back, 863, 20, null);

	//Draw SCORE
	g.drawImage (scorePic, 0, 20, null);

	//Draw SCORE value
	g.drawString (": " + score, 212, 53);

	//Draw LIVES
	g.drawImage (livesPic, 400, 20, null);

	//Draw LIVES value
	g.drawString (": " + lives, 585, 53);

	//Draw coins if their respective boolean is true
	if (coin1image)
	    g.drawImage (coinPic, coinx, coiny, null);
	if (coin2image)
	    g.drawImage (coinPic, coinx2, coiny2, null);
	if (coin3image)
	    g.drawImage (coinPic, coinx3, coiny3, null);

	if (lives == 3 && x_pos < 100 && score == 0)
	{
	    g.drawString ("Press Right to start!", 280, 150);
	}

	//Menu screen Graphics
	if (menu)
	{
	    //Background
	    g.drawImage (background, 0, 0, null);
	    //Display name
	    g.setFont (name);
	    g.drawString ("© Hammad Shaikh", 790, 20);
	    //Title
	    g.drawImage (title, 64, 200, null);
	    //Play button
	    g.drawImage (play, 436, 325, null);
	    //How To button
	    g.drawImage (howTo, 398, 410, null);
	    //Draw sprite in bottom left corner
	    g.drawImage (beachball, x_pos, y_pos, null);
	    //Draw beach chair
	    g.drawImage (chair, 768, 350, null);
	    //Draw Exit button
	    g.drawImage (exit, 475, 490, null);
	    //Draw credits button
	    g.drawImage (creditsPic, 0, 0, null);
	    g.drawImage (seagullPic, seagullx, 70, null);

	}

	// How To screen
	if (howto)
	{
	    //background
	    //Drawing images for user controls
	    //Instructions
	    g.drawImage (background, 0, 0, null);
	    g.drawImage (space, 225, 195, null);
	    g.drawImage (jumpbounce, 425, 200, null);
	    g.drawImage (right, 225, 270, null);
	    g.drawImage (speedup, 425, 275, null);
	    g.drawImage (left, 225, 350, null);
	    g.drawImage (slowdown, 425, 355, null);
	    //Instructions image
	    g.drawImage (instructions, 332, 440, null);
	    g.drawImage (back, 863, 20, null);
	    //Sprite in bottom corner
	    g.drawImage (beachball, x_pos, y_pos, null);
	}

	if (credits)
	{
	    g.setFont (creditsfont); //change font
	    g.drawImage (background, 0, 0, null); //redraw background
	    //how to add music to game
	    g.drawString ("Sound: http://www.realapplets.com/tutorial/soundexample.html", 30, 300);
	    //Where i got special fonts
	    g.drawString ("Fonts: textcraft.net", 380, 350);
	    //Draw back button
	    g.drawImage (back, 863, 20, null);
	}

	//If user loses all lives display this message
	if (tryagain)
	{
	    g.setFont (score2);
	    g.drawString ("TRY AGAIN", 385, 150);
	}


    } // paint method
} // MovingBallApplet5 class


