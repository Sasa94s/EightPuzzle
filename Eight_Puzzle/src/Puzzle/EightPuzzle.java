package Puzzle;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
class EightPuzzle {
	Queue<String> agenda = new LinkedList<String>();
    Map<String,Integer> stateDepth = new HashMap<String, Integer>();
    Map<String,String> stateHistory = new HashMap<String,String>();
    String goal = "123456780";
	String msg="";
/**	public static void main(String args[]){
		Scanner getInput = new Scanner(System.in);
		System.out.print("Enter your initial state: ");
		String str = getInput.next();
		//String str="346502781";
		EightPuzzle e = new EightPuzzle();
	    e.add(str, null);
	    while(!e.agenda.isEmpty()){
	            String currentState = e.agenda.remove();
	            e.up(currentState);
	            e.down(currentState);
	            e.left(currentState);
	            e.right(currentState);
	    }
	    System.out.println("Solution doesn't exist");
	}
**/
    void add(String newState, String oldState){
        if(!stateDepth.containsKey(newState)){
            int newValue = oldState == null ? 0 : stateDepth.get(oldState) + 1;
            stateDepth.put(newState, newValue);
            agenda.add(newState);
            stateHistory.put(newState, oldState);
        }
    }
    void up(String currentState){
        int a = currentState.indexOf("0");
        if(a>2){
            String nextState = currentState.substring(0,a-3)+"0"+currentState.substring(a-2,a)+currentState.charAt(a-3)+currentState.substring(a+1);
            checkCompletion(currentState, nextState);
        }
    }
    void down(String currentState){
    	int a = currentState.indexOf("0");
        if(a<6){
            String nextState = currentState.substring(0,a)+currentState.substring(a+3,a+4)+currentState.substring(a+1,a+3)+"0"+currentState.substring(a+4);
            checkCompletion(currentState, nextState);
        }
    }
    void left(String currentState){
        int a = currentState.indexOf("0");
        if(a!=0 && a!=3 && a!=6){
            String nextState = currentState.substring(0,a-1)+"0"+currentState.charAt(a-1)+currentState.substring(a+1);
            checkCompletion(currentState, nextState);
        }
    }
    void right(String currentState){
        int a = currentState.indexOf("0");
        if(a!=2 && a!=5 && a!=8){
            String nextState = currentState.substring(0,a)+currentState.charAt(a+1)+"0"+currentState.substring(a+2);
            checkCompletion(currentState, nextState);
        }
    }
    void checkCompletion(String oldState, String newState) {
    	try {
    		add(newState, oldState);
    		if(newState.equals(goal)) {
    			msg+= ("Solution Exists at Level "+stateDepth.get(newState)+" of the tree"+"\n");
				String traceState = newState;
				String boardState = traceState.substring(0, 3)+"\n"+traceState.substring(3, 6)+"\n"+traceState.substring(6,9);
				while (traceState != null) {
					msg+= (boardState + " at " + stateDepth.get(traceState)+"\n\n");
				    traceState = stateHistory.get(traceState);
				    boardState = traceState.substring(0, 3)+"\n"+traceState.substring(3, 6)+"\n"+traceState.substring(6,9);
				}				
    		}
    	} catch (NullPointerException e) {
    		stateDepth=null;
			stateHistory=null;
		}
    }

}