
public class I_Instruction extends Instruction {
	private String ALU_immediate;
	private String Rn;
	private String Rd;

	public I_Instruction(String name, String remainingBinary) {
		super(name);
		ALU_immediate = remainingBinary.substring(0, 12);
		Rn = remainingBinary.substring(12, 17);
		Rd = remainingBinary.substring(17);
	}

	@Override
	public void printInstruction() {
		String ActualALU = PA2.convertToDecimal(ALU_immediate);
		String ActualRn = PA2.convertToDecimal(Rn);
		String ActualRd = PA2.convertToDecimal(Rd);
		
		// Specifically for ADDI
		System.out.println(name +" X" + ActualRd +", X" + ActualRn +", #" + ActualALU);
	}

}
