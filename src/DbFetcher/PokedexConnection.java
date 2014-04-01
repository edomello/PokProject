package DbFetcher;
import java.sql.*;
import java.util.ArrayList;

import pkmnTypes.Type;
import PokemonObj.Move;
import PokemonObj.MoveLearn;
import PokemonObj.Pokemon;

	public class PokedexConnection {
		 private Connection c;
		 public PokedexConnection() {
			 try {
			      Class.forName("org.sqlite.JDBC");
			      c = DriverManager.getConnection("jdbc:sqlite:pokedex.sqlite");
			    } catch ( Exception e ) {
			      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			    }
			    System.out.println("Opened pokedex successfully");
			  }
		 	
		
		 public void getPokemonDataFromName(Pokemon pokemon){
			try {
			Statement stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery( "SELECT pokemon.id as id, pokemon.identifier as name, types.identifier as type, slot as typeslot FROM pokemon, pokemon_types, types WHERE pokemon.identifier=='"+pokemon.getName()+"' AND pokemon.id == pokemon_types.pokemon_id and pokemon_types.type_id == types.id" );
			while ( rs.next() ) {
				pokemon.setId(rs.getInt("id"));
				if(rs.getInt("typeslot")==1){pokemon.setType1(Type.valueOf(rs.getString("type")));}
				if(rs.getInt("typeslot")==2){pokemon.setType2(Type.valueOf(rs.getString("type")));} 
		      }
		      rs.close();
		      stmt.close();
		      c.close();
		    } catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		    }
		}
		 
		 public void getLearnSet(int pokemonId, ArrayList<MoveLearn> emptySet){
			 try {
					Statement stmt = c.createStatement();
					ResultSet rs = stmt.executeQuery( "SELECT DISTINCT moves.id,moves.identifier AS movename, machines.machine_number AS TM, pokemon_moves.pokemon_move_method_id AS movemethod, pokemon_moves.level, moves.power, types.identifier AS type, moves.damage_class_id AS dmgtype FROM moves, version_groups, types, pokemon_moves LEFT JOIN machines ON (pokemon_moves.move_id == machines.move_id AND machines.version_group_id==15) WHERE pokemon_moves.pokemon_id == "+pokemonId+" and version_groups.id ==15 and moves.type_id == types.id and pokemon_moves.move_id == moves.id and pokemon_moves.version_group_id == version_groups.id ORDER BY pokemon_moves.pokemon_move_method_id ASC, pokemon_moves.level ASC" );
					
					while ( rs.next() ) {
				       Move currentMove = new Move(rs.getInt("id"),rs.getString("movename"),rs.getInt("power"),rs.getString("type"),rs.getInt("dmgtype"), rs.getInt("TM"));
				       MoveLearn CurrentMoveLearn = new MoveLearn(currentMove, rs.getInt("level"), rs.getInt("movemethod"));
				       emptySet.add(CurrentMoveLearn);
				      }
				      rs.close();
				      stmt.close();
				      c.close(); 
				    } catch ( Exception e ) {
				      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
				    }
		 }
		 
		 
		 
	}
		 
		 

