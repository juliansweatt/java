import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.layout.BackgroundFill;
import java.io.ObjectInputStream;
import java.net.URL;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.Background;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.TextAlignment;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import java.util.Random;

public class Monopoly extends Application
{
	// Used to Pass Players to Control
	public Player[] getPArray()
	{
		return PLAYERS.clone();
	}
	
	public Settings getSettings()
	{
		return pref; 
	}
	
    public String[] getChestArray()
    {
        return chest.clone();
    }
    
    public String[] getChanceArray()
    {
        return chance.clone();
    }
    
    public Button[] getPurchaseArray()
    {
        return PURCHASE.clone();
    }
    
    Player [] ps = getPArray();
	
	
	// Main Stages and Scenes
	static Stage window;
	static Scene gameScene;
	static Scene newgameScene;
	static Scene playersSetupScene;
	static Scene welcomeScene;
	static Scene errorScene;
	static Scene loadScene;
	static GridPane boardView;
	static Settings pref = new Settings();
	static Property [] X;

	// Main Stage Dimensions
	static int stageWidth = 650;
	static int stageDepth = 650;

	// Players Array
	static Player PLAYERS[] = new Player[6];
    static Button PURCHASE[] = new Button[6];
    //BoardController bc = new BoardController();
	static String [] chest = {
			"You were nominated for FSU Student Body President, but you didn't win. Collect $15.",
		    "FSU Financial Aid believes your deductions. Collect $80.",
		    "Cash out on your Financial Aid! Collect $45.",
		    "Your new student show is a 'GO'! Collect $200.",
		    "Willy Taggart mistakenly adds you to the roster. Collect $200.",
		    "Your recent Youtube video received 500 million views! Collect $100.",
		    "You were admitted to the FSU Graduate School Program! Collect $5.",
		    "Pass 'GO' and collect $200.",
		    "Here is your 'Get Out of Jail Free' pass!",
		    "The FSU Psychology Program has funded your research! Collect $250.",
		    "Pay marriage penalty tax of $25.",
		    "Steal SAR Imager materials for market research. Pay $100.",
		    "Wellness Center operates on the wrong leg! Pay $50.",
		    "President Thrasher gets a $100 million X-Mas bonus! You get nothing.",
		    "You cheated in bowling! Go straight to Jail and do not pass 'GO'.",
		    "You left your bar tab open at Madison Social! Pay $150."
		    };
	
    static String [] chance = {
       	"Advance to 'GO' and collect $200.",
    		"Advance to HCB - If you pass Go, collect $200",
    		"Advance to The Rez – If you pass Go, collect $200",
    		"Your new student show is a 'GO'! Collect $200.",
    		"Advance to nearest Utility.",
    		"Advance to the nearest Bus",
    		"FSU pays you dividend of $50.",
    		"You have won an Ultimate Frisbee tournament - Collect $100",
    		"You found a get out of jail free card!",
    		"Go back 3 spaces.",
    		"Go directly to Jail and do not pass 'GO'.",
    		"Make general repairs. Pay $25",
    		"Pay poor tax of $15",
    		"Take a trip to the Gold Bus – If you pass Go, collect $200.",
    		"Take a walk on Legacy Walk.",
    		"You have been elected Student Body Treasurer – Pay each player $50."
    };

	static int tokenWidth = 30;

	// Launch GUI
	public static void main(String[] args)
	{
		launch(args);
	}

	// GUI
	@Override
	public void start(Stage mainStage) throws Exception
	{
		// Image Import
		ImageView welcomeImage = new ImageView(new Image(getClass().getResourceAsStream("/assets/mono_logo.png")));
		welcomeImage.setPreserveRatio(true);
		welcomeImage.setFitWidth(stageDepth*.65);

		ImageView star = new ImageView(new Image(getClass().getResourceAsStream("/assets/star.png")));
		star.setPreserveRatio(true);
		star.setFitWidth(tokenWidth);

		ImageView car = new ImageView(new Image(getClass().getResourceAsStream("/assets/car.png")));
		car.setPreserveRatio(true);
		car.setFitWidth(tokenWidth);

		ImageView rocket = new ImageView(new Image(getClass().getResourceAsStream("/assets/rocket.png")));
		rocket.setPreserveRatio(true);
		rocket.setFitWidth(tokenWidth);

		ImageView plane = new ImageView(new Image(getClass().getResourceAsStream("/assets/plane.png")));
		plane.setPreserveRatio(true);
		plane.setFitWidth(tokenWidth);

		ImageView train = new ImageView(new Image(getClass().getResourceAsStream("/assets/train.png")));
		train.setPreserveRatio(true);
		train.setFitWidth(tokenWidth);

		// Establish Main Window
		window = mainStage;
		window.setTitle("Monopoly");							// Establish stage title

		// Welcome Menu
		VBox welcomeLayout = new VBox();							// Form layout
		welcomeLayout.setAlignment(Pos.CENTER);
		welcomeLayout.setSpacing(stageDepth*.01);

		Button playButton = new Button("New Game");
		Button loadButton = new Button("Load Game");
		playButton.setStyle("-fx-font: 50 times; -fx-base: #b6e7c9;");
		loadButton.setStyle("-fx-font: 25 times; -fx-base: #429ef4;");

		welcomeLayout.getChildren().add(welcomeImage);

		welcomeLayout.getChildren().add(playButton);									// Add start to welcome screen
		welcomeLayout.getChildren().add(loadButton);
		welcomeLayout.setBackground(new Background(new BackgroundFill(Color.rgb(204,255,204), CornerRadii.EMPTY, Insets.EMPTY)));
		welcomeScene = new Scene (welcomeLayout,stageDepth*.75, stageWidth*.5);		// Form welcome scene from welcomeLayout

		// Load Menu (Actions not yet implemented)
		VBox loadLayout = new VBox();							// Form layout
		loadLayout.setAlignment(Pos.CENTER);
		loadLayout.setSpacing(stageDepth*.01);

		Button [] loadSlots = {new Button("Saved Slot 1"),new Button("Saved Slot 2"),new Button("Saved Slot 3"),new Button("Saved Slot 4")};

		Button cancelLoadButton = new Button("Cancel");
        
        loadSlots[0].setOnAction (e-> {
	    		FileInputStream fi = null;
	    		try {
	    			URL url = getClass().getResource("assets/save1.txt");
	    			fi = new FileInputStream(new File(url.getPath()));
	    		} catch (FileNotFoundException e1) {
	    			e1.printStackTrace();
	    		}
	    		ObjectInputStream oi = null;
	    		try {
	    			oi = new ObjectInputStream(fi);
	    		} catch (IOException e1) {
	    			e1.printStackTrace();
	    		}
    		
	    		Settings loadSettings = null;
	    		Player [] loadPlayers = null;
	    		Property [] loadTiles = null;
	    		
	    		try {
	    			loadSettings = (Settings) oi.readObject();
	    			loadPlayers = (Player[]) oi.readObject();
	    			loadTiles = (Property[]) oi.readObject();
	    		} catch (ClassNotFoundException | IOException e1) {
	    			e1.printStackTrace();
	    		}

	    		pref = loadSettings;
	    		PLAYERS = loadPlayers;
	    		X = loadTiles;
	    		
	    		try {
					makeGame();
				} catch (IOException e1) {
                    System.out.println("Error");
                    e1.printStackTrace();
                    
			}
        });
        loadSlots[1].setOnAction (e-> {
    		FileInputStream fi = null;
    		try {
    			URL url = getClass().getResource("assets/save2.txt");
    			fi = new FileInputStream(new File(url.getPath()));
    		} catch (FileNotFoundException e1) {
    			e1.printStackTrace();
    		}
    		ObjectInputStream oi = null;
    		try {
    			oi = new ObjectInputStream(fi);
    		} catch (IOException e1) {
    			e1.printStackTrace();
    		}
		
    		Settings loadSettings = null;
    		Player [] loadPlayers = null;
    		Property [] loadTiles = null;
    		
    		try {
    			loadSettings = (Settings) oi.readObject();
    			loadPlayers = (Player[]) oi.readObject();
    			loadTiles = (Property[]) oi.readObject();
    		} catch (ClassNotFoundException | IOException e1) {
    			e1.printStackTrace();
    		}

    		pref = loadSettings;
    		PLAYERS = loadPlayers;
    		X = loadTiles;
    		
    		try {
				makeGame();
			} catch (IOException e1) {
                System.out.println("Error");
                e1.printStackTrace();
                
		}
    });
        loadSlots[2].setOnAction (e-> {
    		FileInputStream fi = null;
    		try {
    			URL url = getClass().getResource("assets/save3.txt");
    			fi = new FileInputStream(new File(url.getPath()));
    		} catch (FileNotFoundException e1) {
    			e1.printStackTrace();
    		}
    		ObjectInputStream oi = null;
    		try {
    			oi = new ObjectInputStream(fi);
    		} catch (IOException e1) {
    			e1.printStackTrace();
    		}
		
    		Settings loadSettings = null;
    		Player [] loadPlayers = null;
    		Property [] loadTiles = null;
    		
    		try {
    			loadSettings = (Settings) oi.readObject();
    			loadPlayers = (Player[]) oi.readObject();
    			loadTiles = (Property[]) oi.readObject();
    		} catch (ClassNotFoundException | IOException e1) {
    			e1.printStackTrace();
    		}

    		pref = loadSettings;
    		PLAYERS = loadPlayers;
    		X = loadTiles;
    		
    		try {
				makeGame();
			} catch (IOException e1) {
                System.out.println("Error");
                e1.printStackTrace();
                
		}
    });
        loadSlots[3].setOnAction (e-> {
    		FileInputStream fi = null;
    		try {
    			URL url = getClass().getResource("assets/save4.txt");
    			fi = new FileInputStream(new File(url.getPath()));
    		} catch (FileNotFoundException e1) {
    			e1.printStackTrace();
    		}
    		ObjectInputStream oi = null;
    		try {
    			oi = new ObjectInputStream(fi);
    		} catch (IOException e1) {
    			e1.printStackTrace();
    		}
		
    		Settings loadSettings = null;
    		Player [] loadPlayers = null;
    		Property [] loadTiles = null;
    		
    		try {
    			loadSettings = (Settings) oi.readObject();
    			loadPlayers = (Player[]) oi.readObject();
    			loadTiles = (Property[]) oi.readObject();
    		} catch (ClassNotFoundException | IOException e1) {
    			e1.printStackTrace();
    		}

    		pref = loadSettings;
    		PLAYERS = loadPlayers;
    		X = loadTiles;
    		
    		try {
				makeGame();
			} catch (IOException e1) {
                System.out.println("Error");
		}
    });
        
		boolean [] saved = {true,true,true,true};

		// Load Coloring Based On Save (Grey if save file hasn't been written to, Green if it has)
		/*
	for(int i = 0; i < 4; i++)
	{
			
    		FileInputStream fi = null;
    		try {
    			URL url = getClass().getResource("assets/save"+(i+1)+".txt");
    			fi = new FileInputStream(new File(url.getPath()));
    		} catch (FileNotFoundException e1) {
    			saved[i] = false;
    		}
    		ObjectInputStream oi = null;
    		try {
    			oi = new ObjectInputStream(fi);
    		} catch (IOException e1) {
    			saved[i] = false;
    		}
		
    		// Purposeful use of the null pointer exception catch (unreccomended) to determine if a file is empty
    		try {
    			int a = (Integer) oi.available();
    		} catch (IOException | java.lang.NullPointerException exception) {
    			saved[i] = false;
    		}
	}

	for(int i = 0; i < 4; i++)
	{
		if(saved[i] == true)
		{
			loadSlots[i].setStyle("-fx-font: 30 times; -fx-base: #42f44e;");
		}
		else
		{
			loadSlots[i].setStyle("-fx-font: 30 times; -fx-base: #adabab;");
			loadSlots[i].setDisable(true);
		}
	}
		*/
		for(int i = 0; i < 4; i++)
		{
			loadSlots[i].setStyle("-fx-font: 30 times; -fx-base: #42f44e;");
		}
		
		cancelLoadButton.setStyle("-fx-font: 20 times; -fx-base: #c12505;");

		for(int i = 0; i < 4; i++)
		{
			loadLayout.getChildren().add(loadSlots[i]);
		}
		loadLayout.getChildren().add(cancelLoadButton);
		loadLayout.setBackground(new Background(new BackgroundFill(Color.rgb(204,255,204), CornerRadii.EMPTY, Insets.EMPTY)));
		loadScene = new Scene (loadLayout,stageDepth*.75, stageWidth*.5);

		// New Game Setup Menu
		Button cancelNewButton = new Button("Cancel");
		cancelNewButton.setStyle("-fx-font: 20 times; -fx-base: #c12505;");

		HBox newgameLayout = new HBox();							// Form layout
		newgameLayout.setAlignment(Pos.CENTER);
		newgameLayout.setSpacing(stageDepth*.01);

		VBox vertnewgameLayout = new VBox();
		vertnewgameLayout.setAlignment(Pos.CENTER);
		vertnewgameLayout.setSpacing(stageDepth*.01);

		Button [] playersSelect = new Button[6];
		for(int i = 0; i < 6; i++)
		{
			playersSelect [i] = new Button(""+(i+1));
		}
		for(int i = 1; i < 6; i++)
		{
			playersSelect[i].setStyle("-fx-font: 30 times; -fx-base: #42ebf4;");
			newgameLayout.getChildren().add(playersSelect[i]);
		}

		Label playersLabel = new Label("How many players?");
		playersLabel.setStyle("-fx-font: 30 times;");

		vertnewgameLayout.setBackground(new Background(new BackgroundFill(Color.rgb(204,255,204), CornerRadii.EMPTY, Insets.EMPTY)));
		vertnewgameLayout.getChildren().add(playersLabel);
		vertnewgameLayout.getChildren().add(newgameLayout);
		vertnewgameLayout.getChildren().add(cancelNewButton);
		newgameScene = new Scene (vertnewgameLayout,stageDepth*.75, stageWidth*.5);
		
		// Error Window
		VBox errorLayout = new VBox();
		errorLayout.setAlignment(Pos.CENTER);
		errorLayout.setSpacing(stageDepth*.03);
		Label errorMessage1a = new Label("WHOOPS!\n");
		errorMessage1a.setTextAlignment(TextAlignment.CENTER);
		errorMessage1a.setFont(Font.font("Times New Roman", FontWeight.EXTRA_BOLD ,100));
		errorMessage1a.setTextFill(Color.WHITE);
		
		Label errorMessage1b = new Label("It looks like there was a problem setting up your game!\n\nRemember:\n-- No two players can have the same icon\n-- Every player must have an icon\n-- It is advised that every player have a unique nickname");
		errorMessage1b.setWrapText(true);
		errorMessage1b.setTextAlignment(TextAlignment.CENTER);
		errorMessage1b.setFont(Font.font("Times New Roman", FontWeight.EXTRA_BOLD ,20));
		errorMessage1b.setTextFill(Color.WHITE);
		
		Button errorExitButton = new Button("OK - Try Again");
		errorExitButton.setStyle("-fx-font: 30 times; -fx-base: #42ebf4;");
		
		errorLayout.getChildren().addAll(errorMessage1a,errorMessage1b, errorExitButton);
		errorLayout.setBackground(new Background(new BackgroundFill(Color.rgb(170,0,0), CornerRadii.EMPTY, Insets.EMPTY)));
		errorScene = new Scene (errorLayout,stageDepth, stageWidth*.7);
		
		errorExitButton.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override public void handle(ActionEvent e)
			{
				window.setScene(newgameScene);
			}
		});
		
		// Launch Application
		window.setScene(welcomeScene);						// Display welcome screen first
		window.show();										// Display stage to user

		// Menu Button Handling
		playButton.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override public void handle(ActionEvent e)
			{
				window.setScene(newgameScene);
			}
		});

		loadButton.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override public void handle(ActionEvent e)
			{
				window.setScene(loadScene);
			}
		});

		cancelLoadButton.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override public void handle(ActionEvent e)
			{
				window.setScene(welcomeScene);
			}
		});

		cancelNewButton.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override public void handle(ActionEvent e)
			{
				window.setScene(welcomeScene);
			}
		});


		// New Game Setup
		playersSelect[0].setOnAction(new EventHandler<ActionEvent>()
		{
			@Override public void handle(ActionEvent e)
			{
				pref.setPlayerCount(1);
				System.out.println(pref.getPlayerCount()+ " Players Selected");
				makeSettingsMenu(1);
				window.setScene(playersSetupScene);
			}
		});
		playersSelect[1].setOnAction(new EventHandler<ActionEvent>()
		{
			@Override public void handle(ActionEvent e)
			{
				pref.setPlayerCount(2);
				System.out.println(pref.getPlayerCount()+ " Players Selected");
				makeSettingsMenu(2);
				window.setScene(playersSetupScene);
			}
		});
		playersSelect[2].setOnAction(new EventHandler<ActionEvent>()
		{
			@Override public void handle(ActionEvent e)
			{
				pref.setPlayerCount(3);
				System.out.println(pref.getPlayerCount()+ " Players Selected");
				makeSettingsMenu(3);
				window.setScene(playersSetupScene);
			}
		});
		playersSelect[3].setOnAction(new EventHandler<ActionEvent>()
		{
			@Override public void handle(ActionEvent e)
			{
				pref.setPlayerCount(4);
				System.out.println(pref.getPlayerCount()+ " Players Selected");
				makeSettingsMenu(4);
				window.setScene(playersSetupScene);
			}
		});
		playersSelect[4].setOnAction(new EventHandler<ActionEvent>()
		{
			@Override public void handle(ActionEvent e)
			{
				pref.setPlayerCount(5);
				System.out.println(pref.getPlayerCount()+ " Players Selected");
				makeSettingsMenu(5);
				window.setScene(playersSetupScene);
			}
		});
		playersSelect[5].setOnAction(new EventHandler<ActionEvent>()
		{
			@Override public void handle(ActionEvent e)
			{
				pref.setPlayerCount(6);
				System.out.println(pref.getPlayerCount()+ " Players Selected");
				makeSettingsMenu(6);
				window.setScene(playersSetupScene);
			}
		});

	}

	public void makeSettingsMenu(int players)
	{
		// Setup Input Menu
		Button cancelButton = new Button("Cancel");
		cancelButton.setStyle("-fx-font: 10 times; -fx-base: #c12505;");
		Button submitButton = new Button("START");
		submitButton.setStyle("-fx-font: 30 times; -fx-base: green;");

		VBox playersSetupLayout = new VBox();							// Form layout
		playersSetupLayout.setAlignment(Pos.CENTER);
		playersSetupLayout.setSpacing(stageDepth*.01);


		final HBox [] tokenSetupLayout = new HBox[players];
		ToggleGroup [] tokenGroup = new ToggleGroup[players];
		ToggleButton [] carButton = new ToggleButton[players];
		ToggleButton [] starButton = new ToggleButton[players];
		ToggleButton [] planeButton = new ToggleButton[players];
		ToggleButton [] rocketButton = new ToggleButton[players];
		ToggleButton [] trainButton = new ToggleButton[players];
		ToggleButton [] boatButton = new ToggleButton[players];


		for(int i = 0; i < players; i++)
		{
			tokenGroup[i] = new ToggleGroup();

			tokenSetupLayout[i] = new HBox();
			tokenSetupLayout[i].setAlignment(Pos.CENTER);
			tokenSetupLayout[i].setSpacing(stageDepth*.01);

			carButton[i] = new ToggleButton("Car",new ImageView(new Image(getClass().getResourceAsStream("/assets/smallcar.png"))));
			starButton[i] = new ToggleButton("Star",new ImageView(new Image(getClass().getResourceAsStream("/assets/smallstar.png"))));
			planeButton[i] = new ToggleButton("Plane",new ImageView(new Image(getClass().getResourceAsStream("/assets/smallplane.png"))));
			rocketButton[i] = new ToggleButton("Rocket",new ImageView(new Image(getClass().getResourceAsStream("/assets/smallrocket.png"))));
			trainButton[i] = new ToggleButton("Train",new ImageView(new Image(getClass().getResourceAsStream("/assets/smalltrain.png"))));
			boatButton[i] = new ToggleButton("Boat",new ImageView(new Image(getClass().getResourceAsStream("/assets/smallboat.png"))));
			
			carButton[i].setToggleGroup(tokenGroup[i]);
			starButton[i].setToggleGroup(tokenGroup[i]);
			planeButton[i].setToggleGroup(tokenGroup[i]);
			rocketButton[i].setToggleGroup(tokenGroup[i]);
			trainButton[i].setToggleGroup(tokenGroup[i]);
			boatButton[i].setToggleGroup(tokenGroup[i]);

			tokenSetupLayout[i].getChildren().add(carButton[i]);
			tokenSetupLayout[i].getChildren().add(starButton[i]);
			tokenSetupLayout[i].getChildren().add(planeButton[i]);
			tokenSetupLayout[i].getChildren().add(rocketButton[i]);
			tokenSetupLayout[i].getChildren().add(trainButton[i]);
			tokenSetupLayout[i].getChildren().add(boatButton[i]);
		}

		TextField [] playerNames = new TextField [6];

		for(int i = 0; i < players; i++)
		{
			playerNames[i] = new TextField ();
			playerNames[i].setPromptText("Enter your name." );
			playerNames[i].getText();
			playersSetupLayout.getChildren().add(new Label("Player "+ (i+1)+" Name:"));
			playersSetupLayout.getChildren().add(playerNames[i]);
			playersSetupLayout.getChildren().add(new Label("Player "+ (i+1)+" Icon:"));
			playersSetupLayout.getChildren().add(tokenSetupLayout[i]);

		}

		playersSetupLayout.getChildren().add(submitButton);
		playersSetupLayout.getChildren().add(cancelButton);
		
		playersSetupLayout.setBackground(new Background(new BackgroundFill(Color.rgb(204,255,204), CornerRadii.EMPTY, Insets.EMPTY)));
		playersSetupScene = new Scene (playersSetupLayout,stageDepth, stageWidth*1.3);

		cancelButton.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override public void handle(ActionEvent e)
			{
				window.setScene(welcomeScene);
			}
		});

		submitButton.setOnAction(new EventHandler<ActionEvent>()
		{
            public void handle(ActionEvent e)
			{
				boolean validSetup = true;
				boolean tokenAvailable [] = {true,true,true,true,true,true};
				// Car, star, rocket, plane, train, boat

				for(int i = 0; i < players; i++)
				{
					if(carButton[i].isSelected() && tokenAvailable[0])
					{
						tokenAvailable[0] = false;
						PLAYERS[i] = new Player (playerNames[i].getText(),"/assets/car.png", "car");
					}
					else if(starButton[i].isSelected() && tokenAvailable[1])
					{
						tokenAvailable[1] = false;
						PLAYERS[i] = new Player (playerNames[i].getText(),"/assets/star.png", "star");
					}
					else if(rocketButton[i].isSelected() && tokenAvailable[2])
					{
						tokenAvailable[2] = false;
						PLAYERS[i] = new Player (playerNames[i].getText(),"/assets/rocket.png", "rocket");
					}
					else if(planeButton[i].isSelected() && tokenAvailable[3])
					{
						tokenAvailable[3] = false;
						PLAYERS[i] = new Player (playerNames[i].getText(),"/assets/plane.png", "plane");
					}
					else if(trainButton[i].isSelected() && tokenAvailable[4])
					{
						tokenAvailable[4] = false;
						PLAYERS[i] = new Player (playerNames[i].getText(),"/assets/train.png", "train");
					}
					else if(boatButton[i].isSelected() && tokenAvailable[5])
					{
						tokenAvailable[5] = false;
						PLAYERS[i] = new Player (playerNames[i].getText(),"/assets/boat.png", "boat");
					}
					else
					{
						validSetup = false;
						System.out.println("ERROR");
						window.setScene(errorScene);
					}
				}
				
				// Randomly Select First Player
				Random rand = new Random();
				pref.setCurrentPlayer((rand.nextInt(pref.getPlayerCount())));
				
				if(validSetup)
					try {
						makeGame();
					} catch (IOException e1) {
                        System.out.println("Error");
                        e1.printStackTrace();
					}
			}
		});
	}

	public void makeGame() throws IOException
	{        
		Parent root = FXMLLoader.load(getClass().getResource("Monopoly.fxml"));
        Scene fxmlboard = new Scene(root);
		window.setScene(fxmlboard);
	}
	
	public Property [] returnLoadTiles()
	{
		return X;
	}
}
