import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class OrganizeMyTasks implements taskorganizer{
	static Planner planner;

	public OrganizeMyTasks(String name){
		if(name.equalsIgnoreCase("test")){
			runTestProjects();
			return;
		}	

		createPlanner(name);
		plantasks();
	}

	/**
	* 	Runs the project buildhouse.txt and buildhouse2.txt. 
	*	buildhouse.txt is realizable, while buildhouse2.txt is not realizable
	**/
	public void runTestProjects(){
		System.out.println("Buildhouse\t\t");
		createPlanner("buildhouse.txt");
		plantasks();

		System.out.println("Buildhouse2");
		createPlanner("buildhouse2.txt");
		plantasks();

		System.out.println("Buildrail");
		createPlanner("buildrail.txt");
		plantasks();
	}

	/**
	* 	if the planner does not exist it does nothing, else it figures 
	*	out if the project is realizable -if the project is realizable 
	*	it runs the project. Either if the project is realizable or not
	*	it calculate the the latest time for the project. 
	**/
	public void plantasks(){
		if(planner == null)
			return;

		boolean realizable = planner.isRealizable();
		if(!realizable){
			System.out.println("Project is not realizable");
		} else {
			planner.runProject();
		}

		planner.calculatelatesttime();
		planner.printTaskInfo();
	}

	/**
	*	Opens the file and initialize project. Opens a scanner with the file 
	*	called the filename. While scanner has more lines the scanner reads the 
	*	current line in the file. First the scanner reads the first line and opens
	*	a project with this amount of tasks. Then it initializes the tasks one by one.
	*	At the end of the method if the project is initialized the outEdges is created.
	*	@param filename: The name of the file which contains the project.
	*	@error	fileNotFoundException:	File named <filename> is not found.
	*	@note filename must contain the amount of tasks at the first line.
	**/
	public void createPlanner(String filename){
		Scanner sc = null;
		try{
			sc = new Scanner(new File(filename));
		}catch(FileNotFoundException fnef){
			System.out.println("File not found");
			return;
		}

		for(int i = 0; sc.hasNextLine(); i++){
			String line = sc.nextLine();
			if(i == 0){
				int nrOfTasks = Integer.parseInt(line);
				planner = new Planner(nrOfTasks);
			} else if(!line.isEmpty()){
				String[] taskinfo = line.split("\\s+");
				planner.createTask(taskinfo);
			}
		}

		if(planner != null)
			planner.setOutEdges();
	}
}