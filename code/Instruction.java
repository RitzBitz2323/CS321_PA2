
abstract class Instruction {
	protected String name;
	
	public Instruction(String name) {
		this.name = name;
	}
	
	public abstract void printInstruction();
}
