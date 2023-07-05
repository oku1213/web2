package model;

public class NumLogic {
	public void execute(Num num) {
		String org = num.getOrg();
		String[] orgArr = org.split(",");
		num.setSize(orgArr.length);
		
		int max;
		int min;
		int sum;
		max = min = sum = Integer.parseInt(orgArr[0]);
		for(int i =1;i<orgArr.length;i++) {
			int n =Integer.parseInt(orgArr[i]);
			if(max < n) {
				max = n;
			}
			if(min > n) {
				min = n;
			}
			sum += n;
		}
		num.setMax(max);
		num.setMin(min);
		num.setSum(sum);
	}
}
