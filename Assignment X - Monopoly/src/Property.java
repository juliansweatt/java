import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.*;
import javafx.util.Duration;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import java.util.Random;
import javafx.scene.text.TextAlignment;
import javafx.animation.PauseTransition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import java.io.Serializable;

enum propertyTypes {ESTATE, CORNER, BUS, CHEST, CHANCE, TAX, UTILITY};

public class Property implements Serializable
{
	propertyTypes type;
	String name;
	int buyPrice;
	int baseRentPrice;
	public int hotelRentPrice;
	int houses = 0;
	boolean hotel = false;
	boolean mortgaged = false;
	String group;
	transient Image ICON;
	transient Color color;
	Player owner = new Player("NO OWNER");;
    public int numProps = 0;
    int housePrice;
    
	
	public Property() // Default Constructor (Used for build array call)
	{
	}
	
	public Property(propertyTypes t, String n, int bp, int brp, int hrp, String g, Image i) // Constructor for purchasable tiles
	{
		type = t;
		name = n;
		buyPrice = bp;
		baseRentPrice = brp;
		hotelRentPrice = hrp;
		group = g;
		ICON = i;
		mortgaged = false;
		houses = 0;
		hotel = false;
		owner = new Player("NO OWNER");
        numProps = 0;
		
		if( g == "CYAN")
        {
            color = Color.CYAN;
            housePrice = 50;
        }
        
		else if( g == "PINK")
        {
            color = Color.PINK;
            housePrice = 100;
        }
        
        else if( g == "ORANGE")
        {
            color = Color.ORANGE;
            housePrice = 100;
        }
        
		else if( g == "RED")
        {
			color = Color.INDIANRED;
            housePrice = 150;
        }
        
        else if( g == "YELLOW")
        {
			color = Color.YELLOW;
            housePrice = 150;
        }
        
		else if( g == "GREEN")
        {
			color = Color.GREEN;
            housePrice = 200;
        }
        
		else if( g == "BLUE")
        {
			color = Color.CORNFLOWERBLUE;
            housePrice = 200;
        }
		else if( g == "PURPLE")
        {
			color = Color.MEDIUMPURPLE;
            housePrice = 50;
        }
		else
			color = Color.GREY;
	}
	
	public Property(propertyTypes t, String n)		// Constructor for non-purchasable tiles
	{
		type = t;
		name = n;
        numProps = 0;
	}
	public Property(propertyTypes t, String n, Image i)		// Constructor for non-purchasable tiles
	{
		type = t;
		name = n;
		ICON = i;
        numProps = 0;
	}
	
	// Accessors
	public propertyTypes getType()
	{
		return type;
	}
	
	public String getName()
	{
		return name;
	}
	public int getBuyPrice()
	{
		return buyPrice;
	}
    
	public boolean playerOwnsAll(Player p,Property[] TILES)
	{
		int owns = playerOwns(p, TILES);
		
		if( group == "PURPLE")
		{
			if(owns == 2)
				return true;
		}
		else if( group == "CYAN" || group == "PINK" || group == "ORANGE" || group == "RED" || group == "YELLOW" || group == "GREEN" || group == "BLUE" || group == "BUS" || group == "UTILITY")
		{
			if(owns == 3)
				return true;
		}
		else
		{
			return false; 
		}
		return false;
	}
    
	public int playerOwns(Player p,Property[] TILES)		// Returns how many properties the player owns of this type
	{
		int total = 0;
		if( group == "PURPLE")
		{
			if(TILES[1].getOwner() == p)
            {
                total++;
            }
				
			if(TILES[3].getOwner() == p)
            {
                total++;
            }
		}
		else if( group == "CYAN")
		{
			if(TILES[6].getOwner() == p)
            {
                total++;
            }
            
			if(TILES[8].getOwner() == p)
            {
                total++;
            }
            
			if(TILES[9].getOwner() == p)
            {
                total++;
            }
		}
        
		else if( group == "PINK")
		{
			if(TILES[11].getOwner() == p)
            {
                total++;
            }
            
			if(TILES[13].getOwner() == p)
            {
                total++;
            }
            
			if(TILES[14].getOwner() == p)
            {
                total++;
            }
            
		}
		else if( group == "ORANGE")
		{
			if(TILES[16].getOwner() == p)
            {
                total++;
            }
            
			if(TILES[18].getOwner() == p)
            {
                total++;
            }
            
			if(TILES[19].getOwner() == p)
            {
                total++;
            }
            
		}
		else if( group == "RED")
		{
			if(TILES[21].getOwner() == p)
            {
                total++;
            }
            
			if(TILES[23].getOwner() == p)
            {
                total++;
            }
            
			if(TILES[24].getOwner() == p)
            {
                total++;
            }
            
		}
		else if( group == "YELLOW")
		{
			if(TILES[26].getOwner() == p)
            {
                total++;
            }
            
			if(TILES[27].getOwner() == p)
            {
                total++;
            }
            
			if(TILES[29].getOwner() == p)
            {
                total++;
            }
            
		}
		else if( group == "GREEN")
		{
			if(TILES[31].getOwner() == p)
            {
                total++;
            }
            
			if(TILES[32].getOwner() == p)
            {
                total++;
            }
            
			if(TILES[34].getOwner() == p)
            {
                total++;
            }
            
		}
		else if( group == "BLUE")
		{
			if(TILES[37].getOwner() == p)
            {
                total++;
            }
            
			if(TILES[39].getOwner() == p)
            {
                total++;
            }
            
		}
		else if( group == "BUS")
		{
			if(TILES[5].getOwner() == p)
            {
                total++;
            }
            
			if(TILES[15].getOwner() == p)
            {
                total++;
            }
            
			if(TILES[25].getOwner() == p)
            {
                total++;
            }
            
			if(TILES[35].getOwner() == p)
            {
                total++;
            }
            
		}
		else if( group == "UTILITY")
		{
			if(TILES[12].getOwner() == p)
            {
                total++;
            }
            
			if(TILES[28].getOwner() == p)
            {
                total++;
            }
            
		}
		else
		{
			// Do nothing
		}
		
		return total;
	}
    
    
	public int getBaseRentPrice()
	{
			return baseRentPrice;
	}
	public int getHotelRentPrice()
	{
		return hotelRentPrice;
	}
	public String getGroup()
	{
		return group; 
	}
	public Color getColor()
	{
		return color; 
	}
	public Image getICON()
	{
		return ICON; 
	}
	public Player getOwner()
	{
		return owner; 
	}
	public int getHouses()
	{
		return houses; 
	}
	public boolean hasHotel()
	{
		return hotel; 
	}
	public boolean isMort()
	{
		return mortgaged; 
	}
	public void setMort(boolean b)
	{
		mortgaged = b;
	}
	public void setHouses(int i)
	{
		houses = i;
	}
	public void setHotel(boolean b)
	{
		hotel = b;
	}
    
	// Mutators
	public boolean Purchase(Player player, int price)
	{
		if(price > player.getMoney())
			return false;				// Return false if player can't afford the proposed price
		else
		{
			player.spend(price);
			owner.gain(price);
			owner = player;
			return true;
		}
	}
	
	// Special Functions
	public int getRentPrice(Property[] TILES)
	{
		int owns = playerOwns(getOwner(),TILES);
		int rent = 0;
		
		if(group == "UTILITY")							// Util
		{
			Dice d = new Dice();
			int rollSum = d.rollDice() + d.rollDice();
			
			if(owns == 1)
			{
				rent = rollSum * 4;
			}
			else
			{
				rent = rollSum * 10;
			}
		}
		else if(group == "BUS")							// Transport
		{
			rent = baseRentPrice * owns;
		}
		else												// Colored Properties
		{
			if(isMort())
			{
				rent = (baseRentPrice / 2);
			}
			else
			{
				if(getHouses() == 0)
					rent = baseRentPrice;
				else if(getHouses() == 1)
					rent = baseRentPrice * 5;
				else if(getHouses() == 2)
					rent = (baseRentPrice * 5)*3;
				else if(getHouses() == 3)
					rent = (baseRentPrice * 5)*3*3;
				else if(getHouses() == 4)
					rent = (baseRentPrice * 5)*3*3*3;
				else if(hasHotel())
					rent = hotelRentPrice;
				else
					rent = baseRentPrice;
			}
			
			if(playerOwnsAll(getOwner(), TILES))
				rent = rent *2;
		}
		return rent;
	}
    
    public void showSales(Property p, Settings pref, int housesSold)
    {
        Player [] pl = new Monopoly().getPArray();
        Player player = pl[pref.getCurrentPlayer()];
        
        int remaining = 0;
        
        Stage t = new Stage();
        t.initModality(Modality.APPLICATION_MODAL);
        t.setTitle("Selling back to FSU");
        
        Label infoLabel = new Label("You sold " + housesSold + ". The School now refunds you $" + housesSold*p.housePrice/2);
        infoLabel.setFont(new Font("Times New Roman", 20));
        
        player.gain(housesSold*p.housePrice/2);
        
        remaining = p.houses - housesSold;
        p.houses = remaining;
        
        Label houseLabel = new Label("The number of houses remaining on this property: " + remaining);
        houseLabel.setFont(new Font("Times New Roman", 20));
        
               
        VBox layout = new VBox(10);
        layout.getChildren().addAll(infoLabel, houseLabel);
        layout.setAlignment(Pos.CENTER);
        
        Scene scene1 = new Scene(layout, 750, 575);
        t.setScene(scene1);
        t.showAndWait();
    }
    
    public void showPurchase(Property p, Settings pref, Player bought)
    {
        Player [] purchPlayer = new Monopoly().getPArray();
        Stage t = new Stage();
        t.initModality(Modality.APPLICATION_MODAL);
        t.setTitle("Buying From Other Player");
        
        Label infoLabel = new Label(bought.getName() + " acquired " + p.getName() + " from " + p.getOwner().getName());
        infoLabel.setFont(new Font("Times New Roman", 20));
        
        Label soldLabel = new Label(p.getOwner().getName() + "'s budget is now $" + (p.getOwner().getMoney() + p.buyPrice));
        soldLabel.setFont(new Font("Times New Roman", 20));
        
        Purchase(bought, p.buyPrice);
        
        Label buyLabel = new Label(bought.getName() + "'s budget is now $" + bought.getMoney());
        buyLabel.setFont(new Font("Times New Roman", 20));
        
        VBox layout = new VBox(10);
        layout.getChildren().addAll(infoLabel, soldLabel, buyLabel);
        layout.setAlignment(Pos.CENTER);
        
        Scene scene1 = new Scene(layout, 750, 575);
        t.setScene(scene1);
        t.showAndWait();
    }
    
    public void sellToSchool(Settings pref, Property p, Player [] PLAYERS)
    {
    		if(hasHotel())
    		{
    			Stage t = new Stage();
    	        t.initModality(Modality.APPLICATION_MODAL);
    	        t.setTitle("Selling back to FSU");
    	        
    	        int sellbackPrice = (baseRentPrice*5*4) + hotelRentPrice;
    	        
    	        Label infoLabel = new Label("Sell back your hotel for "+ (sellbackPrice) +"?");
    	        infoLabel.setFont(new Font("Times New Roman", 20));
    	        
    	        VBox layout = new VBox(10);
    	        layout.getChildren().addAll(infoLabel);
    	        
    	        Button yes = new Button("Yes");
    	        Button no = new Button("No");
    	        
            layout.getChildren().addAll(yes,no);
            
            yes.setOnAction(ex -> {
        		
        		PLAYERS[pref.currentPlayer].gain(sellbackPrice);
        		p.setHotel(false);
        		t.close();
        });
            no.setOnAction(ex -> {
        		// Do nothing
        		t.close();
        });
     
    	        layout.setAlignment(Pos.CENTER);

    	        Scene scene1 = new Scene(layout, 750, 575);
    	        t.setScene(scene1);
    	        t.showAndWait();
    		}
    		else
    		{
    	        Stage t = new Stage();
    	        t.initModality(Modality.APPLICATION_MODAL);
    	        t.setTitle("Selling back to FSU");
    	        
    	        Label infoLabel = new Label("How many houses would you like to sell back?");
    	        infoLabel.setFont(new Font("Times New Roman", 20));
    	        
    	        VBox layout = new VBox(10);
    	        layout.getChildren().addAll(infoLabel);
    	        
    	        Button one, two, three, four;
    	        
    	            if(p.houses == 1)
    	            {
    	                one = new Button("One : $" + p.housePrice/2);
    	                one.setOnAction(e->{ showSales(p, pref, 1); t.close(); PLAYERS[pref.currentPlayer].gain(p.housePrice/2);});
    	                layout.getChildren().add(one);
    	            }
    	            
    	            if(p.houses == 2)
    	            {
    	                one = new Button("One : $" + p.housePrice/2);
    	                one.setOnAction(e->{ showSales(p, pref, 1); t.close(); PLAYERS[pref.currentPlayer].gain(p.housePrice/2);});
    	                two = new Button("Two : $" + 2*p.housePrice/2);
    	                two.setOnAction(e->{ showSales(p, pref, 2); t.close(); PLAYERS[pref.currentPlayer].gain(2*p.housePrice/2);});
    	                layout.getChildren().addAll(one, two);
    	            }
    	            
    	            if(p.houses == 3)
    	            {
    	                one = new Button("One : $" + p.housePrice/2);
    	                one.setOnAction(e->{ showSales(p, pref, 1); t.close(); PLAYERS[pref.currentPlayer].gain(p.housePrice/2);});
    	                two = new Button("Two : $" + 2*p.housePrice/2);
    	                two.setOnAction(e->{ showSales(p, pref, 2); t.close(); PLAYERS[pref.currentPlayer].gain(2*p.housePrice/2);});
    	                three = new Button("Three: $" + 3*p.housePrice/2);
    	                three.setOnAction(e->{ showSales(p, pref, 3); t.close(); PLAYERS[pref.currentPlayer].gain(3*p.housePrice/2);});
    	                
    	                layout.getChildren().addAll(one, two, three);
    	            }
    	            
    	            if(p.houses == 4)
    	            {
    	                one = new Button("One : $" + p.housePrice/2);
    	                one.setOnAction(e->{ showSales(p, pref, 1); t.close(); PLAYERS[pref.currentPlayer].gain(p.housePrice/2);});
    	                two = new Button("Two : $" + 2*p.housePrice/2);
    	                two.setOnAction(e->{ showSales(p, pref, 2); t.close(); PLAYERS[pref.currentPlayer].gain(2*p.housePrice/2);});
    	                three = new Button("Three: $" + 3*p.housePrice/2);
    	                three.setOnAction(e->{ showSales(p, pref, 3); t.close(); PLAYERS[pref.currentPlayer].gain(3*p.housePrice/2);});
    	                four = new Button("Four : $" + 4*p.housePrice/2);
    	                four.setOnAction(e->{ showSales(p, pref, 4); t.close(); PLAYERS[pref.currentPlayer].gain(4*p.housePrice/2);});
    	                
    	                layout.getChildren().addAll(one, two, three, four);
    	            }
    	            

    	        layout.setAlignment(Pos.CENTER);

    	        Scene scene1 = new Scene(layout, 750, 575);
    	        t.setScene(scene1);
    	        t.showAndWait();
    		}
    }
    
    public void willPlayerBuy(Settings pref, Property TILES, Player buying)
    {
        Stage t = new Stage();
        t.initModality(Modality.APPLICATION_MODAL);
        t.setTitle("Player Buying Other's Property");
        
        Label infoLabel = new Label(buying.getName() + ", would you like to acquire " + TILES.getName() + " from " + TILES.getOwner().getName()  + "?");
        infoLabel.setFont(new Font("Times New Roman", 20));
        
        Button yes = new Button("Yes");
        yes.setStyle("-fx-font: 20 times; -fx-base: green;");
        Button no = new Button("No");
        no.setStyle("-fx-font: 20 times; -fx-base: red;");
        
        yes.setOnAction(e-> {showPurchase(TILES, pref, buying); t.close();});
        no.setOnAction(e->t.close());
        
        
        VBox layout = new VBox(10);
        layout.getChildren().addAll(infoLabel, yes, no);
         layout.setAlignment(Pos.CENTER);
        Scene scene1 = new Scene(layout, 750, 575);
        t.setScene(scene1);
        t.showAndWait();
    }
    
    /*public void sellToPlayer(Settings pref, Property TILES)
    {
        Player [] p = new Monopoly().getPArray();
        
        Stage t = new Stage();
        t.initModality(Modality.APPLICATION_MODAL);
        t.setTitle("Selling Property");
        
        Label infoLabel = new Label("To which player would you like to sell?");
        infoLabel.setFont(new Font("Times New Roman", 20));
        
        VBox layout = new VBox(10);
        layout.getChildren().addAll(infoLabel);
        
        for(int i = 0; i < pref.getPlayerCount(); i++)
        {
            Player buying = p[i];
            Button toPlayer = new Button(p[i].getName());
            toPlayer.setOnAction(e->
            {
                willPlayerBuy(pref, TILES, buying);
                t.close();
            });
            
            if(p[i].getName() != p[pref.getCurrentPlayer()].getName())
            {
                layout.getChildren().add(toPlayer);
            }
        }
        layout.setAlignment(Pos.CENTER);
        
        Scene scene1 = new Scene(layout, 750, 575);
        t.setScene(scene1);
        t.showAndWait();
    }*/
	
	public void auction(Player [] PLAYERS, Settings pref)
	{
		Stage auctionWindow = new Stage();
		auctionWindow.initModality(Modality.APPLICATION_MODAL);
        auctionWindow.setTitle("Auction");
        
        Label infoLabel = new Label(getName() + " is up for auction to the highest bidder!");
        
        Button yes = new Button("Confirm");
        yes.setStyle("-fx-font: 20 times; -fx-base: green;");
        
        VBox layout= new VBox(10);
        layout.getChildren().add(infoLabel);
        layout.setAlignment(Pos.CENTER);
        layout.setBackground(new Background(new BackgroundFill(getColor(), CornerRadii.EMPTY, Insets.EMPTY)));
   
        Slider slider0 = new Slider();
        Slider slider1 = new Slider();
        Slider slider2 = new Slider();
        Slider slider3 = new Slider();
        Slider slider4 = new Slider();
        Slider slider5 = new Slider();
        Label sMax0 = new Label("0");
        Label sMax1 = new Label("0");
        Label sMax2 = new Label("0");
        Label sMax3 = new Label("0");
        Label sMax4 = new Label("0");
        Label sMax5 = new Label("0");
        
        if(pref.playerCount == 2)
        {
        		HBox temp0 = new HBox();
        		HBox temp1 = new HBox();
        		temp0.setAlignment(Pos.CENTER);
        		temp1.setAlignment(Pos.CENTER);

        		slider0.setMin(0);
        		slider0.setMax(PLAYERS[0].getMoney());
        		temp0.getChildren().addAll(new Label(PLAYERS[0].getName()),slider0, sMax0);
            layout.getChildren().add(temp0);
            
            slider1.setMin(0);
    			slider1.setMax(PLAYERS[1].getMoney());
    			temp1.getChildren().addAll(new Label(PLAYERS[1].getName()),slider1, sMax1);
    			layout.getChildren().add(temp1);
        }
        if(pref.playerCount == 3 )
        {
    			HBox temp0 = new HBox();
    			HBox temp1 = new HBox();
    			HBox temp2 = new HBox();
    			temp0.setAlignment(Pos.CENTER);
    			temp1.setAlignment(Pos.CENTER);
    			temp2.setAlignment(Pos.CENTER);

    			slider0.setMin(0);
    			slider0.setMax(PLAYERS[0].getMoney());
    			temp0.getChildren().addAll(new Label(PLAYERS[0].getName()),slider0, sMax0);
    			layout.getChildren().add(temp0);
        
        		slider1.setMin(0);
			slider1.setMax(PLAYERS[1].getMoney());
			temp1.getChildren().addAll(new Label(PLAYERS[1].getName()),slider1, sMax1);
			layout.getChildren().add(temp1);
			
			slider2.setMin(0);
			slider2.setMax(PLAYERS[2].getMoney());
			temp2.getChildren().addAll(new Label(PLAYERS[2].getName()),slider2, sMax2);
			layout.getChildren().add(temp2);
        }
        if(pref.playerCount == 4 )
        {
			HBox temp0 = new HBox();
			HBox temp1 = new HBox();
			HBox temp2 = new HBox();
			HBox temp3 = new HBox();
			temp0.setAlignment(Pos.CENTER);
			temp1.setAlignment(Pos.CENTER);
			temp2.setAlignment(Pos.CENTER);
			temp3.setAlignment(Pos.CENTER);

			slider0.setMin(0);
			slider0.setMax(PLAYERS[0].getMoney());
			temp0.getChildren().addAll(new Label(PLAYERS[0].getName()),slider0, sMax0);
			layout.getChildren().add(temp0);
    
    			slider1.setMin(0);
    			slider1.setMax(PLAYERS[1].getMoney());
    			temp1.getChildren().addAll(new Label(PLAYERS[1].getName()),slider1, sMax1);
    			layout.getChildren().add(temp1);
		
    			slider2.setMin(0);
    			slider2.setMax(PLAYERS[2].getMoney());
    			temp2.getChildren().addAll(new Label(PLAYERS[2].getName()),slider2, sMax2);
    			layout.getChildren().add(temp2);
    			
    			slider3.setMin(0);
    			slider3.setMax(PLAYERS[3].getMoney());
    			temp3.getChildren().addAll(new Label(PLAYERS[3].getName()),slider3, sMax3);
    			layout.getChildren().add(temp3);
        }
        if(pref.playerCount == 5 )
        {
			HBox temp0 = new HBox();
			HBox temp1 = new HBox();
			HBox temp2 = new HBox();
			HBox temp3 = new HBox();
			HBox temp4 = new HBox();
			temp0.setAlignment(Pos.CENTER);
			temp1.setAlignment(Pos.CENTER);
			temp2.setAlignment(Pos.CENTER);
			temp3.setAlignment(Pos.CENTER);
			temp4.setAlignment(Pos.CENTER);

			slider0.setMin(0);
			slider0.setMax(PLAYERS[0].getMoney());
			temp0.getChildren().addAll(new Label(PLAYERS[0].getName()),slider0, sMax0);
			layout.getChildren().add(temp0);
    
    			slider1.setMin(0);
    			slider1.setMax(PLAYERS[1].getMoney());
    			temp1.getChildren().addAll(new Label(PLAYERS[1].getName()),slider1, sMax1);
    			layout.getChildren().add(temp1);
		
    			slider2.setMin(0);
    			slider2.setMax(PLAYERS[2].getMoney());
    			temp2.getChildren().addAll(new Label(PLAYERS[2].getName()),slider2, sMax2);
    			layout.getChildren().add(temp2);
    			
    			slider3.setMin(0);
    			slider3.setMax(PLAYERS[3].getMoney());
    			temp3.getChildren().addAll(new Label(PLAYERS[3].getName()),slider3, sMax3);
    			layout.getChildren().add(temp3);
    			
    			slider4.setMin(0);
    			slider4.setMax(PLAYERS[4].getMoney());
    			temp4.getChildren().addAll(new Label(PLAYERS[4].getName()),slider4, sMax4);
    			layout.getChildren().add(temp4);
        }
        if(pref.playerCount == 6 )
        {
			HBox temp0 = new HBox();
			HBox temp1 = new HBox();
			HBox temp2 = new HBox();
			HBox temp3 = new HBox();
			HBox temp4 = new HBox();
			HBox temp5 = new HBox();
			temp0.setAlignment(Pos.CENTER);
			temp1.setAlignment(Pos.CENTER);
			temp2.setAlignment(Pos.CENTER);
			temp3.setAlignment(Pos.CENTER);
			temp4.setAlignment(Pos.CENTER);
			temp5.setAlignment(Pos.CENTER);

			slider0.setMin(0);
			slider0.setMax(PLAYERS[0].getMoney());
			temp0.getChildren().addAll(new Label(PLAYERS[0].getName()),slider0, sMax0);
			layout.getChildren().add(temp0);
    
    			slider1.setMin(0);
    			slider1.setMax(PLAYERS[1].getMoney());
    			temp1.getChildren().addAll(new Label(PLAYERS[1].getName()),slider1, sMax1);
    			layout.getChildren().add(temp1);
		
    			slider2.setMin(0);
    			slider2.setMax(PLAYERS[2].getMoney());
    			temp2.getChildren().addAll(new Label(PLAYERS[2].getName()),slider2, sMax2);
    			layout.getChildren().add(temp2);
    			
    			slider3.setMin(0);
    			slider3.setMax(PLAYERS[3].getMoney());
    			temp3.getChildren().addAll(new Label(PLAYERS[3].getName()),slider3, sMax3);
    			layout.getChildren().add(temp3);
    			
    			slider4.setMin(0);
    			slider4.setMax(PLAYERS[4].getMoney());
    			temp4.getChildren().addAll(new Label(PLAYERS[4].getName()),slider4, sMax4);
    			layout.getChildren().add(temp4);
    			
    			slider5.setMin(0);
    			slider5.setMax(PLAYERS[5].getMoney());
    			temp5.getChildren().addAll(new Label(PLAYERS[5].getName()),slider5, sMax5);
    			layout.getChildren().add(temp5);
        }
        
        //https://docs.oracle.com/javafx/2/ui_controls/progress.htm
        slider0.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov,
                Number old_val, Number new_val) {
            		int round = new_val.intValue();
                sMax0.setText(String.valueOf(round));
            }
        });
        slider1.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov,
                Number old_val, Number new_val) {
            		int round = new_val.intValue();
                sMax1.setText(String.valueOf(round));
            }
        });
        slider2.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov,
                Number old_val, Number new_val) {
            		int round = new_val.intValue();
                sMax2.setText(String.valueOf(round));
            }
        });
        slider3.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov,
                Number old_val, Number new_val) {
            		int round = new_val.intValue();
                sMax3.setText(String.valueOf(round));
            }
        });
        slider4.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov,
                Number old_val, Number new_val) {
            		int round = new_val.intValue();
                sMax4.setText(String.valueOf(round));
            }
        });
        slider5.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov,
                Number old_val, Number new_val) {
            		int round = new_val.intValue();
                sMax5.setText(String.valueOf(round));
            }
        });
        
        yes.setOnAction(e -> {
        		int highestBid = 0;
        		int hbPlayerNumber = -1;
	        	
	    		int s0 = (int)slider0.getValue();
	    		int s1 = (int)slider1.getValue();
	    		int s2 = (int)slider2.getValue();
	    		int s3 = (int)slider3.getValue();
	    		int s4 = (int)slider4.getValue();
	    		int s5 = (int)slider5.getValue();
	    		
	    		if(s0 > highestBid)
	    		{
	    			highestBid = s0;
	    			hbPlayerNumber = 0;
	    		}
	    		if(s1 > highestBid)
	    		{
	    			highestBid = s1;
	    			hbPlayerNumber = 1;
	    		}
	    		if(s2 > highestBid)
	    		{
	    			highestBid = s2;
	    			hbPlayerNumber = 2;
	    		}
	    		if(s3 > highestBid)
	    		{
	    			highestBid = s3;
	    			hbPlayerNumber = 3;
	    		}
	    		if(s4 > highestBid)
	    		{
	    			highestBid = s4;
	    			hbPlayerNumber = 4;
	    		}
	    		if(s5 > highestBid)
	    		{
	    			highestBid = s5;
	    			hbPlayerNumber = 5;
	    		}
	    		
	    		if(!getOwner().isHuman || highestBid == 0)
	    		{
	    			if(hbPlayerNumber != -1)
                    {
	    				Purchase(PLAYERS[hbPlayerNumber], highestBid);
                        PLAYERS[hbPlayerNumber].propertiesOwned++;
                    }
	    			
	    			Stage secondary = new Stage();
	    			secondary.initModality(Modality.APPLICATION_MODAL);
	    			secondary.setTitle("Auction Results");
	            
	    			Label label2 = new Label();
	    			if(hbPlayerNumber == -1)
	    				label2 = new Label("No Bids! No changes made.");
	    			else
	    				label2 = new Label(PLAYERS[hbPlayerNumber].getName() + " won the bid for $" + highestBid);
	    		    label2.setFont(new Font("Times New Roman", 20));
	    		    label2.setWrapText(true);
	    		    label2.setTextAlignment(TextAlignment.JUSTIFY);
	    	        
	    		    VBox layout1= new VBox(10);
	    		    layout1.getChildren().addAll(label2);
	    		    layout1.setAlignment(Pos.CENTER);
	    		    layout1.setBackground(new Background(new BackgroundFill(Color.LIGHTGREEN, CornerRadii.EMPTY, Insets.EMPTY)));
	    	        
	    		    Scene scene1 = new Scene(layout1, 400, 75);
	    		    secondary.setScene(scene1);
	    		    secondary.show();
	    		    PauseTransition wait = new PauseTransition(Duration.seconds(2));
	    		    wait.setOnFinished( ex ->secondary.close());
	    		    wait.play();
	    		}
	    		else
	    		{
	    			// TODO: Allow owner to decline the bid here if user is still alive
	    			Purchase(PLAYERS[hbPlayerNumber], highestBid);
	    			
	    			Stage secondary = new Stage();
	    			secondary.initModality(Modality.APPLICATION_MODAL);
	    			secondary.setTitle("Auction Results");
	            
	    			Label label2 = new Label();
	    			if(hbPlayerNumber == -1)
	    				label2 = new Label("No Bids! No changes made.");
	    			else
	    				label2 = new Label(PLAYERS[hbPlayerNumber].getName() + " won the bid for $" + highestBid);
	    		    label2.setFont(new Font("Times New Roman", 20));
	    		    label2.setWrapText(true);
	    		    label2.setTextAlignment(TextAlignment.JUSTIFY);
                    
                    Button exit = new Button("Exit");
                    exit.setOnAction(o -> secondary.close());
	    	        
	    		    VBox layout1= new VBox(10);
	    		    layout1.getChildren().addAll(label2);
	    		    layout1.setAlignment(Pos.CENTER);
	    		    layout1.setBackground(new Background(new BackgroundFill(Color.LIGHTGREEN, CornerRadii.EMPTY, Insets.EMPTY)));
	    	        
	    		    Scene scene1 = new Scene(layout1, 400, 75);
	    		    secondary.setScene(scene1);
	    		    secondary.show();
	    		    PauseTransition wait = new PauseTransition(Duration.seconds(2));
	    		    wait.setOnFinished( ex ->secondary.close());
	    		    wait.play();
	    		}
	    		auctionWindow.close();
        });
        
        
        layout.getChildren().add( yes);
        
        Scene scene1 = new Scene(layout, 750, 575);
        auctionWindow.setScene(scene1);
        auctionWindow.showAndWait();
	}
	
	public void processProperty(Player [] PLAYERS, Settings pref, Property [] TILES)
	{
		if(type == propertyTypes.ESTATE || type == propertyTypes.UTILITY || type == propertyTypes.BUS)
		{
			Stage popupwindow = new Stage();
			
			if(!getOwner().isHuman)		// Runs first-time buyer function only if the property is unowned
			{
		        popupwindow.initModality(Modality.APPLICATION_MODAL);
		        popupwindow.setTitle(getName());
		        
		        Button yes = new Button("Yes");
		        Button no = new Button("No");
		        
		        yes.setStyle("-fx-font: 20 times; -fx-base: green;");
		        no.setStyle("-fx-font: 20 times; -fx-base: red;");

		        // Conditional
		        Label infoLabel = new Label("This property is for sale! If you do not buy the property, it will go up for auction.");
		        playerOwns(PLAYERS[pref.getCurrentPlayer()],TILES);
		        
		        VBox ownership = new VBox(); 
		        ownership.setAlignment(Pos.CENTER);
		        for(int i = 0; i < pref.getPlayerCount(); i++)
		        {
		        		Label ownerInfo = new Label (PLAYERS[i].getName() +" owns " + TILES[PLAYERS[pref.getCurrentPlayer()].getPosition()].playerOwns(PLAYERS[i],TILES) + " " + group + " properties. ");
		        		ownerInfo.setWrapText(true);
		        		ownerInfo.setTextAlignment(TextAlignment.JUSTIFY);
		        		ownership.getChildren().add(ownerInfo);
		        }
		        
		        
		        Label label1 = new Label("Would you like to purchase "+ getName() +" for $" + getBuyPrice()+"?");
		        Label moneyInfo = new Label( PLAYERS[pref.currentPlayer].getName() + " has $" + PLAYERS[pref.currentPlayer].getMoney() + " and will have $" + (PLAYERS[pref.currentPlayer].getMoney() - getBuyPrice()) + " remaining after this purchase.");
		        if((PLAYERS[pref.currentPlayer].getMoney() - getBuyPrice()) < 0)
		        {
		        		moneyInfo.setText(PLAYERS[pref.currentPlayer].getName() + " doesn't have enough money to purchase this property.");
		        		yes.setDisable(true);
		        		yes.setVisible(false);
		        }
		        label1.setFont(new Font("Times New Roman", 20));
		        label1.setWrapText(true);
		        label1.setTextAlignment(TextAlignment.JUSTIFY);
		        infoLabel.setFont(new Font("Times New Roman", 20));
		        infoLabel.setWrapText(true);
		        infoLabel.setTextAlignment(TextAlignment.JUSTIFY);
		        
		        yes.setOnAction(e -> {
		        		Purchase(PLAYERS[pref.currentPlayer], getBuyPrice());
                        PLAYERS[pref.currentPlayer].propertiesOwned++;
		        		popupwindow.close();
		        });
		        no.setOnAction(e -> 
		        {
		        		auction(PLAYERS, pref);
		        		popupwindow.close();
		        });
		        
		        HBox buttonBox = new HBox(yes,no);
		        buttonBox.setAlignment(Pos.CENTER);
		        
		        ImageView propertyImage = new ImageView();
		        
		        propertyImage.setImage(getICON());
		        propertyImage.setFitWidth(500);
		        propertyImage.setFitHeight(250);
		        Label label2 = new Label(getName());
		        label2.setFont(new Font("Times New Roman", 20));
		        
		        VBox layout= new VBox(10);
		        layout.getChildren().addAll(infoLabel,label1, ownership, moneyInfo, buttonBox, propertyImage, label2);
		        layout.setAlignment(Pos.CENTER);
		        layout.setBackground(new Background(new BackgroundFill(getColor(), CornerRadii.EMPTY, Insets.EMPTY)));
		        
		        Scene scene1 = new Scene(layout, 750, 575);
		        popupwindow.setScene(scene1);
		        popupwindow.showAndWait();
			}
			
			else if(owner == PLAYERS[pref.currentPlayer])	// Tell player no action is required if they own the tile
			{
				popupwindow.initModality(Modality.APPLICATION_MODAL);
		        popupwindow.setTitle(getName());
		        Label label1 = new Label("You own this tile! Free rent!");
		        label1.setFont(new Font("Times New Roman", 20));
		        label1.setWrapText(true);
		        label1.setTextAlignment(TextAlignment.JUSTIFY);
                Button exit = new Button("Exit");
                exit.setStyle("-fx-font: 20 times; -fx-base: red;");
                exit.setOnAction(v -> popupwindow.close());
		        
		        VBox layout= new VBox(10);
		        layout.getChildren().addAll(label1);
		        layout.setAlignment(Pos.CENTER);
		        layout.setBackground(new Background(new BackgroundFill(getColor(), CornerRadii.EMPTY, Insets.EMPTY)));
		        
		        Scene scene1 = new Scene(layout, 250, 100);
		        popupwindow.setScene(scene1);
		        popupwindow.show();
		        PauseTransition wait = new PauseTransition(Duration.seconds(2));
		        wait.setOnFinished( e ->popupwindow.close());
		        wait.play();
			}
			else												// Tile is owned by another player, pay rent
			{
				if(!isMort())
				{
					popupwindow.initModality(Modality.APPLICATION_MODAL);
			        popupwindow.setTitle(getName());
			        
			        Button yes = new Button("Pay Rent");
			        Button no = new Button("Sell");				// Todo: Implement selling assets
			        
			        yes.setStyle("-fx-font: 20 times; -fx-base: green;");
			        no.setStyle("-fx-font: 20 times; -fx-base: blue;");

			        // Conditional
			        Label infoLabel = new Label(getName() + " is owned by " + getOwner().getName());
			        
			        String mString;
			        mString = "Property has " + houses + " houses, ";
			        if(hasHotel())
			        		mString += "a ";
			        else
			        		mString += "no ";
			        mString += "hotel, ";
			        
			        mString += "and " + getOwner().getName() + " owns " + TILES[PLAYERS[pref.getCurrentPlayer()].getPosition()].playerOwns(getOwner(),TILES) + " " + getGroup() + " properties.";
			        Label multiplierInfo = new Label(mString);
			        multiplierInfo.setWrapText(true);
			        
			        Label label1 = new Label("You must pay rent! Rent is $" + getRentPrice(TILES));
			        Label moneyInfo = new Label( PLAYERS[pref.currentPlayer].getName() + " has $" + PLAYERS[pref.currentPlayer].getMoney() + " and will have $" + (PLAYERS[pref.currentPlayer].getMoney() - getRentPrice(TILES)) + " remaining after this purchase.");
			        if((PLAYERS[pref.currentPlayer].getMoney() - getRentPrice(TILES)) < 0)
			        {
			        		moneyInfo.setText(PLAYERS[pref.currentPlayer].getName() + " doesn't have enough money to pay rent. Press Sell to see what you can sell.");
			        		yes.setDisable(true);
			        		yes.setVisible(false);
			        }
			        label1.setFont(new Font("Times New Roman", 20));
			        label1.setWrapText(true);
			        label1.setTextAlignment(TextAlignment.JUSTIFY);
			        infoLabel.setFont(new Font("Times New Roman", 20));
			        infoLabel.setWrapText(true);
			        infoLabel.setTextAlignment(TextAlignment.JUSTIFY);
			        
			        yes.setOnAction(e -> {
			        		PLAYERS[pref.currentPlayer].spend(getRentPrice(TILES));
			        		getOwner().gain(getRentPrice(TILES));
			        		popupwindow.close();
			        });
			        no.setOnAction(e -> 
			        {
			        		PLAYERS[pref.currentPlayer].Assets(TILES,PLAYERS, false);
			        });
			        
			        HBox buttonBox = new HBox(yes,no);
			        buttonBox.setAlignment(Pos.CENTER);
			        
			        ImageView propertyImage = new ImageView();
			        
			        propertyImage.setImage(getICON());
			        propertyImage.setFitWidth(500);
			        propertyImage.setFitHeight(250);
			        Label label2 = new Label(getName());
			        label2.setFont(new Font("Times New Roman", 20));
			        
			        VBox layout= new VBox(10);
			        layout.getChildren().addAll(infoLabel, label1, multiplierInfo, moneyInfo, buttonBox, propertyImage, label2);
			        layout.setAlignment(Pos.CENTER);
			        layout.setBackground(new Background(new BackgroundFill(getColor(), CornerRadii.EMPTY, Insets.EMPTY)));
			        
			        Scene scene1 = new Scene(layout, 750, 575);
			        popupwindow.setScene(scene1);
			        popupwindow.showAndWait();
				}
				else
				{
					popupwindow.initModality(Modality.APPLICATION_MODAL);
			        popupwindow.setTitle(getName());
			        Label label1 = new Label("This property is mortgaged! Free rent!");
			        label1.setFont(new Font("Times New Roman", 20));
			        label1.setWrapText(true);
			        label1.setTextAlignment(TextAlignment.JUSTIFY);
	                Button exit = new Button("Exit");
	                exit.setStyle("-fx-font: 20 times; -fx-base: red;");
	                exit.setOnAction(v -> popupwindow.close());
			        
			        VBox layout= new VBox(10);
			        layout.getChildren().addAll(label1);
			        layout.setAlignment(Pos.CENTER);
			        layout.setBackground(new Background(new BackgroundFill(getColor(), CornerRadii.EMPTY, Insets.EMPTY)));
			        
			        Scene scene1 = new Scene(layout, 250, 100);
			        popupwindow.setScene(scene1);
			        popupwindow.show();
			        PauseTransition wait = new PauseTransition(Duration.seconds(2));
			        wait.setOnFinished( e ->popupwindow.close());
			        wait.play();
				}
			}
		}
		else if(type == propertyTypes.CORNER)
		{
			if(PLAYERS[pref.currentPlayer].getPosition() == 30)
			{
				Stage popupwindow = new Stage();
				popupwindow.initModality(Modality.APPLICATION_MODAL);
		        popupwindow.setTitle(getName());
		        
				popupwindow.initModality(Modality.APPLICATION_MODAL);
		        popupwindow.setTitle(getName());
		        Label label1 = new Label("YOU'VE BEEN JAILED!");
		        label1.setFont(new Font("Times New Roman", 20));
		        label1.setWrapText(true);
		        label1.setTextAlignment(TextAlignment.JUSTIFY);
		        
		        VBox layout= new VBox(10);
		        layout.getChildren().addAll(label1);
		        layout.setAlignment(Pos.CENTER);
		        layout.setBackground(new Background(new BackgroundFill(Color.INDIANRED, CornerRadii.EMPTY, Insets.EMPTY)));
		        
		        Scene scene1 = new Scene(layout, 250, 100);
		        popupwindow.setScene(scene1);
		        popupwindow.show();
		        PauseTransition wait = new PauseTransition(Duration.seconds(2));
		        wait.setOnFinished( e ->popupwindow.close());
		        wait.play();
		        
				PLAYERS[pref.currentPlayer].setJailed(true);
			}
			if(PLAYERS[pref.currentPlayer].getPosition() == 10 && PLAYERS[pref.getCurrentPlayer()].getJailed())
			{
				Stage popupwindow = new Stage();
				popupwindow.initModality(Modality.APPLICATION_MODAL);
		        popupwindow.setTitle(getName());
		        
		        Button payFine = new Button("Pay Fine");
		        Button skipTurn = new Button("Skip Turn");
		        
		        payFine.setStyle("-fx-font: 20 times; -fx-base: green;");
		        skipTurn.setStyle("-fx-font: 20 times; -fx-base: blue;");
		        Button getOutFree = new Button("Use Jail Card");
		        getOutFree.setStyle("-fx-font: 20 times; -fx-base: yellow;");

		        // Conditional
		        Label infoLabel = new Label("You're in jail and your roll was not a double!");    
		        Label label1 = new Label("You may roll a double OR, use a jail card, OR pay $50 to get out of jail, or skip your turn.");
		        Label moneyInfo = new Label( PLAYERS[pref.currentPlayer].getName() + " has $" + PLAYERS[pref.currentPlayer].getMoney() + " and will have $" + (PLAYERS[pref.currentPlayer].getMoney() - 50) + " remaining after paying fines.");
		        if((PLAYERS[pref.currentPlayer].getMoney() - 50) < 0)
		        {
		        		moneyInfo.setText(PLAYERS[pref.currentPlayer].getName() + " doesn't have enough money to pay the fine.");
		        		payFine.setDisable(true);
		        		payFine.setVisible(false);
		        }
		        label1.setFont(new Font("Times New Roman", 20));
		        label1.setWrapText(true);
		        label1.setTextAlignment(TextAlignment.JUSTIFY);
		        infoLabel.setFont(new Font("Times New Roman", 20));
		        infoLabel.setWrapText(true);
		        infoLabel.setTextAlignment(TextAlignment.JUSTIFY);
		        
		        
		        payFine.setOnAction(e -> {
		        		PLAYERS[pref.currentPlayer].spend(50);
		        		PLAYERS[pref.currentPlayer].setJailed(false);
		        		PLAYERS[pref.currentPlayer].setPosition(10);
		        		
		        		Stage secondary = new Stage();
					secondary.initModality(Modality.APPLICATION_MODAL);
					secondary.setTitle(getName());
				        
					secondary.initModality(Modality.APPLICATION_MODAL);
					secondary.setTitle(getName());
				    Label label2 = new Label("You've been freed!");
				    label2.setFont(new Font("Times New Roman", 20));
				    label2.setWrapText(true);
				    label2.setTextAlignment(TextAlignment.JUSTIFY);
				    
	                Button exit = new Button("Exit");
	                exit.setStyle("-fx-font: 20 times; -fx-base: red;");
	                exit.setOnAction(v -> popupwindow.close());
				        
				    VBox layout= new VBox(10);
				    layout.getChildren().addAll(label2,exit);
				    layout.setAlignment(Pos.CENTER);
				    layout.setBackground(new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));
				        
				    Scene scene1 = new Scene(layout, 250, 100);
				    secondary.setScene(scene1);
				    secondary.show();
				    PauseTransition wait = new PauseTransition(Duration.seconds(2));
				    wait.setOnFinished( ex ->secondary.close());
				    wait.play();
				        
		        		popupwindow.close();
		        });
		        skipTurn.setOnAction(e -> 
		        {
		        		// Do nothing
		        		popupwindow.close();
		        });
		        
                if(PLAYERS[pref.currentPlayer].jailCard == 0)
                {
                    getOutFree.setOnAction(e ->
                                           {
                                               Stage secondary = new Stage();
                                               secondary.initModality(Modality.APPLICATION_MODAL);
                                               secondary.setTitle(getName());
                                               Label label2 = new Label("Nice try, Gator fan!");
                                               label2.setFont(new Font("Times New Roman", 20));
                                               label2.setWrapText(true);
                                               label2.setTextAlignment(TextAlignment.JUSTIFY);
                                               Button g = new Button("Try Again");
                                               g.setStyle("-fx-font: 20 times; -fx-base: red;");
                                               g.setOnAction(f-> secondary.close());
                                               
                                               VBox layout= new VBox(10);
                                               layout.getChildren().addAll(label2, g);
                                               layout.setAlignment(Pos.CENTER);
                                               layout.setBackground(new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));
                                               
                                               Scene scene1 = new Scene(layout, 250, 100);
                                               secondary.setScene(scene1);
                                               secondary.show();
                                           }
                                           
                                           );
                }
                
                else
                {
                    getOutFree.setOnAction(e ->
                                           {
                                           Stage secondary = new Stage();
                                           secondary.initModality(Modality.APPLICATION_MODAL);
                                           secondary.setTitle(getName());
                                           Label label2 = new Label("You've been freed!");
                                           label2.setFont(new Font("Times New Roman", 20));
                                           label2.setWrapText(true);
                                           label2.setTextAlignment(TextAlignment.JUSTIFY);
                                           
                                           Button exit = new Button("Exit");
                                           exit.setStyle("-fx-font: 20 times; -fx-base: red;");
                                           exit.setOnAction(v -> popupwindow.close());
                                           
                                           VBox layout= new VBox(10);
                                           layout.getChildren().addAll(label2,exit);
                                           layout.setAlignment(Pos.CENTER);
                                           layout.setBackground(new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));
                                           
                                           Scene scene1 = new Scene(layout, 250, 100);
                                           secondary.setScene(scene1);
                                           secondary.show();
                                           PauseTransition wait = new PauseTransition(Duration.seconds(2));
                                           wait.setOnFinished( ex ->secondary.close());
                                           wait.play();
                                               PLAYERS[pref.currentPlayer].jailCard--;
                                           }
                                           );
                }
		        
		        HBox buttonBox = new HBox(payFine,skipTurn,getOutFree);
		        buttonBox.setAlignment(Pos.CENTER);
		        
		        VBox layout= new VBox(10);
		        layout.getChildren().addAll(infoLabel, label1, moneyInfo, buttonBox);
		        layout.setAlignment(Pos.CENTER);
		        layout.setBackground(new Background(new BackgroundFill(getColor(), CornerRadii.EMPTY, Insets.EMPTY)));
		        
		        Scene scene1 = new Scene(layout, 750, 575);
		        popupwindow.setScene(scene1);
		        popupwindow.showAndWait();
			}
		}
		else if(type == propertyTypes.TAX)
		{
			if(getName() == "Income Tax")
			{
				Stage popupwindow = new Stage();
		        
				popupwindow.initModality(Modality.APPLICATION_MODAL);
		        popupwindow.setTitle(getName());
		        
		        Button yes = new Button("Pay Tax ($250)");
		        Button no = new Button("Sell");
                Button percent = new Button("Pay %10 of Budget ($" + (0.1*PLAYERS[pref.currentPlayer].getMoney()) + ")");
		        
		        yes.setStyle("-fx-font: 20 times; -fx-base: green;");
		        no.setStyle("-fx-font: 20 times; -fx-base: blue;");
                percent.setStyle("-fx-font: 20 times; -fx-base: yellow;");

		        //Label infoLabel = new Label("You owe $250 of luxury taxes!");
		       
		        Label moneyInfo = new Label( PLAYERS[pref.currentPlayer].getName() + " has $" + PLAYERS[pref.currentPlayer].getMoney() + " and will have $" + (PLAYERS[pref.currentPlayer].getMoney() - 250) + " remaining after this tax if paying the flat rate.");
		        
		        yes.setOnAction(e -> {
		        		PLAYERS[pref.currentPlayer].spend(250);
		        		popupwindow.close();
		        });
		        no.setOnAction(e -> 
		        {
		        		PLAYERS[pref.currentPlayer].Assets(TILES,PLAYERS, false);
		        		popupwindow.close();
		        });
                
                percent.setOnAction(e -> {
                    PLAYERS[pref.currentPlayer].payPercent(10);
                    popupwindow.close();
                });
		        
		        HBox buttonBox = new HBox(yes,percent,no);
		        buttonBox.setAlignment(Pos.CENTER);
		        
		        ImageView propertyImage = new ImageView();
		        
		        propertyImage.setImage(getICON());
		        propertyImage.setFitWidth(500);
		        propertyImage.setFitHeight(250);
		        Label label2 = new Label(getName());
		        label2.setFont(new Font("Times New Roman", 20));
		        
		        VBox layout= new VBox(10);
		        layout.getChildren().addAll( moneyInfo, buttonBox, propertyImage, label2);
		        layout.setAlignment(Pos.CENTER);
		        layout.setBackground(new Background(new BackgroundFill(getColor(), CornerRadii.EMPTY, Insets.EMPTY)));
		        
		        Scene scene1 = new Scene(layout, 750, 575);
		        popupwindow.setScene(scene1);
		        popupwindow.showAndWait();
			}
			else 
			{
				Stage popupwindow = new Stage();
		        
				popupwindow.initModality(Modality.APPLICATION_MODAL);
		        popupwindow.setTitle(getName());
		        
		        Button yes = new Button("Pay Tax");
		        Button no = new Button("Sell");
		        
		        yes.setStyle("-fx-font: 20 times; -fx-base: green;");
		        no.setStyle("-fx-font: 20 times; -fx-base: blue;");

		        Label infoLabel = new Label("You owe $75 of luxury taxes!");
		       
		        Label moneyInfo = new Label( PLAYERS[pref.currentPlayer].getName() + " has $" + PLAYERS[pref.currentPlayer].getMoney() + " and will have $" + (PLAYERS[pref.currentPlayer].getMoney() - 75) + " remaining after this tax if paying the flat rate.");

		        infoLabel.setFont(new Font("Times New Roman", 20));
		        infoLabel.setWrapText(true);
		        infoLabel.setTextAlignment(TextAlignment.JUSTIFY);
		        
                try{
                    yes.setOnAction(e -> {
                        PLAYERS[pref.currentPlayer].spend(75);
                        popupwindow.close();
                    });
                }
                
                catch(Exception fg)
                {
                    System.out.println("Error");
                }
		        
		        no.setOnAction(e -> 
		        {
		        		PLAYERS[pref.currentPlayer].Assets(TILES,PLAYERS, false);
		        		popupwindow.close();
		        });
		        
		        HBox buttonBox = new HBox(yes,no);
		        buttonBox.setAlignment(Pos.CENTER);
		        
		        ImageView propertyImage = new ImageView();
		        
		        propertyImage.setImage(getICON());
		        propertyImage.setFitWidth(500);
		        propertyImage.setFitHeight(250);
		        Label label2 = new Label(getName());
		        label2.setFont(new Font("Times New Roman", 20));
		        
		        VBox layout= new VBox(10);
		        layout.getChildren().addAll(infoLabel, moneyInfo, buttonBox, propertyImage, label2);
		        layout.setAlignment(Pos.CENTER);
		        layout.setBackground(new Background(new BackgroundFill(getColor(), CornerRadii.EMPTY, Insets.EMPTY)));
		        
		        Scene scene1 = new Scene(layout, 750, 575);
		        popupwindow.setScene(scene1);
		        popupwindow.showAndWait();
			}
		}
		else if(type == propertyTypes.CHEST)
		{
			int chestNumber = 0;
			String [] chestCard = new Monopoly().getChestArray();
			Label [] chests = {
				    new Label(chestCard[0]),
				    new Label(chestCard[1]),
				    new Label(chestCard[2]),
				    new Label(chestCard[3]),
				    new Label(chestCard[4]),
				    new Label(chestCard[5]),
				    new Label(chestCard[6]),
				    new Label(chestCard[7]),
				    new Label(chestCard[8]),
				    new Label(chestCard[9]),
				    new Label(chestCard[10]),
				    new Label(chestCard[11]),
				    new Label(chestCard[12]),
				    new Label(chestCard[13]),
				    new Label(chestCard[14]),
				    new Label(chestCard[15])
				    };
			
			Stage popupwindow = new Stage();
	        Random rand = new Random();
	        
	        popupwindow.initModality(Modality.APPLICATION_MODAL);
	        popupwindow.setTitle("Community Chest");
	        
	        int i = rand.nextInt(15+0) - 0;
	        chestNumber = i;
	        
	        Label label1 = chests[i];
	        label1.setFont(new Font("Times New Roman", 20));
            label1.setWrapText(true);
	        
	        ImageView Smith = new ImageView();
	        
	        if(i < 10)
	        {
	            Smith.setImage(new Image(getClass().getResourceAsStream("/assets/Happy.png")));
	            Smith.setFitWidth(350);
	            Smith.setFitHeight(350);
	        }
	        
	        else
	        {
	            Smith.setImage(new Image(getClass().getResourceAsStream("/assets/Mad.png")));
	            Smith.setFitWidth(350);
	            Smith.setFitHeight(350);
	        }
	        
	        VBox layout= new VBox(10);
	        
            Button exit = new Button("Exit");
            exit.setStyle("-fx-font: 20 times; -fx-base: red;");
            exit.setOnAction(v -> popupwindow.close());

	        layout.getChildren().addAll(label1);
	        layout.getChildren().add(Smith);
	        layout.getChildren().add(exit);
	        
	        layout.setAlignment(Pos.CENTER);
	        layout.setBackground(new Background(new BackgroundFill(getColor(), CornerRadii.EMPTY, Insets.EMPTY)));
	        
	        Scene scene1 = new Scene(layout, 750, 575);
	        
	        // Handler
	        if(chestNumber == 0) // "You were nominated for FSU Student Body President, but you didn't win. Collect $15.",
	        {
	        		PLAYERS[pref.currentPlayer].gain(15);
	        }
	        else if(chestNumber == 1) // "FSU Financial Aid believes your deductions. Collect $80."
	        {
	        		PLAYERS[pref.currentPlayer].gain(80);
	        }
	        else if(chestNumber == 2) // "Cash out on your Financial Aid! Collect $45.",
	        {
	        		PLAYERS[pref.currentPlayer].gain(45);
	        }
	        else if(chestNumber == 3) // "Your new student show is a 'GO'! Collect $200."
	        {
	        		PLAYERS[pref.currentPlayer].gain(200);
	        }
	        else if(chestNumber == 4) // "Willy Taggart mistakenly adds you to the roster. Collect $200."
	        {
	        		PLAYERS[pref.currentPlayer].gain(200);
	        }
	        else if(chestNumber == 5) // "Your recent Youtube video received 500 million views! Collect $100."
	        {
	        		PLAYERS[pref.currentPlayer].gain(100);
	        }
	        else if(chestNumber == 6) //"You were admitted to the FSU Graduate School Program! Collect $5."
	        {
	        		PLAYERS[pref.currentPlayer].gain(5);
	        }
	        else if(chestNumber == 7) // "Pass 'GO' and collect $200.",
	        {
	        		PLAYERS[pref.currentPlayer].setPosition(0);
                PLAYERS[pref.currentPlayer].gain(200);
	        }
	        else if(chestNumber == 8) // Jailcard
	        {
	        		PLAYERS[pref.currentPlayer].jailCard++;
	        }
	        else if(chestNumber == 9) // ""The FSU Psychology Program has funded your research! Collect $250.""
	        {
	        		PLAYERS[pref.currentPlayer].gain(250);
	        }
	        else if(chestNumber == 10) // "Pay marriage penalty tax of $25."
	        {
	        		PLAYERS[pref.currentPlayer].spend(25);
	        }
	        else if(chestNumber == 11) // "Steal SAR Imager materials for market research. Pay $100."
	        {
	        		PLAYERS[pref.currentPlayer].spend(100);
	        }
	        else if(chestNumber == 12) // "Wellness Center operates on the wrong leg! Pay $50.",
	        {
	        		PLAYERS[pref.currentPlayer].spend(50);
	        }
	        else if(chestNumber == 13) // "President Thrasher gets a $100 million X-Mas bonus! You get nothing.",
	        {
	        		// Do nothing
	        }
	        else if(chestNumber == 14) // "You cheated in bowling! Go straight to Jail and do not pass 'GO'.",
	        {
	        		PLAYERS[pref.currentPlayer].setPosition(30);
                PLAYERS[pref.currentPlayer].setJailed(true);
                
	        }
	        else if(chestNumber == 15) // "You left your bar tab open at Madison Social! Pay $150."
	        {
	        		PLAYERS[pref.currentPlayer].spend(150);
	        }
	        
	        popupwindow.setScene(scene1);
	        popupwindow.showAndWait();
		}
		
		else if(type == propertyTypes.CHANCE)
		{
			int chanceNumber = 0;
			String [] chanceCard = new Monopoly().getChanceArray();
			Label [] chances = {
				    new Label(chanceCard[0]),
				    new Label(chanceCard[1]),
				    new Label(chanceCard[2]),
				    new Label(chanceCard[3]),
				    new Label(chanceCard[4]),
				    new Label(chanceCard[5]),
				    new Label(chanceCard[6]),
				    new Label(chanceCard[7]),
				    new Label(chanceCard[8]),
				    new Label(chanceCard[9]),
				    new Label(chanceCard[10]),
				    new Label(chanceCard[11]),
				    new Label(chanceCard[12]),
				    new Label(chanceCard[13]),
				    new Label(chanceCard[14]),
				    new Label(chanceCard[15])
				    };
			
			Stage popupwindow = new Stage();
	        Random rand = new Random();
	        
	        popupwindow.initModality(Modality.APPLICATION_MODAL);
	        popupwindow.setTitle("Let's play a game of Chance!");
	        
	        int i = rand.nextInt(15+0) - 0;
	        
	        Label label1 = chances[i];
	        label1.setFont(new Font("Georgia", 20));
            label1.setWrapText(true);
	        
	        ImageView Smith = new ImageView();
	        
	        Smith.setImage(new Image(getClass().getResourceAsStream("/assets/happy.png")));
	        Smith.setFitWidth(250);
	        Smith.setFitHeight(350);
	        
	        VBox layout= new VBox(10);
	        
	        Button exit = new Button("Exit");
            exit.setStyle("-fx-font: 20 times; -fx-base: red;");
            exit.setOnAction(v -> popupwindow.close());
            
	        layout.getChildren().addAll(label1);
	        layout.getChildren().add(Smith);
	        layout.getChildren().add(exit);
	        
	        layout.setAlignment(Pos.CENTER);
	        layout.setBackground(new Background(new BackgroundFill(getColor(), CornerRadii.EMPTY, Insets.EMPTY)));
	        
	        Scene scene1 = new Scene(layout, 750, 575);
	        
	     // Handler
	        if(i == 0) // "Advance to 'GO' and collect $200."
	        {
	        		PLAYERS[pref.currentPlayer].setPosition(0);
                PLAYERS[pref.currentPlayer].gain(200);
	        }
	        else if( i == 2 ) // "Advance to HCB  - If you pass Go, collect $200"
	        {
                if(PLAYERS[pref.currentPlayer].getPosition() > 0 &&  PLAYERS[pref.currentPlayer].getPosition() < 6)
                {
                    PLAYERS[pref.currentPlayer].setPosition(6);
                }
                
                if(PLAYERS[pref.currentPlayer].getPosition() > 6)
                {
                    PLAYERS[pref.currentPlayer].setPosition(6);
                    PLAYERS[pref.currentPlayer].gain(200);
                }
	        		
	        }
	        else if( i == 3) // Advance to The Rez – If you pass Go, collect $200
	        {
                if(PLAYERS[pref.currentPlayer].getPosition() > 31)
                {
                    PLAYERS[pref.currentPlayer].setPosition(31);
                    PLAYERS[pref.currentPlayer].gain(200);
                }
                
                if(PLAYERS[pref.currentPlayer].getPosition() < 31)
                {
                    PLAYERS[pref.currentPlayer].setPosition(31);
                    
                }
	        }
	        else if( i == 4) // "Your new student show is a 'GO'! Collect $200."
	        {
	        		PLAYERS[pref.currentPlayer].gain(200);
	        }
	        else if( i == 5) // "Advance to nearest Utility. If unowned, you may buy it from the School. If owned, throw dice and pay owner a total ten times the amount thrown.",
	        {
                //Property [] TILES = new Property().buildPropertyList();
                
                if(PLAYERS[pref.currentPlayer].getPosition() < 12)
                {
                    PLAYERS[pref.currentPlayer].setPosition(12);
                }
                
                else if(PLAYERS[pref.currentPlayer].getPosition() > 12 && PLAYERS[pref.currentPlayer].getPosition() < 28)
                {
                    PLAYERS[pref.currentPlayer].setPosition(28);
                }
	        }
	        else if( i == 6) // "Advance to the nearest Bus and pay owner twice the rental to which he/she is otherwise entitled. If Bus is unowned, you may buy it from the School",
	        {
                if(PLAYERS[pref.currentPlayer].getPosition() < 5)
                {
                    PLAYERS[pref.currentPlayer].setPosition(5);
                }
                
                else if(PLAYERS[pref.currentPlayer].getPosition() > 5 && PLAYERS[pref.currentPlayer].getPosition() < 15)
                {
                    PLAYERS[pref.currentPlayer].setPosition(15);
                }
                
                else if(PLAYERS[pref.currentPlayer].getPosition() > 15 && PLAYERS[pref.currentPlayer].getPosition() < 25)
                {
                    PLAYERS[pref.currentPlayer].setPosition(25);
                }
                
                else if(PLAYERS[pref.currentPlayer].getPosition() > 25 && PLAYERS[pref.currentPlayer].getPosition() < 25)
                {
                    PLAYERS[pref.currentPlayer].setPosition(35);
                }
	        }
	        else if( i == 7 ) // "FSU pays you dividend of $50.",
	        {
	        		PLAYERS[pref.currentPlayer].gain(50);
	        }
	        else if( i == 8 ) // "You have won an Ultimate Frisbee tournament - Collect $100"
	        {
	        		PLAYERS[pref.currentPlayer].gain(100);
	        }
	        else if( i == 9) // Jail card
	        {
	        		PLAYERS[pref.currentPlayer].jailCard++;
	        }
	        else if( i == 10) // "Go back 3 spaces."
	        {
                PLAYERS[pref.currentPlayer].setPosition((PLAYERS[pref.currentPlayer].getPosition() - 3));
	        }
	        else if( i == 11) // "Go directly to Jail and do not pass 'GO'.",
	        {
	        		PLAYERS[pref.currentPlayer].setPosition(30);
                PLAYERS[pref.currentPlayer].setJailed(true);
	        }
	        else if( i == 12) // "Make general repairs on all your property – For each house pay $25.",
	        {
                PLAYERS[pref.currentPlayer].spend(25);
	        }
	        else if( i == 13) // "Pay poor tax of $15"
	        {
	        		PLAYERS[pref.currentPlayer].spend(15);
	        }
	        else if(i == 14) // "Take a trip to the Gold Bus – If you pass Go, collect $200."
	        {
                if(PLAYERS[pref.currentPlayer].getPosition() < 25)
                {
                    PLAYERS[pref.currentPlayer].setPosition(25);
                }
                
                else
                {
                    PLAYERS[pref.currentPlayer].setPosition(25);
                    PLAYERS[pref.currentPlayer].gain(200);
                }
	        		
	        }
	        else if ( i == 15)// "Take a walk on Legacy Walk."
	        {
	        		PLAYERS[pref.currentPlayer].setPosition(26);
	        }
	        else if ( i == 16) // "You have been elected Student Body Treasurer – Pay each player $50."
	        {
                for(int j = 0; j < pref.getPlayerCount(); j++)
                {
                    if(j != pref.getPlayerCount())
                    {
                        PLAYERS[pref.currentPlayer].spend(50);
                        PLAYERS[j].gain(50);
                    }
                    
                }
	        }
	        
	        popupwindow.setScene(scene1);
	        popupwindow.showAndWait();
		}
		else if(type == propertyTypes.UTILITY || type == propertyTypes.BUS)
		{
			Stage popupwindow = new Stage();
			
			if(!getOwner().isHuman)		// Runs first-time buyer function only if the property is unowned
			{
		        popupwindow.initModality(Modality.APPLICATION_MODAL);
		        popupwindow.setTitle(getName());
		        
		        Button yes = new Button("Yes");
		        Button no = new Button("No");
		        
		        yes.setStyle("-fx-font: 20 times; -fx-base: green;");
		        no.setStyle("-fx-font: 20 times; -fx-base: red;");

		        // Conditional
		        Label infoLabel = new Label("This property is for sale! If you do not buy the property, it will go up for auction.");
		        playerOwns(PLAYERS[pref.getCurrentPlayer()],TILES);
		        
		        VBox ownership = new VBox(); 
		        ownership.setAlignment(Pos.CENTER);
		        for(int i = 0; i < pref.getPlayerCount(); i++)
		        {
		        		Label ownerInfo = new Label (PLAYERS[i].getName() +" owns " + TILES[PLAYERS[pref.getCurrentPlayer()].getPosition()].playerOwns(PLAYERS[i],TILES) + " " + group + " properties. ");
		        		ownerInfo.setWrapText(true);
		        		ownerInfo.setTextAlignment(TextAlignment.JUSTIFY);
		        		ownership.getChildren().add(ownerInfo);
		        }
		        
		        
		        Label label1 = new Label("Would you like to purchase "+ getName() +" for $" + getBuyPrice()+"?");
		        Label moneyInfo = new Label( PLAYERS[pref.currentPlayer].getName() + " has $" + PLAYERS[pref.currentPlayer].getMoney() + " and will have $" + (PLAYERS[pref.currentPlayer].getMoney() - getBuyPrice()) + " remaining after this purchase.");
		        if((PLAYERS[pref.currentPlayer].getMoney() - getBuyPrice()) < 0)
		        {
		        		moneyInfo.setText(PLAYERS[pref.currentPlayer].getName() + " doesn't have enough money to purchase this property.");
		        		yes.setDisable(true);
		        		yes.setVisible(false);
		        }
		        label1.setFont(new Font("Times New Roman", 20));
		        label1.setWrapText(true);
		        label1.setTextAlignment(TextAlignment.JUSTIFY);
		        infoLabel.setFont(new Font("Times New Roman", 20));
		        infoLabel.setWrapText(true);
		        infoLabel.setTextAlignment(TextAlignment.JUSTIFY);
		        
		        yes.setOnAction(e -> {
		        		Purchase(PLAYERS[pref.currentPlayer], getBuyPrice());
                        PLAYERS[pref.currentPlayer].propertiesOwned++;
		        		popupwindow.close();
		        });
		        no.setOnAction(e -> 
		        {
		        		// TODO: Begin auction
		        		popupwindow.close();
		        });
		        
		        HBox buttonBox = new HBox(yes,no);
		        buttonBox.setAlignment(Pos.CENTER);
		        
		        ImageView propertyImage = new ImageView();
		        
		        propertyImage.setImage(getICON());
		        propertyImage.setFitWidth(500);
		        propertyImage.setFitHeight(250);
		        Label label2 = new Label(getName());
		        label2.setFont(new Font("Times New Roman", 20));
		        
		        VBox layout= new VBox(10);
		        layout.getChildren().addAll(infoLabel,label1, ownership, moneyInfo, buttonBox, propertyImage, label2);
		        layout.setAlignment(Pos.CENTER);
		        layout.setBackground(new Background(new BackgroundFill(getColor(), CornerRadii.EMPTY, Insets.EMPTY)));
		        
		        Scene scene1 = new Scene(layout, 750, 575);
		        popupwindow.setScene(scene1);
		        popupwindow.showAndWait();
			}
			
			else if(owner == PLAYERS[pref.currentPlayer])	// Tell player no action is required if they own the tile
			{
				popupwindow.initModality(Modality.APPLICATION_MODAL);
		        popupwindow.setTitle(getName());
		        Label label1 = new Label("You own this tile! Free rent!");
		        label1.setFont(new Font("Times New Roman", 20));
		        label1.setWrapText(true);
		        label1.setTextAlignment(TextAlignment.JUSTIFY);
		        
                Button exit = new Button("Exit");
                exit.setStyle("-fx-font: 20 times; -fx-base: red;");
                exit.setOnAction(v -> popupwindow.close());
		        
		        VBox layout= new VBox(10);
		        layout.getChildren().addAll(label1,exit);
		        layout.setAlignment(Pos.CENTER);
		        layout.setBackground(new Background(new BackgroundFill(getColor(), CornerRadii.EMPTY, Insets.EMPTY)));
		        
		        Scene scene1 = new Scene(layout, 250, 100);
		        popupwindow.setScene(scene1);
		        popupwindow.show();
		        PauseTransition wait = new PauseTransition(Duration.seconds(2));
		        wait.setOnFinished( e ->popupwindow.close());
		        wait.play();
			}
			else												// Tile is owned by another player, pay rent
			{
				popupwindow.initModality(Modality.APPLICATION_MODAL);
		        popupwindow.setTitle(getName());
		        
		        Button yes = new Button("Pay Rent");
		        Button no = new Button("Sell");				// Todo: Implement selling assets
		        
		        yes.setStyle("-fx-font: 20 times; -fx-base: green;");
		        no.setStyle("-fx-font: 20 times; -fx-base: blue;");

		        // Conditional
		        Label infoLabel = new Label(getName() + " is owned by " + getOwner().getName());
		        
		        String mString;
		        mString = "Property has " + houses + " houses, ";
		        if(hasHotel())
		        		mString += "a ";
		        else
		        		mString += "no ";
		        mString += "hotel, ";
		        
		        mString += "and " + getOwner().getName() + " owns " + TILES[PLAYERS[pref.getCurrentPlayer()].getPosition()].playerOwns(getOwner(),TILES) + " " + getGroup() + " properties.";
		        Label multiplierInfo = new Label(mString);
		        multiplierInfo.setWrapText(true);
		        
		        Label label1 = new Label("You must pay rent! Rent is $" + getRentPrice(TILES));
		        Label moneyInfo = new Label( PLAYERS[pref.currentPlayer].getName() + " has $" + PLAYERS[pref.currentPlayer].getMoney() + " and will have $" + (PLAYERS[pref.currentPlayer].getMoney() - getRentPrice(TILES)) + " remaining after this purchase.");
		        if((PLAYERS[pref.currentPlayer].getMoney() - getRentPrice(TILES)) < 0)
		        {
		        		moneyInfo.setText(PLAYERS[pref.currentPlayer].getName() + " doesn't have enough money to pay rent. Press Sell to see what you can sell.");
		        		yes.setDisable(true);
		        		yes.setVisible(false);
		        }
		        label1.setFont(new Font("Times New Roman", 20));
		        label1.setWrapText(true);
		        label1.setTextAlignment(TextAlignment.JUSTIFY);
		        infoLabel.setFont(new Font("Times New Roman", 20));
		        infoLabel.setWrapText(true);
		        infoLabel.setTextAlignment(TextAlignment.JUSTIFY);
		        
		        yes.setOnAction(e -> {
		        		PLAYERS[pref.currentPlayer].spend(getRentPrice(TILES));
		        		getOwner().gain(getRentPrice(TILES));
		        		popupwindow.close();
		        });
		        no.setOnAction(e -> 
		        {
		        		// TODO: OPEN PLAYER'S ASSETS
		        		popupwindow.close();
		        });
		        
		        HBox buttonBox = new HBox(yes,no);
		        buttonBox.setAlignment(Pos.CENTER);
		        
		        ImageView propertyImage = new ImageView();
		        
		        propertyImage.setImage(getICON());
		        propertyImage.setFitWidth(500);
		        propertyImage.setFitHeight(250);
		        Label label2 = new Label(getName());
		        label2.setFont(new Font("Times New Roman", 20));
		        
		        VBox layout= new VBox(10);
		        layout.getChildren().addAll(infoLabel, label1, multiplierInfo, moneyInfo, buttonBox, propertyImage, label2);
		        layout.setAlignment(Pos.CENTER);
		        layout.setBackground(new Background(new BackgroundFill(getColor(), CornerRadii.EMPTY, Insets.EMPTY)));
		        
		        Scene scene1 = new Scene(layout, 750, 575);
		        popupwindow.setScene(scene1);
		        popupwindow.showAndWait();
			}
		}
	}
	
	// Build Property Board Array
	public Property [] buildPropertyList()// TODO: Prices for bus/utilities not yet done
	{
		Property [] pList = new Property [40];				// Builds 40 properties (Monopoly has 40 tiles)
		
		// Go
		pList[0] = new Property(propertyTypes.CORNER, "GO");
		
		// Top Side
		pList[1] = new Property(propertyTypes.ESTATE, "Smith Hall", 60, 2, 250, "PURPLE", new Image(getClass().getResourceAsStream("/assets/SmithHall.png")));
		pList[2] = new Property(propertyTypes.CHEST, "Community Chest");
		pList[3] = new Property(propertyTypes.ESTATE, "Salley Hall", 60, 4, 250, "PURPLE", new Image(getClass().getResourceAsStream("/assets/SalleyHall.png")));
		pList[4] = new Property(propertyTypes.TAX, "Income Tax", new Image(getClass().getResourceAsStream("/assets/Income.png")));
		pList[5] = new Property(propertyTypes.BUS, "Night Nole", 200, 25, 0, "BUS", new Image(getClass().getResourceAsStream("/assets/NiteNole.png")));
		pList[6] = new Property(propertyTypes.ESTATE, "HCB", 100, 6, 550, "CYAN", new Image(getClass().getResourceAsStream("/assets/HCB.png")));
		pList[7] = new Property(propertyTypes.CHANCE, "Chance");
		pList[8] = new Property(propertyTypes.ESTATE, "Dorman Hall", 100, 6, 550, "CYAN", new Image(getClass().getResourceAsStream("/assets/DormanHall.png")));
		pList[9] = new Property(propertyTypes.ESTATE, "Love Building", 120, 8, 600, "CYAN", new Image(getClass().getResourceAsStream("/assets/Love.png")));
		
		// Jail
		pList[10] = new Property(propertyTypes.CORNER, "Jail");
		
		// Right Side
		pList[11] = new Property(propertyTypes.ESTATE, "King Building", 140, 10, 750, "PINK", new Image(getClass().getResourceAsStream("/assets/King.png")));
		pList[12] = new Property(propertyTypes.UTILITY, "Electric", 150, 0, 0, "UTILITY", new Image(getClass().getResourceAsStream("/assets/Electric.png")));
		pList[13] = new Property(propertyTypes.ESTATE, "Fresh Foods", 140, 10, 750, "PINK", new Image(getClass().getResourceAsStream("/assets/Fresh.png")));
		pList[14] = new Property(propertyTypes.ESTATE, "Fisher Hall", 160, 12, 900, "PINK", new Image(getClass().getResourceAsStream("/assets/Fisher.png")));
		
		pList[15] = new Property(propertyTypes.BUS, "Heritage Bus", 200, 25, 0, "BUS", new Image(getClass().getResourceAsStream("/assets/Heritage.png")));
		
		pList[16] = new Property(propertyTypes.ESTATE, "Strozier", 180, 14, 950, "ORANGE", new Image(getClass().getResourceAsStream("/assets/Stroz.png")));
		pList[17] = new Property(propertyTypes.CHEST, "Community Chest");
		pList[18] = new Property(propertyTypes.ESTATE, "The SLC", 180, 14, 950, "ORANGE", new Image(getClass().getResourceAsStream("/assets/SLC.png")));
		pList[19] = new Property(propertyTypes.ESTATE, "Suwannee Room", 200, 16, 1000, "ORANGE", new Image(getClass().getResourceAsStream("/assets/Suwannee.png")));
		
		// Free Parking
		pList[20] = new Property(propertyTypes.CORNER, "Free Parking");
		
		// Bottom Side
		pList[21] = new Property(propertyTypes.ESTATE, "Dirac", 220, 18, 1050, "RED", new Image(getClass().getResourceAsStream("/assets/Dirac.png")));
		pList[22] = new Property(propertyTypes.CHANCE, "Chance");
		pList[23] = new Property(propertyTypes.ESTATE, "MagLab", 220, 18, 1050, "RED", new Image(getClass().getResourceAsStream("/assets/MagLab.png")));
		pList[24] = new Property(propertyTypes.ESTATE, "FSU Circus", 240, 20, 1100, "RED", new Image(getClass().getResourceAsStream("/assets/Circus.png")));
		pList[25] = new Property(propertyTypes.BUS, "Gold Bus", 200, 25, 0, "ORANGE", new Image(getClass().getResourceAsStream("/assets/Gold.png")));
		pList[26] = new Property(propertyTypes.ESTATE, "Legacy Walk", 260, 22, 1150, "YELLOW", new Image(getClass().getResourceAsStream("/assets/Legacy.png")));
		pList[27] = new Property(propertyTypes.ESTATE, "The Leach", 260, 22, 1150, "YELLOW", new Image(getClass().getResourceAsStream("/assets/Leach.png")));
		pList[28] = new Property(propertyTypes.UTILITY, "Water", 150, 0, 0, "UTILITY", new Image(getClass().getResourceAsStream("/assets/Water.png")));
		pList[29] = new Property(propertyTypes.ESTATE, "Oglesby Union", 280, 24, 1200, "YELLOW", new Image(getClass().getResourceAsStream("/assets/Union.png")));
		
		// Go to Jail
		pList[30] = new Property(propertyTypes.CORNER, "Go To Jail");
		
		// Left Side
		pList[31] = new Property(propertyTypes.ESTATE, "The Rez", 300, 26, 1275, "GREEN", new Image(getClass().getResourceAsStream("/assets/Rez.png")));
		pList[32] = new Property(propertyTypes.ESTATE, "Landis Green", 300, 26, 1275, "GREEN", new Image(getClass().getResourceAsStream("/assets/Landis.png")));
		pList[33] = new Property(propertyTypes.CHEST, "Community Chest");
		pList[34] = new Property(propertyTypes.ESTATE, "Ruby Diamond", 320, 28, 1400, "GREEN", new Image(getClass().getResourceAsStream("/assets/Ruby.png")));
		pList[35] = new Property(propertyTypes.BUS, "Garnet Bus", 200, 25, 0, "BUS", new Image(getClass().getResourceAsStream("/assets/Garnet.png")));
		pList[36] = new Property(propertyTypes.CHANCE, "Chance");
		pList[37] = new Property(propertyTypes.ESTATE, "Wescott", 350, 35, 1500, "BLUE", new Image(getClass().getResourceAsStream("/assets/Westcott.png")));
		pList[38] = new Property(propertyTypes.TAX, "Luxury Tax", new Image(getClass().getResourceAsStream("/assets/Luxury.png")));
		pList[39] = new Property(propertyTypes.ESTATE, "Doak Stadium", 400, 50, 2000, "BLUE", new Image(getClass().getResourceAsStream("/assets/Doak.png")));
		
		return pList; 
	}
}
