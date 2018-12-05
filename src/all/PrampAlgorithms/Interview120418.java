package all.PrampAlgorithms;

public class Interview120418 {

	static int findBusiestPeriod(int[][] data) {
		int maxCount = -99;
		int maxTimeStamp = 0;
		//check if only one point or zero point
		if(data.length == 1)
			return data[0][1];
		for (int i = 1; i < data.length; i++) {
			int previousTimeStamp = data[i-1][0];
			int currentTimeStamp = data[i][0];
			if(previousTimeStamp == currentTimeStamp) {
				if(data[i-1][2] == 0) {
					data[i][1] -= data[i-1][1];
				}
				else {
					data[i][1] += data[i-1][1];
				}
			}
			else {
				//first occurrence of new timestamp
				//setting max count to accumulated sum of previous timestamps
				if(data[i-1][1] > maxCount) {
					maxCount = data[i-1][1];
					maxTimeStamp = data[i-1][0];
				}
				
			}
		}
		return maxTimeStamp;
	}
	
	static int getBusiestTime(int[][] data) {
		int maxCount = 0;
		int maxTimeStamp = 0;
		int currentCount = 0;
		
		//if only one record in data
		if(data.length == 1)
			return data[0][0];
		
		//if multiple
		for (int i = 0; i < data.length; i++) {
			if(i != 0) {
				if(data[i-1][0] != data[i][0]) {
					if(maxCount < currentCount) {
						maxCount = currentCount;
						maxTimeStamp = data[i-1][0];
					}
				}
			}
			if(data[i][2] == 1)
				currentCount += data[i][1];
			else
				currentCount -= data[i][1];
		}
		
		if(currentCount > maxCount) {
			maxTimeStamp = data[data.length - 1][0];
		}
		return maxTimeStamp;
	}
	public static void main(String[] args) {

		int[][] data1 = new int[][]{
										{1487799425,14,1},
										{1487799425,4,1},
										{1487799425,2,1},
										{1487800378,10,1},
										{1487801478,18,1},
										{1487901013,1,1},
										{1487901211,7,1},
										{1487901211,7,1}
									};
		int timestamp = getBusiestTime(data1);
		System.out.println(timestamp);
	}
}
