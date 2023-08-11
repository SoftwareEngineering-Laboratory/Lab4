package parser.acts;

import Log.Log;
import codeGenerator.CodeGeneratorFacade;
import parser.ParseTable;
import parser.Rule;
import scanner.ScannerFacade;
import scanner.token.Token;

import java.util.ArrayList;
import java.util.Stack;

public class Reduce extends Act{
    @Override
    public String toCustomString() {
        return null;
    }

    @Override
    public Token parse(Token lookAhead, Stack<Integer> parsStack, ParseTable parseTable, ArrayList<Rule> rules, int number, ScannerFacade scannerFacade, CodeGeneratorFacade codeGeneratorFacade) {
        Rule rule = rules.get(number);
        for (int i = 0; i < rule.RHS.size(); i++) {
            parsStack.pop();
        }

        Log.print(/*"state : " +*/ parsStack.peek() + "\t" + rule.LHS);
        parsStack.push(parseTable.getGotoTable(parsStack.peek(), rule.LHS));
        Log.print(/*"new State : " + */parsStack.peek() + "");
        try {
            codeGeneratorFacade.semanticFunction(rule.semanticAction, lookAhead);
        } catch (Exception e) {
            Log.print("Code Genetator Error");
        }
        return lookAhead;
    }
}
