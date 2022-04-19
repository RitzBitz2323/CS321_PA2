
public class B_Instruction extends Instruction {
	private String BR_address;

	public B_Instruction(String name, String remainingBinary) {
		super(name);
		BR_address = remainingBinary;
	}

	@Override
	public void printInstruction() {
		String ActualBR_address = PA2.convertToDecimal(BR_address);
		System.out.println(name +" " + ActualBR_address);
	}

}
