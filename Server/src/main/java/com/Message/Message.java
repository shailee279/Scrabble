package Message;

import java.io.Serializable;

public class Message implements Serializable{
    private Character Gamecharacter;
    private String Gamelocation;
    private String Gameword;
    private String clientName;
    private int tableId;

    public int getTableId() {
        return tableId;
    }

    public void setTableId(int tableId) {
        this.tableId = tableId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    private static final long serialVersionUID = 1L;

    public Character getGamecharacter() {
        return Gamecharacter;
    }

    public void setGamecharacter(Character gamecharacter) {
        Gamecharacter = gamecharacter;
    }

    public String getGamelocation() {
        return Gamelocation;
    }

    public void setGamelocation(String gamelocation) {
        Gamelocation = gamelocation;
    }

    public String getGameword() {
        return Gameword;
    }

    public void setGameword(String gameword) {
        Gameword = gameword;
    }
}
