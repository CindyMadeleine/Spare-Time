public class PlanMyTasks{
	public static void main(String[] args){
		//TaskPlannerFrame plannerframe = new TaskPlannerFrame();
		String filename;
		if(args.length == 0){
			filename = "test";
		} else {
			filename = args[0];
		}
		OrganizeMyTasks omt = new OrganizeMyTasks(filename);
	}
}