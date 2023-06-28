package _202306._02_gasStation;
import static java.lang.System.out;

import java.util.Queue;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Test_GasStation {
	
	private static class GasStationStatus{
		
		public int remainingFuel;
		public int lastUsedTime;
		
		public GasStationStatus(int remainingFuel) {
			this.remainingFuel = remainingFuel;
		}
		
	}
	
	
	
	public static void main(String[] args) {
		
		{
			Queue<Integer> carFuelNeeds = new LinkedList<>( Arrays.asList(2,8,4,3,2) );
			out.println( longestWaitingTime(carFuelNeeds, 7, 11, 3) );
		}

		
		{
			Queue<Integer> carFuelNeeds = new LinkedList<>( Arrays.asList(5) );
			out.println( longestWaitingTime(carFuelNeeds, 4, 0, 3) );
		}
		
		
		{
			Queue<Integer> carFuelNeeds = new LinkedList<>( Arrays.asList(4,3) );
			out.println( longestWaitingTime(carFuelNeeds, 4, 0, 3) );
		}
		
		
		{
			Queue<Integer> carFuelNeeds = new LinkedList<>( Arrays.asList(3,2,2) );
			out.println( longestWaitingTime(carFuelNeeds, 4, 0, 3) );
		}
		
		{
			Queue<Integer> carFuelNeeds = new LinkedList<>( Arrays.asList(2,3,4,1) );
			out.println( longestWaitingTime(carFuelNeeds, 10, 0, 0) );
		}
		
		{
			Queue<Integer> carFuelNeeds = new LinkedList<>( Arrays.asList(1,2,3,4) );
			out.println( longestWaitingTime(carFuelNeeds, 10, 0, 0) );
		}
		
		{
			Queue<Integer> carFuelNeeds = new LinkedList<>( Arrays.asList(1,2,3,4) );
			out.println( longestWaitingTime(carFuelNeeds, 100, 0, 0) );
		}
		
		

	}
	
	
	
	public static int longestWaitingTime( Queue<Integer> carFuelNeeds, int gasStationFuel_x, int gasStationFuel_y, int gasStationFuel_z ) {
		
		List<GasStationStatus> gasStations = getGasStationStatuses( gasStationFuel_x, gasStationFuel_y, gasStationFuel_z );
		List<Integer> waitingTimeOfCars = new ArrayList<>();
		
		while( carFuelNeeds.size() > 0 ) {
			
			int currentCarFuelNeed = carFuelNeeds.remove();
			
			GasStationStatus validGasStation = 
				//among all gasStation X, Y, Z
				gasStations.stream()
				//we only consider such gasStatoin that has more fuel than a car does. we rule out those gasStation that cannot meet the requirement
				.filter( gasStation -> gasStation.remainingFuel >= currentCarFuelNeed )
				/*
				 * now that we have stations that has more fuel that a car does.
				 * since we want to pull the car to gasStation as soon as possible
				 * sort the gasStation by its lastUsedTime, and if times equal, pick gasStation with less fuel( based on question's requirement 
				 */
				.min( (o1, o2) -> {
					if( o1.lastUsedTime != o2.lastUsedTime )
						return o1.lastUsedTime - o2.lastUsedTime;
					else
						return o1.remainingFuel - o2.remainingFuel; } )
				//if there is no such gasStation that has more fuel than a car does, return null
				.orElse( null );
			
			//if none of a gasStation can satisfy any car's need, the car is waiting indefinitely, and the whole car queue is blocked. return -1 based on question's requirement 
			if(validGasStation == null ) {
				return -1;
			}
			
			
			/* now the car c is pulled into the gasStaion g; following things occurs
			 * the time car can be pulled is right after the gasStation's the last used time, so the waiting time of the car g is validGasStation.lastUsedTime
			 * based on the question's description, the time it takes for a gasStation to tank a car is the currentCarFuelNeed. So lastUsedTime is added by currentCarFuelNeed
			 * the remaining fuel of a gasStation is subtracted by  currentCarFuelNeed
			 */
			waitingTimeOfCars.add( validGasStation.lastUsedTime );
			validGasStation.lastUsedTime += currentCarFuelNeed;
			validGasStation.remainingFuel -= currentCarFuelNeed;
			
		}
		
		return Collections.max( waitingTimeOfCars );
	}

	

	private static List<GasStationStatus> getGasStationStatuses(int...  gasStationFuels) {
		
		List<GasStationStatus> gasStationStatuses = new ArrayList<>();
		for(int i=0; i < gasStationFuels.length; i++) {
			gasStationStatuses.add( new GasStationStatus(gasStationFuels[i]) );
		}
		
		return gasStationStatuses;
	}

}


