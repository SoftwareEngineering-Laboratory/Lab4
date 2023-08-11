package semantic.symbol;

import codeGenerator.varType;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mohammad hosein on 6/28/2015.
 */

public class Symbol {
    public SymbolType type;
    public int address;

    private Map<SymbolType, varType> symbolToVarMap;

    public Symbol(SymbolType type, int address) {
        this.type = type;
        this.address = address;

        this.generateSymbolToVarMap();

    }

    private void generateSymbolToVarMap() {
        this.symbolToVarMap = new HashMap<>();
        symbolToVarMap.put(SymbolType.Bool, varType.Bool);
        symbolToVarMap.put(SymbolType.Int, varType.Int);
    }

    private Map<SymbolType, varType> getSymbolToVarMap(){
        return this.symbolToVarMap;
    }

    public varType getVarType() {
        return this.getSymbolToVarMap().get(this.type);
    }
}
