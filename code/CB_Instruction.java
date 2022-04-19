
public class CB_Instruction extends Instruction {
	private String COND_BR_address;
	private String Rt;

	public CB_Instruction(String name, String remainingBinary) {
		super(name);
		COND_BR_address = remainingBinary.substring(0, 19);
		Rt = remainingBinary.substring(19);
	}

	@Override
	public void printInstruction() {
		String ActualCOND_BR_address = PA2.convertToDecimal(COND_BR_address);
		String ActualRt = PA2.convertToDecimal(Rt);
		
		if (name.equals("B.cond")) {
			// NOTE: Rt is actually what the .cond should be, not a real register
			switch(ActualRt) {
			case "0":
				name = "B.EQ";
				break;
			case "1":
				name = "B.NE";
				break;
			case "2": 
				name = "B.HS";
				break;
			case "3":
				name = "B.LO";
				break;
			case "4": 
				name = "B.MI";
				break;
			case "5": 
				name = "B.PL";
				break;
			case "6": 
				name = "B.VS";
				break;
			case "7": 
				name = "B.VC";
				break;
			case "8": 
				name = "B.HI";
				break;
			case "9":
				name = "B.LS";
				break;
			case "10":
				name = "B.GE";
				break;
			case "11": 
				name = "B.LT";
				break;
			case "12":
				name = "B.GT";
				break;
			case "13":
				name = "B.LE";
				break;
			}
			// For B.cond printing
			System.out.println(name +" " + ActualCOND_BR_address);
		}
		else {
			// For CBZ or CBNZ negative printing
			if (ActualCOND_BR_address.charAt(0) == '-') {
				System.out.println(name +" X" + ActualRt +", " + ActualCOND_BR_address);
			}
			// For CBZ or CBNZ positive printing
			else {
				// NOT SURE ABOUT THE PLUS SIGN
				System.out.println(name +" X" + ActualRt +", " + ActualCOND_BR_address);
			}
		}
	}

}
