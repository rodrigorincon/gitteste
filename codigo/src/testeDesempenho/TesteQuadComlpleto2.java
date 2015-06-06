package testeDesempenho;

import pathPlanner.PathPlanner;
import pathPlanner.Quadtree;
import util.Path;
import bestPath.BestPath;
import bestPath.Djikstra;
import controller.PathPlannerController;

public class TesteQuadComlpleto2 {

	/*
	 * mesmo com um mapa pequeno se o n� de obstaculos cresce o consumo de memoria fica grande
	 */
	public static void main(String[] args) {
		int size = 30;
		float largura_robo = (float)13.8;
		boolean[][] mapa = new boolean[size][size];
		for(int i=0; i<size; i++){
			for(int j=0; j<size; j++){
				if(i%3==2)
					mapa[i][j] = false;
				else if(j%3!=2)
					mapa[i][j] = true;
				else
					mapa[i][j] = false;
			}
		}
		PathPlanner path_planner = new Quadtree(largura_robo, largura_robo);
		BestPath best_path = new Djikstra();
		
		PathPlannerController framework = new PathPlannerController(path_planner, best_path);
		framework.defineMap(mapa, false, 0, 2, 8, 8);
		Path path = framework.execute(largura_robo, largura_robo);
		path.getRoute();
	}

}