package security_camera;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Car implements Comparable<Car>{
	
	int startPoint;
	int endPoint;
	
	public Car(int startPoint, int endPoint) {
		this.startPoint = startPoint;
		this.endPoint = endPoint;
	}
	
	@Override
	public String toString() {
		return "(start:" + startPoint + ", end:" + endPoint + ")";
	}

	@Override
	public int compareTo(Car car) {
		if(this.startPoint > car.startPoint)
			return 1;
		else if(this.startPoint < car.startPoint)
			return -1;
		else
			return 0;
	}
}

public class Solution {

	private List<Car> cars = new ArrayList<>();
	
	public int solution(int[][] routes) {
		init(routes);
        return findMinimumNumberOfCamera();
    }
	
	private void init(int[][] routes) {
		for(int i = 0; i < routes.length; i++) 
			cars.add(new Car(routes[i][0], routes[i][1]));
		Collections.sort(cars);
	}
	
	private int findMinimumNumberOfCamera() {
		int cameraCount = 1;
		Car tmp = cars.get(0);
		for(int i = 1; i < cars.size(); i++) {
			Car now = cars.get(i);
			if(tmp.endPoint >= now.endPoint)
				tmp = now;
			else if(tmp.endPoint < now.startPoint) {
				cameraCount++;
				tmp = now;
			}
		}
		return cameraCount;
	}
	
}
