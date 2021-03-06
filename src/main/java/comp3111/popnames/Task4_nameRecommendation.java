package comp3111.popnames;
import java.util.Random;

public class Task4_nameRecommendation {
	
	/**
	 * Task4
	 * find the most popular male/female name in the year of dadYOB/momYOB and return the recommendation report.
	 * 
	 */
	
	public static String t4x1_func(int dadYOB, int momYOB, String dadName, String momName) {
		String[][] topN_M = Task1_AnalyzeNames.getTopNnames(dadYOB, 1, "M");
		String[][] topN_F = Task1_AnalyzeNames.getTopNnames(momYOB, 1, "F");
		String oReport = "";
		
		oReport = String.format("%s is the most popular male name in the year", topN_M[0][0]);
		oReport += String.format("%d.\n", dadYOB);
		
		oReport += String.format("%s is the most popular female name in the year", topN_F[0][0]);
		oReport += String.format("%d.\n", momYOB);
		
		return oReport;	
	}
	
	/**
	 * Task4
	 * find the top 10 popular male/female names in the year of dadYOB/momYOB and recommend a random name in the top
	 * 10 names list and return the recommendation report.
	 * 
	 */
	
	public static String t4x2_func(int dadYOB, int momYOB, String dadName, String momName) {
		String[][] topN_M = Task1_AnalyzeNames.getTopNnames(dadYOB, 10, "M");
		String[][] topN_F = Task1_AnalyzeNames.getTopNnames(momYOB, 10, "F");
		String boyName = "";
		String girlName = "";
		int boyNamePlace = 0;
		int girlNamePlace = 0;
		
		for(int i = 0; i < 10; ++i) {
			Random rand = new Random();
			int randomTopN = rand.nextInt(10);
			if(topN_M[randomTopN][0] != dadName) {
				boyName = topN_M[randomTopN][0];
				boyNamePlace = randomTopN;
				break;
			}
		}
		
		for(int j = 0; j < 10; ++j) {
			Random rand = new Random();
			int randomTopN = rand.nextInt(10);
			if(topN_F[randomTopN][0] != momName) {
				girlName = topN_F[randomTopN][0];
				girlNamePlace = randomTopN;
				break;
			}
		}
		
		String oReport = "";
		oReport = String.format("%s is the ", boyName);
		oReport += String.format("%s-th popular male name in the year ", boyNamePlace);
		oReport += String.format("%d.\n", dadYOB);
		
		oReport += String.format("%s is the ", girlName);
		oReport += String.format("%s-th popular female name in the year ", girlNamePlace);
		oReport += String.format("%d.\n", momYOB);
		
		return oReport;	
	}
	
	
	/**
	 * Task4
	 * check validity of input birthday 
	 * 
	 */
	
	public static boolean checkBirthday_T4(int dadYOB, int momYOB) {
		if(dadYOB < 1880 || dadYOB > 2019 || momYOB < 1880 || momYOB > 2019) {
			PopupWindow.displayErrorMsg("error", "Invalid year input!");
			return false;
		}
		return true;
	}
	/**
	 * Task4
	 * check emptiness of input 
	 * 
	 */
	
	public static boolean checkEmpty_T4(String input1, String input2) {
		if(input1 == ""  || input2 == "" ) {
			PopupWindow.displayErrorMsg("error", "Input cannot be empty");
			return false;
		}
		return true;	
	}
}
