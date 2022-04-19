
public class D_Instruction extends Instruction {
	private String DT_address;
	private String op;
	private String Rn;
	private String Rt;

	public D_Instruction(String name, String remainingBinary) {
		super(name);
		DT_address = remainingBinary.substring(0, 9);
		op = remainingBinary.substring(9, 11);
		Rn = remainingBinary.substring(11, 16);
		Rt = remainingBinary.substring(16);
	}

	@Override
	public void printInstruction() {
		String ActualDT_address = PA2.convertToDecimal(DT_address);
		String ActualRn = PA2.convertToDecimal(Rn);
		String ActualRt = PA2.convertToDecimal(Rt);
		
		// Specifically for LDUR and STUR
		System.out.println(name +" X" + ActualRt +", [X" + ActualRn +", #" + ActualDT_address + "]");
	}

}
