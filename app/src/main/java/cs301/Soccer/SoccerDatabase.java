package cs301.Soccer;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;
import cs301.Soccer.soccerPlayer.SoccerPlayer;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

/**
 * Soccer player database -- presently, all dummied up
 *
 * @author *** put your name here ***
 * @version *** put date of completion here ***
 *
 */
public class SoccerDatabase implements SoccerDB {

    private HashMap<String,SoccerPlayer> playerBase = new HashMap<String, SoccerPlayer>();

    /**
     * add a player
     *
     * @see SoccerDB#addPlayer(String, String, int, String)
     */
    @Override
    //Done (Checkpoint 1)
    public boolean addPlayer(String firstName, String lastName,
                             int uniformNumber, String teamName)
    {
        //Checkpoint 1 has ben complete
        String targetKey = combineNames(firstName,lastName);
        //Make a loop to see if names are there
        //use a While loop
        Iterator playerIterator = playerBase.entrySet().iterator();
        while(playerIterator.hasNext())
        {
           Map.Entry player = (Map.Entry)playerIterator.next();
           if(player.getKey().equals(targetKey))
           {
               return false;
           }
        }
        //When there are no more names to look for, make a new area on map and return true
        playerBase.put(targetKey,new SoccerPlayer(firstName,lastName,uniformNumber,teamName));
        return true;
    }

    /**
     * remove a player
     *
     * @see SoccerDB#removePlayer(String, String)
     */
    @Override
    public boolean removePlayer(String firstName, String lastName)
    {
        //Checkpoint 3
        String targetKey = combineNames(firstName,lastName);
        Iterator playerIterator = playerBase.entrySet().iterator();
        while(playerIterator.hasNext())
        {
            Map.Entry player = (Map.Entry)playerIterator.next();
            if(player.getKey().equals(targetKey))
            {
                playerBase.remove(targetKey);
                return true;
            }
        }
        return false;
    }

    /**
     * look up a player
     *
     * @see SoccerDB#getPlayer(String, String)
     */
    @Override
    //Done
    public SoccerPlayer getPlayer(String firstName, String lastName)
    {
        //Checkpoint 2 Status: has been complete.
        String targetName = combineNames(firstName,lastName);
        Iterator playerIterator = playerBase.entrySet().iterator();
        while(playerIterator.hasNext())
        {
            Map.Entry player = (Map.Entry)playerIterator.next();
            if(player.getKey().equals(targetName))
            {
                return (SoccerPlayer) player.getValue();
            }
        }
        return null;
    }

    //BUMP METHODS Checkpoint 4
    /**
     * increment a player's goals
     *
     * @see SoccerDB#bumpGoals(String, String)
     */
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public boolean bumpGoals(String firstName, String lastName)
    {
        //This code works. Copy and paste to other ones
        String targetKey = combineNames(firstName,lastName);
        Iterator playerIterator = playerBase.entrySet().iterator();
        while(playerIterator.hasNext())
        {
            Map.Entry player = (Map.Entry)playerIterator.next();
            if(player.getKey().equals(targetKey))
            {
                SoccerPlayer modPlayer = (SoccerPlayer)player.getValue();
                modPlayer.bumpGoals();
                playerBase.replace(targetKey,modPlayer);
                return true;
            }
        }
        return false;
    }

    /**
     * increment a player's assists
     *
     * @see SoccerDB#bumpAssists(String, String)
     */
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public boolean bumpAssists(String firstName, String lastName)
    {
        String targetKey = combineNames(firstName,lastName);
        Iterator playerIterator = playerBase.entrySet().iterator();
        while(playerIterator.hasNext())
        {
            Map.Entry player = (Map.Entry)playerIterator.next();
            if(player.getKey().equals(targetKey))
            {
                SoccerPlayer modPlayer = (SoccerPlayer)player.getValue();
                modPlayer.bumpAssists();
                playerBase.replace(targetKey,modPlayer);
                return true;
            }
        }
        return false;
    }

    /**
     * increment a player's shots
     *
     * @see SoccerDB#bumpShots(String, String)
     */
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public boolean bumpShots(String firstName, String lastName)
    {
        String targetKey = combineNames(firstName,lastName);
        Iterator playerIterator = playerBase.entrySet().iterator();
        while(playerIterator.hasNext())
        {
            Map.Entry player = (Map.Entry)playerIterator.next();
            if(player.getKey().equals(targetKey))
            {
                SoccerPlayer modPlayer = (SoccerPlayer)player.getValue();
                modPlayer.bumpShots();
                playerBase.replace(targetKey,modPlayer);
                return true;
            }
        }
        return false;
    }

    /**
     * increment a player's saves
     *
     * @see SoccerDB#bumpSaves(String, String)
     */
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public boolean bumpSaves(String firstName, String lastName)
    {
        String targetKey = combineNames(firstName,lastName);
        Iterator playerIterator = playerBase.entrySet().iterator();
        while(playerIterator.hasNext())
        {
            Map.Entry player = (Map.Entry)playerIterator.next();
            if(player.getKey().equals(targetKey))
            {
                SoccerPlayer modPlayer = (SoccerPlayer)player.getValue();
                modPlayer.bumpSaves();
                playerBase.replace(targetKey,modPlayer);
                return true;
            }
        }
        return false;
    }

    /**
     * increment a player's fouls
     *
     * @see SoccerDB#bumpFouls(String, String)
     */
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public boolean bumpFouls(String firstName, String lastName)
    {
        String targetKey = combineNames(firstName,lastName);
        Iterator playerIterator = playerBase.entrySet().iterator();
        while(playerIterator.hasNext())
        {
            Map.Entry player = (Map.Entry)playerIterator.next();
            if(player.getKey().equals(targetKey))
            {
                SoccerPlayer modPlayer = (SoccerPlayer)player.getValue();
                modPlayer.bumpFouls();
                playerBase.replace(targetKey,modPlayer);
                return true;
            }
        }
        return false;
    }

    /**
     * increment a player's yellow cards
     *
     * @see SoccerDB#bumpYellowCards(String, String)
     */
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public boolean bumpYellowCards(String firstName, String lastName)
    {
        String targetKey = combineNames(firstName,lastName);
        Iterator playerIterator = playerBase.entrySet().iterator();
        while(playerIterator.hasNext())
        {
            Map.Entry player = (Map.Entry)playerIterator.next();
            if(player.getKey().equals(targetKey))
            {
                SoccerPlayer modPlayer = (SoccerPlayer)player.getValue();
                modPlayer.bumpYellowCards();
                playerBase.replace(targetKey,modPlayer);
                return true;
            }
        }
        return false;
    }

    /**
     * increment a player's red cards
     *
     * @see SoccerDB#bumpRedCards(String, String)
     */
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public boolean bumpRedCards(String firstName, String lastName)
    {
        String targetKey = combineNames(firstName,lastName);
        Iterator playerIterator = playerBase.entrySet().iterator();
        while(playerIterator.hasNext())
        {
            Map.Entry player = (Map.Entry)playerIterator.next();
            if(player.getKey().equals(targetKey))
            {
                SoccerPlayer modPlayer = (SoccerPlayer)player.getValue();
                modPlayer.bumpRedCards();
                playerBase.replace(targetKey,modPlayer);
                return true;
            }
        }
        return false;
    }

    /**
     * tells the number of players on a given team
     *
     * @see SoccerDB#numPlayers(String)
     */
    @Override
    // report number of players on a given team (or all players, if null)
    public int numPlayers(String teamName)
    {
        //Checkpoint 5 was finished
        int players = 0;
        if(teamName == null)
        {
            return playerBase.size();
        }
        else
        {
            Iterator playerIterator = playerBase.entrySet().iterator();
            while(playerIterator.hasNext())
            {
                Map.Entry player = (Map.Entry)playerIterator.next();
                SoccerPlayer somePlayer = (SoccerPlayer)player.getValue();
                if(somePlayer.getTeamName().equals(teamName))
                {
                    players++;
                }
            }
        }
        return players;
    }

    /**
     * gives the nth player on a the given team
     *
     * @see SoccerDB#playerNum(int, String)
     */
    // get the nTH player
    @Override
    public SoccerPlayer playerNum(int idx, String teamName)
    {
        //Checkpoint 6 has been finished.
        //If the id is beyond the map
        if(idx >= playerBase.size())
        {
            return null;
        }
        //If the id is beyond a specified team's map
        if(teamName != null)
        {
            if(idx >= numPlayers(teamName))
            {
                return null;
            }
        }
        //Make the iterator
        Iterator playerIterator = playerBase.entrySet().iterator();
        int currentcount = 0;
        while(playerIterator.hasNext())
        {
            Map.Entry player = (Map.Entry)playerIterator.next();
            //If no team name has been specified, look at entire hashmap
            if(teamName == null)
            {
                if(currentcount == idx)
                {
                    return (SoccerPlayer)player.getValue();
                }
                else
                {
                    currentcount++;
                }
            }
            //When a team is present
            else
            {
                SoccerPlayer concernedPlayer = (SoccerPlayer)player.getValue();
                //Is said player in stated team?
                if(concernedPlayer.getTeamName().equals(teamName))
                {
                    //Are they the idxth member in that team?
                    if(currentcount == idx)
                    {
                        return concernedPlayer;
                    }
                    //If not, increase the currentcount
                    else
                    {
                        currentcount++;
                    }
                }
            }
        }

        return null;
    }

    /**
     * reads database data from a file
     *
     * @see SoccerDB#readData(java.io.File)
     */
    // read data from file
    @Override
    public boolean readData(File file) {
        return file.exists();
    }

    /**
     * write database data to a file
     *
     * @see SoccerDB#writeData(java.io.File)
     */
    // write data to file
    @Override
    public boolean writeData(File file) {
        return false;
    }

    /**
     * helper method that logcat-logs a string, and then returns the string.
     * @param s the string to log
     * @return the string s, unchanged
     */
    private String logString(String s) {
        Log.i("write string", s);
        return s;
    }

    /**
     * returns the list of team names in the database
     *
     * @see cs301.Soccer.SoccerDB#getTeams()
     */
    // return list of teams
    @Override
    public HashSet<String> getTeams() {
        return new HashSet<String>();
    }

    //Helper method for Making the Hashvalue for names
    public String combineNames(String firstName, String lastName)
    {
        return firstName.trim() + " " + lastName.trim();
    }

}


