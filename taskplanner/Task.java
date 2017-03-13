import java.util.Arrays;
import java.util.ArrayList;

public class Task{
	String name;
	int estimatedTime, manpower, id;
	int earlieststart, lateststart;
	int cntPredecessors;
	int[] inEdges;
	ArrayList<Task> outEdges;
	boolean seen; //init with al

	/**
	* Set inEdges equal to the total amount of tasks
	* Set outEdges independent.
	* @param total_nr_of_task
	**/
	public Task(int total_nr_of_task){
		inEdges = new int[total_nr_of_task];
		outEdges = new ArrayList<Task>();
	}

	/**
	* 	Calculate how much time that can the task t have between latest start and 
	*	earliest start.
	**/
	private int calculateSlack(){
		return lateststart - earlieststart;
	}


	/**
	*	Prints the information about the task. The information consist of 
	*	id, name, estimated time, manpower, earliest start, latest start and slack.
	**/
	public void printInfo(){
		System.out.println("id:\t" + id);
		System.out.println("name:\t" + name);
		System.out.println("estimated time:\t" + estimatedTime);
		System.out.println("manpower:\t" + manpower);
		System.out.println("Earliest start:\t" + earlieststart);
		System.out.println("Latest start:\t" + lateststart);
		System.out.println("Slack\t" + calculateSlack());
		System.out.println("");
	}
}