package bubblesort;

public class BubbleSort {
	public static void main(String[] args) {
		int[] inputs = {5, 10, 3, 9, -2, -6, 1};
		
		for (int i = 0; i < inputs.length; i++) {
			for (int j = 0; j < inputs.length - 1; j++) {
				if (inputs[j] > inputs[j+1]) {
					inputs = swap(j, j+1, inputs);
				}
			}
		}
		
		printArray(inputs);
	}
	
	private static void printArray(int[] inputs) {
		for (int i : inputs) {
			System.out.println(i + " ");
		}
	}
	
	private static int[] swap(int i, int j, int[] inputs) {
		int temp = inputs[i];
		inputs[i] = inputs[j];
		inputs[j] = temp;
		return inputs;
	}
}
