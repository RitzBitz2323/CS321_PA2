
public class R_Instruction extends Instruction {
	private String Rm;
	private String shamt;
	private String Rn;
	protected String Rd;

	public R_Instruction(String name, String remainingBinary) {
		super(name);
		Rm = remainingBinary.substring(0, 5);
		shamt = remainingBinary.substring(5, 11);
		Rn = remainingBinary.substring(11, 16);
		Rd = remainingBinary.substring(16);
	}

	@Override
	public void printInstruction() {
		String ActualRd = PA2.convertToDecimal(Rd);
		String ActualShamt = PA2.convertToDecimal(shamt);
		String ActualRn = PA2.convertToDecimal(Rn);
		String ActualRm = PA2.convertToDecimal(Rm);
		if (ActualShamt.equals("0")) {
			System.out.println(name +" X" + ActualRd +", X" + ActualRn +", X" + ActualRm);
		}
		// MAYBE ADD IF ELSE HERE FOR MUL
		else {
			System.out.println(name +" X" + ActualRd +", X" + ActualRn +", #" + ActualShamt);
		}
	}
}
