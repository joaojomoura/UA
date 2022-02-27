package BdeX_Language;
import java.util.*;
import SemanticCheck.*;

public class SemCheck extends BdeXBaseVisitor<Boolean> {
    // private HashMap<String, HashMap<String, String>> table = new HashMap<>();
    // private HashMap<String, String> ids = new HashMap<>();

    // @Override public Boolean visitStat(BdeXParser.StatContext ctx){
    //     for(BdeXParser.BdeXContext bc : ctx.table()){
    //         visit(bc);
    //     }
    //     return null;
    // }
    // @Override public Boolean visitTable(BdeXParser.StatContext ctx){
    //     String nome = ctx.IDENTIFIER(0).getText();
    //     String id = ctx.IDENTIFIER(1).getText();

    //     if(table.containsKey(nome)){
    //         ids = table.get(nome);
    //         if(ids.containsKey(id)){
    //             ErrorHandling.printError(ctx, "Erro: Este identificador já foi utilizado!");
    //         }    
    //         ArrayList<String> valores = new ArrayList<>();
    //         for(String i : ids.values()){
    //             valores.add(i);
    //         }
    //         for(int i = 0; i < valores.size(); i++){
    //             if(valores.get(i).equalsIgnoreCase(id)){
    //                 ErrorHandling.printError(ctx, "Erro: Duas colunas com o mesmo identificador!");
    //             }
    //         }
    //         ids.put(id, nome);
    //     }

        
    //     else{
    //         ids.put(id, nome);
    //         table.put(nome, ids);
    //     }
    //     return null;
    // }
}
