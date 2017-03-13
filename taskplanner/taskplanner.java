import java.util.ArrayList;

interface taskplanner{
	void createTask(String[] info);
	boolean isRealizable();
	ArrayList<Integer> setearliesttime();
	void runProject();
	void calculatelatesttime();
	void printTaskInfo();
}