import models.objects.City;
import models.objects.Graph;
import utils.CityInitializer;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Class untuk ngetes graph
 * */

public class TesterClass {
	private static void testCityGraph() {
		// Test the dijkstra shortest path using city and vertices that are already defined in CityInitializer
		HashMap<String, City> cities = new HashMap<>();

		Graph graph = new Graph(29);
		CityInitializer.initCities(cities);
		for (City city : cities.values()) {
			System.out.printf("%s %d\n", city.getLabel(), city.getId());
		}

		CityInitializer.initGraph(graph, cities);
		CityInitializer.initEdges(graph);

		graph.displayMatrix();
		var src = "BREBES";
		var dst = "SRAGEN";
		var previous = graph.dijkstra(src, dst);
		graph.printPath(previous, graph.getVertex(dst));

		System.out.println();
		var vertexOrder = graph.getVertexOrder(previous, graph.getVertex(dst), new ArrayList<>());
		var vertexDists = graph.getVertexDistances(vertexOrder);
		for (var vertex : vertexOrder) {
			System.out.printf("%s ", vertex.getLabel());
		}

		System.out.println();
		graph.printEachVertexDistance(vertexOrder, vertexDists);
	}

	public static void main(String[] args) {
		testCityGraph();
	}
}
