import javafx.geometry.Insets;
import java.io.Serializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;

public class Player implements Serializable
{
	private int position = 0;
	private transient ImageView token = null;
	private String playerName = "";
	private int myMoney = 0;
	private String tokenDescription = "";
	private boolean jailed = false;
	public boolean isHuman = false;
	public int totalWealth = 0;
	public String imagePath = "";
	public int jailCard = 0;
	
    public int propertiesOwned;
    
    public String [] colors = {
    "", "-fx-background-color: #800080", "", "-fx-background-color: #800080", "", "-fx-background-color: #808080", "-fx-background-color: #00FFFF", "", "-fx-background-color: #00FFFF", "-fx-background-color: #00FFFF", "", // colors for top spaces
    
    "-fx-background-color: #FF4ECB", "-fx-background-color: #808080", "-fx-background-color: #FF4ECB", "-fx-background-color: #FF4ECB", "-fx-background-color: #808080", "-fx-background-color: #FFA500", "", "-fx-background-color: #FFA500", "-fx-background-color: #FFA500", "", // colors for right spaces
    
    
    "-fx-background-color: #850000", "", "-fx-background-color: #850000", "-fx-background-color: #850000", "-fx-background-color: #808080", "-fx-background-color: #F9FB00", "-fx-background-color: #F9FB00", "", "-fx-background-color: #F9FB00", "",
    //colors for bottom spaces
    
    
    "-fx-background-color: #009612", "-fx-background-color: #009612", "", "-fx-background-color: #009612", "808080", "", "-fx-background-color: #0000FF", "", "-fx-background-color: #0000FF"
    //colors for left spaces
    };
    
    Settings pref = new Monopoly().getSettings();
	
	public Player(String n)
	{
		position = 0;
		playerName = n;
		myMoney = 1500;
        propertiesOwned = 0;
	}
	
	
	public Player(String n, String t)
	{
		position = 0;
		imagePath = t;
		myMoney = 1500;
		tokenDescription = "";
        propertiesOwned = 0;
         
        token = new ImageView(new Image(getClass().getResourceAsStream(imagePath)));
		token.setPreserveRatio(true);
		token.setFitWidth(30);
	}
	
	public Player(String n, String t, String td)
	{
		position = 0;
		imagePath = t;
		myMoney = 1500;
		tokenDescription = td;
        propertiesOwned = 0;
        isHuman = true;
        
        token = new ImageView(new Image(getClass().getResourceAsStream(imagePath)));
		token.setPreserveRatio(true);
		token.setFitWidth(30);
        
		
		if(n.length() == 0) // Default names
		{
			System.out.println("NO NAME");
			if(tokenDescription == "car")
				playerName = "Car Player";
			else if(tokenDescription == "plane")
				playerName = "Plane Player";
			else if(tokenDescription == "rocket")
				playerName = "Rocket Player";
			else if(tokenDescription == "star")
				playerName = "Star Player";
			else if(tokenDescription == "boat")
				playerName = "Boat Player";
			else if(tokenDescription == "train")
				playerName = "Thomas the Tank Engine";
			else
				playerName = "Unnamed Player";
		}
		else
			playerName = n;
	}
	
	public Player()
	{

	}
	
	public void moveForward(int moves)
	{
		for(int i = 0; i < moves; i++)
		{
			if(getPosition() == 0)
			{
				gain(200);
				Stage popupwindow = new Stage();
				popupwindow.initModality(Modality.APPLICATION_MODAL);
		        popupwindow.setTitle(getName() + "Passed Go!");
		        Label label1 = new Label("You passed GO! Collect $200!");
		        label1.setFont(new Font("Times New Roman", 20));
		        label1.setWrapText(true);
		        label1.setTextAlignment(TextAlignment.JUSTIFY);
                Button exit = new Button("Exit");
                exit.setStyle("-fx-font: 20 times; -fx-base: red;");
                exit.setOnAction(v -> popupwindow.close());
		        
		        VBox layout= new VBox(10);
		        layout.getChildren().addAll(label1,exit);
		        layout.setAlignment(Pos.CENTER);
		        layout.setBackground(new Background(new BackgroundFill(Color.LIGHTGREEN, CornerRadii.EMPTY, Insets.EMPTY)));
		        
		        Scene scene1 = new Scene(layout, 250, 100);
		        popupwindow.setScene(scene1);
		        popupwindow.showAndWait();
			}
			
			if(position < 39)
			{
				position++;
			}
			else
				position =0;
		}
	}
    
    
	
	public void setPosition(int p)
	{
		position = p;
	}
    
    public void setMoney(int m)
    {
        myMoney = m;
    }
    
    public void setName(String pName)
    {
        playerName = pName;
    }
	
	public void setJailed(boolean b)
	{
		jailed = b;
	}
	
	public void setTotal(int i )
	{
		totalWealth = i;
	}
	
	public boolean getJailed()
	{
		return jailed;
	}
	
	public int getPosition()
	{
		return position;
	}
	
	public String getName()
	{
		return playerName;
	}
	
	public ImageView getToken()
	{
		return token;
	}
	
	public int getMoney()
	{
		return myMoney;
	}
	
	public void setTokenDescription(String desc)
	{
		tokenDescription = desc;
	}
	
	public String getTokenDescription()
	{
		return tokenDescription;
	}
	
	public int spend(int withdrawl)
	{
		myMoney = myMoney - withdrawl; 
		return myMoney;
	}
	
	public int gain(int deposit)
	{
		myMoney = myMoney + deposit; 
		return myMoney;
	}
    
    public void payPercent(int a)
    {
        myMoney -= (myMoney/a) ;
    }
    
    public void forceImageRender()
    {
    		token = new ImageView(new Image(getClass().getResourceAsStream(imagePath)));
		token.setPreserveRatio(true);
		token.setFitWidth(30);
    }
    
    public void Assets(Property [] TILES, Player [] PLAYERS, boolean inBankrupcy)
    {
        Stage t = new Stage();
        t.initModality(Modality.APPLICATION_MODAL);
        t.setTitle(getName() + "'s Assets");
        
        Label infoLabel = new Label(getName() + "'s budget:");
        infoLabel.setFont(new Font("Times New Roman", 20));
        
        Label cashLabel = new Label("$" + getMoney() + "");
        cashLabel.setFont(new Font("Times New Roman", 20));

        Button yes = new Button("Exit");
        yes.setStyle("-fx-font: 20 times; -fx-base: Red;");
        
        yes.setOnAction(e -> t.close());
        
        VBox layout = new VBox(10);

        layout.getChildren().addAll(infoLabel, cashLabel);
        
        for(int i = 0; i < 40; i++)
        {
            Button sell = new Button("Sell");
            Button mort = new Button("Mortgage");
            Button unmort = new Button("Unmortgage");
            
            Label temp = new Label(TILES[i].getName());
            temp.setFont(new Font("Times New Roman", 22));
            Label temp2 = new Label("     Houses: " + TILES[i].getHouses());
            temp2.setFont(new Font("Times New Roman", 15));
            Label temp3 = new Label("     Hotel: " + TILES[i].hasHotel());
            temp3.setFont(new Font("Times New Roman", 15));
            Property x = TILES[i];
            
            Region region1 = new Region();
            HBox.setHgrow(region1, Priority.ALWAYS);
            Region region2 = new Region();
            HBox.setHgrow(region2, Priority.ALWAYS);
            Region region3 = new Region();
            HBox.setHgrow(region3, Priority.ALWAYS);
            HBox hb;
            if(TILES[i].isMort())
            {
            		hb = new HBox(temp, temp2, temp3, region1, unmort);
            }
            else
            {
            		hb = new HBox(temp, temp2, temp3, region1, mort, sell);
            }
            
            hb.setBackground(new Background(new BackgroundFill(TILES[i].getColor(), CornerRadii.EMPTY, Insets.EMPTY)));
            
            if(TILES[i].houses == 0 && !TILES[i].hasHotel())
            {
            		int w = i;
                sell.setOnAction(e ->
                                 {
                                     System.out.println(pref.getPlayerCount());
                                     x.auction(PLAYERS,pref);	//Changed from sales
                                     t.close();
                                 });
                mort.setOnAction(e ->
                {
                		Stage popupwindow2 = new Stage();
	                popupwindow2.initModality(Modality.APPLICATION_MODAL);
	    		        popupwindow2.setTitle(getName());
	    		        
	    		        Button accept = new Button("Accept");
	    		        Button decline = new Button("Decline");
	    		        
	    		        accept.setStyle("-fx-font: 20 times; -fx-base: green;");
	    		        decline.setStyle("-fx-font: 20 times; -fx-base: red;");

	    		        // Conditional
	    		        Label mortInfo = new Label("Mortgaging this property will grant you $" + (TILES[w].getBuyPrice()/2));

	    		        Label lab = new Label("Mortgaging will make this tile useless until it has been unmortgaged with 10% interest.");

	    		        lab.setFont(new Font("Times New Roman", 20));
	    		        lab.setWrapText(true);
	    		        lab.setTextAlignment(TextAlignment.JUSTIFY);
	    		        
	    		        accept.setOnAction(ex -> {
	    		        		gain(TILES[w].getBuyPrice()/2);
	    		        		TILES[w].setMort(true);
	    		        		popupwindow2.close();
	    		        });
	    		        decline.setOnAction(ex -> 
	    		        {
	    		        		// Purposefully do nothing
	    		        		popupwindow2.close();
	    		        });
	    		        
	    		        HBox buttonBox2 = new HBox(accept,decline);
	    		        buttonBox2.setAlignment(Pos.CENTER);
	    		        
	    		        
	    		        VBox layout2= new VBox(10);
	    		        layout2.getChildren().addAll(mortInfo,lab, buttonBox2);
	    		        layout2.setAlignment(Pos.CENTER);
	    		        layout2.setBackground(new Background(new BackgroundFill(Color.LIGHTGREEN, CornerRadii.EMPTY, Insets.EMPTY)));
	    		        
	    		        Scene sc = new Scene(layout2, 750, 575);
	    		        popupwindow2.setScene(sc);
	    		        popupwindow2.showAndWait();
	    		        
	    		        if(!inBankrupcy)
	    		        {
	    		        		t.close();
	    		        		new BoardController().checkBankruptcy(PLAYERS, pref, TILES);
	    		        }
	    		        else
	    		        {
	    		        		t.close();
	    		        }
                });
                unmort.setOnAction(e ->
                {
                	Stage popupwindow2 = new Stage();
	                popupwindow2.initModality(Modality.APPLICATION_MODAL);
	    		        popupwindow2.setTitle(getName());
	    		        
	    		        Button accept = new Button("Accept");
	    		        Button decline = new Button("Decline");
	    		        
	    		        accept.setStyle("-fx-font: 20 times; -fx-base: green;");
	    		        decline.setStyle("-fx-font: 20 times; -fx-base: red;");
	    		        int interestPrice = (int)(((TILES[w].getBuyPrice()/2)*.1) + (TILES[w].getBuyPrice()/2));

	    		        // Conditional
	    		        Label mortInfo = new Label("Unmortgaging this property will cost you $" + (((TILES[w].getBuyPrice()/2)*.1)+(TILES[w].getBuyPrice()/2)));

	    		        Label lab = new Label("Mortgaging will make this tile useless until it has been unmortgaged with 10% interest.");

	    		        mortInfo.setFont(new Font("Times New Roman", 20));
	    		        mortInfo.setWrapText(true);
	    		        mortInfo.setTextAlignment(TextAlignment.JUSTIFY);
	    		        
	    		        accept.setOnAction(ex -> {
	    		        		spend(interestPrice);
	    		        		TILES[w].setMort(false);
	    		        		popupwindow2.close();
	    		        });
	    		        decline.setOnAction(ex -> 
	    		        {
	    		        		// Purposefully do nothing
	    		        		popupwindow2.close();
	    		        });
	    		        
	    		        HBox buttonBox2 = new HBox(accept,decline);
	    		        buttonBox2.setAlignment(Pos.CENTER);
	    		        
	    		        
	    		        VBox layout2= new VBox(10);
	    		        layout2.getChildren().addAll(mortInfo,lab, buttonBox2);
	    		        layout2.setAlignment(Pos.CENTER);
	    		        layout2.setBackground(new Background(new BackgroundFill(Color.LIGHTGREEN, CornerRadii.EMPTY, Insets.EMPTY)));
	    		        
	    		        Scene sc = new Scene(layout2, 750, 575);
	    		        popupwindow2.setScene(sc);
	    		        popupwindow2.showAndWait();
	    		        
                    t.close();
                });
            }
            
            else
            {
                sell.setOnAction(e ->
                                 {
                                     x.sellToSchool(pref, x,PLAYERS);
                                     t.close();
                                 });
            }
            
            if(TILES[i].getOwner() == this)
            {
                layout.getChildren().add(hb);
            }
        }
        
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().add(yes);
        
        Scene scene1 = new Scene(layout, 750, 575);
        t.setScene(scene1);
        t.showAndWait();
    }
    
    public void buy(Property t)
    {
        if(t.getHouses() == 4)
        {
        		Stage s = new Stage();
            s.initModality(Modality.APPLICATION_MODAL);
            s.setTitle("Buying Houses");
            
            Label infoLabel = new Label("Would you like to upgrade to a hotel for $" + t.getHotelRentPrice() +"?");
            infoLabel.setWrapText(true);
            
            infoLabel.setFont(new Font("Times New Roman", 30));
            
            Button yes = new Button("Purchase Hotel");
            Button no = new Button("Decline");
            yes.setStyle("-fx-font: 20 times; -fx-base: Green;");
            no.setStyle("-fx-font: 20 times; -fx-base: Red;");
            
            yes.setOnAction(e ->
            {
                t.setHouses(0);
                t.setHotel(true);
                s.close();
            });
            no.setOnAction(e ->
            {
                s.close();
            });
            
            VBox layout= new VBox(10);
            layout.getChildren().addAll(infoLabel);
            layout.setAlignment(Pos.CENTER);
            layout.getChildren().addAll(yes, no);
            
            Scene scene1 = new Scene(layout, 750, 575);
            s.setScene(scene1);
            s.showAndWait();
        }
        else
        {
        		Stage s = new Stage();
            s.initModality(Modality.APPLICATION_MODAL);
            s.setTitle("Buying Houses");
            
            Label infoLabel = new Label("How many houses would you like to buy on " + t.getName() + "?");
            infoLabel.setWrapText(true);
            
            infoLabel.setFont(new Font("Times New Roman", 30));
            
            Button one = new Button("One: $" + t.housePrice);
            Button two = new Button("Two: $" + 2*t.housePrice);
            Button three = new Button("Three: $" + 3*t.housePrice);
            Button four = new Button("Four: $" + 4*t.housePrice);
            one.setStyle("-fx-font: 20 times; -fx-base: Red;");
            two.setStyle("-fx-font: 20 times; -fx-base: Green;");
            three.setStyle("-fx-font: 20 times; -fx-base: Blue;");
            four.setStyle("-fx-font: 20 times; -fx-base: Yellow;");
            
            Button no = new Button("Exit");
            
            no.setStyle("-fx-font: 20 times; -fx-base: Red;");
            
            one.setOnAction(e ->
            {
                buyNumProps(1, t);
                s.close();
            });
            two.setOnAction(e ->
            {
                buyNumProps(2, t);
                s.close();
            });
            three.setOnAction(e ->
            {
                buyNumProps(3, t);
                s.close();
            });
            four.setOnAction(e ->
            {
                buyNumProps(4, t);
                s.close();
            });
            
            no.setOnAction(e ->
            {
                s.close();
            });
            
            VBox layout= new VBox(10);
            layout.getChildren().addAll(infoLabel);
            layout.setAlignment(Pos.CENTER);
            layout.getChildren().addAll(one, two, three, four);
            
            Scene scene1 = new Scene(layout, 750, 575);
            s.setScene(scene1);
            s.showAndWait();
        }
    }
    
    
    public void ownsTiles(Property [] TILES)
    {
        String group = TILES[getPosition()].getGroup();
        
        System.out.println(getPosition());
        
        Stage t = new Stage();
        t.initModality(Modality.APPLICATION_MODAL);
        t.setTitle("Properties");
        
        Label label = new Label(getName() + ", you currently own the following properties which can be built on:");
        label.setFont(new Font("Times New Roman", 20));
        
        VBox layout= new VBox(10);
        layout.getChildren().add(label);
        
        for(int i = 0; i < 40; i++)
        {
            Property prop = TILES[i];
            Button temp = new Button(TILES[i].getName());
            String color = colors[i];
            temp.setStyle(color);
            temp.setOnAction(e ->
            {
                buy(prop);
                t.close();
            });
            
            if(TILES[i].getOwner() == this && TILES[i].getName() != "Electric" && TILES[i].getName() != "Water" && TILES[i].getName() != "Night Nole" && TILES[i].getName() != "Garnet Bus" && TILES[i].getName() != "Gold Bus" && TILES[i].getName() != "Heritage Bus" )
            {
            		if(!TILES[i].isMort() && TILES[i].playerOwnsAll(this, TILES) && !TILES[i].hasHotel())
            			layout.getChildren().add(temp);
            }
        }
        
        Button exit = new Button("Exit");
        exit.setStyle("-fx-font: 20 times; -fx-base: Red;");
        
        exit.setOnAction(e ->
        {
            t.close();
        });
        
        layout.getChildren().add(exit);
        
        layout.setAlignment(Pos.CENTER);
        layout.setBackground(new Background(new BackgroundFill(Color.LIGHTGREEN, CornerRadii.EMPTY, Insets.EMPTY)));
        layout.setAlignment(Pos.CENTER);
        Scene scene1 = new Scene(layout, 750, 575);
        t.setScene(scene1);
        t.showAndWait();
        
    }
    
	
    public void noProperties(Player p)
    {
        Stage t = new Stage();
        t.initModality(Modality.APPLICATION_MODAL);
        t.setTitle("No Properties");
        
        Label infoLabel = new Label(p.getName() + ", you have no properties!");
        Label infoLabel2 = new Label("Buy some, ya filty animal!");
        
        infoLabel.setFont(new Font("Times New Roman", 30));
        infoLabel2.setFont(new Font("Times New Roman", 30));
        
        Button yes = new Button("Exit");
        yes.setStyle("-fx-font: 20 times; -fx-base: Red;");
        
        yes.setOnAction(e -> t.close());
        
        VBox layout= new VBox(10);
        layout.getChildren().addAll(infoLabel, infoLabel2);
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().add(yes);
        
        Scene scene1 = new Scene(layout, 750, 575);
        t.setScene(scene1);
        t.showAndWait();
    }
    
   
	// Special Functions
	//TODO: Finish ownershipMenu
	public void ownershipMenu(Property [] TILES)
	{
		Stage popupwindow = new Stage();
        popupwindow.initModality(Modality.APPLICATION_MODAL);
        popupwindow.setTitle(getName() + "'s Properties");
        
        Label infoLabel = new Label(getName() + "'s Properties");
        infoLabel.setFont(new Font("Times New Roman", 20));
        infoLabel.setWrapText(true);
        infoLabel.setTextAlignment(TextAlignment.JUSTIFY);
        
        VBox layout = new VBox(10);
        for(int i = 0; i < 40; i++)
        {
        		HBox hb = new HBox(); 
        		Label temp = new Label(TILES[i].getName());
        		hb.getChildren().add(temp);
        		hb.setBackground(new Background(new BackgroundFill(TILES[i].getColor(), CornerRadii.EMPTY, Insets.EMPTY)));
        		
        		if(TILES[i].getOwner() == this)
        		{
        			layout.getChildren().add(hb);
        		}
        }
       
        layout.setAlignment(Pos.CENTER);
        layout.setBackground(new Background(new BackgroundFill(Color.LIGHTGREEN, CornerRadii.EMPTY, Insets.EMPTY)));
        
        Scene scene1 = new Scene(layout, 750, 575);
        popupwindow.setScene(scene1);
        popupwindow.showAndWait();
	}
    
    
    
    public void buyNumProps(int nP, Property t)
    {
        Stage c = new Stage();
        Label label;
        Label priceLabel;
        
        
        int house = t.housePrice;
        
        if(t.houses + nP > 4)
        {
            c.initModality(Modality.APPLICATION_MODAL);
            c.setTitle("Purchasing Property");
            
            label = new Label("You can only purchase a maximum of 4 houses per property!");
            label.setFont(new Font("Times New Roman", 20));
            
            priceLabel = new Label("Please choose a different amount to purchase.");
            priceLabel.setFont(new Font("Times New Roman", 20));
        }
        
        else
        {
            for(int i = 0; i < nP; i++)
            {
                t.houses++;
            }
            
            c.initModality(Modality.APPLICATION_MODAL);
            c.setTitle("Purchasing Property");
            
            label = new Label("Congrats! You've purchased " + nP + " properties in this area!");
            label.setFont(new Font("Times New Roman", 20));
            
            spend(nP*house);
            
            priceLabel = new Label(getName() + " now has $" + getMoney() + " remaining in the budget!");
            label.setFont(new Font("Times New Roman", 15));
        }
            VBox payed = new VBox(10);
            
            payed.getChildren().add(label);
            payed.getChildren().add(priceLabel);
            payed.setAlignment(Pos.CENTER);
            payed.setStyle("-fx-background-color: #C4C4C4;");
            
            Scene scene = new Scene(payed, 750, 575);
            
            c.setScene(scene);
            
            c.showAndWait();
        
    }
}
