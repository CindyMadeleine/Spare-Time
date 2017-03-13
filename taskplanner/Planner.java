import java.util.Arrays;
import java.util.ArrayList;

public class Planner{
	Task[] tasklist;
	private int time;
	private int manpower;

	/**
	* Initialize class Planner. 
	* @param nrOfTasks: The amount of tasks which the project contains
	**/
	public Planner(int nrOfTasks){
		tasklist = new Task[nrOfTasks];
		manpower = 0;
	}

	/**
	* Creates a task with information.
	* @param info: An array with information about the task. 
	* @note The array should contain more the elements: task id, the name of name, the 
	*	estimated time of task, how many workers it needs to perform the task, the id
	*	for all the task that are dependent on the task (Optional!)
	**/
	public void createTask(String[] info){
		Task t = new Task(tasklist.length);

		if(info.length < 4){
			System.out.println("Task does not have enough information");
			return;
		}

		try{
			t.id = Integer.parseInt(info[0]);
		} catch(NumberFormatException nfe){
			System.out.println("Could not create task with id" + info[0]);
			return;
		}

		if(tasklist[t.id-1] != null){
			System.out.println("Could not create task, there is another task with this id");
			return;
		}


		t.name = info[1];

		try{
			t.estimatedTime = Integer.parseInt(info[2]);
			t.manpower = Integer.parseInt(info[3]);
		} catch(NumberFormatException nfe){
			System.out.println("Could not convert int to format");
			return;
		}


		int innum = 0;
		for(int i = 4; i < info.length && !"0".equals(info[i]); i++){
			int tasknum;
			try{
				tasknum = Integer.parseInt(info[i]);
			} catch(NumberFormatException nfe){
				continue;
			}
			t.inEdges[tasknum-1] = tasknum;
			++t.cntPredecessors;
		}

		tasklist[t.id-1] = t;
	}

	/**
	*	Run through the tasklist once, if the current task in the tasklist,
	*	let us call it out, has any predecessors out is set as an outedge
	*	to that predecessor. 
	**/
	public void setOutEdges(){ 
		for(int i = 0; i < tasklist.length; i++){ //O(|N|)
			Task out = tasklist[i];
			if(out == null)
				continue;

			for(int j = 0; j < out.inEdges.length; j++){ //O(|N|)
				int inId = out.inEdges[j];
				if(inId != 0){
					Task in = tasklist[inId-1];
					in.outEdges.add(out);
				}
			}
		}
	}

	/**
	* Calculate earliest and latest time. If we have found a cycle when we calculated
	* the earliest time we print out the cycle and return false. If we have not found 
	* a case we return true.
	* @return true: realizable
	* @return false: not realizable 
	**/
	public boolean isRealizable(){
		ArrayList<Integer> cycle = setearliesttime();
		if(cycle != null){
			System.out.print("Cycle found! This is the path");
			for(int taskid : cycle){
				System.out.print(" " + taskid);
			}
			System.out.println("");
			return false;
		}
		return true;
	}

	/**
	*	First we add all the tasks who does not have any dependencies to the que.
	*	While the queue is not empty we remove one element from the queue. Then we
	*	add it to the path. We set the finish time to current task equal to the the
	*	earliest ending time to the current task. For each task that is dependant on 
	*	the current task we set it's earliest starting time equal to the finish time to
	*	the current task. Then we decrease the dependant amount of predecessors by one.
	*	@return path : the path size is huger than the tasklist we return the path
	*	@return null : null
	**/
	private ArrayList<Integer> setearliesttime(){ //Topsort
		ArrayList<Task> que = new ArrayList<Task>();
		ArrayList<Integer> path = new ArrayList<Integer>();

		for(int i = 0; i < tasklist.length; i++){ //O(|T|)
			if(tasklist[i].cntPredecessors == 0){
				que.add(tasklist[i]);

			}
		}

		while(!que.isEmpty()){ //o(|T|)
			Task t = que.remove(0);
			path.add(t.id);

			int finishTimeToCurrentTask = t.earlieststart + t.estimatedTime;

			for(int i = 0; i < tasklist.length; i++){ //O(|T|)
				if(tasklist[i].inEdges[t.id-1] == t.id){ //get the units he dependece on.
					Task w = tasklist[i];
					
					if(w.earlieststart < finishTimeToCurrentTask){
						w.earlieststart = finishTimeToCurrentTask; 
					}

					if(--w.cntPredecessors == 0){
						que.add(w);
					}
				}
			}
		}

		if(path.size() != tasklist.length){ //cycle is found
			return path;
		}

		return null;
	}


	/**
	*	Calculating the latest time by using the dfs() method
	*	on every node in the tasklist. 
	**/
	public void calculatelatesttime(){ // O(|V|+|E|)
		//Must find a way to find those task to start dfs with
		for(int i = 0; i < tasklist.length; i++){
			dfs(tasklist[i]); //must have a if statement?
		}
	}

	/**
	*	If task t already is seen it does nothing. 
	*
	*	If task t is not seen it is set to seen and one of two cases is performed:
	*	The first case is that task t have no outEdges or all the outEdges is null: task t
	*	latest time is set equal to it's earliest start. The second case is that if task t
	*	has one existing outEdge w: Let us assume that we have a variable smallesttime.
	*	Set smallesttime to be the latest time equal to earliest start of  
	*	the outEdge with the earliest estimatedTime minus the estimated time of slack. If
	*	smallesttime is more than the latest start of task t the latest start of task t 
	*	is set to smallesttime. 
	*
	*	@param t : Oppgave.
	**/
	private void dfs(Task t){ //|V| + |E|
		if(t.seen){
			return;
		}
		t.seen = true;
		//calculate the 
		for(Task w : t.outEdges){
			if(w == null){
				continue;
			} else {
				int time = w.earlieststart - t.estimatedTime;
				if(t.lateststart < time){
					t.lateststart = time;
				}
				dfs(w);
			}
		}

		if(t.lateststart == 0){
			t.lateststart = t.earlieststart;
		}
	}

	/**
	*	prints the information about all the tasks in the tasklist by
	*	calling printInfo(). The information consist of id, name, estimated 
	*	time, manpower, earliest start, latest start and slack.
	**/
	public void printTaskInfo(){
		for(Task t : tasklist){
			t.printInfo();
		}
	}

	/**
	*	Calculate when the task starts, how much manpower is needed at the current time
	*	and which start should start and end.
	*
	*	First it sorts all the task in tasklist by earliest start and earlist end. 
	*	Then it set times equal to the first task in the list. First we check that
	* 	there is still one task that has not started. If there is a task that has not
	*	started yet, we check if this task start at an earlier point than the ending time
	*	to the task which is the first in line to end. If this is the case we set the time 
	*	current to this time if this is not already the case and then start the task.
	*	if the task does not start at an earlier point than the ending time to the task
	*	which is the first in line to en is not the case we set the time equal to the en task
	*	which is now ending and print the manpower, then we end the task and update the 
	*	manpower. 
	**/
	public void runProject(){
		QuickSort qs = new QuickSort(); //O(T log T)
		qs.sort(tasklist);

		int time = tasklist[0].earlieststart;
		System.out.println("Time: " + time);
		int i = 0, j = 0;
		for(; j < tasklist.length; ){ //O(|T|)
			if(i < tasklist.length && tasklist[i].earlieststart < tasklist[j].earlieststart + tasklist[j].estimatedTime){ //cjeck if some task ends
				int pivot = tasklist[i].earlieststart;
				if(pivot != time){
					System.out.println("Manpower: " + manpower);
					System.out.println("");
					time = pivot;
					System.out.println("Time: " + time);
				}
				System.out.println("Start:" + tasklist[i].id);
				manpower += tasklist[i].manpower;
				i++;
			} else {
				int pivot = tasklist[j].earlieststart + tasklist[j].estimatedTime; //end time
				if(pivot != time){
					System.out.println("Manpower: " + manpower);
					System.out.println("");
					time =	pivot;
					System.out.println("Time: " + time);
				}

				System.out.println("End:" + tasklist[j].id);
				manpower -= tasklist[j].manpower;
				j++;
			}
		}

		System.out.println("manpower: " + manpower + "\n");
	}
}