package com.example.calculadora;
import java.util.Stack;
public class Convertidor {
    Stack<String> pilaNum;//Stack<String> pilaNum = new Stack<String>();
    Stack<String> pilaOp;//Stack<String> pilaOp = new Stack<String>();
    String cadenaPost;//String cadenaPost="";
    String [] opList={"+","-","*","/","^","%","¬","(",")","Log","ln","!","Sqrt","Sen","Cos","Tan","Ctg","Csc","Sec"};

    public Convertidor() {
        this.pilaNum = new Stack<String>();
        this.pilaOp = new Stack<String>();
        this.cadenaPost="";
        //String [] opList={"+","-","*","/","^","%","¬","(",")","Log","ln","!","Sqrt","Sen","Cos","Tan","Ctg","Csc","Sec"};
    }

    public boolean verificaPrioriOp(String opA, String opB){
        boolean res=true;
        if(opA.compareTo("(")==0){ //si A=+
            res=true;
        }
        else if(opB.compareTo("(")==0){ //si A=+
            res=true;
        }
        else if(opA.compareTo("+")==0){ //si A=+
            if(opB.compareTo("(")==0){
                //res=false;
                res=true;
            }
        }
        else if(opA.compareTo("-")==0){ //si A=-
            if(opB.compareTo("(")==0){
                //res=false;
                res=true;
            }
        }
        else if(opA.compareTo("*")==0){ //si A=*
            if(opB.compareTo("+")==0){
                res=false;
            }
            else if(opB.compareTo("-")==0){
                res=false;
            }
        }
        else if(opA.compareTo("/")==0){ //si A=/
            if(opB.compareTo("+")==0){
                res=false;
            }
            else if(opB.compareTo("-")==0){
                res=false;
            }
        }
        else if(opA.compareTo("^")==0){ //si A=^
            //res=false;
            if(opB.compareTo("^")==0){
                res=true;
            }
            else if(opB.compareTo("(")==0){
                res=true;
            }
            else if(opB.compareTo("¬")==0){
                res=true;
            }
            else{
                res=false;
            }
        }
        else if(opA.compareTo("%")==0){ //si A=%
            //res=false;
            if(opB.compareTo("^")==0){
                res=true;
            }
            else if(opB.compareTo("(")==0){
                res=true;
            }
            else if(opB.compareTo("¬")==0){
                res=true;
            }
            else{
                res=false;
            }
        }

        else if(opA.compareTo("Sqrt")==0){ //si A=Sqrt
            if(opB.compareTo("^")==0){
                res=true;
            }
            else if(opB.compareTo("(")==0){
                res=true;
            }
            else if(opB.compareTo("Sqrt")==0){
                res=true;
            }
            else if(opB.compareTo("¬")==0){
                res=true;
            }
            else{
                res=false;
            }
        }
        else if(opA.compareTo("Log")==0){ //si A=Log
            if(opB.compareTo("¬")==0){
                res=true;
            }
            else if(opB.compareTo("Log")==0){
                res=true;
            }
            else if(opB.compareTo("ln")==0){
                res=true;
            }
            else if(opB.compareTo("(")==0){
                res=true;
            }
            else{
                res=false;
            }
        }
        else if(opA.compareTo("ln")==0){ //si A=Log
            if(opB.compareTo("¬")==0){
                res=true;
            }
            else if(opB.compareTo("Log")==0){
                res=true;
            }
            else if(opB.compareTo("ln")==0){
                res=true;
            }
            else if(opB.compareTo("(")==0){
                res=true;
            }
            else{
                res=false;
            }
        }
        else if(opA.compareTo("(Log")==0){ //si A=!
            if(opB.compareTo("+")==0){
                res=false;
            }
            else if(opB.compareTo("-")==0){
                res=false;
            }
            else if(opB.compareTo("*")==0){
                res=false;
            }
            else if(opB.compareTo("/")==0){
                res=false;
            }
            else if(opB.compareTo("(")==0){
                res=false;
            }
            else{
                res=true;
            }
        }
        else{ //todas las funciones trigonometricas
            if(opB.compareTo("¬")==0){
                res=true;
            }
            else{
                res=false;
            }
        }
        return res;
    }

    public boolean isOp(String c){
        boolean res=false;
        for(int i=0; i<opList.length; i++){
            if(c.compareTo(opList[i])==0){
                res=true;
                break;
            }
        }
        return res;
    }

    public boolean isNum(String c) {
        boolean resultado;
        try {
            Double.parseDouble(c);
            resultado = true;
        }
        catch (NumberFormatException excepcion) {
            if(c.compareTo("pi")==0){
                resultado = true;
            }
            else if(c.compareTo("e")==0){
                resultado = true;
            }
            else{
                resultado = false;
            }
        }

        return resultado;
    }

    public void opToPostSP(){ // funcion que inserta los operadores a la cadena hasta econtrar un parentesis
        String op="";
        op=op=pilaOp.pop();
        //System.out.println("Se tiene "+op+"\n");
        while(!(op.compareTo("(")==0)){
            cadenaPost=cadenaPost+"#"+op;
            //System.out.println("Se agrega op "+op+" a la cadenaPos\n");
            if(!pilaOp.empty()){
                //System.out.println("Se saca "+op+"\n");
                op=pilaOp.pop();
            }
            else{
                break;
            }
        }
        if(op.compareTo("(")==0){
            //System.out.println("Se guarda "+op+"\n");
            pilaOp.push(op);
        }
    }

    public void opToPostQP(){ // funcion que inserta los operadores a la cadena hasta econtrar un parentesis
        String op="";
        op=op=pilaOp.pop();
        if(op.compareTo(")")==0){
            op=op=pilaOp.pop();
        }
        //System.out.println("Se tiene "+op+"\n");
        while(!(op.compareTo("(")==0)){
            cadenaPost=cadenaPost+"#"+op;
            //System.out.println("Se agrega op "+op+" a la cadenaPos\n");
            if(!pilaOp.empty()){
                //System.out.println("Se saca "+op+"\n");
                op=pilaOp.pop();
            }
            else{
                break;
            }
        }
        if(op.compareTo("(")==0){
            //System.out.println("Termina "+op+"\n");
        }
    }

    public String separar(String cadenaInf){
        String aux="";
        int flagPoint=0;
        for(int i=0; i<cadenaInf.length(); i++){
            //System.out.println("Se evalua: "+cadenaInf.charAt(i)+"\n");
            //System.out.println("Aux = "+aux);
            //aux=aux+cadenaInf.charAt(i);
            //SI EL CARACTER NO ES NUM NI OP
            if(cadenaInf.charAt(i)==' '){
                //System.out.println("Nope\n");
            }
            else if((cadenaInf.charAt(i)=='.' && flagPoint==0)){ // && (aux=="" || isNum(aux))
                aux=aux+cadenaInf.charAt(i);
                flagPoint=1;
            }

            //SI EL CARACTER ES UN NUM
            else if(isNum(cadenaInf.charAt(i)+"")){//si es num
                aux=aux+cadenaInf.charAt(i);
            }
            else if( !isNum(cadenaInf.charAt(i)+"") && isNum(aux)){//Si no es num pero aux si lo es
                //System.out.println("CASO 1\n");
                if(isOp(cadenaInf.charAt(i)+"")){ // Si es un operador de 1
                    //System.out.println("CASO 1-A\n");
                    //System.out.println("Se inserta "+aux+" en la expr "+cadenaPost+"\n");
                    cadenaPost=cadenaPost+"#"+aux;
                    aux="";
                    flagPoint=0;
                    //verificar prioridad de Operadores
                    String opA,opB;
                    opB=cadenaInf.charAt(i)+"";
                    if(pilaOp.empty()){
                        pilaOp.push(opB);
                    }
                    else{
                        opA=pilaOp.pop();
                        //System.out.println("OPA: "+opA+"\n");
                        if(opB.compareTo(")")==0){
                            pilaOp.push(opA);
                            //System.out.println("Se quitan parentesis\n");
                            opToPostQP();
                        }
                        else if(verificaPrioriOp(opA,opB)){
                            //System.out.println(opB+" mas import que "+opA+" asi que se inserta en pila\n");
                            pilaOp.push(opA);
                            pilaOp.push(opB);
                        }
                        else{
                            pilaOp.push(opA);
                            //System.out.println(opA+" mas import que "+opB+" asi que se inserta CADENA\n");
                            opToPostSP();
                            pilaOp.push(opB);
                        }
                    }
                    //pilaOp.push(cadenaInf.charAt(i)+"");
                    //System.out.println("Se inserta "+cadenaInf.charAt(i)+" en la pila Op\n");

                }
                else{ //si es un operador de varios digitos
                    //System.out.println("CASO 1-B\n");
                    //System.out.println("Se inserta "+aux+" en la cad "+cadenaPost+"\n");
                    cadenaPost=cadenaPost+"#"+aux;
                    aux=""+cadenaInf.charAt(i);
                    //System.out.println("Op de varias letras\n");
                    flagPoint=0;
                }
            }
            else if(!isNum(cadenaInf.charAt(i)+"")){ // Si aux no es num
                if(isOp(aux+cadenaInf.charAt(i))){ //si solo tenemos un operador de 1 digito y aux=""
                    aux=aux+cadenaInf.charAt(i);
                    //System.out.println("CASO 2\n");
                    String opA,opB;
                    opB=aux;
                    aux="";
                    if(pilaOp.empty()){
                        //System.out.println("CASO 2-A\n");
                        pilaOp.push(opB);
                    }
                    else{
                        //System.out.println("CASO 2-B\n");
                        opA=pilaOp.pop();
                        if(opB.compareTo(")")==0){
                            pilaOp.push(opA);
                            //System.out.println("Se quitan parentesis\n");
                            opToPostQP();
                        }
                        else if(verificaPrioriOp(opA,opB)){
                            //System.out.println(opB+" mas import que "+opA+" asi que se inserta en pila\n");
                            pilaOp.push(opA);
                            pilaOp.push(opB);
                        }
                        else{
                            pilaOp.push(opA);
                            //System.out.println(opA+" mas import que "+opB+" asi que se inserta CADENA\n");
                            opToPostSP();
                            pilaOp.push(opB);
                        }
                    }
                    //pilaOp.push(aux);
                    //System.out.println("Se inserta "+aux+" en la pila Op\n");
                    //aux="";
                }
                else{ //si tenemos un op que es de varios digitos y aux=""
                    //System.out.println("Se agrega "+cadenaInf.charAt(i)+" a "+aux+"\n");
                    aux=aux+cadenaInf.charAt(i);
                }
            }
            else{
                //System.out.println("Syntax error :v\n");
            }
        } //termina de recorrer la cadena
        if(isNum(aux)){
            cadenaPost=cadenaPost+"#"+aux;
        }
        String op="";
        while(!pilaOp.empty()){
            op=pilaOp.pop();
            cadenaPost=cadenaPost+"#"+op;
            //System.out.println("Se agrega op "+op+" a la cadenaPos\n");
        }
        //System.out.println("La cadena postfija es: "+cadenaPost);
        return cadenaPost;
    }

}
