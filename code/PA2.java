import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class PA2 {

	public static void main(String[] args) {		
		// Iterate through file and pull each instructions binary one by one.
		// Kyle Test
        File file = new File("./test.txt");
        Scanner scan = null;
		try {
			scan = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        ArrayList<String> ListOfInstructions = new ArrayList<>();
        String temporaryInstrucString = "";
        char ch = scan.next().charAt(0);
        while(scan.hasNextLine()){
            for(int i =0; i < 32; i++){
                temporaryInstrucString = temporaryInstrucString + ch;
            }
            ListOfInstructions.add(temporaryInstrucString);
        }
        // Put them into an array list
            System.out.println(ListOfInstructions.toString());
		
		// Put them into an array list
		String ADDCustom = "10001011000001000000000001100000";
		String ADDCustom2 = "11010011011000000001001001101011";
		ListOfInstructions.add(ADDCustom);
		ListOfInstructions.add(ADDCustom2);

		findOpcode(ListOfInstructions);
		
	}

	private static String findOpcode(ArrayList<String> InstructionsList) {
		String InstructionName = "";
		Instruction myInstruction = null;
		// Iterate through each instruction and classify them by length
		for (int i = 0; i < InstructionsList.size(); i++) {
			String currentInstruction = InstructionsList.get(i);
			
			// Find 6 bit opcodes
			switch (currentInstruction.substring(0, 6)) {
			case "000101":
				// This is B, Do stuff here
				break;
			case "100101":
				// This is BL, do stuff here
				break;
			}
			
			// Find 8 bit opcodes
			switch (currentInstruction.substring(0, 8)) {
			case "01010100":
				// This is B.cond, do stuff here
				break;
			case "10110100":
				// This is CBZ, do stuff here
				break;
			case "10110101":
				// This is CBNZ, do stuff here
				break;
			}
			
			// Don't have to deal with 9 bit opcodes
			
			// Find 10 bit opcodes
			switch (currentInstruction.substring(0, 10)) {
			case "1001000100":
				// This is ADDI, do stuff here
				myInstruction = new I_Instruction("ADDI", currentInstruction.substring(10));
				break;
			case "1001001000":
				// This is ANDI, do stuff here
				myInstruction = new I_Instruction("ANDI", currentInstruction.substring(10));
				break;
			case "1011001000":
				// This is ORRI, do stuff here
				myInstruction = new I_Instruction("ORRI", currentInstruction.substring(10));
				break;
			case "1101000100":
				// This is SUBI, do stuff here
				myInstruction = new I_Instruction("SUBI", currentInstruction.substring(10));
				break;
			case "1101001000":
				// This is EORI, do stuff here
				myInstruction = new I_Instruction("EORI", currentInstruction.substring(10));
				break;
			case "1111000100":
				// This is SUBIS, do stuff here
				myInstruction = new I_Instruction("SUBIS", currentInstruction.substring(10));
				break;
			}
			
			// Find 11 bit opcodes
			switch (currentInstruction.substring(0, 11)) {
			case "10001010000":
				// This is AND, do stuff here
				myInstruction = new R_Instruction("AND", currentInstruction.substring(11));
				break;
			case "10001011000":
				// This is ADD, do stuff here
				myInstruction = new R_Instruction("ADD", currentInstruction.substring(11));
				break;
			case "10011011000":
				// This is MUL, do stuff here
				myInstruction = new R_Instruction("MUL", currentInstruction.substring(11));
				break;
			case "10101010000":
				// This is ORR, do stuff here
				myInstruction = new R_Instruction("ORR", currentInstruction.substring(11));
				break;
			case "11001010000":
				// This is EOR, do stuff here
				myInstruction = new R_Instruction("EOR", currentInstruction.substring(11));
				break;
			case "11001011000":
				// This is SUB, do stuff here
				myInstruction = new R_Instruction("SUB", currentInstruction.substring(11));
				break;
			case "11010011010":
				// This is LSR, do stuff here
				myInstruction = new R_Instruction("LSR", currentInstruction.substring(11));
				break;
			case "11010011011":
				// This is LSL, do stuff here
				myInstruction = new R_Instruction("LSL", currentInstruction.substring(11));
				break;
			case "11010110000":
				// This is BR, do stuff here
				myInstruction = new R_Instruction("BR", currentInstruction.substring(11));
				break;
			case "11101011000":
				// This is SUBS, do stuff here
				myInstruction = new R_Instruction("SUBS", currentInstruction.substring(11));
				break;
			case "11111000000":
				// This is STUR, do stuff here
				myInstruction = new D_Instruction("STUR", currentInstruction.substring(11));
				break;
			case "11111000010":
				// This is LDUR, do stuff here
				myInstruction = new D_Instruction("LDUR", currentInstruction.substring(11));
				break;
			case "11111111101":
				// This is PRNT, do stuff here
				myInstruction = new R_Instruction("PRNT", currentInstruction.substring(11));
				break;
			case "11111111100":
				// This is PRNL, do stuff here
				myInstruction = new R_Instruction("PRNL", currentInstruction.substring(11));
				break;
			case "11111111110":
				// This is DUMP, do stuff here
				myInstruction = new R_Instruction("DUMP", currentInstruction.substring(11));
				break;
			case "11111111111":
				// This is HALT, do stuff here
				myInstruction = new R_Instruction("HALT", currentInstruction.substring(11));
				break;
			}
			myInstruction.printInstruction();
		}
		return InstructionName;
	}
	
	public static String convertToDecimal(String binaryNumber) {
		int decimal=Integer.parseInt(binaryNumber, 2);  
		String s = Integer.toString(decimal);  
		return s;
	}

}
