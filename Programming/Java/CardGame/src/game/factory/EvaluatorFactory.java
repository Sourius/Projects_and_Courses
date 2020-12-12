package game.factory;

import gameLogic.GameEvaluator;
import gameLogic.HighGameEvaluator;
import gameLogic.LowGameEvaluator;

public class EvaluatorFactory {
	public enum EvaluatorType{
		HIGH,
		LOW
	}

	public static GameEvaluator makeEvaluator(EvaluatorType evaluatorType) {
		switch(evaluatorType) {
			case LOW: return new LowGameEvaluator();
			case HIGH: return new HighGameEvaluator();
		}
		return new HighGameEvaluator();
	}
	
}
