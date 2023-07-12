package model;

public class NumLogic {
	public void execute(Numbeans nb) {
		String org = nb.getOrg();
		String[] orgArr = org.split(",");
		nb.setSize(orgArr.length);
		int max,min,sum;
		max=min=sum=Integer.parseInt(orgArr[0]);
		for(int i=1; i<orgArr.length ;i++) {
			int n = Integer.parseInt(orgArr[i]);
			if(max < n) {
				max=n;
			}
			if(min > n) {
				min=n;
			}
			sum+=n;
		}
		nb.setMax(max);
		nb.setMin(min);
		nb.setSum(sum);
		
	}

}
