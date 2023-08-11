package parser.acts;

import codeGenerator.CodeGeneratorFacade;
import parser.ParseTable;
import parser.Rule;
import scanner.ScannerFacade;
import scanner.token.Token;

import java.util.ArrayList;
import java.util.Stack;

public class Shift extends Act {

    @Override
    public String toCustomString() {
        return null;
    }
    @Override
    public Token parse(Token lookAhead, Stack<Integer> parsStack, ParseTable parseTable, ArrayList<Rule> rules, int number, ScannerFacade scannerFacade, CodeGeneratorFacade codeGeneratorFacade){
        parsStack.push(number);
        return scannerFacade.getNextTokenFromAnalyzer();
    }
}
