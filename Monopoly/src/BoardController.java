import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.Random;

public class BoardController
{
	Player [] PLAYERS = new Monopoly().getPArray();
	Property [] TILES = new Property().buildPropertyList();
    Button [] BUTTONS = new Monopoly().getPurchaseArray();
	Settings pref = new Monopoly().getSettings();
	
	@FXML
	public Button PlayButton = new Button();
    
    @FXML
    public Button SaveButton = new Button();
	
	@FXML
	public Button BeginButton = new Button();
    
    @FXML
    public Button PropertyButton = new Button();
    
    @FXML
    public Button Assets = new Button();
	
	@FXML
	public GridPane mainGrid = new GridPane();
	
	@FXML
	public Label currentPlayerName = new Label();
	
	@FXML
	public ImageView D1 = new ImageView();
	
	@FXML
	public ImageView D2 = new ImageView();
	
	@FXML
	public ImageView currentToken = new ImageView();
	
	@FXML
	public Label currentPlayerWealth = new Label();
	
	@FXML
	public Label currentPlayerRolled = new Label();
    
    @FXML
    public int position;
    
    @FXML
    public Random random = new Random();
    
    public String [] letters = {"A", "a", "B", "b", "C", "c"};
    
    @FXML
    public void Save() throws IOException
    {
    		System.out.println("Save Complete");
    		Stage popupwindow = new Stage();
    		Scene loadScene;
    		VBox loadLayout = new VBox();
    		loadLayout.setAlignment(Pos.CENTER);
    		loadLayout.setSpacing(650*.01);

    		Button [] loadSlots = {new Button("Saved Slot 1"),new Button("Saved Slot 2"),new Button("Saved Slot 3"),new Button("Saved Slot 4")};

    		Button cancelLoadButton = new Button("Cancel");
    

	boolean [] saved = {true,true,true,true};
	
	// Load Coloring Based On Save
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
			loadSlots[i].setStyle("-fx-font: 30 times; -fx-base: #ffff80;");
		}
		else
		{
			loadSlots[i].setStyle("-fx-font: 30 times; -fx-base: #adabab;");
		}
	}*/
	
	for(int i = 0; i < 4; i++)
	{
		loadSlots[i].setStyle("-fx-font: 30 times; -fx-base: #ffff80;");
	}

	cancelLoadButton.setStyle("-fx-font: 20 times; -fx-base: #c12505;");
	
	loadSlots[0].setOnAction(e -> {
		FileOutputStream f = null;
		try {
			URL url = getClass().getResource("assets/save1.txt");
			f = new FileOutputStream(new File(url.getPath()));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		ObjectOutputStream o = null;
		try {
			o = new ObjectOutputStream(f);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		// Write Objects to file
		// Order: Preferences, Players, Board
		try {
			o.writeObject(pref);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		try {
			o.writeObject(PLAYERS);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		try {
			o.writeObject(TILES);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		// Close out data streams
		try {
			o.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		try {
			f.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		popupwindow.close();
	});
	loadSlots[1].setOnAction(e -> {
		FileOutputStream f = null;
		try {
			URL url = getClass().getResource("assets/save2.txt");
			f = new FileOutputStream(new File(url.getPath()));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		ObjectOutputStream o = null;
		try {
			o = new ObjectOutputStream(f);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		// Write Objects to file
		// Order: Preferences, Players, Board
		try {
			o.writeObject(pref);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		try {
			o.writeObject(PLAYERS);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		try {
			o.writeObject(TILES);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		// Close out data streams
		try {
			o.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		try {
			f.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		popupwindow.close();
	});
	loadSlots[2].setOnAction(e -> {
		FileOutputStream f = null;
		try {
			URL url = getClass().getResource("assets/save3.txt");
			f = new FileOutputStream(new File(url.getPath()));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		ObjectOutputStream o = null;
		try {
			o = new ObjectOutputStream(f);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		// Write Objects to file
		// Order: Preferences, Players, Board
		try {
			o.writeObject(pref);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		try {
			o.writeObject(PLAYERS);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		try {
			o.writeObject(TILES);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		// Close out data streams
		try {
			o.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		try {
			f.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		popupwindow.close();
	});
	loadSlots[3].setOnAction(e -> {
		FileOutputStream f = null;
		try {
			URL url = getClass().getResource("assets/save4.txt");
			f = new FileOutputStream(new File(url.getPath()));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		ObjectOutputStream o = null;
		try {
			o = new ObjectOutputStream(f);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		// Write Objects to file
		// Order: Preferences, Players, Board
		try {
			o.writeObject(pref);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		try {
			o.writeObject(PLAYERS);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		try {
			o.writeObject(TILES);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		// Close out data streams
		try {
			o.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		try {
			f.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		popupwindow.close();
	});
	
	cancelLoadButton.setOnAction(e -> {
		popupwindow.close();
	});

	for(int i = 0; i < 4; i++)
	{
		loadLayout.getChildren().add(loadSlots[i]);
	}
	loadLayout.getChildren().add(cancelLoadButton);
	loadLayout.setBackground(new Background(new BackgroundFill(Color.rgb(204,255,204), CornerRadii.EMPTY, Insets.EMPTY)));
	loadScene = new Scene (loadLayout,650*.75, 650*.5);
	
	popupwindow.setScene(loadScene);
    popupwindow.showAndWait();
    }
    
    @FXML
    public void showAssets()
    {
        Player p = PLAYERS[pref.getCurrentPlayer()];
        p.Assets(TILES,PLAYERS, false);
    }
    
    @FXML
    public void purchProp()
    {
        Player p = PLAYERS[pref.getCurrentPlayer()];
        int tiles = p.propertiesOwned;
        
        if(tiles == 0)
        {
            p.noProperties(p);
        }
        
        else
        {
            p.ownsTiles(TILES);
        }
    }
	
	@FXML
	public void Begin()	// Initializes board for random first player
	{
		if(!pref.isNew())
		{
			Property [] TEMP = new Monopoly().returnLoadTiles();
			for(int i = 0; i < 40; i++)
			{
				TILES[i].owner = TEMP[i].owner;
				TILES[i].houses = TEMP[i].houses;
				TILES[i].hotel = TEMP[i].hotel;
				TILES[i].mortgaged = TEMP[i].mortgaged;
				TILES[i].numProps = TEMP[i].numProps;
			}
			System.out.println("Tiles Loaded");
		}

		for(int i = 0; i < pref.playerCount; i++)
		{
			PLAYERS[i].forceImageRender();
		}
		
		for(int i = 0; i < pref.playerCount; i++)
		{

			if(PLAYERS[i].getPosition() == 0)
			{
				try
				{mainGrid.add(PLAYERS[i].getToken(),0,0);}
				catch(IllegalArgumentException ex) {}
			}
			else
			{
				int col = 0;
				int row = 0;
		        
				position = PLAYERS[i].getPosition();
				
				if(PLAYERS[i].getJailed())
				{
					row = 1;
					col = 11;
				}
				else if(position < 10)
				{
		            
					row = 0;
					col = position +1;
				}
		        
				else if(position == 10)
				{
					row = 0;
					col = 12;
				}
		        
				else if(position > 10 && position < 20)
				{
					col = 12;
					row = position -9;
				}
		        
				else if(position == 20)
				{
					row = 12;
					col = 12;
				}
		        
				else if(position > 20 && position < 30)
				{
					row = 12;
					col = -position + 31;
				}
		        
				else if(position == 30)
				{
					row = 12;
					col = 0;
				}
				
				else if( position == 40)						// Jail position
				{
					row = 1;
					col = 11;
				}
		        
				else if(position > 30)
				{
					col = 0;
					row = -position +41;
				}
				
				// Update Location
				if(PLAYERS[i].getJailed())
				{
					try
					{
						mainGrid.add(PLAYERS[i].getToken(),11,1);
					} catch(IllegalArgumentException ex) {}
				}
				else
				{
					try
					{
						mainGrid.add(PLAYERS[i].getToken(),col,row);
					} catch(IllegalArgumentException ex) {}
				}
			}
			pref.setIsNew(false);
		}
		
		PlayButton.setText("First up: " + PLAYERS[pref.currentPlayer].getName() + "\n Click Here to Roll!");
        PropertyButton.setText("Buy Houses?");
        
		currentPlayerName.setText("Current Player: " + PLAYERS[pref.currentPlayer].getName());
		currentPlayerWealth.setText("Wealth: See Assets Button");
		currentPlayerRolled.setText("Rolled: No Rolls Yet");
		
		BeginButton.setVisible(false);
		BeginButton.setDisable(true);
        
	}

    public void checkBankruptcy(Player [] PLAYERS, Settings pref, Property [] TILES)
    {
        for(int i = 0; i < pref.getPlayerCount(); i++)
        {
            if(PLAYERS[i].getMoney() <= 0)
            {
            		lastResort(i);
            }
        }
    }
/*=============================================================================*/    
    public void lastResort(int i)
    {
    			Stage popupwindow2 = new Stage();
    			popupwindow2.initModality(Modality.APPLICATION_MODAL);
	        popupwindow2.setTitle("YOU'RE IN CRISIS!");
	        
	        Button sell = new Button("See Your Options...");
	        Button surrender = new Button("Declare Bankruptcy!");
	        
	        sell.setStyle("-fx-font: 20 times; -fx-base: green;");
	        surrender.setStyle("-fx-font: 20 times; -fx-base: red;");

	        // Conditional
	        Label mortInfo = new Label(PLAYERS[i].getName() + "'s liquid assets are in the negative!");

	        Label lab = new Label("Try selling or mortgaging your assets to prevent bankruptcy!");

	        mortInfo.setFont(new Font("Times New Roman", 20));
	        mortInfo.setWrapText(true);
	        mortInfo.setTextAlignment(TextAlignment.JUSTIFY);
	        
	        sell.setOnAction(ex -> {
	        		PLAYERS[i].Assets(TILES,PLAYERS, true);
	        		popupwindow2.close();
	        });
	        surrender.setOnAction(ex -> 
	        {
	        		runBankrupt(PLAYERS, pref, TILES,i);
	        		popupwindow2.close();
	        });
	        
	        // Tallies Properties
	        int tally = 0;
	        for(int x = 0; x < 40; x++)
	        {
	            if(TILES[x].getOwner() == PLAYERS[i])
	            {
	            		tally++;
	            }
	        }
	        
	        HBox buttonBox2;
	        
	        if(tally >0)
	        {
	        		buttonBox2 = new HBox(sell,surrender);
	        		lab = new Label("Try selling or mortgaging your assets to prevent bankruptcy!");
	        }
	        else
	        {
	        		buttonBox2 = new HBox(surrender);
	        		lab = new Label("You have no assets to sell to prevent bankruptcy... Game Over.");
	        }
	        
	        
	        buttonBox2.setAlignment(Pos.CENTER);
	        
	        
	        VBox layout2= new VBox(10);
	        layout2.getChildren().addAll(mortInfo,lab, buttonBox2);
	        layout2.setAlignment(Pos.CENTER);
	        layout2.setBackground(new Background(new BackgroundFill(Color.LIGHTGREEN, CornerRadii.EMPTY, Insets.EMPTY)));
	        
	        Scene sc = new Scene(layout2, 750, 575);
	        popupwindow2.setScene(sc);
	        popupwindow2.showAndWait();
	        
    }
    
/*=============================================================================*/    
    
    public void runBankrupt(Player [] PLAYERS, Settings pref, Property [] TILES, int i)
    {
        Stage s = new Stage();
        s.initModality(Modality.APPLICATION_MODAL);
        s.setTitle("Bankrupt");
        
        Label infoLabel = new Label(PLAYERS[i].getName() + " has gone bankrupt! The game is over!");
        infoLabel.setFont(new Font("Times New Roman", 20));
        
        Label bankLabel = new Label("Let's find our winner!");
        bankLabel.setFont(new Font("Times New Roman", 20));
        
        Button winner = new Button("Find the Winner!");
        winner.setStyle("-fx-font: 20 times; -fx-base: Red;");
        
        winner.setOnAction(e-> {
        	addAllAssets(PLAYERS, pref, TILES);
        	s.close();
        	});
        
        VBox layout = new VBox(10);
        layout.getChildren().addAll(infoLabel, bankLabel,winner);
        layout.setAlignment(Pos.CENTER);
        
        Scene scene1 = new Scene(layout, 750, 575);
        s.setScene(scene1);
        s.showAndWait();
    }
/*=============================================================================*/    
    public void addAllAssets(Player [] PLAYERS, Settings pref, Property [] TILES)
    {
        Player winner;
        
        Stage s = new Stage();
        s.initModality(Modality.APPLICATION_MODAL);
        s.setTitle("Bankrupt");

        VBox layout = new VBox(10);

        for(int i = 0; i < pref.getPlayerCount(); i++)
        {
            Label infoLabel = new Label(PLAYERS[i].getName() + "'s total budget:");
            infoLabel.setFont(new Font("Times New Roman", 20));
            
            for(int j = 0; j < 40; j++)
            {
				if(TILES[j].getOwner() == PLAYERS[i] && TILES[j].houses == 0)
				{
                    //System.out.println(PLAYERS[i].getName() + "'s money was $" + PLAYERS[i].getMoney());
                    PLAYERS[i].setTotal(PLAYERS[i].getMoney() + TILES[j].buyPrice);
                    //System.out.println(PLAYERS[i].getName() + "'s money is now $" + PLAYERS[i].getMoney());
				}
                
                if(TILES[j].getOwner() == PLAYERS[i] && TILES[j].houses != 0)
                {
                    //System.out.println(TILES[j].getOwner().getName());
                    PLAYERS[i].setTotal(PLAYERS[i].getMoney() + TILES[j].buyPrice + TILES[j].housePrice*TILES[j].houses);
                }
            }

            
            Region region1 = new Region();
            HBox.setHgrow(region1, Priority.ALWAYS);
            
            Label assetsLabel = new Label("$" + PLAYERS[i].totalWealth);
            assetsLabel.setFont(new Font("Times New Roman", 20));
            
            
            HBox hb = new HBox(infoLabel, region1, assetsLabel);
            
            layout.getChildren().addAll(hb);
        }
        
        Button exit = new Button("Close Game");
		exit.setOnAction(e-> {
			new Monopoly().window.close();
			s.close();
        	});
		
        layout.getChildren().add(exit);
        int highestBudget = PLAYERS[0].totalWealth;
        winner = PLAYERS[0];
        
        for(int i = 1; i < pref.getPlayerCount(); i++)
        {
            if(PLAYERS[i].totalWealth > highestBudget)
            {
                highestBudget = PLAYERS[i].totalWealth;
                winner = PLAYERS[i];
            }
        }
        
        Label winLabel = new Label(winner.getName() + " wins! Thanks for playing!");
        winLabel.setFont(new Font("Times New Roman", 20));
        
        layout.getChildren().add(winLabel);
        layout.setAlignment(Pos.CENTER);
        Scene scene1 = new Scene(layout, 750, 575);
        s.setScene(scene1);
        s.showAndWait();
        
    }


/*=============================================================================*/    

    
	@FXML
	public void PlayAction()
	{
		checkBankruptcy(PLAYERS, pref, TILES);
		
		// Concludes Turn & Moves to Next Player
		if(pref.getCurrentPlayer()==(pref.getPlayerCount()-1))
		{
			pref.setCurrentPlayer(0);
		}
		else
			pref.setCurrentPlayer(pref.getCurrentPlayer()+1);
		
		// Roll Dice
		Dice d = new Dice();
		int roll1 = d.rollDice();
		int roll2 = d.rollDice();
        
		
		// Dice Graphics
		D1.setImage(new Image(getClass().getResourceAsStream("/assets/Dice" + roll1 + ".png")));
		D2.setImage(new Image(getClass().getResourceAsStream("/assets/Dice" + roll2 + ".png")));
        

		// Set Current Player Information
		currentPlayerRolled.setText("Rolled: "+ roll1 + " + " + roll2 +" = " + (roll1+roll2));
		currentToken.setImage(new Image(getClass().getResourceAsStream("/assets/" + PLAYERS[pref.currentPlayer].getTokenDescription() + ".png")));
		
		if(!PLAYERS[pref.getCurrentPlayer()].getJailed())
		{
			// Calculates New Position After Dice Roll
			for(int i = 0; i < (roll1+roll2); i++)
			{
				PLAYERS[pref.getCurrentPlayer()].moveForward(1);
			}
		}
		else
		{
			if(roll1 == roll2)
			{
        			PLAYERS[pref.currentPlayer].spend(50);
        			PLAYERS[pref.currentPlayer].setJailed(false);
        			PLAYERS[pref.getCurrentPlayer()].setPosition(10);
        		
        			Stage secondary = new Stage();
        			secondary.initModality(Modality.APPLICATION_MODAL);
        			secondary.setTitle("Freedom!");
        			Label label2 = new Label("You've been freed!");
        			label2.setFont(new Font("Times New Roman", 20));
        			label2.setWrapText(true);
        			label2.setTextAlignment(TextAlignment.JUSTIFY);
        			
                    Button exit = new Button("Exit");
                    exit.setStyle("-fx-font: 20 times; -fx-base: red;");
                    exit.setOnAction(v -> secondary.close());
                    
        			VBox layout= new VBox(10);
        			layout.getChildren().addAll(label2,exit);
        			layout.setAlignment(Pos.CENTER);
        			layout.setBackground(new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));
		        
        			Scene scene1 = new Scene(layout, 250, 100);
        			secondary.setScene(scene1);
        			secondary.show();
        			PauseTransition wait = new PauseTransition(Duration.seconds(5));
        			wait.setOnFinished( ex ->secondary.close());
        			wait.play();
			}
			else
				PLAYERS[pref.getCurrentPlayer()].setPosition(10);
		}

		// Determines Mapping to Game Grid
		int col = 0;
		int row = 0;
        
		position = PLAYERS[pref.getCurrentPlayer()].getPosition();
		
		if(PLAYERS[pref.getCurrentPlayer()].getJailed())
		{
			row = 1;
			col = 11;
		}
		else if(position < 10)
		{
            
			row = 0;
			col = position +1;
		}
        
		else if(position == 10)
		{
			row = 0;
			col = 12;
		}
        
		else if(position > 10 && position < 20)
		{
			col = 12;
			row = position -9;
		}
        
		else if(position == 20)
		{
			row = 12;
			col = 12;
		}
        
		else if(position > 20 && position < 30)
		{
			row = 12;
			col = -position + 31;
		}
        
		else if(position == 30)
		{
			row = 12;
			col = 0;
		}
		
		else if( position == 40)						// Jail position
		{
			row = 1;
			col = 11;
		}
        
		else if(position > 30)
		{
			col = 0;
			row = -position +41;
		}
		
		int currentPlayer = pref.getCurrentPlayer();
		
		// Update Location
		try
		{
            mainGrid.add(PLAYERS[pref.getCurrentPlayer()].getToken(),col,row);
        } catch(IllegalArgumentException ex) {}
		
		// Tile Processing
		TILES[position].processProperty(PLAYERS, pref,TILES);
		
		// Update Location
		if(PLAYERS[pref.getCurrentPlayer()].getJailed())
		{
			try
			{
				mainGrid.add(PLAYERS[pref.getCurrentPlayer()].getToken(),11,1);
			} catch(IllegalArgumentException ex) {}
		}
		else
		{
			try
			{
				mainGrid.add(PLAYERS[pref.getCurrentPlayer()].getToken(),col,row);
			} catch(IllegalArgumentException ex) {}
		}
		
		int nextPlayer;
		// Determine Next Player for printout
				if(pref.getCurrentPlayer()==(pref.getPlayerCount()-1))
				{
					nextPlayer = 0;
				}
				else
					nextPlayer = pref.getCurrentPlayer()+1;
		
		// Update Money After Property Evaluations
		PlayButton.setText("End " + PLAYERS[currentPlayer].getName()+ "'s turn\n" + "Roll for " + PLAYERS[nextPlayer].getName());
        currentPlayerName.setText("Current Player: " + PLAYERS[pref.currentPlayer].getName());
        currentPlayerWealth.setText("Wealth: See Assets Button");
        PropertyButton.setText("Buy Houses?");

	}

}