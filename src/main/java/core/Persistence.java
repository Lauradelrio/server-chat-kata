package core;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: laura
 * Date: 12/12/13
 * Time: 10:42
 * To change this template use File | Settings | File Templates.
 */
public class Persistence {
    private ArrayList<Message> msgList;

    public Persistence(){
        msgList=new ArrayList<Message>();
    }


    public boolean addMsg(Message msg){
        return msgList.add(msg);
    }

    public int getSizeMsg(){
        return msgList.size();
    }

    public ArrayList<Message> getMsgList(){
        return msgList;
    }
}
