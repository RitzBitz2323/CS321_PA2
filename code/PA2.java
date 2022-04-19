import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class PA2 {

	public static void main(String[] args) {	
		
		// Array list used to store instructions
        ArrayList<String> ListOfInstructions = new ArrayList<>();
		
		File file = new File(args[0]);
		FileInputStream stream = null;
		try {
			stream = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
				
		byte mybyte;
		 try {
			while(stream.available() > 0) {
				 String individualInstruction = "";
				 // reads 4 bytes at a time and puts them into a string
				 for(int i = 0; i < 4; i++) {
					 mybyte = (byte) stream.read();
					 individualInstruction = individualInstruction + String.format("%8s", Integer.toBinaryString(mybyte & 0xFF)).replace(' ', '0');
				 }
				 // add individualInstruction to the list of instructions
				 ListOfInstructions.add(individualInstruction);
			 }
		} catch (IOException e) {
			e.printStackTrace();
		}
		 
		 try {
			 stream.close();
		 } catch (IOException e) {
			 e.printStackTrace();
		 }
		 
		
		// Iterate through file and pull each instructions binary one by one.
//        File file = new File("./test.txt");
//        Scanner scan = null;
//		try {
//			scan = new Scanner(file);
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//        String temporaryInstrucString = "";
//        char ch = scan.next().charAt(0);
//        while(scan.hasNextLine()){
//            for(int i =0; i < 32; i++){
//                temporaryInstrucString = temporaryInstrucString + ch;
//            }
//            ListOfInstructions.add(temporaryInstrucString);
//        }
//        // Put them into an array list
//            System.out.println(ListOfInstructions.toString());
		
		// Put them into an array list
		String ADDCustom = "10001011000001000000000001100000";
		String ADDCustom2 = "11010011011000000001001001101011";
		String ADDCustom3 = "11111000010000001000000101001001";
		String ADDCustom4 = "11111000000000010000001010010011";
		String ADDCustom5 = "10010001000000000010001000110101";
		String ADDCustom6 = "10110100000000000000100010001110";
		String ADDCustom7 = "10110101111111111111110101010101";
		String ADDCustom8 = "01010100000000000000010000101010";
		String ADDCustom9 = "00010100000000000000000000101111";



		ListOfInstructions.add(ADDCustom);
		ListOfInstructions.add(ADDCustom2);
		ListOfInstructions.add(ADDCustom3);
		ListOfInstructions.add(ADDCustom4);
		ListOfInstructions.add(ADDCustom5);
		ListOfInstructions.add(ADDCustom6);
		ListOfInstructions.add(ADDCustom7);
		ListOfInstructions.add(ADDCustom8);
		ListOfInstructions.add(ADDCustom9);


		findOpcode(ListOfInstructions);
	}

	private static void findOpcode(ArrayList<String> InstructionsList) {
		Instruction myInstruction = null;
		// Iterate through each instruction and classify them by length
		for (int i = 0; i < InstructionsList.size(); i++) {
			String currentInstruction = InstructionsList.get(i);
			
			// Find 6 bit opcodes
			switch (currentInstruction.substring(0, 6)) {
			case "000101":
				// This is B, do stuff here
				myInstruction = new B_Instruction("B", currentInstruction.substring(6));
				break;
			case "100101":
				// This is BL, do stuff here
				myInstruction = new B_Instruction("BL", currentInstruction.substring(6));
				break;
			}
			
			// Find 8 bit opcodes
			switch (currentInstruction.substring(0, 8)) {
			case "01010100":
				// This is B.cond, do stuff here
				myInstruction = new CB_Instruction("B.cond", currentInstruction.substring(8));
				break;
			case "10110100":
				// This is CBZ, do stuff here
				myInstruction = new CB_Instruction("CBZ", currentInstruction.substring(8));
				break;
			case "10110101":
				// This is CBNZ, do stuff here
				myInstruction = new CB_Instruction("CBNZ", currentInstruction.substring(8));
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
	}
	
	public static String convertToDecimal(String binaryNumber) {
		String s = "";
		// This is a normal register, don't convert twos complement
		if (binaryNumber.length() == 5) {
			int decimal=Integer.parseInt(binaryNumber, 2);  
			s = Integer.toString(decimal);  
			return s;
		}
		else if (binaryNumber.charAt(0) == '1') {
	        String invertedInt = invertDigits(binaryNumber);
	        //Change this to decimal format.
	        int decimalValue = Integer.parseInt(invertedInt, 2);
	        //Add 1 to the current decimal and multiply it by -1 because we know it's a negative number
	        decimalValue = (decimalValue + 1) * -1;
	        s = Integer.toString(decimalValue);
	        //return the final result
	        return s;
	    } else {
	        // Else we know it's a positive number
	    	int decimal=Integer.parseInt(binaryNumber, 2);  
			s = Integer.toString(decimal);  
			return s;
	    }
	}
	
	public static String invertDigits(String binaryInt) {
	    String result = binaryInt;
	    result = result.replace("0", " "); //temp replace 0s
	    result = result.replace("1", "0"); //replace 1s with 0s
	    result = result.replace(" ", "1"); //put the 1s back in
	    return result;
	}

}
